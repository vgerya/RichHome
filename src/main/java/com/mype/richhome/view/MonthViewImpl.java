package com.mype.richhome.view;

import com.google.inject.Inject;
import com.mype.richhome.vo.MonthVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class MonthViewImpl extends AbstractView implements MonthView {
    @Inject
    private MonthViewMediator mediator;

    private final ObservableList<MonthVO> data = FXCollections.observableArrayList();
    private ListView<MonthVO> monthList = new ListView<>(data);

    protected void constructView(final Pane viewPane) {
        monthList.setCellFactory(new MonthRenderer());
        viewPane.getChildren().add(monthList);

        mediator.loadMonthList();
    }

    @Override
    public void updateMonthList(final List<MonthVO> months) {
        data.clear();
        data.addAll(months);
    }

    private static class MonthRenderer implements Callback<ListView<MonthVO>, ListCell<MonthVO>> {
        @Override
        public ListCell<MonthVO> call(final ListView<MonthVO> param) {
            return new MonthCell();
        }
    }

    private static class MonthCell extends ListCell<MonthVO> {
        private final FlowPane rootPane = new FlowPane();
        private final Label monthLabel = new Label();
        private final Label yearLabel = new Label();

        @Override
        protected void updateItem(final MonthVO item, final boolean empty) {
            super.updateItem(item, empty);

            if (item != null) {
                monthLabel.setText(item.getMonth().format(DateTimeFormatter.ofPattern("MMMM")));
                yearLabel.setText(item.getMonth().format(DateTimeFormatter.ofPattern("yyyy")));

                rootPane.getChildren().addAll(monthLabel, yearLabel);

                setGraphic(rootPane);
            }
        }
    }
}
