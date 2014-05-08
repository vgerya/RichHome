package com.mype.richhome.command;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.concurrent.Service;

/**
 * Creates instances of different Commands.
 *
 * @author Vitaliy Gerya
 */
public class CommandProviderImpl implements CommandProvider {
    @Inject
    private Injector injector;

    @Override
    public <T extends Service> T get(final Class<T> commandClass) {
        return injector.getInstance(commandClass);
    }
}
