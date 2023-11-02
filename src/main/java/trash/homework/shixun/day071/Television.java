package trash.homework.shixun.day071;

import lombok.Data;

@Data
public class Television extends ElectricAppliance {
    private int screenSize;
    /**
     * 分辨率
     */
    private int[] dpi;
}
