package org.xiaoqiaotq.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/16.
 * 自动统计设置
 */
@Entity
public class AutoStatisticsConf{
    @Id
    @GeneratedValue
    private int id;

    private TimeType timeType;

    @Embedded
    private TimePoint timePoint;

    @ElementCollection
    private Set<TimePoint> timePoints;

    public int getId() {
        return id;
    }

    public TimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeType timeType) {
        this.timeType = timeType;
    }

    public TimePoint getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(TimePoint timePoint) {
        this.timePoint = timePoint;
    }

    public Set<TimePoint> getTimePoints() {
        return timePoints;
    }

    public void setTimePoints(Set<TimePoint> timePoints) {
        this.timePoints = timePoints;
    }

    /**
     * 时间类型
     */
    public enum  TimeType{
        WEEKLY,DAILY
    }
}
