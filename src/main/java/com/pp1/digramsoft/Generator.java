package com.pp1.digramsoft;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Generator extends Group {
    public Button button;
    public TextField[] textFields;
    public EntityType entityType;
    public Node[] colorSelect;
    public Group colorSelector;
    private boolean isColorSelectorVisable = false;

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
                this.isColorSelectorVisable = !this.isColorSelectorVisable;
                this.colorSelector.setVisible(this.isColorSelectorVisable);
            });
            this.colorSelector.getChildren().add(color);
        }
        this.colorSelector.setVisible(this.isColorSelectorVisable);
        this.getChildren().add(this.colorSelector);

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
            this.colorSelect[0].setOnMouseClicked(event -> {
                System.out.println("[Generator] Open color selector");

                this.isColorSelectorVisable = !this.isColorSelectorVisable;
                this.colorSelector.setLayoutX(210);
                this.colorSelector.setLayoutY(15);
                this.colorSelector.setVisible(isColorSelectorVisable);
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

        // STAKEHOLDER MAP
        if (this.entityType == EntityType.STAKEHOLDER_MAP) {
            /*        10
                +-----+-------+
                |50x50| 180x50|
                +-----+-------+10
                |  240x40     |
                +-------------+10
                |  240x40     |
                +-------------+
             */
            // colorSelect
            this.colorSelect = new Node[] {
                    new ImageView(new Image("com/pp1/digramsoft/assets/colorCircle.png", 50, 50, false, false)) // 210, 75, 25
            };
            this.colorSelect[0].setOnMouseClicked(event -> {
                System.out.println("[Generator] Open color selector");

                this.isColorSelectorVisable = !this.isColorSelectorVisable;
                this.colorSelector.setLayoutX(210);
                this.colorSelector.setLayoutY(15);
                this.colorSelector.setVisible(isColorSelectorVisable);
                this.colorSelector.toFront();
            });

            // TextFields
            this.textFields = new TextField[] {
                    new TextField(),  // x interest
                    new TextField()   // y influence
            };
            this.textFields[0].setMinWidth(240);
            this.textFields[0].setMinHeight(40);
            this.textFields[1].setMinWidth(240);
            this.textFields[1].setMinHeight(40);



        }



        // INIT
        this.getChildren().add(this.button);
        this.getChildren().addAll(this.textFields);
        this.getChildren().addAll(this.colorSelect);
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
