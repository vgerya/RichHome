package com.mype.richhome.application.guice;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.mype.richhome.command.CommandProvider;
import com.mype.richhome.command.CommandProviderImpl;
import com.mype.richhome.command.LoadMonthsCommand;
import com.mype.richhome.persistence.EntityManager;
import com.mype.richhome.persistence.JSONEntityManager;
import com.mype.richhome.persistence.dao.BudgetDao;
import com.mype.richhome.persistence.dao.BudgetDaoImpl;
import com.mype.richhome.preferences.Preferences;
import com.mype.richhome.preferences.PreferencesImpl;
import com.mype.richhome.service.BudgetService;
import com.mype.richhome.service.BudgetServiceImpl;
import com.mype.richhome.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vitaliy Gerya
 */
public class RichHomeModule extends AbstractModule {
    private final static Logger logger = LoggerFactory.getLogger(RichHomeModule.class);

    @Override
    protected void configure() {
        logger.info("Configuring Guice Module.");
        bind(RichHomeModule.class).toInstance(this);

        bindListener(Matchers.any(), new TypeListener() {
            @Override
            public <I> void hear(final TypeLiteral<I> type, final TypeEncounter<I> encounter) {
                encounter.register(new InjectionListener<I>() {
                    @Override
                    public void afterInjection(final Object injectee) {
                        logger.debug("Matching class {} for invoking init method.", injectee.getClass().getCanonicalName());
                        System.out.println(injectee.getClass().getCanonicalName());
                        if (injectee instanceof Initializable) {
                            logger.debug("Invoking init method for class {}.", injectee.getClass().getCanonicalName());
                            Initializable initializableObject = (Initializable) injectee;
                            initializableObject.init();
                        }
                    }
                });
            }
        });

        mapInfrastructure();

        mapModels();
        mapViews();
        mapMediators();
        mapCommands();

        mapPersistence();
        mapServices();
        logger.info("Guice Module has been configured.");
    }

    private void mapInfrastructure() {
        bind(Preferences.class).to(PreferencesImpl.class);
    }

    private void mapPersistence() {
        bind(EntityManager.class).to(JSONEntityManager.class);

        bind(BudgetDao.class).to(BudgetDaoImpl.class);
    }

    private void mapViews() {
        bind(GeneralView.class).to(GeneralViewImpl.class);
        bind(MonthView.class).to(MonthViewImpl.class);
    }

    private void mapMediators() {
        bind(GeneralViewMediator.class).to(GeneralViewMediatorImpl.class);
        bind(MonthViewMediator.class).to(MonthViewMediatorImpl.class);
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
