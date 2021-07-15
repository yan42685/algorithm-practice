package homework.shixun.day071;

import lombok.Data;

@Data
public class WashingMachine extends ElectricAppliance {
    /**
     * 电机类型
     */
    private String motorType;
    /**
     * 洗涤容量
     */
    private int capacity;
}
