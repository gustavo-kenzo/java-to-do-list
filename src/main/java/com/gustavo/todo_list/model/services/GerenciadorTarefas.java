package com.gustavo.todo_list.model.services;

import com.gustavo.todo_list.model.dao.DaoFactory;
import com.gustavo.todo_list.model.dao.TarefaDao;
import com.gustavo.todo_list.model.entities.Tarefa;

import java.util.List;

public class GerenciadorTarefas {
    private final TarefaDao taskDao = DaoFactory.creatTarefa();

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
        int pendente = 0, concluida = 0, ordem = 1;
        for (Tarefa tarefa : list) {
            String linha = String.format("%d. %s\n", ordem++, tarefa);
            if (tarefa.isStatus()) {
                concluidas.append(linha);
                concluida++;
            } else {
                pendentes.append(linha);
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

    public void marcarConcluida(Integer visualId) {
        mudarStatus(visualId, true);
    }

    public void desmarcarConcluida(Integer visualId) {
        mudarStatus(visualId, false);
    }

    public void removerTarefa(Integer visualId) {
        Tarefa tarefaRemover = getTarefaVisualId(visualId);
        taskDao.delete(tarefaRemover);
    }

    private Tarefa getTarefaVisualId(Integer visualId) {
        List<Tarefa> list = taskDao.findAll();
        if (visualId <= 0 || visualId > list.size()) {
            throw new IllegalArgumentException("ID inválido: tarefa não existe!\n");
        }
        return list.get(visualId - 1);
    }

    private void mudarStatus(Integer visualId, boolean status) {
        Tarefa tarefa = getTarefaVisualId(visualId);

        if (tarefa.isStatus() == status) {
            throw new IllegalStateException(status ? "Tarefa já está concluída!\n" : "Tarefa já está pendente!\n");
        }

        tarefa.setStatus(status);
        taskDao.update(tarefa);
    }
}
