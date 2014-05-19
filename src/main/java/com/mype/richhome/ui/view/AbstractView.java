package com.mype.richhome.ui.view;

import javafx.scene.layout.Pane;

/**
 * @author Vitaliy Gerya
 */
public abstract class AbstractView implements View {
    private Pane viewPane;

    @Override
    public Pane getView() {
        if (viewPane == null) {
            this.viewPane = new Pane();
            this.viewPane.setId(getViewName());

            constructView(viewPane);
        }

        return viewPane;
    }

    protected abstract void constructView(final Pane viewPane);

    protected abstract String getViewName();
}
