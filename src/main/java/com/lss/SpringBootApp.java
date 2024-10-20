package com.lss;

import com.lss.config.Splash;
import com.lss.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.application.Platform;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 */
@SpringBootApplication
public class SpringBootApp extends AbstractJavaFxApplicationSupport {
    public static void main( String[] args ) {
        launch(SpringBootApp.class, LoginView.class,new Splash(),args);
    }

    public static void exit() {
        Platform.exit();
    }
}
