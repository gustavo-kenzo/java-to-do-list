package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.TarefaDao;
import model.entities.Tarefa;

public class GerenciadorTarefas {
	private TarefaDao taskDao = DaoFactory.creatTarefa();

	private List<Tarefa> tarefas = new ArrayList<>();

	public void adicionarTarefa(String nomeTarefa) throws IllegalArgumentException {
		Tarefa task = new Tarefa(nomeTarefa);
		taskDao.insert(task);
		// tarefas.add(new Tarefa(nomeTarefa));
	}

	public void adicionarTarefa(String nomeTarefa, String descricao) throws IllegalArgumentException {
		Tarefa task = new Tarefa(nomeTarefa, descricao);
		taskDao.insert(task);
		// tarefas.add(new Tarefa(nomeTarefa,descricao));
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

	public void marcarConcluida(int id) {
		if (id < 0 || id >= tarefas.size()) {
			throw new IllegalArgumentException("Índice inválido: tarefa não existe!\n");
		}
		if (tarefas.get(id).isStatus()) {
			throw new IllegalStateException("Tarefa já está concluída!\n");
		}
		tarefas.get(id).marcarConcluida();
	}

	public void desmarcarConcluida(int id) {
		if (id < 0 || id >= tarefas.size()) {
			throw new IllegalArgumentException("Índice inválido: tarefa não existe!\n");
		}
		if (!tarefas.get(id).isStatus()) {
			throw new IllegalStateException("Tarefa já está pendente!\n");
		}
		tarefas.get(id).desmarcarConcluida();
	}

	public void removerTarefa(Integer id) {
		Integer idTrue = taskDao.findIdByRowNumber(id);
		if (idTrue == null) {
			throw new IllegalArgumentException("ID inválido: tarefa não existe!\n");
		}
		taskDao.deleteById(idTrue);
		// tarefas.remove(id);

	}
}
