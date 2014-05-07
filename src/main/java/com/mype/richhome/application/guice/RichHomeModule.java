package com.mype.richhome.application.guice;

import com.google.inject.AbstractModule;
import com.mype.richhome.view.GeneralView;
import com.mype.richhome.view.GeneralViewImpl;
import com.mype.richhome.view.GeneralViewMediator;
import com.mype.richhome.view.GeneralViewMediatorImpl;

/**
 * @author Vitaliy Gerya
 */
public class RichHomeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RichHomeModule.class).toInstance(this);

        mapViews();
        mapMediators();
        mapCommands();
        mapServices();
        mapModels();
        mapInfrastructure();
    }

    private void mapViews() {
        bind(GeneralView.class).to(GeneralViewImpl.class);
    }

    private void mapMediators() {
        bind(GeneralViewMediator.class).to(GeneralViewMediatorImpl.class);
    }
    private void mapInfrastructure() {

    }

    private void mapModels() {

    }

    private void mapServices() {

    }

    private void mapCommands() {

    }


}
