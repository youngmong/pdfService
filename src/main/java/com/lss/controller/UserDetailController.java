package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class UserDetailController implements Initializable {


    @FXML public void back(){
        SpringBootApp.showView(MenuView.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}
