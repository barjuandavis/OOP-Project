package main;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


import java.util.Observer;

public class Cell extends TextField implements Observable, InvalidationListener {
    Property value;
    String temp;
    String computedValue;

    public Cell(Property value) {
        this.value = value;
//        value = new SimpleStringProperty("");
        setText("");
        setEditable(false);
        setCursor(Cursor.DEFAULT);
        setStyle("-fx-background-radius: 0");
        setOnAction(e -> {
            Table table = (Table) getParent();
            temp = getText();
            computedValue = temp;
            setEditable(false);
            table.setFocusedRow(table.getFocusedRow() + 1);

        });

        focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Table table = (Table) getParent();
                int col = GridPane.getColumnIndex(this);
                int row = GridPane.getRowIndex(this);
                table.setFocusedColumn(col);
                table.setFocusedRow(row);
                setCursor(Cursor.TEXT);
            } else {
                setEditable(false);
                setCursor(Cursor.DEFAULT);
            }

        });
        setOnMouseClicked((MouseEvent e) -> {
            if (isFocused()) {
                setEditable(true);
            } else {
                requestFocus();
            }
        });
    }

    public Cell() {
        this(null);
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }

    @Override
    public void invalidated(Observable observable) {

    }
}
