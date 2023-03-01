//Student ID: 3619873
//   Student Name: Md Abdullah Mehedi Patwary
//    Student email: mpatwary1@athabasca.edu
//Date: 05/12/2022

package com.example.tme_4_part2;

import java.io.File;


import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;

import javafx.scene.control.TextField;


public class Greenhouse extends Application {
    public MenuItem contextNewWindow;
    public MenuItem contextCloseWindow;
    public MenuItem contextOpenEvent;
    public MenuItem contextLoadDump;
    public MenuItem contextExit;
    public Button openEventsFileButton;
    public TextArea logArea;


    private Stage stage;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        

        //scene
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("TME4");
        stage.setScene(scene);
        stage.show();
    }

    // GUI
    @FXML
    private TextField eventsFilePathTextField;

    @FXML
    void handleNewWindowAction() {
        try {
            Process process = Runtime.getRuntime().exec("java Greenhouse");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleCloseWindowAction() {
        stage.close();
    }

    @FXML
    void handleOpenEventsFileAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Event File");
        File file = fileChooser.showOpenDialog(stage);

        if(file != null) {
            eventsFilePathTextField.setText(file.getAbsolutePath());
            startButton.setDisable(false);
        }
    }

    @FXML
    void handleOpenDumpFileAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Event File");

    }
    @FXML
    void handleExitAction() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private Button startButton;
    @FXML
    private Button restartButton;
    @FXML
    void handleStartButtonAction() {
        startButton.setDisable(true);
        restartButton.setDisable(true);
        suspendButton.setDisable(false);
        terminateButton.setDisable(false);
    }

    @FXML
    private Button terminateButton;
    @FXML
    void handleTerminateButtonAction() {
        startButton.setDisable(false);
        restartButton.setDisable(false);
        suspendButton.setDisable(false);
        resumeButton.setDisable(true);
        terminateButton.setDisable(true);
    }

    @FXML
    private Button suspendButton;
    @FXML
    void handleSuspendButtonAction() {
        resumeButton.setDisable(false);
        suspendButton.setDisable(true);
    }

    @FXML
    private Button resumeButton;
    @FXML
    void handleResumeButtonAction() {
        resumeButton.setDisable(true);
        suspendButton.setDisable(false);
    }

    
    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
    }
}