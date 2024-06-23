package com.camellia.thread.ScheduledTasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * 定时任务类：专门记录日期的定时任务类。
 * <p>
 * 该类继承了TimerTask，用于在指定时间间隔执行任务，
 * 并打印当前日期和时间以及任务执行的次数。
 */
public class LogTimeTask extends TimerTask {
    // 格式化日期时间的对象
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    // 记录任务执行的次数
    int count = 0;

    /**
     * 定时任务的具体执行内容。
     * 每次执行任务时，获取当前日期和时间并打印，同时增加执行次数的计数。
     */
    @Override
    public void run() {
        // 获取当前日期和时间
        Date now = new Date();
        // 将日期时间格式化为指定格式的字符串
        String strTime = sdf.format(now);
        // 打印格式化后的日期时间和执行次数
        System.out.println(strTime + ":" + (count++));
    }
}
