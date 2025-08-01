package com.gustavo.todo_list.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OpcaoMenu {
    ADICIONAR(1, "Adicionar tarefas"),
    LISTAR(2, "Listar tarefas"),
    MARCAR_CONCLUIDA(3, "Marcar como concluída"),
    REMOVER(4, "Remover tarefa"),
    REDEFINIR_STATUS(5, "Redefinir status"),
    SAIR(6, "Sair");

    private static final Map<Integer, OpcaoMenu> map = new HashMap<>();

    static {
        for (OpcaoMenu values : values()) {
            map.put(values.getCodigo(), values);
        }
    }

    private final int codigo;
    private final String descricao;

    OpcaoMenu(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OpcaoMenu fromCodigo(int codigo) {
        OpcaoMenu opcaoEscolhida = map.get(codigo);
        if (opcaoEscolhida == null) {
            throw new IllegalArgumentException("Opção inválida!\n");
        }
        return opcaoEscolhida;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getCodigo() + ". " + getDescricao();
    }
}
