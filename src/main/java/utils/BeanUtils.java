package utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

public class BeanUtils {
    public static <T> T copyProperties(Object source, Class<T> tClass) {
        try {
            T target = tClass.newInstance();
            // 忽略null值
            BeanUtil.copyProperties(source, target, CopyOptions.create().ignoreNullValue());
            return target;
        } catch (Exception e) {
            throw new RuntimeException("通过反射实例化失败");
        }
    }
}
