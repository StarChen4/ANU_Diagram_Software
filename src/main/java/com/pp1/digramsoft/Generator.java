package com.pp1.digramsoft;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Generator extends Group {
    public Button button;
    public TextField[] textFields;
    public EventHandler<ActionEvent>[] eventEventHandler;
    public EntityType entityType;
    public Circle[] colorSelect;

    public Generator(double x, double y, String buttonText, EntityType entityType, ArrayList<Stakeholder> stakeholders, Group root) {
        this.entityType = entityType;

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
            this.eventEventHandler = new EventHandler[] {
                event -> System.out.println("[Generator] input text: " + textFields[0].getText())
            };
            // colorSelect
            this.colorSelect = new Circle[] {
                new Circle(210, 75, 25)
            };
            this.colorSelect[0].setOnMouseClicked(event -> {
                System.out.println("[Generator] Open color selector");

            });
            // button
            this.button = new Button(buttonText);
            this.button.setOnAction(event -> {
                System.out.println("[Generator] input text: " + textFields[0].getText());

                Stakeholder stakeholder = new Stakeholder(this.textFields[0].getText(), (Color) this.colorSelect[0].getFill());
                stakeholder.setLayoutX(0);
                stakeholder.setLayoutY(0);
                root.getChildren().add(stakeholder);
                stakeholders.add(stakeholder);

                // reset
                this.textFields[0].setText("");
            });
            this.button.setMinWidth(180);
            this.button.setMinHeight(50);
            this.button.setLayoutY(50);

        }



        // INIT
        this.getChildren().add(this.button);
        this.getChildren().addAll(this.textFields);
        this.getChildren().addAll(this.colorSelect);
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
