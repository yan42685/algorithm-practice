package trash.homework.designpattern.lab2.two;

public class Client {
    public static void main(String[] args) {
        Logger fileLogger = new FileLoggerFactory().getLogger();
        Logger databaseLogger = new DatabaseLoggerFactory().getLogger();
        fileLogger.log();
        databaseLogger.log();
    }
}
