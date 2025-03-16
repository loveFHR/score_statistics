package com.fhr.cuit.common;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author FHR
 * @create 2025/03/16 16:36
 */
public class SnowflakeUtil {
    public static Long createId() {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        return snowflake.nextId();
    }
}
