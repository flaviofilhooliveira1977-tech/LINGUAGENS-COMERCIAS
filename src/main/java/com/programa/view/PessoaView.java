package com.programa.view;

import com.programa.model.Pessoa;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PessoaView {

    private TextField campoNome;
    private TextField campoCpf;
    private TextField campoEmail;
    private TextField campoTelefone;

    private Button botaoSalvar;
    private Button botaoCancelar;
    private Button botaoListar;

    private TableView<Pessoa> tabela;
    private VBox root;

    public PessoaView() {
        criarComponentes();
    }

    private void criarComponentes() {
        campoNome = new TextField();
        campoCpf = new TextField();
        campoEmail = new TextField();
        campoTelefone = new TextField();

        campoNome.setPromptText("Digite o nome");
        campoCpf.setPromptText("Digite o CPF");
        campoEmail.setPromptText("Digite o e-mail");
        campoTelefone.setPromptText("Digite o telefone");

        botaoSalvar = new Button("Salvar");
        botaoCancelar = new Button("Cancelar");
        botaoListar = new Button("Listar");

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

        root = new VBox(15, formulario, botoes, tabela);
        root.setStyle("-fx-padding: 20;");
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

        return tableView;
    }

    public VBox getRoot() {
        return root;
    }

    public TextField getCampoNome() {
        return campoNome;
    }

    public TextField getCampoCpf() {
        return campoCpf;
    }

    public TextField getCampoEmail() {
        return campoEmail;
    }

    public TextField getCampoTelefone() {
        return campoTelefone;
    }

    public Button getBotaoSalvar() {
        return botaoSalvar;
    }

    public Button getBotaoCancelar() {
        return botaoCancelar;
    }

    public Button getBotaoListar() {
        return botaoListar;
    }

    public TableView<Pessoa> getTabela() {
        return tabela;
    }
}