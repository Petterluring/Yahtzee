package com.frontend.scenes;

import com.viewmodels.BaseViewModel;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * A base scene which the other scenes extends.
 */
public abstract class BaseScene {
    protected int width;
    protected int height;
    protected Scene scene;
    protected BaseViewModel viewModel;

    public BaseScene(int width, int height) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero");
        }
        this.width = width;
        this.height = height;
        buildScene();
    }

    /**
     * Building a basic scene with a label in the middle. The extending classes
     * should overrite this method when building their scene.
     */
    protected void buildScene() {
        Label label = new Label("This is an abstract scene");
        label.setFont(Font.font("Times new roman", 20));
        HBox hBox = new HBox(label);
        hBox.setAlignment(Pos.CENTER);
        scene = new Scene(hBox, width, height);
    }

    public Scene getScene() {
        return scene;
    }
}
