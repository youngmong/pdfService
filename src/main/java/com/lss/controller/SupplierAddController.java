package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.pojo.entity.Supplier;
import com.lss.service.SupplierService;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class SupplierAddController implements Initializable {
    @Resource
    SupplierService supplierService;

    @FXML private TextField name;
    @FXML private TextField number;
    @FXML private TextField plantSize;
    @FXML private TextField firstGrade;
    @FXML private TextField address;
    @FXML private TextField grade;

    @FXML private void back1(){
        SpringBootApp.showView(MenuView.class);
    }

    @FXML private void send(){
        Supplier supplier = new Supplier(name.getText(),number.getText(),Integer.parseInt(grade.getText()),
              Integer.parseInt(firstGrade.getText()),address.getText(),plantSize.getText() );

        if(supplierService.SupplierAdd(supplier)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("信息提示：");
            alert.headerTextProperty().set("添加成功！");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("信息提示：");
            alert.headerTextProperty().set("添加失败！");
            alert.showAndWait();
        }
    }



    @Override
    public  void  initialize(URL url, ResourceBundle resourceBundle){

    }
}
