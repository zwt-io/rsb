package io.zwt.ui;

import io.zwt.ui.ChartApplication.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:chart.fxml")
    private Resource stageResource;
    private ApplicationContext applicationContext;

    public StageInitializer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent stageReadyEvent) {

        Stage stage = stageReadyEvent.getStage();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(stageResource.getURL());
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));

            Parent parent = fxmlLoader.load();
            stage.setScene(new Scene(parent, 800, 600));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
