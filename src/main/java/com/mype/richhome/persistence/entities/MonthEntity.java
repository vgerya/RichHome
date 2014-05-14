package com.mype.richhome.persistence.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Month;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement(name = "month")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class MonthEntity {
    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "month")
    private Month month;

    public MonthEntity() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(final Month month) {
        this.month = month;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonthEntity that = (MonthEntity) o;

        if (year != that.year) return false;
        if (month != that.month) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "com.mype.richhome.persistence.entities.MonthEntity{" +
                "year=" + year +
                ", month=" + month +
                '}';
    }
}
