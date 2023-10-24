package com.pp1.digramsoft;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Generator extends Group {
    public Button button;
    public TextField[] textFields;
    public EventHandler<ActionEvent>[] eventEventHandler;
    public EntityType entityType;
    public Circle[] colorSelect;

    public Generator(double x, double y, String buttonText, EntityType entityType) {
        this.entityType = entityType;

        if (this.entityType == EntityType.STAKEHOLDER) {
            // TextFields
            this.textFields = new TextField[] {
                new TextField()
            };
            this.textFields[0].setMinWidth(240);
            this.textFields[0].setMinHeight(30);
            this.eventEventHandler = new EventHandler[] {
                event -> System.out.println("[Generator] input text: " + textFields[0].getText())
            };
            // colorSelect
            this.colorSelect = new Circle[] {
                new Circle()
            };
            // button
            this.button = new Button(buttonText);
            this.button.setOnAction(event -> {
                System.out.println("[Generator] input text: " + textFields[0].getText());
            });
            this.button.setMinWidth(180);
            this.button.setMinHeight(30);
            this.button.setLayoutX(0);
            this.button.setLayoutY(0);

        }



        // INIT
        this.getChildren().add(this.button);
        this.getChildren().addAll(this.textFields);
        this.getChildren().addAll(this.colorSelect);
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
}
