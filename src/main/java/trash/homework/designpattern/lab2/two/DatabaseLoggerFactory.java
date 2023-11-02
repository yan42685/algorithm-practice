package trash.homework.designpattern.lab2.two;

public class DatabaseLoggerFactory implements LoggerFactory {
    private static final Logger LOGGER = new DatabaseLogger();

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
