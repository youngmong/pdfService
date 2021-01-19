package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.service.UserService;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class LoginController implements Initializable{
    @Resource
    UserService userService;

    @FXML private TextField accountInput;
    @FXML private PasswordField passwordInput;
    private ResourceBundle resourceBundle;

    @FXML public void login(ActionEvent event){
        System.out.println("密码输入错误！请重新输入！"+accountInput.getText());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.titleProperty().set("信息提示：");
        alert.headerTextProperty().set("密码输入错误！请重新输入！");
        alert.showAndWait();
        /*if(userService.userLoginCheck(accountInput.getText(),passwordInput.getText())){
            System.out.println("欢迎进入菜单！");
            SpringBootApp.showView(MenuView.class);
        }else {
            System.out.println("密码输入错误！请重新输入！");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.titleProperty().set("信息提示：");
            alert.headerTextProperty().set("密码输入错误！请重新输入！");
            alert.showAndWait();
        }*/
    }

    @FXML public void manage(){
        SpringBootApp.showView(MenuView.class);
    }

    @FXML
    public void clearAll(ActionEvent event){
        accountInput.setText(null);
        passwordInput.setText(null);
    }

    @FXML
    public void exitBtn(){
        SpringBootApp.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.resourceBundle = rb;
    }
}
