package com.mype.richhome.ui.command;

import com.google.inject.Inject;
import com.mype.richhome.service.BudgetService;
import com.mype.richhome.ui.vo.MonthVO;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class LoadMonthsCommand extends Service<List<MonthVO>> {
    @Inject
    private BudgetService budgetService;

    @Override
    protected Task<List<MonthVO>> createTask() {
        return new Task<List<MonthVO>>() {
            @Override
            protected List<MonthVO> call() throws Exception {
                return budgetService.loadMonths();
            }
        };
    }
}
