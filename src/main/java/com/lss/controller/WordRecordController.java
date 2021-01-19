package com.lss.controller;


import com.lss.SpringBootApp;
import com.lss.pojo.VO.DishVO;
import com.lss.service.DishService;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.HTMLEditor;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class WordRecordController implements Initializable {

    @Resource
    DishService dishService;

    public ObservableList<DishVO> list = FXCollections.observableArrayList();

    @FXML
    private HTMLEditor editor;




    @FXML private void back(){
        SpringBootApp.showView(MenuView.class);
    }

    @FXML
    private void save(){
        System.out.println("保存内容为：");
        System.out.println(editor.getHtmlText());
    }

    @FXML private void delete(){

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}
