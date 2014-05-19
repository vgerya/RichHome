package com.mype.richhome.ui.view;

import com.mype.richhome.ui.vo.MonthVO;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public interface MonthView extends View {
    void updateMonthList(List<MonthVO> months);
}
