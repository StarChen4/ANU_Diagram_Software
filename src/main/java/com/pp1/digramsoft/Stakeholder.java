package com.pp1.digramsoft;


import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Stakeholder extends Group {
    private Color color;
    private String text;
    private boolean isDraggable;
    private boolean isVisible;
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
    }

    public Stakeholder(String name, Color color){
        this.text = name;
        this.color = color;
        this.isDraggable = true;
        this.isVisible = true;
    }
    public void setInvisible(){
        this.isVisible = false;
    }
}
