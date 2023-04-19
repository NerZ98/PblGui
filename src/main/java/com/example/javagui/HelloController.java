package com.example.javagui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.example.javagui.ReceiveTextField;

public class HelloController{

    @FXML
    TextField textfield = new TextField();
    public TextField ipTextField;

    @FXML
    void loadPressed(ActionEvent event){

        FileChooser keyfileChooser = new FileChooser();
        keyfileChooser.setTitle("Open...");
        File FileDestination = keyfileChooser.showOpenDialog(new Stage());
        String filename = FileDestination.getPath();

        System.out.println(filename);
    }

    public void handledragdrop(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    public void handledropped(DragEvent event) {

        Dragboard db = event.getDragboard();
        File file = db.getFiles().get(0);
        System.out.println(file);
    }

    public void initialize() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            //TextField ipTextField = new TextField("");
            ipTextField.setText(ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

//    public void handleInput(ActionEvent actionEvent) {
//    }
//    //ReceiveTextField.handleInput();
//    public void restrictToComma(KeyEvent event){

    //ReceiveTextField.handleInput();

}