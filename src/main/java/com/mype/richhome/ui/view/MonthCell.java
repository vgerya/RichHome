package com.mype.richhome.ui.view;

import com.mype.richhome.ui.vo.MonthVO;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.tbee.javafx.scene.layout.MigPane;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author Vitaliy Gerya
 */
public class MonthCell extends ListCell<MonthVO> {
    private ResourceBundle resourceBundle;

    private final MigPane rootPane = new MigPane("insets 0", "[grow][grow]", "[]");

    private final MigPane labelsPane = new MigPane("insets 0", "[fill, grow]", "[][]");
    private final Label monthLabel = new Label("May");
    private final Label yearLabel = new Label("1234");

    private final MigPane tabsPane = new MigPane("insets 0", "[]", "[][][]");
    private final Button planButton = new Button();
    private final Button currentButton = new Button();
    private final Button totalButton = new Button();

    public MonthCell() {
    }

    public void placeElements() {
        setPrefHeight(24 * 3);

        monthLabel.getStyleClass().add("test-border");
        labelsPane.add(monthLabel, "w pref!, growx, wrap");
        yearLabel.getStyleClass().add("test-border");
        labelsPane.add(yearLabel, "w pref!, growx, wrap");
        rootPane.add(labelsPane, "w pref!");

        planButton.setText(resourceBundle.getString("monthlist.cell.planTab"));
        tabsPane.add(planButton, "w pref!, wrap");
        currentButton.setText(resourceBundle.getString("monthlist.cell.currentTab"));
        tabsPane.add(currentButton, "w pref!, wrap");
        totalButton.setText(resourceBundle.getString("monthlist.cell.totalTab"));
        tabsPane.add(totalButton, "w pref!, wrap");

        tabsPane.getStyleClass().add("test-border");
        rootPane.add(tabsPane, "w pref!");

        rootPane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    System.out.println(event.getSource());
                }
            }
        );

        getChildren().add(rootPane);
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
