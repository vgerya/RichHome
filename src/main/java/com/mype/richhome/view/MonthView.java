package com.mype.richhome.view;

import com.mype.richhome.vo.MonthVO;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public interface MonthView extends View {
    void updateMonthList(List<MonthVO> months);
}
