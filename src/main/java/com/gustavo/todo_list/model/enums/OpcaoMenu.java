package com.gustavo.todo_list.model.enums;

public enum OpcaoMenu {
	ADICIONAR(1, "Adicionar tarefas"), 
	LISTAR(2, "Listar tarefas"), 
	MARCAR_CONCLUIDA(3, "Marcar como concluída"),
	REMOVER(4, "Remover tarefa"), 
	REDEFINIR_STATUS(5, "Redefinir status"), 
	SAIR(6, "Sair");

	private int codigo;
	private String descricao;

	OpcaoMenu(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static OpcaoMenu fromCodigo(int codigo) {
		for (OpcaoMenu opcao : values()) {
			if (opcao.codigo == codigo) {
				return opcao;
			}
		}
		throw new IllegalArgumentException("Opção inválida!\n");
	}
}
