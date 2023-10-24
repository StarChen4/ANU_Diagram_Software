package com.pp1.digramsoft;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Stakeholder extends Group {
    private Color color;
    private String name;
    private boolean isDraggable;
    public boolean notSeparated;
    private Circle circle;
    private double circleRadius = 20;
    private Text text;
    private double textSize = 20;
    // a copy of itself to stay at the original place
    public Group draggablePart = new Group();
    public Stakeholder selfCopy;
    // determine to copy or not to avoid infinite copy
    private boolean needCopy;
    private double mouseX;
    private double mouseY;
    public enum StakeholderColor{
        YELLOW("#fbc82f"),
        RED("#cc163a"),
        GREEN("#5bae23"),
        BLUE("#1a94bc"),
        DARKGRAY("#393733"),
        WHITE("#f8f4ed");
        private final Color color;
        StakeholderColor(String color){
            this.color = Color.web(color);
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
        this.notSeparated = true;
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
            // only execute this part below when the draggablePart and the selfCopy are not separated
            if (notSeparated) {
                addDraggableInScreen(root);
                // avoid separating the selfCopy
                this.selfCopy.notSeparated = false;
            }
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

    /**
     * when clicked
     * remove the draggable part from the VBox
     * and move it into the stage root
     * leave the selfCopy in the VBox
     * @param root the stage root
     */
    public void addDraggableInScreen(Group root){
        System.out.println("now the stakeholder " + this + "has children " + this.getChildren());
        if (this.getChildren().contains(draggablePart)) {
            this.getChildren().remove(draggablePart);
            System.out.println("draggablePart has been removed from the original stakeholder group");
            if (!root.getChildren().contains(draggablePart)) {
                root.getChildren().add(draggablePart);
                System.out.println("draggablePart has been added into the root");
            }
        }
        else System.out.println("the draggablePart has already been dragged away");
    }
    public void setDraggable(boolean isDraggable){this.isDraggable = isDraggable;}
    public Stakeholder getSelfCopy(){return selfCopy;}

    public String toString(){
        return name;
    }
}
