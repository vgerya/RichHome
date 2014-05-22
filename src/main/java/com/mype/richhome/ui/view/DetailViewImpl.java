package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import javafx.scene.layout.Pane;

/**
 * @author Vitaliy Gerya
 */
public class DetailViewImpl extends AbstractView implements DetailView {
    @Inject
    private DetailViewMediator mediator;

    @Override
    protected void constructView(final Pane viewPane) {
        // TODO

        mediator.init();
    }
}
