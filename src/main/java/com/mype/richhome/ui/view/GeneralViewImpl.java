package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import javafx.scene.layout.Pane;
import org.tbee.javafx.scene.layout.MigPane;

/**
 * @author Vitaliy Gerya
 */
public class GeneralViewImpl implements GeneralView {
    @Inject
    private GeneralViewMediator mediator;

    @Inject
    private MonthView monthView;

    @Inject
    private DetailView detailView;

    private MigPane rootPane;

    @Override
    public Pane getView() {
        if (rootPane == null) {
            rootPane = new MigPane("insets 0", "[grow, fill][grow, fill]", "[grow, fill]");

            constructView();
        }

        return rootPane;
    }

    private void constructView() {
        rootPane.add(monthView.getView(), "w 200!, growy");

        rootPane.add(detailView.getView(), "grow");

        rootPane.setPrefSize(800, 600);
    }

    @Override
    public void loadMonths() {

    }
}
