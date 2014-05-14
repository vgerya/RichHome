package com.mype.richhome.service;

import com.google.inject.Inject;
import com.mype.richhome.persistence.dao.BudgetDao;
import com.mype.richhome.vo.MonthVO;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
public class BudgetServiceImpl implements BudgetService {
    @Inject
    private BudgetDao dao;

    @Override
    public List<MonthVO> loadMonths() {
        // FIXME
        MonthVO m1 = new MonthVO();
        m1.setMonth(LocalDate.of(2014, Month.MAY, 1));

        MonthVO m2 = new MonthVO();
        m2.setMonth(LocalDate.of(2014, Month.JUNE, 1));

        return Arrays.asList(m1, m2);
    }
}
