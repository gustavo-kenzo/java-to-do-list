package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Tarefa;

public class GerenciadorTarefas {
	private List<Tarefa> tarefas = new ArrayList<>();

	public void adicionarTarefa(String nomeTarefa) throws IllegalArgumentException {
		tarefas.add(new Tarefa(nomeTarefa));
	}
	public void adicionarTarefa(String nomeTarefa, String descricao) throws IllegalArgumentException {
		tarefas.add(new Tarefa(nomeTarefa,descricao));
	}

	public String listarTarefas() {
		if (tarefas.isEmpty()) {
			return "\nNão há tarefas\n";
		}
		StringBuilder pendentes = new StringBuilder("TAREFAS PENDENTES:\n");
		StringBuilder concluidas = new StringBuilder("\nTAREFAS CONCLUIDAS:\n");
		int pendente = 0, concluida = 0;
		for (int i = 0; i < tarefas.size(); i++) {
			if (tarefas.get(i).isStatus()) {
				concluidas.append(String.format("%d. %s\n", i + 1, tarefas.get(i)));
				concluida++;
			} else {
				pendentes.append(String.format("%d. %s\n", i + 1, tarefas.get(i)));
				pendente++;
			}
		}
		if (pendente == 0) {
			pendentes.append("Nenhuma tarefa pendente!\n");
		}
		if (concluida == 0) {
			concluidas.append("Nenhuma tarefa concluída!\n");
		}

		return pendentes.append(concluidas).toString();
	}

	public void marcarConcluida(int indice) {
		if (indice < 0 || indice >= tarefas.size()) {
			throw new IllegalArgumentException("Índice inválido: tarefa não existe!\n");
		}
		if (tarefas.get(indice).isStatus()) {
			throw new IllegalStateException("Tarefa já está concluída!\n");
		}
		tarefas.get(indice).marcarConcluida();
	}

	public void desmarcarConcluida(int indice) {
		if (indice < 0 || indice >= tarefas.size()) {
			throw new IllegalArgumentException("Índice inválido: tarefa não existe!\n");
		}
		if (!tarefas.get(indice).isStatus()) {
			throw new IllegalStateException("Tarefa já está pendente!\n");
		}
		tarefas.get(indice).desmarcarConcluida();
	}

	public void removerTarefa(int indice) {
		if (tarefas.isEmpty()) {
			throw new IllegalStateException("Não há tarefas para remover!\n");
		}
		if (indice < 0 || indice >= tarefas.size()) {
			throw new IllegalArgumentException("Índice inválido: tarefa não existe!\n");
		}
		tarefas.remove(indice);

	}
}
