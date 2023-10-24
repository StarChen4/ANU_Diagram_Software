package com.pp1.digramsoft;


import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Stakeholder extends Group {
    private Color color;
    private String text;
    private boolean isDraggable;
    private boolean isVisible;
    private double mouseX;
    private double mouseY;
    public enum StakeholderColor{
        RED(Color.RED),
        YELLOW(Color.YELLOW),
        GREEN(Color.GREEN),
        CYAN(Color.CYAN),
        BLACK(Color.BLACK),
        WHITE(Color.WHITE);
        public final Color color;
        StakeholderColor(Color color){
            this.color = color;
        }
        public Color getColor(){return color;}
    }

    /**
     * constructor: set the color and the text of stakeholder
     * and make it draggable
     * @param name a String representing the name of it
     * @param color the color
     */
    public Stakeholder(String name, Color color){
        // initialization
        this.text = name;
        this.color = color;
        this.isDraggable = true;
        this.isVisible = true;
        // get the coordinate of mouse and move to the front when pressed
        this.setOnMousePressed(event -> {
            this.mouseX = event.getSceneX();
            this.mouseY = event.getSceneY();
            this.toFront();
        });
        // make it draggable
        this.setOnMouseDragged(event -> {
            this.setLayoutX(this.getLayoutX() + event.getSceneX() - mouseX);
            this.setLayoutY(this.getLayoutY() + event.getSceneY() - mouseY);
            this.mouseX = event.getSceneX();
            this.mouseY = event.getSceneY();
        });
    }
}
