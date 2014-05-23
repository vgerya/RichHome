package com.mype.richhome.ui.view;

import com.mype.richhome.ui.vo.MonthVO;
import javafx.scene.control.*;
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

    private final MigPane rootPane = new MigPane("insets 0", "[grow][fill, grow, align right]", "[fill, grow]");

    private final MigPane labelsPane = new MigPane("insets 0", "[fill, grow]", "[][]");
    private final Label monthLabel = new Label("May");
    private final Label yearLabel = new Label("1234");

    private final MigPane tabsPane = new MigPane("insets 0", "[fill]", "[]0[]0[]");
    private final ToggleButton planButton = new ToggleButton();
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

        constructButton(planButton, resourceBundle.getString("monthlist.cell.planTab"));
        tabsPane.add(planButton, "wrap");
        constructButton(currentButton, resourceBundle.getString("monthlist.cell.currentTab"));
        tabsPane.add(currentButton, "wrap");
        constructButton(totalButton, resourceBundle.getString("monthlist.cell.totalTab"));
        tabsPane.add(totalButton, "wrap");

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
