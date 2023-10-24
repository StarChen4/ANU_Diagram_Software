package com.pp1.digramsoft;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ScreenShooter {
    public WritableImage outputImage;
    public File outputFile;
    public FileChooser fileChooser;
    public Button screenShotButton = new Button("Screenshot");
    public ScreenShooter(double window_width, double window_height, Stage stage, Group root){
        this.screenShotButton.setLayoutX(window_width - 100);
        this.screenShotButton.setLayoutX(window_height - 40);
        root.getChildren().add(this.screenShotButton);
        this.screenShotButton.setOnAction(event -> {
            // take a screenshot of root
            outputImage = root.snapshot(null,null);
            fileChooser = new FileChooser();
            fileChooser.setTitle("Sava Image");
            outputFile = fileChooser.showSaveDialog(stage);
            // save it to the directory chosen by the user
            if (outputFile != null) {
                BufferedImage bufferedImage = convertFxImageToBufferedImage(outputImage);
                try {
                    ImageIO.write((RenderedImage) bufferedImage, "png", outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // read the image pixel by pixel and transform it into a BufferedImage
    private BufferedImage convertFxImageToBufferedImage(WritableImage fxImage) {
        int width = (int) fxImage.getWidth();
        int height = (int) fxImage.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        PixelReader pixelReader = fxImage.getPixelReader();
        int[] buffer = new int[width];
        for (int y = 0; y < height; y++) {
            pixelReader.getPixels(0, y, width, 1, PixelFormat.getIntArgbInstance(), buffer, 0, width);
            for (int x = 0; x < width; x++) {
                bufferedImage.setRGB(x, y, buffer[x]);
            }
        }
        return bufferedImage;
    }
}
