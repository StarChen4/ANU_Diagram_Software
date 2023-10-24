package com.pp1.digramsoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public final Group root = new Group();
    public final VBox stakeholders = new VBox();
    public final VBox diagram = new VBox();
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final int LEFT_WINDOW_WIDTH = 260;
    private static final int LEFT_WINDOW_HEIGHT = 720;
    private static final int RIGHT_WINDOW_WIDTH = 260;
    private static final int RIGHT_WINDOW_HEIGHT = 720;

//    private final ArrayList<Stakeholder> stakeholders = new ArrayList<>();
    private final ArrayList<Stakeholder> inScreenStakeholders = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Window Background
        Rectangle leftWindow = new Rectangle(0, 0, LEFT_WINDOW_WIDTH, LEFT_WINDOW_HEIGHT);
        leftWindow.setFill(Color.GRAY);
        root.getChildren().add(leftWindow);
        // -> Stakeholder list
        stakeholders.setSpacing(10);
        ScrollPane stakeholderList = new ScrollPane(stakeholders);
        stakeholderList.pannableProperty().set(true);
        stakeholderList.setLayoutX(10);
        stakeholderList.setLayoutY(10);
        stakeholderList.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        stakeholderList.setPrefSize(LEFT_WINDOW_WIDTH - 20, LEFT_WINDOW_HEIGHT - 140);
        stakeholderList.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        stakeholderList.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.getChildren().add(stakeholderList);
        // Stakeholder Generator
        Generator stakeholderGenerator = new Generator(10, 600, "Generate", EntityType.STAKEHOLDER, stakeholders, this.root);
        root.getChildren().add(stakeholderGenerator);

        // Background


        // Window Background
        Rectangle rightWindow = new Rectangle(WINDOW_WIDTH - RIGHT_WINDOW_WIDTH, 0, RIGHT_WINDOW_WIDTH, RIGHT_WINDOW_HEIGHT);
        rightWindow.setFill(Color.GRAY);
        root.getChildren().add(rightWindow);
        // -> Diagram list

        // Stakeholder Map Generator
        Generator stakeholderMapGenerator = new Generator(WINDOW_WIDTH - RIGHT_WINDOW_WIDTH + 10, 300,
                "Change Text", EntityType.STAKEHOLDER_MAP, diagram, this.root);
        root.getChildren().add(stakeholderMapGenerator);





        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
