package com.frontend.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Welcome extends BaseScene {

    

    public Welcome(int width, int height) {
        super(width, height);
    }

    @Override
    protected void buildScene() {
        // Init all components
        Label welcomeLabel = buildWelcomeLabel();
        StackPane addPlayerWindow =buildAddPlayerWindow();

        // Add components in anchorpane
        AnchorPane anchorPane = new AnchorPane(
            welcomeLabel, addPlayerWindow
        );
        anchorPane.setBackground(new Background(
            new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, null))
            );

        // Positoning
        welcomeLabel.setLayoutX((width - welcomeLabel.getPrefWidth()) / 2);
        addPlayerWindow.setLayoutX((width - addPlayerWindow.getPrefWidth()) / 2);
        addPlayerWindow.setLayoutY((height - addPlayerWindow.getPrefWidth()) / 2);

        scene = new Scene(anchorPane, width, height, Color.BLACK);
    }



    private Label buildWelcomeLabel() {
        Label label = new Label("Welcome to the Yathzee game");
        label.setFont(Font.font("Times new roman", 40));
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(
            new BackgroundFill(Color.rgb(255, 255, 255, 0.8),
                new CornerRadii(30),
                null
        )));
        label.setPrefWidth(calculateLabelWidth(label.getText(), label.getFont()) + 20);
        label.setPrefHeight(label.getFont().getSize() + 20);
        
        return label;
    }

    private double calculateLabelWidth(String text, Font font) {
        Text tempText = new Text(text);
        tempText.setFont(font);
        return tempText.getLayoutBounds().getWidth();
    }

    private StackPane buildAddPlayerWindow() {
        int widht = 200;
        int height = 100;
        Rectangle rectangle = new Rectangle(widht, height, Color.WHITE);

        StackPane stackPane = new StackPane(rectangle);
        stackPane.setPrefSize(200, 100);
        return stackPane;
    }

    private void addEventHandlers() {

    }
}
