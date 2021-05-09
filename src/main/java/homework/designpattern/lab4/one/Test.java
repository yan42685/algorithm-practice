package homework.designpattern.lab4.one;

public class Test {
    public static void main(String[] args) {
        WeeklyLog log = new WeeklyLog();
        log.setAuthor("abc");
        log.setDate("2021/5/3");
        log.setContent("content");

        System.out.println("----- 周报 -----");
        System.out.printf("作者：%s\n日期: %s\n内容: %s\n\n", log.getAuthor(), log.getDate(), log.getContent());

        WeeklyLog copiedWeeklyLog = log.clone();
        System.out.println("----- 复制的周报 -----");
        System.out.printf("作者：%s\n日期: %s\n内容: %s", copiedWeeklyLog.getAuthor(), copiedWeeklyLog.getDate(), copiedWeeklyLog.getContent());
    }
}
