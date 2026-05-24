package com.programa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    private TextField campoNome;
    private TextField campoCpf;
    private TextField campoEmail;
    private TextField campoTelefone;

    private ObservableList<Pessoa> pessoas = FXCollections.observableArrayList();
    private TableView<Pessoa> tabela;

    @Override
    public void start(Stage stage) {
        campoNome = new TextField();
        campoCpf = new TextField();
        campoEmail = new TextField();
        campoTelefone = new TextField();

        campoNome.setPromptText("Digite o nome");
        campoCpf.setPromptText("Digite o CPF");
        campoEmail.setPromptText("Digite o e-mail");
        campoTelefone.setPromptText("Digite o telefone");

        Button botaoSalvar = new Button("Salvar");
        Button botaoCancelar = new Button("Cancelar");
        Button botaoListar = new Button("Listar");

        botaoSalvar.setOnAction(e -> salvarPessoa());
        botaoCancelar.setOnAction(e -> limparCampos());
        botaoListar.setOnAction(e -> listarPessoas());

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(campoNome, 1, 0);

        formulario.add(new Label("CPF:"), 0, 1);
        formulario.add(campoCpf, 1, 1);

        formulario.add(new Label("E-mail:"), 0, 2);
        formulario.add(campoEmail, 1, 2);

        formulario.add(new Label("Telefone:"), 0, 3);
        formulario.add(campoTelefone, 1, 3);

        HBox botoes = new HBox(10, botaoSalvar, botaoCancelar, botaoListar);

        tabela = criarTabela();

        VBox layout = new VBox(15, formulario, botoes, tabela);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 650, 450);

        stage.setTitle("Cadastro de Pessoas");
        stage.setScene(scene);
        stage.show();
    }

    private TableView<Pessoa> criarTabela() {
        TableView<Pessoa> tableView = new TableView<>();

        TableColumn<Pessoa, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Pessoa, String> colunaCpf = new TableColumn<>("CPF");
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Pessoa, String> colunaEmail = new TableColumn<>("E-mail");
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Pessoa, String> colunaTelefone = new TableColumn<>("Telefone");
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tableView.getColumns().addAll(colunaNome, colunaCpf, colunaEmail, colunaTelefone);
        tableView.setItems(pessoas);

        return tableView;
    }

    private void salvarPessoa() {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String email = campoEmail.getText();
        String telefone = campoTelefone.getText();

        Pessoa pessoa = new Pessoa(nome, cpf, email, telefone);
        pessoas.add(pessoa);

        System.out.println("Pessoa cadastrada:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("----------------------");

        limparCampos();
    }

    private void limparCampos() {
        campoNome.clear();
        campoCpf.clear();
        campoEmail.clear();
        campoTelefone.clear();
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

    public static void main(String[] args) {
        launch();
    }
}