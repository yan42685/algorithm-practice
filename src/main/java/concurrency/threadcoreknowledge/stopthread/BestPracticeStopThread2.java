package concurrency.threadcoreknowledge.stopthread;


/**
 * 最佳实践 (恢复中断)：当不想或者不能传递中断时，在InterruptedException的catch语句中调用
 * Thread.currentThread().interrupt() 来恢复中断状态，以便在后续的执行中依然能检查刚才发生了中断
 */
public class BestPracticeStopThread2 {
}
