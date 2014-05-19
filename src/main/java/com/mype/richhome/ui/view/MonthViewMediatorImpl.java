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
}
