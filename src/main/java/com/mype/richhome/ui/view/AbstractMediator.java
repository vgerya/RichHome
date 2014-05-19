package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import com.mype.richhome.ui.command.CommandProvider;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

/**
 * @author Vitaliy Gerya
 */
public abstract class AbstractMediator {
    private final static EventHandler<WorkerStateEvent> DEFAULT_ERROR_HANDLER = (event) -> {
        System.out.println("Error" + event);
        if(event.getSource() instanceof Service) {
            Service service = (Service) event.getSource();
            service.getException().printStackTrace();
        }
    };

    @Inject
    private CommandProvider commandProvider;

    protected <T extends Service> T startCommandWithSucceedHandler(Class<T> commandClass, EventHandler<WorkerStateEvent> succeedHandler) {
        final T commandInstance = commandProvider.get(commandClass);
        commandInstance.setOnSucceeded(succeedHandler);
        commandInstance.setOnFailed(DEFAULT_ERROR_HANDLER);

        commandInstance.start();

        return commandInstance;
    }
}
