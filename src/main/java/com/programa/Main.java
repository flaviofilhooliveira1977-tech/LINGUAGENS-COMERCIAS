package com.programa;

import com.programa.controller.PessoaController;
import com.programa.view.PessoaView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        PessoaView view = new PessoaView();

        new PessoaController(view);

        Scene scene = new Scene(view.getRoot(), 650, 450);

        stage.setTitle("Cadastro de Pessoas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}