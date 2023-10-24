package com.pp1.digramsoft;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
        // initialization, draw those lines
        double horizonGap = window_width / verticalLineAmount;
        double verticalGap = window_height / horizonLineAmount;
        for (int i = 0; i < verticalLineAmount; i++) {
            verticalLines.add(new Line(i * verticalGap,0,i * verticalGap,window_height));
        }
        for (int i = 0; i < horizonLineAmount; i++) {
            horizonLines.add(new Line(0,i * verticalGap,window_width,i * verticalGap));
        }
        // change the features of the lines
        for (int i = 0; i < verticalLineAmount; i++) {
            verticalLines.get(i).setStroke(Color.DARKGREY);
            verticalLines.get(i).setStrokeWidth(1);
            verticalLines.get(i).getStrokeDashArray().addAll(10.0, 5.0);
        }
        for (int i = 0; i < horizonLineAmount; i++) {
            horizonLines.get(i).setStroke(Color.DARKGREY);
            horizonLines.get(i).setStrokeWidth(1);
            horizonLines.get(i).getStrokeDashArray().addAll(10.0, 5.0);
        }
        // if clicked, show those lines
        this.gridButton.setOnAction(event -> {
            if (!isShown
                    // avoid multiple adding
                    && !root.getChildren().containsAll(horizonLines)){
                System.out.println("show grid");
                root.getChildren().addAll(1,horizonLines);
                root.getChildren().addAll(1,verticalLines);
                // adjust the order of lines and the diagram
//                for (int i = 0; i < verticalLineAmount; i++) {
//                    verticalLines.get(i).toBack();
//                }
//                for (int i = 0; i < horizonLineAmount; i++) {
//                    horizonLines.get(i).toBack();
//                }

            }
            else {
                System.out.println("hide grid");
                root.getChildren().removeAll(horizonLines);
                root.getChildren().removeAll(verticalLines);
            }
        });
    }
}
