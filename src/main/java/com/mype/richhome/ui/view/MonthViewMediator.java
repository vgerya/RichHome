package com.mype.richhome.ui.view;

import com.mype.richhome.ui.vo.MonthVO;

/**
 * @author Vitaliy Gerya
 */
public interface MonthViewMediator {
    /**
     * Loads all Month from storage into left sidebar.
     */
    void loadMonthList();

    /**
     * Handles selection of Month in sidebar.
     * @param selectedItem
     */
    void selectMonth(MonthVO selectedItem);
}
