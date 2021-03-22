package test.lab1;

public class SimpleEquation {
    public static void eval(double a, double b, double c) {
        if (a == 0) {
            System.out.println("a=0时, 这不是一元二次方程");
            return;
        }
        double delta = b * b - 4 * a * c;
        String rootA;
        String rootB;
        if (delta == 0) {
            rootA = String.valueOf(0.5 * (-b + Math.sqrt(delta)));
            rootB = rootA;
            System.out.println("有两个相同的实根");
        } else if (delta > 0) {
            rootA = String.valueOf(0.5 * (-b + Math.sqrt(delta)));
            rootB = String.valueOf(0.5 * (-b - Math.sqrt(delta)));
            System.out.println("有两个不同的实根");
        } else {
            double positiveDelta = -delta;
            rootA = 0.5 * -b + "+" + 0.5 * Math.sqrt(positiveDelta) + "i";
            rootB = 0.5 * -b + "-" + 0.5 * Math.sqrt(positiveDelta) + "i";
            System.out.println("有两个虚根");
        }
        System.out.println("rootA: " + rootA);
        System.out.println("rootB: " + rootB);
    }

}
