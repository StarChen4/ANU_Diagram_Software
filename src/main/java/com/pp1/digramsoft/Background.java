package com.pp1.digramsoft;

import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class Background extends ImageView {
/*
• type: stakeholderMap/ RainbowChart/ ...
• I/ color!]: 1
1 3/...
• colorType: colorful/ black&white
• //image]

•Image image = new Image("flower.png");

          // simple displays ImageView the image as is
          ImageView iv1 = new ImageView();
          iv1.setImage(image);

          // resizes the image to have width of 100 while preserving the ratio and using
          // higher quality filtering method; this ImageView is also cached to
          // improve performance
          ImageView iv2 = new ImageView();
          iv2.setImage(image);
          iv2.setFitWidth(100);
          iv2.setPreserveRatio(true);
          iv2.setSmooth(true);
          iv2.setCache(true);

          // defines a viewport into the source image (achieving a "zoom" effect) and
          // displays it rotated
          ImageView iv3 = new ImageView();
          iv3.setImage(image);
          Rectangle2D viewportRect = new Rectangle2D(40, 35, 110, 110);
          iv3.setViewport(viewportRect);
          iv3.setRotate(90);

          Group root = new Group();
          Scene scene = new Scene(root);
          scene.setFill(Color.BLACK);
          HBox box = new HBox();
          box.getChildren().add(iv1);
          box.getChildren().add(iv2);
          box.getChildren().add(iv3);
          root.getChildren().add(box);

          stage.setTitle("ImageView");
          stage.setWidth(415);
          stage.setHeight(200);
          stage.setScene(scene);
          stage.sizeToScene();
          stage.show();
      }
 */

    Image blackWhiteRainbow = new Image("file:src/main/java/com/pp1/digramsoft/assets/BlackWhiteRainbow.png");
    Image colouredRainbow = new Image("file:src/main/java/com/pp1/digramsoft/assets/ColouredRainbow.png");
    Image unlabeledStakeholdersMap = new Image("file:src/main/java/com/pp1/digramsoft/assets/UnlabeledStakeholdersMap.png");
    Image labeledStakeholdersMap = new Image("file:src/main/java/com/pp1/digramsoft/assets/LabeledStakeholdersMap.png");
    Image colouredLabeledStakeholdersMap = new Image("file:src/main/java/com/pp1/digramsoft/assets/ColouredLabeledStakeholdersMap.png");

    Image colouredUnlabeledStakeholdersMap = new Image("file:src/main/java/com/pp1/digramsoft/assets/ColouredUnlabeledStakeholdersMap.png");

//   ImageView stakeHolderImage = new ImageView(stakeholdersMap);
//   ImageView colouredRainbowImage = new ImageView(colouredRainbow);
//   ImageView blackWhiteRainbowImage = new ImageView(blackWhiteRainbow);


    boolean isColorful;
    boolean isLabeled;

    public Text[] textEntities;
    public void setTextEntities(String[] text) {
        textEntities = new Text[text.length];
        for (int idx = 0; idx < textEntities.length; idx++) {
            textEntities[idx] = new Text(text[idx]);
        }
    }

    public Background(EntityType entityType, boolean isColorful, boolean isLabeled, String[] text, double width){
        this.isColorful = isColorful;
        this.isLabeled = isLabeled;
        setTextEntities(text);
        System.out.println("[Background] init with Type: " + entityType + " color: " + isColorful + " label: " + isLabeled);
        if (entityType == EntityType.RAINBOW_CHART && isColorful && isLabeled) {
            this.setImage(colouredRainbow);
            this.setFitWidth(width+150);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];

            textEntity1.rotateProperty();
            textEntity2.rotateProperty().set(270);
            textEntity3.rotateProperty().set(90);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(100);
            textEntity2.setLayoutX(250);
            textEntity2.setLayoutY(300);
            textEntity3.setLayoutX(930);
            textEntity3.setLayoutY(300);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);

        }
        if (entityType == EntityType.RAINBOW_CHART && !isColorful && isLabeled){
            this.setImage(blackWhiteRainbow);
            this.setFitWidth(width+150);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];

            textEntity1.rotateProperty();
            textEntity2.rotateProperty().set(270);
            textEntity3.rotateProperty().set(90);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(100);
            textEntity2.setLayoutX(250);
            textEntity2.setLayoutY(300);
            textEntity3.setLayoutX(930);
            textEntity3.setLayoutY(300);
            textEntity1.rotateProperty();
            textEntity2.rotateProperty().set(270);
            textEntity3.rotateProperty().set(90);
            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);
        }
        if (entityType == EntityType.RAINBOW_CHART && isColorful && !isLabeled){
            this.setImage(colouredRainbow);
            this.setFitWidth(width+150);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];

            textEntity1.rotateProperty();
            textEntity2.rotateProperty().set(270);
            textEntity3.rotateProperty().set(90);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(100);
            textEntity2.setLayoutX(250);
            textEntity2.setLayoutY(300);
            textEntity3.setLayoutX(930);
            textEntity3.setLayoutY(300);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);
        }
        if (entityType == EntityType.RAINBOW_CHART && !isColorful && !isLabeled){
            this.setImage(blackWhiteRainbow);
            this.setFitWidth(width+150);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];
            textEntity1.rotateProperty();
            textEntity2.rotateProperty().set(270);
            textEntity3.rotateProperty().set(90);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(100);
            textEntity2.setLayoutX(250);
            textEntity2.setLayoutY(300);
            textEntity3.setLayoutX(930);
            textEntity3.setLayoutY(300);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);
        }
        if (entityType == EntityType.STAKEHOLDER_MAP && !isColorful && isLabeled){
            this.setImage(labeledStakeholdersMap);
            this.setFitWidth(width+100);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];
            textEntity1.rotateProperty();
            textEntity2.rotateProperty();
            textEntity3.rotateProperty().set(270);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(80);
            textEntity2.setLayoutX(600);
            textEntity2.setLayoutY(680);
            textEntity3.setLayoutX(300);
            textEntity3.setLayoutY(350);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);

        }
        if (entityType == EntityType.STAKEHOLDER_MAP && !isColorful && !isLabeled){
            this.setImage(unlabeledStakeholdersMap);
            this.setFitWidth(width+100);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];
            textEntity1.rotateProperty();
            textEntity2.rotateProperty();
            textEntity3.rotateProperty().set(270);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(80);
            textEntity2.setLayoutX(600);
            textEntity2.setLayoutY(680);
            textEntity3.setLayoutX(300);
            textEntity3.setLayoutY(350);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);

        }
        if (entityType == EntityType.STAKEHOLDER_MAP && isColorful && isLabeled){
            this.setImage(colouredLabeledStakeholdersMap);
            this.setFitWidth(width+100);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];
            textEntity1.rotateProperty();
            textEntity2.rotateProperty();
            textEntity3.rotateProperty().set(270);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(80);
            textEntity2.setLayoutX(600);
            textEntity2.setLayoutY(680);
            textEntity3.setLayoutX(300);
            textEntity3.setLayoutY(350);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);

        }
        if (entityType == EntityType.STAKEHOLDER_MAP && isColorful && !isLabeled){
            this.setImage(colouredUnlabeledStakeholdersMap);
            this.setFitWidth(width+100);
            this.setPreserveRatio(true);
            Text textEntity1 = textEntities[0];
            Text textEntity2 = textEntities[1];
            Text textEntity3 = textEntities[2];
            textEntity1.rotateProperty();
            textEntity2.rotateProperty();
            textEntity3.rotateProperty().set(270);
            textEntity1.setLayoutX(600);
            textEntity1.setLayoutY(80);
            textEntity2.setLayoutX(600);
            textEntity2.setLayoutY(680);
            textEntity3.setLayoutX(300);
            textEntity3.setLayoutY(350);

            for ( Text t : textEntities) {
                t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,20));
                t.setFill(Color.DARKSLATEGRAY);
                t.toFront();
            }
            HelloApplication.root.getChildren().addAll(textEntities);
        }
    }





}
