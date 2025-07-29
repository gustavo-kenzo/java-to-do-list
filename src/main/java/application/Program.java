package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import db.DB;
import model.enums.OpcaoMenu;
import model.services.GerenciadorTarefas;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		GerenciadorTarefas gerenciador = new GerenciadorTarefas();
		int codigo = 0;
		while (true) {
			exibirMenu();
			System.out.print("Escolha uma opção: ");

			try {
				codigo = sc.nextInt();
				sc.nextLine();
				OpcaoMenu escolha = OpcaoMenu.fromCodigo(codigo);
				System.out.println();

				switch (escolha) {
				case ADICIONAR:
					adicionar(sc, gerenciador);
					break;
				case LISTAR:
					System.out.println(gerenciador.listarTarefas());
					break;
				case MARCAR_CONCLUIDA:
					marcarConcluida(sc, gerenciador);
					break;
				case REMOVER:
					remover(sc, gerenciador);
					break;
				case REDEFINIR_STATUS:
					redefinirStatus(sc, gerenciador);
					break;
				case SAIR:
					System.out.println("SAINDO...");
					sc.close();
					DB.closeConnection();
					return;
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!\n");
				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Erro inesperado: " + e.getMessage());
			}
		}
	}

	public static void exibirMenu() {
		for (OpcaoMenu opcao : OpcaoMenu.values()) {
			System.out.printf("%d. %s\n", opcao.getCodigo(), opcao.getDescricao());
		}
	}

	public static void adicionar(Scanner sc, GerenciadorTarefas gerenciador) {
		System.out.println("INFORMAÇÕES DA TAREFA: ");
		System.out.print("Título: ");
		String nomeTarefa = sc.nextLine();
		System.out.print("Descrição: ");
		String descricao = sc.nextLine();
		if (descricao == null || descricao.isBlank()) {
			gerenciador.adicionarTarefa(nomeTarefa);
		} else {
			gerenciador.adicionarTarefa(nomeTarefa, descricao);
		}
		System.out.println("Tarefa adicionada!\n");
	}

	public static void marcarConcluida(Scanner sc, GerenciadorTarefas gerenciador) {
		System.out.println("(CONCLUIR)");
		System.out.print("Digite o número da tarefa: ");
		gerenciador.marcarConcluida(sc.nextInt());
		System.out.println("Tarefa concluída!\n");
	}

	public static void remover(Scanner sc, GerenciadorTarefas gerenciador) {
		System.out.println("(REMOVER)");
		System.out.print("Digite o número da tarefa: ");
		gerenciador.removerTarefa(sc.nextInt());
		System.out.println("Tarefa removida!\n");
	}

	public static void redefinirStatus(Scanner sc, GerenciadorTarefas gerenciador) {
		System.out.println("(REDEFINIR)");
		System.out.print("Digite o número da tarefa: ");
		gerenciador.desmarcarConcluida(sc.nextInt());
		System.out.println("Status redefinido!\n");
	}

}
