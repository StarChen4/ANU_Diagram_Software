package com.pp1.digramsoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

public class HelloApplication extends Application {
    private final Group root = new Group();
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    Triangle highlighted = null;
    ArrayList<Triangle> triangles = new ArrayList<>();
    Triangle findNearestTriangle(double x, double y) {
//        System.out.println(triangles.get(0));
        int minDistanceTriIdx = -1;
        double minDistance = Double.POSITIVE_INFINITY;
        for (int triIdx = 0; triIdx < triangles.size(); triIdx++) {
            System.out.println(triangles.get(triIdx).x + " " + triangles.get(triIdx).x);
            if (minDistance > triangles.get(triIdx).getDistance(x, y)) {
                minDistance = triangles.get(triIdx).getDistance(x, y);
                minDistanceTriIdx = triIdx;
            }
        }
        if (minDistanceTriIdx == -1) return null;
        return triangles.get(minDistanceTriIdx);
    }
    void highlightedNearestTriangle(double x, double y) {
        if (highlighted != null) highlighted.setFill(Color.LIGHTGRAY);
        highlighted = findNearestTriangle(x, y);
        highlighted.setFill(Color.GREEN);
    }

    static class Triangle extends Polygon {
        double x;
        double y;
        double side;
        Triangle(double x, double y, double side) {
            this.x = x;
            this.y = y;
            this.side = side;
            updateTriangle();
        }

        private void updateTriangle() {
            double midLine = Math.sqrt((side * side) - (side * side / 4)) / 2;
            this.getPoints().addAll(0.0, -midLine,
                    side / 2, midLine,
                    -side / 2, midLine);
            this.setLayoutX(x);
            this.setLayoutY(y);
        }

        private double distance(double x, double y) {
            double distanceSquare = (this.x - x)*(this.x - x) + (this.y - y)*(this.y - y);
            return Math.sqrt(distanceSquare);
        }

        public double getDistance(double x, double y) {
            return distance(x, y);
        }
    }

    class DraggableTriangle extends Triangle {
        private double mousex;
        private double mousey;
        DraggableTriangle(double x, double y, double side) {
            super(x, y, side);
            this.setOnMousePressed(event -> {
                mousex = event.getSceneX();
                mousey = event.getSceneY();
//                System.out.println("mouseX/mouseY " + mousex + " " +mousey);

                this.toFront();
            });

            this.setOnMouseDragged(event -> {
                double deltaX = event.getSceneX() - mousex;
                double deltaY = event.getSceneY() - mousey;
//                System.out.println(this.x + " " + this.y + "\n" + deltaX + " " + deltaY + "\n");
                this.setLayoutX(this.getLayoutX() + deltaX);
                this.setLayoutY(this.getLayoutY() + deltaY);
                mousex = event.getSceneX();
                mousey = event.getSceneY();
                highlightedNearestTriangle(event.getSceneX(), event.getSceneY());
            });

            this.setOnMouseReleased(event -> {
                System.out.println("Highlighted rotate:" + highlighted.getRotate());
                this.setRotate(highlighted.getRotate());
                this.setLayoutX(highlighted.getLayoutX());
                this.setLayoutY(highlighted.getLayoutY());
            });
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);

//        Polygon tri = new Polygon();
//        tri.getPoints().addAll(0.0, -86.6,
//                100.0, 86.6,
//                -100.0, 86.6);
//        tri.setLayoutX((double) WINDOW_WIDTH /2);
//        tri.setLayoutY((double) WINDOW_HEIGHT /2);
//        Triangle tri = new Triangle((double) WINDOW_WIDTH / 2, (double) WINDOW_HEIGHT / 2, 200);
//        tri.setFill(Color.LIGHTGRAY);
//        this.root.getChildren().add(tri);
//
//
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 5; col++) {
//                Triangle grid = new Triangle((col + 1)*100, (row + 1) * 173.2 - 86.6, 196);
//                grid.setFill(Color.LIGHTGRAY);
//                if (col % 2 == 1) grid.setRotate(180);
//                triangles.add(grid);
//            }
//        }
//        this.root.getChildren().addAll(triangles);
//
//        DraggableTriangle dragTri = new DraggableTriangle((double) WINDOW_WIDTH / 2, (double) WINDOW_HEIGHT / 2, 200);
//        dragTri.setFill(Color.RED);
//        this.root.getChildren().add(dragTri);

        stage.setScene(scene);
        stage.show();
    }
}
