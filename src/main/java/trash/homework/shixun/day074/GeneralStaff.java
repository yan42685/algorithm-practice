package trash.homework.shixun.day074;

import lombok.Data;

/**
 * 职员（总称）
 */
@Data
public class GeneralStaff {
    protected String id;
    protected String name;
    protected int age;

    public void publishNotice(String content) {
        System.out.println("通知：");
        System.out.println("\t" + content);
        System.out.println("\t\t\t" + this.name);
        System.out.println("\t\t\t" + this.id);
        System.out.println("\t\t\t" + "必胜环球科技有限公司");
    }
}
