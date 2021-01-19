package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.service.PDFService;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class PdfMergeController implements Initializable {

    @Resource
    PDFService pdfService;
    @FXML
    private TextField pdfButton;
    @FXML
    private TextField pdfButton1;

    @FXML
    private TextField savePath;

    @FXML
    private TextField pdfName;

    private ResourceBundle resourceBundle;

    private String filePath;

    private String mergePDFPath;

    private List<String> fileList = new ArrayList<>();


    @FXML
    public void mergePDF(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.titleProperty().set("信息提示：");
        if (fileList.size()==0) {
            alert.headerTextProperty().set("请重新选择文件！");
            alert.showAndWait();
            pdfButton.setText("请选择需要合并的PDF文件1");
            pdfButton1.setText("请选择需要合并的PDF文件2");
            savePath.setText("请选择保存路径");
            pdfName.setText("请输入存储文件名");
            return;
        }else if (StringUtils.isEmpty(mergePDFPath)||
                mergePDFPath.endsWith("/.pdf")||
                mergePDFPath.endsWith("/")) {
            alert.headerTextProperty().set("请检查PDF输出路径！");
            alert.showAndWait();
            pdfButton.setText("请选择需要合并的PDF文件1");
            pdfButton1.setText("请选择需要合并的PDF文件2");
            savePath.setText("请选择保存路径");
            pdfName.setText("请输入存储文件名");
            fileList.clear();
            return;
        }else {
            try {
                pdfService.mergePdfFiles(fileList, mergePDFPath);
                alert.headerTextProperty().set("合并完成！");
                alert.showAndWait();
                pdfButton.setText("请选择需要合并的PDF文件1");
                pdfButton1.setText("请选择需要合并的PDF文件2");
                savePath.setText("请选择保存路径");
                pdfName.setText("请输入存储文件名");
                filePath="";
                fileList.clear();
            }catch (Exception e) {
                System.out.println("error");
                alert.headerTextProperty().set("合并发生错误！");
                alert.showAndWait();
                pdfButton.setText("请选择需要合并的PDF文件1");
                pdfButton1.setText("请选择需要合并的PDF文件2");
                savePath.setText("请选择保存路径");
                pdfName.setText("请输入存储文件名");
                fileList.clear();
                return;
            }
        }
    }

    @FXML
    public void selectPDF(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择PDF文件");
        Stage selectFile = new Stage();
        System.out.println(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All PDF", "*.pdf"));
        File file = fileChooser.showOpenDialog(selectFile);
        if (file != null) {
            try {
                System.out.println(file.getAbsolutePath());
                fileList.add(file.getAbsolutePath());
                pdfButton.setText(file.getName());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void selectPDF1(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择PDF文件");
        Stage selectFile = new Stage();
        System.out.println(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All PDF", "*.pdf"));
        File file1 = fileChooser.showOpenDialog(selectFile);
        if (file1 != null) {
            try {
                System.out.println(file1.getAbsolutePath());
                fileList.add(file1.getAbsolutePath());
                pdfButton1.setText(file1.getName());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void selectDirectory(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("选择保存目录");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = directoryChooser.showDialog(new Stage());
        if (file != null) {
            try {
                System.out.println(file.getAbsolutePath());
                filePath = file.getAbsolutePath();
                savePath.setText(filePath);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void inputName(){
        mergePDFPath = filePath+"/"+pdfName.getText()+".pdf";
        savePath.setText(mergePDFPath);
    }

    @FXML
    public void clear(){
        pdfName.setText(null);
    }

    @FXML
    public void back(){
        SpringBootApp.showView(MenuView.class);
    }







    @Override
    public void initialize(URL url, ResourceBundle rb){
        this.resourceBundle = rb;
    }
}
