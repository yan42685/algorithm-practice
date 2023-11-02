package trash.homework.designpattern.lab2.three1;

public class MySQLFactory implements DBFactory {
    @Override
    public Connection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public Statement createStatement() {
        return new MySQLStatement();
    }
}
