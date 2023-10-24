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
    private Group draggablePart = new Group();
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
     * @param needCopy whether this is one stakeholder with copy or not
     */
    public Stakeholder(String name, Color color, boolean needCopy, Group root){
        // initialization
        this.name = name;
        this.color = color;
        this.isDraggable = true;
        this.isVisible = true;
        this.needCopy = needCopy;

        // draw the circle
        this.circle = new Circle(circleRadius);
        this.circle.setFill(this.color);
        this.draggablePart.getChildren().add(this.circle);
        this.circle.setLayoutX(circleRadius);
        this.circle.setLayoutY(circleRadius);

        // generate the text
        this.text = new Text(this.name);
        this.text.setStyle("-fx-font-color: black; -fx-font-size: " + textSize + "px; -fx-font-weight: bold;");
        this.draggablePart.getChildren().add(this.text);
        this.text.setLayoutX(2 * circleRadius + textSize);
        this.text.setLayoutY(circleRadius * 5 / 4);

        // the copy of itself, cannot be dragged, no need to copy again
        if (needCopy) {
            this.selfCopy = new Stakeholder(this.name, this.color, false, root);
            this.selfCopy.setDraggable(false);
            this.getChildren().add(this.selfCopy);
        }

        // set it draggable
        this.getChildren().add(this.draggablePart);
        this.draggablePart.setOnMousePressed(event -> {
            this.mouseX = event.getSceneX();
            this.mouseY = event.getSceneY();
            this.draggablePart.toFront();
            addInScreen(root);
        });
        // make the whole stakeholder draggable
        this.draggablePart.setOnMouseDragged(event -> {
            if (isDraggable){
                this.draggablePart.setLayoutX(this.draggablePart.getLayoutX() + event.getSceneX() - mouseX);
                this.draggablePart.setLayoutY(this.draggablePart.getLayoutY() + event.getSceneY() - mouseY);
                this.mouseX = event.getSceneX();
                this.mouseY = event.getSceneY();
            }
        });
    }

    public void addInScreen(Group root){
        if (this.getChildren().contains(draggablePart)) {
            this.getChildren().remove(draggablePart);
            if (root.getChildren().contains(draggablePart))
                root.getChildren().add(draggablePart);
        }
    }
    public void setDraggable(boolean isDraggable){this.isDraggable = isDraggable;}
    public Stakeholder getSelfCopy(){return selfCopy;}
    public String toString(){
        return name;
    }
}
