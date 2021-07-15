package homework.shixun.day01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

public class T3 {
    @AllArgsConstructor
    @Data
    private static class Result {
        private double value;
        private Character operator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int x = scanner.nextInt();
        System.out.print("请输入第二个整数：");
        int y = scanner.nextInt();
        System.out.print("请输入您要进行的计算(1:表示加法,2:表示减法,3:表示乘法,4:表示除法)：");
        int operatorMode = scanner.nextInt();
        Result result = calculate(operatorMode, x, y);
        System.out.printf("%d%c%d=%.2f", x, result.getOperator(), y, result.getValue());
    }


    private static Result calculate(int operatorMode, int x, int y) {
        switch (operatorMode) {
            case 1:
                return new Result(x + y, '+');
            case 2:
                return new Result(x - y, '-');
            case 3:
                return new Result(x * y, 'x');
            case 4:
                if (y == 0) {
                    throw new IllegalArgumentException("被除数不能为0");
                }
                return new Result((double) x / y, '÷');
            default:
                throw new IllegalArgumentException("未知的运算符");
        }
    }
}

