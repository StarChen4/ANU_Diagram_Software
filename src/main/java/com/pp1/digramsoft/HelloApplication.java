package com.pp1.digramsoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public final Group root = new Group();
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final int LEFT_WINDOW_WIDTH = 260;
    private static final int LEFT_WINDOW_HEIGHT = 720;

    private final ArrayList<Stakeholder> stakeholders = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle leftWindow = new Rectangle(0, 0, LEFT_WINDOW_WIDTH, LEFT_WINDOW_HEIGHT);
        leftWindow.setFill(Color.GRAY);
        root.getChildren().add(leftWindow);

        Generator stakeholderGenerator = new Generator(10, 600, "Generate", EntityType.STAKEHOLDER, stakeholders, root);
        root.getChildren().add(stakeholderGenerator);

        stage.setScene(scene);
        stage.show();
    }
}
