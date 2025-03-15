package com.fhr.cuit.interceptor;

import com.fhr.cuit.common.BaseContext;
import com.fhr.cuit.common.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**

 * @author FHR
 * @create 2025/3/15 17:11
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是options(预检请求),直接放行
        String method = request.getMethod();
        // 如果是跨域预检请求，直接放行
        if("OPTIONS".equals(method)) {
            return true ;
        }
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null) {
            System.out.println("拦截");
            response.setStatus(401);
            return false;
        }
        Jws<Claims> claims = JwtUtil.parseJWT(token,"FHR^*^*^*^*^*^*^*^*^*&^%$%^%%^%$^#%#");

        Long userId = Long.valueOf(claims.getPayload().get("userId").toString());
        BaseContext.setUserId(userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContext.removeUserId();
    }
}
