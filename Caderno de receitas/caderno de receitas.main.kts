// 1. Modelagem: Classe Ingrediente
data class Ingrediente(
    val nome: String,
    var quantidade: Double
)

// 1 & 5. Modelagem: Classe Receita com Null Safety na Dica do Chef
class Receita(
    val nome: String,
    var tempoPreparo: Int, // em minutos
    var porcoes: Int,
    val dificuldadeCodigo: Int,
    val ingredientes: List<Ingrediente>,
    val dicaExtra: String? = null // Propriedade opcional (Null Safety)
) {
    // 3. Nível de Dificuldade (estruturas condicionais com `when`)
    fun obterDificuldade(): String {
        return when (dificuldadeCodigo) {
            1 -> "Fácil"
            2 -> "Médio"
            3 -> "Difícil"
            else -> "Desconhecido"
        }
    }

    // 2. Cálculo de Proporção (utilização de `if/else`)
    fun ajustarRendimento(dobrarRendimento: Boolean) {
        if (dobrarRendimento) {
            tempoPreparo *= 2
            porcoes *= 2
            for (ingrediente in ingredientes) {
                ingrediente.quantidade *= 2.0
            }
        } else {
            println("Mantendo as proporções originais da receita.")
        }
    }

    // 4 & 5. Listagem de ingredientes (laço `for`) e Dica do Chef (Operador Elvis `?:`)
    fun exibirDetalhes() {
        println("=========================================")
        println("Receita: $nome")
        println("Tempo de Preparo: $tempoPreparo min")
        println("Rendimento: $porcoes porções")
        println("Dificuldade: ${obterDificuldade()}")
        println("-----------------------------------------")

        println("Ingredientes:")
        // 4. Iteração sobre a lista utilizando laço `for`
        for (ingrediente in ingredientes) {
            println("- ${ingrediente.nome}:${ingrediente.quantidade}")
        }

        println("-----------------------------------------")
        // 5. Tratamento de nulos utilizando o Operador Elvis (`?:`)
        val dica = dicaExtra ?: "Nenhuma dica disponível para esta receita"
        println("Dica do Chef: $dica")
        println("=========================================\n")
    }
}

// 1. Modelagem: Classe LivroReceitas
class LivroReceitas {
    private val listaReceitas = mutableListOf<Receita>()

    fun adicionarReceita(receita: Receita) {
        listaReceitas.add(receita)
    }

    fun listarTodas() {
        if (listaReceitas.isEmpty()) {
            println("O livro de receitas está vazio.")
        } else {
            for (receita in listaReceitas) {
                receita.exibirDetalhes()
            }
        }
    }
}

// Exemplo de execução simulando o aplicativo
fun main() {
    val livro = LivroReceitas()

    // Criando uma lista de ingredientes
    val ingredientesBolo = listOf(
        Ingrediente("Farinha de Trigo (chá)", 2.0),
        Ingrediente("Açúcar (chá)", 1.5),
        Ingrediente("Ovos", 3.0),
        Ingrediente("Manteiga (colheres de sopa)", 2.0)
    )

    // Criando uma receita com dica do chef
    val boloChocolate = Receita(
        nome = "Bolo de Chocolate Simples",
        tempoPreparo = 40,
        porcoes = 8,
        dificuldadeCodigo = 1, // Fácil
        ingredientes = ingredientesBolo,
        dicaExtra = "Unte a forma com cacau em pó em vez de farinha para não ficar branco por fora."
    )

    // Criando outra receita sem dica do chef (para testar o Null Safety)
    val omelete = Receita(
        nome = "Omelete Rápido",
        tempoPreparo = 10,
        porcoes = 1,
        dificuldadeCodigo = 1,
        ingredientes = listOf(
            Ingrediente("Ovos", 2.0),
            Ingrediente("Sal (pitada)", 1.0)
        ),
        dicaExtra = null
    )

    livro.adicionarReceita(boloChocolate)
    livro.adicionarReceita(omelete)

    println("--- EXIBINDO RECEITA ORIGINAL ---")
    boloChocolate.exibirDetalhes()

    // 2. Testando a regra de negócio para dobrar o rendimento
    println("--- APLICANDO DOBRO DE RENDIMENTO ---")
    boloChocolate.ajustarRendimento(dobrarRendimento = true)
    boloChocolate.exibirDetalhes()

    // Testando a receita sem dica
    println("--- EXIBINDO RECEITA SEM DICA DO CHEF ---")
    omelete.exibirDetalhes()
}