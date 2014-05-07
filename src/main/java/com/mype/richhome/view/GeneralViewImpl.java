package com.mype.richhome.view;

import com.google.inject.Inject;
import com.mype.richhome.vo.MonthVO;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * @author Vitaliy Gerya
 */
public class GeneralViewImpl extends AbstractView implements GeneralView {
    @Inject
    private GeneralViewMediator mediator;

    private ListView<MonthVO>

    @Override
    protected void constructView(final Pane viewPane) {

    }
}
