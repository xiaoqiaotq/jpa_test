package org.xiaoqiaotq.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/16.
 */
@Embeddable
public class TimePoint {
    private Week week;
    @Column(nullable = true)
    private int hour;
    @Column(nullable = true)
    private int minute;
    @Column(nullable = true)
    private int second;

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public  enum Week{
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
}
