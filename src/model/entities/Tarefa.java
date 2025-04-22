package model.entities;

public class Tarefa {
	private String descricao;
	private boolean concluida;

	public Tarefa(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Descrição não pode ser vazia ou nula!\n");
		}
		this.descricao = descricao;
		this.concluida = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void marcarConcluida() {
		concluida = true;
	}

	public void desmarcarConcluida() {
		concluida = false;
	}

	@Override
	public String toString() {
		return descricao.trim();
	}

}
