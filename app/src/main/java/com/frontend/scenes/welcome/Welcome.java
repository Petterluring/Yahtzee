package com.frontend.scenes.welcome;


import com.frontend.scenes.BaseScene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Welcome extends BaseScene {
    private TextField firstName;
    private TextField lastName;
    private Button add;
    private Button start;
    private TextField messagePrompt;
    

    public Welcome(int width, int height) {
        super(width, height);
    }

    @Override
    protected void buildScene() {
        // Init all components
        StackPane welcomeLabel = buildWelcomeLabel();
        StackPane addPlayerWindow = buildAddPlayerWindow();

        // Add components in anchorpane
        AnchorPane anchorPane = new AnchorPane(
            welcomeLabel, addPlayerWindow
        );

        // Positoning
        AnchorPane.setLeftAnchor(welcomeLabel, (width - welcomeLabel.getPrefWidth()) / 2);
        AnchorPane.setRightAnchor(welcomeLabel, (height - welcomeLabel.getPrefHeight()) / 2);
        AnchorPane.setRightAnchor(addPlayerWindow, ((width - addPlayerWindow.getPrefWidth()) / 2));
        AnchorPane.setLeftAnchor(addPlayerWindow, ((width - addPlayerWindow.getPrefWidth()) / 2));
        AnchorPane.setTopAnchor(addPlayerWindow, ((width - addPlayerWindow.getPrefHeight()) / 2));
        AnchorPane.setBottomAnchor(addPlayerWindow, ((width - addPlayerWindow.getPrefHeight()) / 2));


        // Create background
        Image image = new Image("Welcome.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(100, 100,
            true, true, true, true)
        );

        // Set the background image to the Pane
        anchorPane.setBackground(new Background(backgroundImage));
        scene = new Scene(anchorPane, width, height);


    }

    private StackPane buildWelcomeLabel() {
        // Label
        Label label = new Label("Welcome to the Yathzee game");
        label.setFont(Font.font("Times new roman", 40));
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(calculateLabelWidth(label.getText(), label.getFont()) + 20);
        label.setPrefHeight(label.getFont().getSize() + 20);

        // Background
        Rectangle rec = new Rectangle(label.getPrefWidth() + 5, label.getPrefHeight() + 5, Color.WHITE);
        rec.setArcHeight(20);
        rec.setArcWidth(20);

        // Stacking objects
        StackPane stackPane = new StackPane(rec, label);
        stackPane.setPrefSize(rec.getWidth(), rec.getHeight());
        return stackPane;
    }

    private double calculateLabelWidth(String text, Font font) {
        Text tempText = new Text(text);
        tempText.setFont(font);
        return tempText.getLayoutBounds().getWidth();
    }

    private StackPane buildAddPlayerWindow() {
        // Add text fields to a vBox
        initTextFields();
        VBox textFields = new VBox(firstName, lastName);
        textFields.setAlignment(Pos.CENTER);
        textFields.setSpacing(5);

        // Add background
        Rectangle rec = new Rectangle(1000 * 0.4, 600 * 0.4, Color.rgb(255, 255, 255, 0.9));

        rec.setArcHeight(20);
        rec.setArcWidth(20);
        
        // Add buttons
        initAddButton();
        initStartButton();
        
        // Adding buttons and text fields in vBox
        VBox vBox = new VBox(textFields, add, start);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        
        // Stack objects
        StackPane stackPane = new StackPane(rec, vBox);
        stackPane.setPrefWidth(rec.getWidth());
        stackPane.setPrefHeight(rec.getHeight());

        stackPane.setPrefSize(rec.getWidth(), rec.getHeight());
        return stackPane;
    }

    private void initTextFields() {
         // init text fields
         firstName = new TextField();
         lastName = new TextField();
 
         // Style text fields starting with width and height
         int value = 200;
         firstName.setMaxWidth(value);
         firstName.setMinWidth(value);
         lastName.setMaxWidth(value);
         lastName.setMinWidth(value);
 
         // Adding background look
         int cornerRadii = 20;
         Background background = new Background(new BackgroundFill(
             Color.WHITE, new CornerRadii(cornerRadii), null
         ));
         firstName.setBackground(background);
         lastName.setBackground(background);
 
         // Prompt text
         firstName.setPromptText("First name");
         lastName.setPromptText("Last name");
 
         // Border strokes
         BorderStroke borderStroke = new BorderStroke(
             Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(cornerRadii), null);
         Border border = new Border(borderStroke);
         firstName.setBorder(border);
         lastName.setBorder(border);
        
    }

    private void initAddButton() {
        add = new Button("Add player");
        add.setPrefSize(100, 100);
        add.setBackground(new Background(new BackgroundFill(
            Color.WHITE, new CornerRadii(20), null
        )));
        add.setBorder(new Border(new BorderStroke(
            Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), null)));
    }

    private void initStartButton() {
        start = new Button("Start game");
        start.setPrefSize(100, 100);
        start.setBackground(new Background(new BackgroundFill(
            Color.WHITE, new CornerRadii(20), null
        )));
        start.setBorder(new Border(new BorderStroke(
            Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(20), null)));
    }
}
