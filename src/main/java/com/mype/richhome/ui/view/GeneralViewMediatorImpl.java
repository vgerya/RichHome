package com.mype.richhome.ui.view;

import javax.inject.Inject;

/**
 * @author Vitaliy Gerya
 */
public class GeneralViewMediatorImpl extends AbstractMediator implements GeneralViewMediator {
    @Inject
    private GeneralView view;

    @Override
    public void init() {
        view.loadMonths();
    }
}
