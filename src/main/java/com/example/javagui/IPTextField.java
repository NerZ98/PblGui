package com.example.javagui;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.scene.control.TextField;

public class IPTextField extends TextField {

    public IPTextField() {
        super();
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            setText(ipAddress);
        } catch (UnknownHostException e) {
            // handle exception appropriately
            e.printStackTrace();
        }
    }

}