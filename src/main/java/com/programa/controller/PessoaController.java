package com.programa.controller;

import com.programa.model.Pessoa;
import com.programa.view.PessoaView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PessoaController {

    private PessoaView view;
    private ObservableList<Pessoa> pessoas;

    public PessoaController(PessoaView view) {
        this.view = view;
        this.pessoas = FXCollections.observableArrayList();

        this.view.getTabela().setItems(pessoas);

        this.view.getBotaoSalvar().setOnAction(e -> salvarPessoa());
        this.view.getBotaoCancelar().setOnAction(e -> limparCampos());
        this.view.getBotaoListar().setOnAction(e -> listarPessoas());
    }

    private void salvarPessoa() {
        String nome = view.getCampoNome().getText();
        String cpf = view.getCampoCpf().getText();
        String email = view.getCampoEmail().getText();
        String telefone = view.getCampoTelefone().getText();

        Pessoa pessoa = new Pessoa(nome, cpf, email, telefone);
        pessoas.add(pessoa);

        limparCampos();
    }

    private void limparCampos() {
        view.getCampoNome().clear();
        view.getCampoCpf().clear();
        view.getCampoEmail().clear();
        view.getCampoTelefone().clear();
    }

    private void listarPessoas() {
        System.out.println("Lista de pessoas cadastradas:");

        for (Pessoa pessoa : pessoas) {
            System.out.println(
                    pessoa.getNome() + " | " +
                    pessoa.getCpf() + " | " +
                    pessoa.getEmail() + " | " +
                    pessoa.getTelefone()
            );
        }

        System.out.println("----------------------");
    }
}
