package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import com.mype.richhome.ui.vo.MonthVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class MonthViewImpl extends AbstractView implements MonthView {
    private static final String VIEW_NAME = "monthView";

    @Inject
    private MonthCellFactory monthCellFactory;

    @Inject
    private MonthViewMediator mediator;

    private final ObservableList<MonthVO> data = FXCollections.observableArrayList();
    private ListView<MonthVO> monthList = new ListView<>(data);

    protected void constructView(final Pane viewPane) {
        monthList.setCellFactory(monthCellFactory);
        monthList.setId("monthList");
        viewPane.getChildren().add(monthList);

        mediator.loadMonthList();
    }

    @Override
    protected String getViewName() {
        return VIEW_NAME;
    }

    public void setMediator(final MonthViewMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void updateMonthList(final List<MonthVO> months) {
        data.clear();
        data.addAll(months);
    }

}
