package com.mype.richhome.view;

import com.google.inject.Inject;
import javafx.scene.layout.Pane;

/**
 * @author Vitaliy Gerya
 */
public class GeneralViewImpl extends AbstractView implements GeneralView {
    @Inject
    private GeneralViewMediator mediator;

    @Inject
    private MonthView monthView;

    @Override
    protected void constructView(final Pane viewPane) {
        viewPane.getChildren().add(monthView.getView());

        mediator.init();
    }

    @Override
    public void loadMonths() {

    }
}
