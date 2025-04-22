# To-Do List

Um aplicativo de console em Java para gerenciar tarefas, com suporte a adicionar, listar, marcar como concluída, remover e redefinir status.

## Funcionalidades
- Adicionar tarefas com descrição.
- Listar tarefas pendentes e concluídas.
- Marcar tarefas como concluídas ou redefinir status.
- Remover tarefas.
- Menu interativo com opções centralizadas via enum `OpcaoMenu`.
- Tratamento robusto de erros com exceções.

## Como Executar
1. Clone o repositório: `git clone https://github.com/seu-usuario/to-do-list.git`
2. Navegue até a pasta: `cd to-do-list`
3. Compile o projeto: `javac src/application/Program.java`
4. Execute: `java -cp src application.Program`

## Estrutura do Projeto
- `src/application/Program.java`: Ponto de entrada com o menu interativo.
- `src/model/entities/Tarefa.java`: Representa uma tarefa.
- `src/model/enums/OpcaoMenu.java`: Enum para opções do menu.
- `src/model/services/GerenciadorTarefas.java`: Gerencia a lista de tarefas.

## Tecnologias
- ![Java](https://img.shields.io/badge/Java-17+-blue)
- Git para controle de versão

## Contribuições
Sinta-se à vontade para abrir issues ou pull requests!
