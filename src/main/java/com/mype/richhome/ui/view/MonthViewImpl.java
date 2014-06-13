package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import com.mype.richhome.ui.vo.MonthVO;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.event.EventType;
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

    private final ObservableList<MonthVO> data = FXCollections.<MonthVO>observableArrayList();
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

        monthList.addEventHandler(TOTAL_SELECTED, new MonthClickHandler() {
            @Override
            public void handle(final MonthClickEvent event) {
                System.out.println("total");
            }
        });

        monthList.addEventHandler(CURRENT_SELECTED, new MonthClickHandler() {
            @Override
            public void handle(final MonthClickEvent event) {
                System.out.println("current");
            }
        });

        monthList.addEventHandler(PLAN_SELECTED, new MonthClickHandler() {
            @Override
            public void handle(final MonthClickEvent event) {
                System.out.println("plan");
            }
        });

        monthList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MonthVO>() {
            @Override
            public void changed(final ObservableValue<? extends MonthVO> observable, final MonthVO oldValue, final MonthVO newValue) {
                monthList.fireEvent(new MonthClickEvent(MONTH_SELECTED));
            }
        });

        monthList.addEventHandler(MONTH_SELECTED, new MonthClickHandler() {
            @Override
            public void handle(final MonthClickEvent event) {
                System.out.println("month");
            }
        });


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

    public static EventType<MonthClickEvent> MONTH_SELECTED = new EventType<>("MONTH_SELECTED");
    public static EventType<MonthClickEvent> PLAN_SELECTED = new EventType<>("PLAN_SELECTED");
    public static EventType<MonthClickEvent> CURRENT_SELECTED = new EventType<>("CURRENT_SELECTED");
    public static EventType<MonthClickEvent> TOTAL_SELECTED = new EventType<>("TOTAL_SELECTED");

    public static class MonthClickEvent extends Event {

        public MonthClickEvent(@NamedArg("eventType") final EventType<? extends Event> eventType) {
            super(eventType);
        }

        public MonthClickEvent(@NamedArg("source") final Object source, @NamedArg("target") final EventTarget target, @NamedArg("eventType") final EventType<? extends Event> eventType) {
            super(source, target, eventType);
        }
    }

    public static interface MonthClickHandler extends EventHandler<MonthClickEvent> {

    }


}
