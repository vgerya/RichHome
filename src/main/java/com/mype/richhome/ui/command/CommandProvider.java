package com.mype.richhome.ui.command;

import javafx.concurrent.Service;

/**
 * @author Vitaliy Gerya
 */
public interface CommandProvider {
    <T extends Service> T get(final Class<T> commandClass);
}
