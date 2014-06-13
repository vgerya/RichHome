package com.mype.richhome.ui.view;

import com.mype.richhome.ui.vo.MonthVO;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.tbee.javafx.scene.layout.MigPane;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class MonthCell extends ListCell<MonthVO> {
    private final ListView<MonthVO> list;
    private ResourceBundle resourceBundle;

    private final MigPane rootPane = new MigPane("insets 0", "[grow][fill, grow, align right]", "[fill, grow]");

    private final MigPane labelsPane = new MigPane("insets 0", "[fill, grow]", "[][]");
    private final Label monthLabel = new Label("May");
    private final Label yearLabel = new Label("1234");

    private final MigPane tabsPane = new MigPane("insets 0", "[fill]", "[]0[]0[]");
    private final ToggleButton planButton = new ToggleButton();
    private final Button currentButton = new Button();
    private final Button totalButton = new Button();

    public MonthCell(final ListView<MonthVO> list) {
        this.list = list;
    }

    public void placeElements() {
        setPrefHeight(24 * 3);

        monthLabel.getStyleClass().add("test-border");
        labelsPane.add(monthLabel, "w pref!, growx, wrap");
        yearLabel.getStyleClass().add("test-border");
        labelsPane.add(yearLabel, "w pref!, growx, wrap");
        rootPane.add(labelsPane, "w pref!");

        constructButton(planButton, resourceBundle.getString("monthlist.cell.planTab"));
        tabsPane.add(planButton, "wrap");
        planButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonSelected(MonthViewImpl.PLAN_SELECTED, list));
        constructButton(currentButton, resourceBundle.getString("monthlist.cell.currentTab"));
        tabsPane.add(currentButton, "wrap");
        currentButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonSelected(MonthViewImpl.CURRENT_SELECTED, list));
        constructButton(totalButton, resourceBundle.getString("monthlist.cell.totalTab"));
        totalButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonSelected(MonthViewImpl.TOTAL_SELECTED, list));
        tabsPane.add(totalButton, "wrap");

        tabsPane.getStyleClass().add("test-border");
        rootPane.add(tabsPane, "w pref!");

        getChildren().add(rootPane);
    }

    private static class ButtonSelected implements EventHandler<MouseEvent> {
        public final EventType<MonthViewImpl.MonthClickEvent>  eventType;
        private final ListView<MonthVO> list;

        public ButtonSelected(EventType<MonthViewImpl.MonthClickEvent> eventType, ListView<MonthVO> list) {
            this.eventType = eventType;
            this.list = list;
        }

        @Override
        public void handle(final MouseEvent event) {
            list.fireEvent(new MonthViewImpl.MonthClickEvent(eventType));
        }
    }

    private void constructButton(final ButtonBase button, final String text) {
        button.setText(text);
        button.getStyleClass().add("tab-button");
        button.applyCss();
    }

    @Override
    protected void updateItem(final MonthVO item, final boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            monthLabel.setText(item.getMonth().format(DateTimeFormatter.ofPattern("MMMM")));
            yearLabel.setText(item.getMonth().format(DateTimeFormatter.ofPattern("yyyy")));

            setGraphic(rootPane);
        }
    }

    public void setResourceBundle(final ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
}
