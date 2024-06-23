package com.camellia.thread.ThreadLifecycle_4.ScheduledTasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * 使用java.util.Timer和java.util.TimerTask实现定时任务示例。
 */
public class ScheduledTasksTest {

    /**
     * 主方法，程序入口。
     * @param args 命令行参数
     * @throws ParseException 解析日期字符串可能抛出的异常
     * @throws InterruptedException 线程中断可能抛出的异常
     */
    public static void main(String[] args) throws ParseException, InterruptedException {
        // 创建定时器对象（本质上就是一个线程）
        // 如果这个定时器执行的任务是一个后台任务，是一个守护任务，建议将其定义为守护线程。
        Timer timer = new Timer(true);

        // 指定定时任务的开始时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstDate = sdf.parse("2024-06-23 9:05:00");

        // 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        // 参数说明：
        //   new LogTimeTask()：要执行的任务
        //   firstDate：开始执行任务的时间
        //   1000：执行任务的间隔时间（毫秒），即每隔1秒执行一次
        timer.schedule(new LogTimeTask(), firstDate, 1000);

        // 主线程休眠一段时间，示例中为10秒
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000 * 1);
        }
    }
}
/**
 * 1. JDK中提供的定时任务：
 *      java.util.Timer         定时器
 *      java.util.TimerTask     定时任务
 * 2. 定时器 + 定时任务：可以帮我们在程序中完成：每间隔多久执行一次某段程序。
 * 3. Timer的构造方法：
 *      Timer()
 *      Timer(boolean isDaemon) isDaemon是true表示该定时器是一个守护线程。
 */