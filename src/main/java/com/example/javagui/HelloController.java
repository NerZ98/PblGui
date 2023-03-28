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
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController{

    @FXML
    TextField textfield = new TextField();

    @FXML
    void loadPressed(ActionEvent event){

        FileChooser keyfileChooser = new FileChooser();
        keyfileChooser.setTitle("Open...");
        File FileDestination = keyfileChooser.showOpenDialog(new Stage());
        String filename = FileDestination.getPath();

        System.out.print(filename);
    }

    public void IPTextField(ActionEvent actionEvent) {
            try {
                String ipAddress = InetAddress.getLocalHost().getHostAddress();
                textfield.setText(ipAddress);
            } catch (UnknownHostException e) {
                // handle exception appropriately
                e.printStackTrace();
            }
        }

    public void handledragdrop(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    public void handledropped(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.getDragboard().getFiles().forEach(file -> System.out.println(file.getAbsolutePath()));
        }
    }
}
