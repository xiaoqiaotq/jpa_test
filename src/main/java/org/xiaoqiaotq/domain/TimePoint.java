package org.xiaoqiaotq.domain;

import javax.persistence.Embeddable;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/16.
 */
@Embeddable
public class TimePoint {
    private Week week;
    private int hour;
    private int minute;
    private int second;
    public static enum Week{
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
}
