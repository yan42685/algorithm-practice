package javase.tankbattle.constants;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;
    // values()方法每次调用都会生成一个新的数组，所以定义为常量，而不是放在方法里
    private static final Direction[] VALUES = Direction.values();
    public static Direction random() {
        int randomIndex = Constants.RANDOM.nextInt(VALUES.length);
        return VALUES[randomIndex];
    }
}
