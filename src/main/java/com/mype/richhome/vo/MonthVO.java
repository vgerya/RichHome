package com.mype.richhome.vo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 * @author Vitaliy Gerya
 */
public class MonthVO {
    private ObjectProperty<LocalDate> month = new SimpleObjectProperty<>(this, "month");

    public MonthVO() {
    }

    public LocalDate getMonth() {
        return month.get();
    }

    public ObjectProperty<LocalDate> getMonthProperty() {
        return month;
    }

    public void setMonth(final LocalDate month) {
        this.month.set(month);
    }

    @Override
    public String toString() {
        return "com.mype.richhome.vo.MonthVO{" +
                "month=" + month.getValue().getMonth() + "-" + month.getValue().getYear() +
                '}';
    }
}
