package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import com.mype.richhome.ui.vo.MonthVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class MonthViewImpl implements MonthView {
    @Inject
    private MonthCellFactory monthCellFactory;

    @Inject
    private MonthViewMediator mediator;

    private MigPane rootPane;

    private final ObservableList<MonthVO> data = FXCollections.observableArrayList();
    private final ListView<MonthVO> monthList = new ListView<>(data);

    @Override
    public Pane getView() {
        if (rootPane == null) {
            this.rootPane = new MigPane("insets 0", "[grow, fill]", "[grow, fill]");

            constructView();
        }

        return rootPane;
    }

    protected void constructView() {
        monthList.setCellFactory(monthCellFactory);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(monthList);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        rootPane.add(scrollPane, "grow");

        mediator.loadMonthList();
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
