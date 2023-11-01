package javase.innerclass;

public class Outer {
    private int outer = 3;
    private int x;

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method1();

    }

    public MemberInnerClass getMemberInnerObject() {
        return new MemberInnerClass();
    }

    private void method1() {
        final class LocalInnerClass {
            private int value = 0;
        }

        LocalInnerClass localInnerClass = new LocalInnerClass();

        // 匿名内部类能通过接口、抽象类、普通类创建
        InterfaceA a1 = new InterfaceA() {
            @Override
            public void method2() {
                System.out.println("From anonymous inner class");
            }
        };

        InterfaceA a2 = () -> System.out.println("From Lambda expression");

        a1.method2();
        a2.method2();

    }


    public class MemberInnerClass {
        private int memberInner = 5;
        private int x;

        public void outerPlusOne() {
            ++outer;
        }

        private int getOuterX() {
            return Outer.this.x;
        }
    }

    private void method3() {
        MemberInnerClass memberInner = new MemberInnerClass();
        memberInner.outerPlusOne();
    }

    public static class staticNestedClass {
        private int x;
        private static int y;
    }

}

