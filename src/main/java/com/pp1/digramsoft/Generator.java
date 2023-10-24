package com.pp1.digramsoft;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Arrays;

public class Generator extends Group {
    public Button button;
    public TextField[] textFields;
    public EntityType entityType;
    public Node[] colorSelect;
    public Group colorSelector;
    private boolean isColorSelectorVisible = false;
    private boolean hasLabel;
    public EntityType diagramType;
    public Generator(double x, double y, String buttonText, EntityType entityType, VBox toShow, Group root) {
        this.entityType = entityType;
        this.colorSelector = new Group();
        // color selector
        /*
            +-+-+---------------------+
            |O|O| ...
            +-+-+---
            60(50)
         */
        Region subWindow = new Region();
        subWindow.setStyle(
            "-fx-background-color: #e7e3e3;" +
            " -fx-border-style: solid;" +
            " -fx-border-width: 5;" +
            " -fx-border-color: #494949;" +
            " -fx-min-width: "+Stakeholder.StakeholderColor.values().length * 60+";" +
            " -fx-min-height: 60;"
        );
        this.colorSelector.getChildren().add(subWindow);
        for (int idx = 0; idx < Stakeholder.StakeholderColor.values().length; idx++) {
            Circle color = new Circle(60 * (idx + 0.5), 30, 25, Stakeholder.StakeholderColor.values()[idx].getColor());
            color.setOnMouseClicked(event -> {
                ((Circle) this.colorSelect[0]).setFill(color.getFill());
                this.isColorSelectorVisible = !this.isColorSelectorVisible;
                this.colorSelector.setVisible(this.isColorSelectorVisible);
            });
            this.colorSelector.getChildren().add(color);
        }
        this.colorSelector.setVisible(this.isColorSelectorVisible);
        root.getChildren().add(this.colorSelector);

        // STAKEHOLDER
        if (this.entityType == EntityType.STAKEHOLDER) {
            /*
             * +----------------+
             * | 240x40         |
             * +---------+------+10
             * | 180x50  | 50x50|
             * +---------+------+
             * 0         10     0
             */
            // TextFields
            this.textFields = new TextField[] {
                new TextField()
            };
            this.textFields[0].setMinWidth(240);
            this.textFields[0].setMinHeight(40);

            // colorSelect
            this.colorSelect = new Node[] {
                new Circle(210, 75, 25)
            };
            ((Circle) this.colorSelect[0]).setFill(Stakeholder.StakeholderColor.DARKGRAY.getColor());
            this.colorSelect[0].setOnMouseClicked(event -> {

                System.out.println("[Generator] Open color selector");

                this.isColorSelectorVisible = !this.isColorSelectorVisible;
                this.colorSelector.setLayoutX(210);
                this.colorSelector.setLayoutY(615);
                this.colorSelector.setVisible(isColorSelectorVisible);
                this.colorSelector.toFront();
            });
            // button
            this.button = new Button(buttonText);
            this.button.setOnAction(event -> {
                System.out.println("[Generator] input text: " + textFields[0].getText());

                Stakeholder stakeholder = new Stakeholder(this.textFields[0].getText(), (Color) ((Circle) this.colorSelect[0]).getFill(), true, root);
                stakeholder.setLayoutX(10);
                stakeholder.setLayoutY(10);
                toShow.getChildren().add(stakeholder);
//                root.getChildren().add(stakeholder);

                // reset
                this.textFields[0].setText("");
            });
            this.button.setMinWidth(180);
            this.button.setMinHeight(50);
            this.button.setLayoutY(50);

        }

        // MAP
        if (this.entityType == EntityType.DIAGRAM) {
            /*
                +-------------+
                |   240x50    |
                +-----+-+-----+10
                |50x50| |50x50|
                +-----+-+-----+10
                |  240x40     |
                +-------------+10
                |  240x40     |
                +-------------+10
                |  240x40     |
                +-------------+
             */

            // button
            this.button = new Button(buttonText);
            this.button.setOnAction(event -> {
                // Text field to String[]
                toShow.getChildren().clear();
                String[] text = new String[textFields.length];
                for (int idx = 0; idx < textFields.length; idx++) {
                    text[idx] = textFields[idx].getText();
                }
                System.out.println("[Generator] input text: " + Arrays.deepToString(text));
                // create


                System.out.println("[Generator] get isColorful: " + this.isColorSelectorVisible +
                        " isLabeled: " + this.hasLabel +
                        " title: " +
                        " Type: " + this.diagramType);
                Background background = new Background(diagramType, this.isColorSelectorVisible, this.hasLabel, text,
                        "", (HelloApplication.WINDOW_WIDTH - HelloApplication.LEFT_WINDOW_WIDTH - HelloApplication.RIGHT_WINDOW_WIDTH) * 0.8);
                background.toFront();
                toShow.getChildren().add(background);
                toShow.toBack();

                // reset
                this.textFields[0].setText("");
                this.textFields[1].setText("");
                this.textFields[2].setText("");
            });
            this.button.setMinWidth(240);
            this.button.setMinHeight(50);

            // colorSelect
            this.colorSelect = new Node[] {
                    new ImageView(new Image("file:src/main/java/com/pp1/digramsoft/assets/colorCircle.png",
                            50, 50, false, false)),
                    new Circle(215, 85, 25)
            };
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setSaturation(this.isColorSelectorVisible ? 0 : -0.8);
            this.colorSelect[0].setEffect(colorAdjust);
            this.colorSelect[0].setOnMouseClicked(event -> {

                System.out.println("[Generator] Open color selector");

                this.isColorSelectorVisible = !this.isColorSelectorVisible;
                // act as isColorful
                colorAdjust.setSaturation(this.isColorSelectorVisible ? 0 : -0.8);
                this.colorSelect[0].setEffect(colorAdjust);
            });
            this.colorSelect[0].setLayoutY(60);

            ((Circle) this.colorSelect[1]).setFill(this.hasLabel ? Color.RED : Color.BLACK);
            this.colorSelect[1].setOnMouseClicked(event -> {
                this.hasLabel = !this.hasLabel;
                System.out.println("[Generator] Set hasLabel to: " + this.hasLabel);
                ((Circle) this.colorSelect[1]).setFill(this.hasLabel ? Color.RED : Color.BLACK);
            });

            // TextFields
            this.textFields = new TextField[] {
                    new TextField(),  // x interest
                    new TextField(),  // y influence
                    new TextField()   // y influence
            };
            this.textFields[0].setMinWidth(240);
            this.textFields[0].setMinHeight(40);
            this.textFields[0].setLayoutY(120);
            this.textFields[1].setMinWidth(240);
            this.textFields[1].setMinHeight(40);
            this.textFields[1].setLayoutY(170);
            this.textFields[2].setMinWidth(240);
            this.textFields[2].setMinHeight(40);
            this.textFields[2].setLayoutY(220);



        }



        // INIT
        this.getChildren().add(this.button);
        this.getChildren().addAll(this.textFields);
        this.getChildren().addAll(this.colorSelect);
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public void setHasLabel(boolean hasLabel) {
        this.hasLabel = hasLabel;
    }

    public void setDiagramType(EntityType diagramType) {
        this.diagramType = diagramType;
    }
}
