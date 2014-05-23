package com.mype.richhome.ui.view;

import com.google.inject.Inject;
import com.mype.richhome.ui.command.LoadMonthsCommand;
import com.mype.richhome.ui.vo.MonthVO;
import javafx.concurrent.Worker;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class MonthViewMediatorImpl extends AbstractMediator implements MonthViewMediator {
    @Inject
    private MonthView view;

    @Override
    public void loadMonthList() {
        startCommandWithSucceedHandler(LoadMonthsCommand.class, (event) -> {
            Worker source = event.getSource();
            view.updateMonthList((List<MonthVO>) source.getValue());
        });
    }

    @Override
    public void selectMonth(final MonthVO selectedItem) {
        startCommand(LoadMonthsCommand.class, (event) -> {
            // TODO detect kind of selection (skip or process it)
            // unselect previous tab or automatically select the same kind of tab on next Month
            // load appropriate data and put to the interface
            Worker source = event.getSource();
            view.updateMonthList((List<MonthVO>) source.getValue());
        }, (event) -> {
            // TODO select previous selection with reload of information
        });
    }
}
