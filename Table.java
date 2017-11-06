package main;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Table extends GridPane{
    private static final int MAX_COLUMN = 32767;
    private static final int MAX_ROW = 32767;
    private static final int PREF_COLUMN = 100;
    private static final int PREF_ROW = 100;
    private static final double PREF_COLUMN_WIDTH = 100;
    private static final double PREF_ROW_HEIGHT = 25;
    private int focusedColumn;
    private int focusedRow;

    public Table(){
//        setGridLinesVisible(true);
        for(int i = 0; i<PREF_COLUMN; ++i){
            ColumnConstraints columnConstraints = new ColumnConstraints(PREF_COLUMN_WIDTH);
            getColumnConstraints().add(columnConstraints);
        }
        for(int i = 0; i<PREF_ROW; ++i){
            RowConstraints rowConstraints = new RowConstraints(PREF_ROW_HEIGHT);
            getRowConstraints().add(rowConstraints);
        }
        for(int i = 0; i<PREF_COLUMN; ++i){
            for(int j = 0; j<PREF_ROW; ++j){
                Cell cell = new Cell();
                cell.prefWidthProperty().bind(getColumnConstraints().get(i).prefWidthProperty());
                cell.prefHeightProperty().bind(getRowConstraints().get(j).prefHeightProperty());
                add(cell, i, j);
            }
        }
        focusedColumn = 0;
        focusedRow = 0;
    }

    public void setFocusedColumn(int focusedColumn) {
        this.focusedColumn = focusedColumn;
        System.out.println(focusedColumn);
    }

    public void setFocusedRow(int focusedRow) {
        this.focusedRow = focusedRow;
        System.out.println(focusedRow);
    }

    public int getFocusedColumn() {
        return focusedColumn;
    }

    public int getFocusedRow() {
        return focusedRow;
    }
}
