package com.pp1.digramsoft;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class testXing extends Application {
    private Stakeholder stakeholders;
    private Group root = new Group();
    private int WINDOW_HEIGHT = 700;
    private int WINDOW_WIDTH = 1200;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stakeholders = new Stakeholder("Name", Color.RED);
        root.getChildren().add(stakeholders);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
