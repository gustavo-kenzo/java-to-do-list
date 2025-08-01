package com.gustavo.todo_list.application.UI;

import com.gustavo.todo_list.model.enums.OpcaoMenu;

public class MenuConsole {

    public static void exibirMenu() {
        System.out.println("===== MENU DE OPÇÕES =====");
        for (OpcaoMenu opcao : OpcaoMenu.values()) {
            System.out.println(opcao);
        }
        System.out.println("==========================");
    }
}
