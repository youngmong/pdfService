package com.lss.controller;

import com.lss.SpringBootApp;
import com.lss.service.PDFService;
import com.lss.view.MenuView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class PdfSpliceController implements Initializable {

    @Resource
    PDFService pdfService;
    @FXML
    private Button pdfButton;

    private String pdfAbsolutePath;
    private String outPath;

    private Integer start;
    private Integer end;


    // 起始页码
    @FXML
    private TextField startPage;
    // 终止页码
    @FXML
    private TextField endPage;
    // 输出文件名称
    @FXML
    private TextField pdfSpliceName;


    @FXML
    public void selectPDF() {
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
                pdfAbsolutePath = file.getAbsolutePath();
                outPath = file.getParent();
                file.getAbsolutePath();
                pdfButton.setText(file.getName());
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
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void splice() {
        List<String> validateList = validateParam();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.titleProperty().set("信息提示：");
        if (!CollectionUtils.isEmpty(validateList)) {
            alert.headerTextProperty().set(validateList.get(0));
            alert.showAndWait();
            return;
        }
        System.out.println("pdfAbsolutePath -->" + pdfAbsolutePath);
        System.out.println("pdf output --> " + outPath + "/" + pdfSpliceName.getText() + ".pdf");
        String result = pdfService.splitPDF(pdfAbsolutePath,
                outPath + "/" + pdfSpliceName.getText() + ".pdf",
                Integer.parseInt(startPage.getText()),
                Integer.parseInt(endPage.getText()));

        if ("ok".equalsIgnoreCase(result)) {
            pdfButton.setText("请选择需要拆分的PDF文件");
            startPage.setText(null);
            endPage.setText(null);
            pdfSpliceName.setText(null);
            alert.headerTextProperty().set("拆分成功");
        }else {
            alert.headerTextProperty().set("拆分失败，失败原因为：\n"+result);
        }
        alert.showAndWait();
    }

    @FXML
    public void back() {
        pdfButton.setText("请选择需要拆分的PDF文件");
        startPage.setText(null);
        endPage.setText(null);
        pdfSpliceName.setText(null);
        SpringBootApp.showView(MenuView.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startPage.setText(null);
        endPage.setText(null);
        pdfSpliceName.setText(null);
    }

    private List<String> validateParam(){
        List<String> validateList = new ArrayList<>();
        if(StringUtils.isEmpty(pdfAbsolutePath) || !pdfAbsolutePath.endsWith(".pdf")){
            validateList.add("请选择PDF格式文件！");
        }
        try{
            start = Integer.parseInt(startPage.getText());
            end = Integer.parseInt(endPage.getText());
        }catch (NumberFormatException ne) {
            validateList.add("请输入正确的页码信息！");
        }
        if(StringUtils.isEmpty(pdfSpliceName.getText())) {
            validateList.add("请输入拆分后的PDF文件名称！");
        }
        return validateList;
    }
}
