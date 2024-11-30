package app;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class App {
    public static void main(String[] args) {
        String[] test = {"Item 1", "Item 2", "Item 3"};
        ObservableList<String> observableList = FXCollections.observableArrayList(test);
        System.out.println(observableList.toString());

        // Add a listener to observe changes
        observableList.addListener((ListChangeListener<String>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    System.out.println("Added: " + change.getAddedSubList());
                }
                if (change.wasRemoved()) {
                    System.out.println("Removed: " + change.getRemoved());
                }
                if (change.wasUpdated()) {
                    System.out.println("Updated: " + observableList.get(change.getFrom()));
                }
            }
        });
        test[0] = "NEW ITEM";
    }
}
