# To-Do List

Um aplicativo de console em Java para gerenciamento de tarefas, com funcionalidades de cadastro, visualização e manipulação de status. Projeto voltado para fins educativos, utilizando boas práticas com JPA, JDBC, MySQL e organização modular em pacotes.

## ✅ Funcionalidades
- Adicionar tarefas com descrição.
- Listar tarefas pendentes e concluídas.
- Marcar tarefas como concluídas ou redefinir como pendentes.
- Remover tarefas.
- Menu interativo baseado no enum `OpcaoMenu`.
- Tratamento robusto de erros com exceções personalizadas.

## 🚀 Como Executar

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/to-do-list.git
```
ou baixe o `.zip` do projeto.

### 2. Configure o banco de dados
- Crie o banco e a tabela `tarefas` no MySQL:
```sql
CREATE DATABASE todolist;
USE todolist;

CREATE TABLE tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    concluida BOOLEAN NOT NULL DEFAULT FALSE
);
```

### 3. Configure o acesso ao banco
- Edite o arquivo `db.properties` com suas credenciais:
```properties
db.url=jdbc:mysql://localhost:3306/todolist
db.user=seu_usuario
db.password=sua_senha
```

### 4. Compile e execute
Se estiver usando **Maven** (recomendado):

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="application.Program"
```

Se estiver usando **compilação manual**:

```bash
javac -d out $(find src -name "*.java")
java -cp out application.Program
```

## 📁 Estrutura do Projeto

```
src/
├── application/
│   └── Program.java                # Ponto de entrada da aplicação
├── model/
│   ├── dao/
│   │   ├── DaoFactory.java
│   │   ├── TarefaDao.java
│   │   └── impl/TarefaDaoJDBC.java
│   ├── entities/
│   │   └── Tarefa.java             # Classe entidade da tarefa
│   ├── enums/
│   │   └── OpcaoMenu.java          # Enum de opções do menu
│   └── services/
│       └── GerenciadorTarefas.java
├── db/
│   ├── DB.java
│   ├── DBException.java
│   └── DBIntegrityException.java
└── resources/
    └── db.properties               # Configuração do banco de dados
```

## 🛠 Tecnologias Utilizadas
- ![Java](https://img.shields.io/badge/Java-17+-blue)
- ![Maven](https://img.shields.io/badge/Maven-Build%20Tool-orange)
- ![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
- JDBC e JPA/Hibernate (implementação gradual)
- IntelliJ IDEA (ou Eclipse)
- Git para controle de versão

## 🤝 Contribuições

Contribuições são bem-vindas! Fique à vontade para abrir uma issue ou pull request com melhorias, correções ou sugestões.

---

📌 **Observações:**
- Projeto em constante evolução com foco no aprendizado e boas práticas.
  
