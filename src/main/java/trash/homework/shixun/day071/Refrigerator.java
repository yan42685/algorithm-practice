package trash.homework.shixun.day071;

import lombok.Data;

@Data
public class Refrigerator extends ElectricAppliance {
    /**
     * 门款式
     */
    private String doorStyle;
    /**
     * 制冷方式
     */
    private String coolingMode;
}
