package trash.homework.designpattern.lab2.two;

public class FileLoggerFactory implements LoggerFactory {
    private static final Logger LOGGER = new FileLogger();

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
