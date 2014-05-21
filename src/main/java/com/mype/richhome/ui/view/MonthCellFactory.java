package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import com.mype.richhome.ui.vo.MonthVO;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class MonthCellFactory implements Callback<ListView<MonthVO>, ListCell<MonthVO>> {
    @Inject
    private ResourceBundle resourceBundle;

    @Override
    public ListCell<MonthVO> call(final ListView<MonthVO> param) {
        MonthCell monthCell = new MonthCell();
        monthCell.setResourceBundle(resourceBundle);
        monthCell.placeElements();

        return monthCell;
    }
}
