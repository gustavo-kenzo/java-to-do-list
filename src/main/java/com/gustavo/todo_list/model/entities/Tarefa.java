package com.gustavo.todo_list.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeTarefa;

    private String descricao;

    @Column(nullable = false)
    private boolean status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Tarefa() {
    }

    public Tarefa(String nomeTarefa) {
        validarTarefa(nomeTarefa);
        this.nomeTarefa = nomeTarefa;
        this.status = false;
    }

    public Tarefa(String nomeTarefa, String descricao) {
        validarTarefa(nomeTarefa);
        this.nomeTarefa = nomeTarefa;
        this.descricao = descricao;
        this.status = false;
    }

    private void validarTarefa(String nomeTarefa) {
        if (nomeTarefa == null || nomeTarefa.isBlank()) {
            throw new IllegalArgumentException("Título da tarefa não pode ser vazia ou nula!\n");
        }
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
        StringBuilder sb = new StringBuilder(nomeTarefa.trim().toUpperCase());
        if (descricao != null) {
            String descricaoTrim = descricao.trim();
            if (!descricao.isBlank()) {
                String descricaoFormatada = descricaoTrim.substring(0, 1).toUpperCase() + descricaoTrim.substring(1);
                sb.append(": ").append(descricaoFormatada);
            }
        }
        return sb.toString();
    }

}
