package com.pp1.digramsoft;

import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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

    Image blackWhiteRainbow = new Image("file:src/main/java/com/pp1/digramsoft/assets/LabeledRainbowDiagram.png");
    Image unlabledBlackWhiteRainbow = new Image("file:src/main/java/com/pp1/digramsoft/assets/unlabeledRainbowDiagram.png");
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

    public Background(EntityType entityType, boolean isColorful, boolean isLabeled, String[] text, String title, double width){
        this.isColorful = isColorful;
        this.isLabeled = isLabeled;
        System.out.println("[Background] init with Type: " + entityType + " color: " + isColorful + " label: " + isLabeled);
        if (entityType == EntityType.RAINBOW_CHART && isColorful && isLabeled){
            this.setImage(colouredRainbow);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text textEntity3 = new Text(text[2]);
            Text titleOfGraph = new Text(title);
        }

        if (entityType == EntityType.RAINBOW_CHART && !isColorful && !isLabeled){
            this.setImage(unlabledBlackWhiteRainbow);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text textEntity3 = new Text(text[2]);
            Text titleOfGraph = new Text(title);
        }
        if (entityType == EntityType.RAINBOW_CHART && !isColorful && isLabeled){
            this.setImage(blackWhiteRainbow);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text textEntity3 = new Text(text[2]);
            Text titleOfGraph = new Text(title);
        }
        if (entityType == EntityType.STAKEHOLDER_MAP && !isColorful && isLabeled){
            this.setImage(labeledStakeholdersMap);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text titleOfGraph = new Text(title);
        }
        if (entityType == EntityType.STAKEHOLDER_MAP && !isColorful && !isLabeled){
            this.setImage(unlabeledStakeholdersMap);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text titleOfGraph = new Text(title);
        }
        if (entityType == EntityType.STAKEHOLDER_MAP && isColorful && isLabeled){
            this.setImage(colouredLabeledStakeholdersMap);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text titleOfGraph = new Text(title);
        }
        if (entityType == EntityType.STAKEHOLDER_MAP && isColorful && !isLabeled){
            this.setImage(colouredUnlabeledStakeholdersMap);
            this.setFitWidth(width);
            this.setPreserveRatio(true);
            Text textEntity1 = new Text(text[0]);
            Text textEntity2 = new Text(text[1]);
            Text titleOfGraph = new Text(title);
        }
    }





}
