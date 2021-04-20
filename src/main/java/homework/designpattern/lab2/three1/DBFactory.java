package homework.designpattern.lab2.three1;

public interface DBFactory {
    Connection createConnection();

    Statement createStatement();
}
