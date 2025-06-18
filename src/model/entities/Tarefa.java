package model.entities;

public class Tarefa {
	private Integer id;
	private String nomeTarefa;

	private String descricao;
	private boolean status;

	public Tarefa() {
	}

	public Tarefa(String nomeTarefa) {
		if (nomeTarefa == null || nomeTarefa.isBlank()) {
			throw new IllegalArgumentException("Título da tarefa não pode ser vazia ou nula!\n");
		}
		this.nomeTarefa = nomeTarefa;
		this.status = false;
	}

	public Tarefa(String nomeTarefa, String descricao) {
		if (nomeTarefa == null || nomeTarefa.isBlank()) {
			throw new IllegalArgumentException("Título da tarefa não pode ser vazia ou nula!\n");
		}

		this.nomeTarefa = nomeTarefa;
		this.descricao = descricao;
		this.status = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void marcarConcluida() {
		status = true;
	}

	public void desmarcarConcluida() {
		status = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		if (descricao == null) {
			return nomeTarefa.trim().toUpperCase();
		} else {
			descricao = descricao.substring(0, 1).toUpperCase().concat(descricao.substring(1));
			return nomeTarefa.trim().toUpperCase() + ": " + descricao.trim();
		}
	}

}
