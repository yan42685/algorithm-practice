package homework.shixun.day01;

public class T1 {
    public static void main(String[] args) {
        double fatherHeight = 177;
        double motherHeight = 165;
        double sonHeight = (fatherHeight + motherHeight) * 1.08 / 2;
        double daughterHeight = (fatherHeight * 0.923 + motherHeight) / 2;
        System.out.printf("sonHeight: %.2fcm, daughterHeight: %.2fcm\n", sonHeight, daughterHeight);
    }
}

