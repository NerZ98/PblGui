package com.example.javagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ReceiveTextField {
    @FXML
    private TextField ipReceiver;

    public ReceiveTextField(TextField ipReceiver){
        this.ipReceiver = ipReceiver;
    }

    public void handleInput(ActionEvent event){
        String input = ipReceiver.getText();
        String[] values =input.split(",");
        for (String value : values){
            System.out.println(value.trim());
        }
    }

    public void restrictToComma(KeyEvent event){
        if(!event.getCharacter().matches("[0-9]")){
            event.consume();
        }

    }

}
