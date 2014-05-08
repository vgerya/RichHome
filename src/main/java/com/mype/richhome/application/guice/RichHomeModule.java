package com.mype.richhome.application.guice;

import com.google.inject.AbstractModule;
import com.mype.richhome.command.CommandProvider;
import com.mype.richhome.command.CommandProviderImpl;
import com.mype.richhome.command.LoadMonthsCommand;
import com.mype.richhome.service.BudgetService;
import com.mype.richhome.service.BudgetServiceImpl;
import com.mype.richhome.view.*;

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
        bind(MonthView.class).to(MonthViewImpl.class);
    }

    private void mapMediators() {
        bind(GeneralViewMediator.class).to(GeneralViewMediatorImpl.class);
        bind(MonthViewMediator.class).to(MonthViewMediatorImpl.class);
    }

    private void mapInfrastructure() {

    }

    private void mapModels() {

    }

    private void mapServices() {
        bind(BudgetService.class).to(BudgetServiceImpl.class);
    }

    private void mapCommands() {
        bind(CommandProvider.class).to(CommandProviderImpl.class);

        bind(LoadMonthsCommand.class);
    }


}
