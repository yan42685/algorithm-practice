package homework.designpattern.lab2.three1;

public class Test {
    public static void main(String[] args) {
        DBFactory factory = new OracleFactory();
        Connection connection = factory.createConnection();
        System.out.println(connection.getClass().getSimpleName());
    }
}
