import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.AutoStatisticsConf;
import org.xiaoqiaotq.domain.TimePoint;
import org.xiaoqiaotq.repository.AutoStatisticsConfRepository;

import javax.persistence.Temporal;
import java.util.HashSet;
import java.util.Set;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class AutoStatisticsConfTest {
    @Autowired
    private AutoStatisticsConfRepository autoStatisticsConfRepository;

    @Test
    public void saveDaily(){
        AutoStatisticsConf conf=new AutoStatisticsConf();
        conf.setTimeType(AutoStatisticsConf.TimeType.DAILY);
        TimePoint timePoint=new TimePoint();
        timePoint.setHour(2);
        timePoint.setMinute(30);
        conf.setTimePoint(timePoint);
        autoStatisticsConfRepository.save(conf);
    }

    @Test
    public void saveDaily2(){
        AutoStatisticsConf conf=new AutoStatisticsConf();
        conf.setTimeType(AutoStatisticsConf.TimeType.DAILY);
        autoStatisticsConfRepository.save(conf);
    }

    @Test
    public void saveWeekly(){
        AutoStatisticsConf conf=new AutoStatisticsConf();
        conf.setTimeType(AutoStatisticsConf.TimeType.WEEKLY);

        Set<TimePoint> timePoints = new HashSet<>();
        TimePoint timePoint=new TimePoint();
        timePoint.setHour(2);
        timePoint.setMinute(30);
        timePoint.setWeek(TimePoint.Week.FRIDAY);
        timePoints.add(timePoint);

        TimePoint timePoint2=new TimePoint();
        timePoint2.setHour(1);
        timePoint2.setMinute(20);
        timePoint2.setWeek(TimePoint.Week.THURSDAY);
        timePoints.add(timePoint2);

        conf.setTimePoints(timePoints);
        autoStatisticsConfRepository.save(conf);
    }
}
