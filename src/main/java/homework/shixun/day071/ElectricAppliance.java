package homework.shixun.day071;

import lombok.Data;

/**
 * 电器类
 */
@Data
public class ElectricAppliance {
    /**
     * 品牌
     */
    protected String brand;
    /**
     * 型号
     */
    protected String type;
    protected String color;
    protected double price;

}
