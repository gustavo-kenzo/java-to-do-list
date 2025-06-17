package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.TarefaDao;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TarefaDao td = DaoFactory.creatTarefa();
//INSERT OK
//		System.out.println("Informações da tarefa: ");
//		System.out.print("Título: ");
//		String nomeTarefa = sc.nextLine();
//		System.out.print("Descrição: ");
//		String descricao = sc.nextLine();
//		Tarefa task = new Tarefa();
//		if (descricao == null || descricao.isBlank()) {
//			task = new Tarefa(nomeTarefa);
//		} else {
//			task = new Tarefa(nomeTarefa, descricao);
//		}
//		td.insert(task);
//
//		System.out.println("Tarefa adicionada!\n");
//UPDATE OK
//		System.out.print("Digite o número da tarefa: ");
//		Tarefa task = new Tarefa();
//		task.setId(sc.nextInt());
//		task.marcarConcluida();
//		td.update(task);
//		//gerenciador.desmarcarConcluida(sc.nextInt() - 1);
//		System.out.println("Tarefa concluída!\n");
//UPDATE OK
//		System.out.print("Digite o número da tarefa: ");
//		Tarefa task = new Tarefa();
//		task.setId(sc.nextInt());
//		task.desmarcarConcluida();
//		td.update(task);
//		//gerenciador.desmarcarConcluida(sc.nextInt() - 1);
//		System.out.println("Status redefinido!\n");

	}

}
