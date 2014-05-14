package com.mype.richhome.view;

import com.google.inject.Inject;
import javafx.scene.layout.Pane;

/**
 * @author Vitaliy Gerya
 */
public class GeneralViewImpl extends AbstractView implements GeneralView {
    private static final String VIEW_NAME = "generalView";
    @Inject
    private GeneralViewMediator mediator;

    @Inject
    private MonthView monthView;

    @Override
    protected void constructView(final Pane viewPane) {
        viewPane.getChildren().add(monthView.getView());
        monthView.getView().setId(".monthView");

        mediator.init();
    }

    @Override
    protected String getViewName() {
        return VIEW_NAME;
    }

    @Override
    public void loadMonths() {

    }
}
