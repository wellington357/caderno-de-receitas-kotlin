# 📖 Caderno de Receitas Culinárias - Kotlin

Projeto desenvolvido para a disciplina de Programação, aplicando conceitos fundamentais da linguagem Kotlin e Programação Orientada a Objetos (POO).

---

## 📝 Descrição do Projeto
Este projeto simula a lógica de um aplicativo de receitas e culinária (inspirado no *TudoGostoso*).
O sistema permite gerir receitas, calcular a proporção de ingredientes (dobrar rendimento), avaliar o nível de dificuldade
da receita e exibir dicas do chef utilizando boas práticas de tratamento de nulos (*Null Safety*).

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **Paradigmas:** Programação Orientada a Objetos (POO)
- **Ferramentas:** IntelliJ IDEA / Git / GitHub

---

## 🎯 Requisitos e Regras de Negócio Implementadas

1. **Modelagem POO:**
   - `Ingrediente`: Representa o nome e a quantidade do ingrediente.
   - `Receita`: Armazena informações da receita, lista de ingredientes e dica do chef.
   - `LivroReceitas`: Contém a lista e gestão de receitas.

2. **Cálculo de Proporção (`if/else`):**
   - Possibilidade de dobrar a receita (`dobrarRendimento == true`), o que duplica a quantidade dos ingredientes e o tempo de preparo.

3. **Nível de Dificuldade (`when`):**
   - Converte um código numérico de dificuldade em texto:
     - `1` -> Fácil
     - `2` -> Médio
     - `3` -> Difícil

4. **Listagem de Ingredientes (`for`):**
   - Iteração sobre a lista de ingredientes para exibição detalhada.

5. **Dica do Chef (`Null Safety` & Operador Elvis):**
   - A propriedade `dicaExtra` é opcional (`String?`). Se for nula, o sistema exibe `"Nenhuma dica disponível para esta receita"`.

---

## 🚀 Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/wellington357/caderno-de-receitas-kotlin.git](https://github.com/wellington357/caderno-de-receitas-kotlin.git)
