package com.pp1.digramsoft;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

import java.util.ArrayList;

/**
 * contains a button to show/hide grid
 * the grid consists of Lines
 */
public class Gridlines extends Group {
    public Button gridButton = new Button("Grid");
    public ArrayList<Line> horizonLines = new ArrayList<>();
    public ArrayList<Line> verticalLines = new ArrayList<>();
    public int horizonLineAmount = 10;
    public int verticalLineAmount = 15;
    public boolean isShown;
    public Gridlines(double window_width, double window_height, Group root){
        isShown = false;
        //initialization, draw those lines
        double horizonGap = window_width / verticalLineAmount;
        double verticalGap = window_height / horizonLineAmount;
        for (int i = 0; i < horizonLineAmount; i++) {
            horizonLines.set(i,new Line(i * horizonGap,0,i * horizonGap,window_height));
        }
        for (int i = 0; i < verticalLineAmount; i++) {
            horizonLines.set(i,new Line(0,i * verticalGap,window_width,i * verticalGap));
        }
        // if clicked, show those lines
        this.gridButton.setOnAction(event -> {
            if (!isShown
                    // avoid multiple adding
                    && root.getChildren().containsAll(horizonLines)){
                root.getChildren().addAll(horizonLines);
                root.getChildren().addAll(verticalLines);
            }
            else {
                root.getChildren().removeAll(horizonLines);
                root.getChildren().removeAll(verticalLines);
            }
        });
    }
}
