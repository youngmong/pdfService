package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.view.*;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class MenuController implements Initializable {
    private ResourceBundle resourceBundle;

    /**
     * 食材模块
     */
    @FXML
    public void pdfMerge(){
        SpringBootApp.showView(PdfMergeView.class);
    }
    @FXML
    public void pdfSplice(){
        SpringBootApp.showView(PdfSpliceView.class);
    }
    @FXML
    public void igdQuality(){
        SpringBootApp.showView(IgdWatchView.class);
    }

    /**
     * 调味品模块
     */
    @FXML
    public void cdmList(){
        SpringBootApp.showView(CdmListView.class);
    }
    @FXML
    public void cdmWrite(){
        SpringBootApp.showView(CdmAddView.class);
    }

    /***
     * 菜品模块
     */
    @FXML
    public void wordRecord(){
        SpringBootApp.showView(WordRecordView.class);
    }
    @FXML
    public void recordList(){
        SpringBootApp.showView(RecordListView.class);
    }

    /**
     * 供应商模块
     */
    @FXML public void supplierList(){
        SpringBootApp.showView(SupplierListView.class);
    }
    @FXML public void supplierWrite(){
        SpringBootApp.showView(SupplierAddView.class);
    }

    /**
     * 用户模块
     */
    @FXML public void imageAllOf(){
        SpringBootApp.showView(ImageAllOfView.class);
    }
    @FXML public void accountDetail(){
        SpringBootApp.showView(UserDetailView.class);
    }
    @FXML public void exit(){
        SpringBootApp.exit();
    }

    /**
     * 帮助模块
     */
    @FXML
    public void usageMethod(){

    }
    @FXML
    public void problem(){

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        this.resourceBundle = rb;
    }
}
