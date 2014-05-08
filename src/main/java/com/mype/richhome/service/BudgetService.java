package com.mype.richhome.service;

import com.mype.richhome.vo.MonthVO;

import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public interface BudgetService {

    List<MonthVO> loadMonths();
}
