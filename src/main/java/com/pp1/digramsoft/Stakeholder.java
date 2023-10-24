package com.pp1.digramsoft;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Stakeholder extends Group {
    private Color color;
    private String name;
    private boolean isDraggable;
    private boolean isVisible;
    private Circle circle;
    private double circleRadius = 20;
    private Text text;
    private double textSize = 20;
    // a copy of itself to stay at the original place
    private Stakeholder selfCopy;
    // determine to copy or not to avoid infinite copy
    private boolean needCopy;
    private double mouseX;
    private double mouseY;
    public enum StakeholderColor{
        RED(Color.RED),
        YELLOW(Color.YELLOW),
        GREEN(Color.GREEN),
        CYAN(Color.CYAN),
        BLACK(Color.BLACK),
        WHITE(Color.WHITE);
        private final Color color;
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
    public Stakeholder(String name, Color color, boolean needCopy){
        // initialization
        this.name = name;
        this.color = color;
        this.isDraggable = true;
        this.isVisible = true;
        this.needCopy = needCopy;

        // draw the circle
        this.circle = new Circle(circleRadius);
        this.circle.setFill(this.color);
        this.getChildren().add(this.circle);
        this.circle.setLayoutX(circleRadius);
        this.circle.setLayoutY(circleRadius);

        // generate the text
        this.text = new Text(this.name);
        this.text.setStyle("-fx-font-color: black; -fx-font-size: " + textSize + "px; -fx-font-weight: bold;");
        this.getChildren().add(this.text);
        this.text.setLayoutX(2 * circleRadius + textSize);
        this.text.setLayoutY(circleRadius * 5 / 4);

        // the copy of itself, cannot be dragged, no need to copy again
        if (needCopy) {
            this.selfCopy = new Stakeholder(this.name, this.color, false);
            this.selfCopy.setDraggable(false);
            this.getChildren().add(this.selfCopy);
        }

        // get the coordinate of mouse and move to the front when pressed
        this.setOnMousePressed(event -> {
            this.mouseX = event.getSceneX();
            this.mouseY = event.getSceneY();
            this.toFront();
        });
        // make the whole stakeholder draggable
        this.setOnMouseDragged(event -> {
            if (isDraggable){
                this.setLayoutX(this.getLayoutX() + event.getSceneX() - mouseX);
                this.setLayoutY(this.getLayoutY() + event.getSceneY() - mouseY);
                this.mouseX = event.getSceneX();
                this.mouseY = event.getSceneY();
            }
        });
    }

    public void setDraggable(boolean isDraggable){this.isDraggable = isDraggable;}
    public String toString(){
        return name;
    }
}
