package com.fhr.cuit.common;


/**
 *
 * @author FHR
 * @create 2025/3/15 17:08
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static Long getUserId() {
        return threadLocal.get();
    }
    public static void setUserId(Long user) {
        threadLocal.set(user);
    }
    public static void removeUserId() {
        threadLocal.remove();
    }
}
