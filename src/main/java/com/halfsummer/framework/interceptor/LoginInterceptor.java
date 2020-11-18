package com.halfsummer.framework.interceptor;

import com.halfsummer.framework.web.result.ResultDataUtil;
import com.halfsummer.framework.web.vo.LoginUserVo;
import com.halfsummer.common.enums.CommonEnum;
import com.halfsummer.common.enums.SysFlagStatusEnum;
import com.halfsummer.common.utils.JwtUtils;
import com.halfsummer.common.utils.ServletUtils;
import com.halfsummer.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.sun.org.glassfish.external.statistics.impl.StatisticImpl.START_TIME;

/**
 * @author BestClever
 * @title: LoginInterceptor
 * @projectName kaoqin
 * @description: TODO
 * @date 2020-05-28 11:07
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 在控制器执行之前完成业务逻辑操作
     * 方法的返回值决定逻辑是否继续执行， true，表示继续执行， false, 表示不再继续执行。
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        String token = request.getHeader(SysFlagStatusEnum.TOKEN_HEAD.getKey());
        if (StringUtils.isBlank(token)) {
            ResultDataUtil.throwExcepion(CommonEnum.SIGNATURE_NOT_MATCH);
        }
        LoginUserVo loginUser = JwtUtils.getLoginUserByToken(token);
        // 判断当前用户是否已经登陆
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8"); // 设置编码为utf初-8
        response.setContentType("text/html;charset=utf-8");
        if (StringUtils.isNull(loginUser)) {
            // Ajax请求会话过期处理
            if (ServletUtils.isAjaxRequest(request)) {
                response.setHeader("SessionStatus", "sessionTimeOut");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//没有权限
                ServletUtils.responseOutWithJson(response, ResultDataUtil.createFail(CommonEnum.SIGNATURE_NOT_MATCH));
                return false;
            }
            String path = session.getServletContext().getContextPath();
            response.sendRedirect(path + "/login");
            return false;
        } else {
            return true;
        }
    }

    /**
     * 在完成视图渲染之后，执行此方法。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        String url = request.getRequestURI().toString();
        long start = (long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request finished. url:{},cost:{}",url,end-start);
    }


}