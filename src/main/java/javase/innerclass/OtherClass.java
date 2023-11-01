package javase.innerclass;

public class OtherClass {
    public static void main(String[] args) {
        // 外部类调用成员内部类 方式1  Outer对象.new XXX();
        Outer.MemberInnerClass memberInnerObject = new Outer().new MemberInnerClass();
        // 方式2
        Outer.MemberInnerClass memberInnerObject2 = new Outer().getMemberInnerObject();


        Outer.staticNestedClass staticNestedClass = new Outer.staticNestedClass();
    }
}

