package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.service.DishService;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class RecordListController implements Initializable{
    @Resource
    DishService dishService;

    @FXML private TextField name;
    @FXML private TextField type;
    @FXML private TextField difficulty;
    @FXML private TextField cdm;
    @FXML private TextField food1;
    @FXML private TextField food2;
    @FXML private TextField food2Amount;
    @FXML private TextField food1Amount;

    @FXML public void send(){
    }

    @FXML public void back(){
        SpringBootApp.showView(MenuView.class);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}
