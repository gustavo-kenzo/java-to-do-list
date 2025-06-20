package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.TarefaDao;
import model.entities.Tarefa;

public class GerenciadorTarefas {
	private TarefaDao taskDao = DaoFactory.creatTarefa();

	public void adicionarTarefa(String nomeTarefa) throws IllegalArgumentException {
		Tarefa task = new Tarefa(nomeTarefa);
		taskDao.insert(task);
	}

	public void adicionarTarefa(String nomeTarefa, String descricao) throws IllegalArgumentException {
		Tarefa task = new Tarefa(nomeTarefa, descricao);
		taskDao.insert(task);
	}

	public String listarTarefas() {
		List<Tarefa> list = taskDao.findAll();
		if (list == null || list.isEmpty()) {
			return "\nNão há tarefas\n";
		}
		StringBuilder pendentes = new StringBuilder("TAREFAS PENDENTES:\n");
		StringBuilder concluidas = new StringBuilder("\nTAREFAS CONCLUIDAS:\n");
		int pendente = 0, concluida = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isStatus()) {
				concluidas.append(String.format("%s\n", list.get(i)));
				concluida++;
			} else {
				pendentes.append(String.format("%s\n", list.get(i)));
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

	public void marcarConcluida(Integer id) {

		Integer idTrue = taskDao.findIdByRowNumber(id);
		List<Tarefa> list = taskDao.findAll();
		if (id <= 0 || id > list.size()) {
			throw new IllegalArgumentException("ID inválido: tarefa não existe!\n");
		}
		if (list.get(id - 1).isStatus()) {
			throw new IllegalStateException("Tarefa já está concluída!\n");
		}
		list.get(id - 1).setId(idTrue);
		list.get(id - 1).setStatus(true);
		taskDao.update(list.get(id - 1));
	}

	public void desmarcarConcluida(Integer id) {
		Integer idTrue = taskDao.findIdByRowNumber(id);
		List<Tarefa> list = taskDao.findAll();

		if (id <= 0 || id > list.size()) {
			throw new IllegalArgumentException("ID inválido: tarefa não existe!\n");
		}
		if (!list.get(id - 1).isStatus()) {
			throw new IllegalStateException("Tarefa já está pendente!\n");
		}
		list.get(id - 1).setId(idTrue);
		list.get(id - 1).setStatus(false);
		taskDao.update(list.get(id - 1));
	}

	public void removerTarefa(Integer id) {
		Integer idTrue = taskDao.findIdByRowNumber(id);
		if (idTrue == null) {
			throw new IllegalArgumentException("ID inválido: tarefa não existe!\n");
		}
		taskDao.deleteById(idTrue);
	}
}
