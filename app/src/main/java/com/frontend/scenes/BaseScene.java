package com.frontend.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * A base scene which the other scenes extends.
 */
public abstract class BaseScene {
    protected int width;
    protected int height;
    protected Scene scene;

    public BaseScene(int width, int height) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero");
        }
        this.width = width;
        this.height = height;
        this.scene = buildScene();
    }

    /**
     * Building a basic scene with a label in the middle. The extending classes
     * should overrite this method when building their scene.
     */
    private Scene buildScene() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Label label = new Label("This is an abstract scene");
        hBox.getChildren().add(label);
        return new Scene(hBox, width, height);
    }

    public Scene getScene() {
        return scene;
    }
}
