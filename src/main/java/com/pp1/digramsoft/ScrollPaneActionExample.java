package com.pp1.digramsoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class ScrollPaneActionExample extends Application {
    public void start(Stage stage) throws FileNotFoundException {
        //creating the image object
        Image image = new Image("https://github.com/ANU-COMP6250-Group4-Toolkit/D/blob/c9d3352544d065cb5121b1698792bf4b7a6bc0a9/src/main/java/com/pp1/digramsoft/assets/StakeholdersMap.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(5);
        imageView.setY(0);
        imageView.setFitWidth(595);
        imageView.setPreserveRatio(true);
        //Creating the scroll pane
        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(595, 600);
        //Setting content to the scroll pane
        scroll.setContent(imageView);
        //Setting the stage
        Group root = new Group();
        root.getChildren().addAll(scroll);
        Scene scene = new Scene(root, 595, 200, Color.BEIGE);
        stage.setTitle("Scroll Pane Example");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}