package com.kh.admin.api.shiro.filter;


import com.kh.admin.common.constants.ErrorConstants;
import com.kh.admin.common.result.ResultModle;
import com.kh.admin.common.utils.JsonUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * 项目：liquidator-platform-admin
 * 包名：com.fshows.liquidator.platform.admin.web.shiro.filter
 * 功能：
 * 时间：2016-08-22
 * 作者：呱牛
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = Logger.getLogger(CaptchaFormAuthenticationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {

                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                // allow them to see the login page ;)
                return true;
            }
        } else {

            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");

            }
//            if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
//                saveRequestAndRedirectToLogin(request, response);
//            } else {
//                response.setCharacterEncoding("UTF-8");
//                PrintWriter out = response.getWriter();
//                Map<String, String> resultMap = new HashMap<>();
//                resultMap.put("login_status", "300");
//                resultMap.put("message", "\u5F53\u524D\u7528\u6237\u6CA1\u6709\u767B\u5F55\uFF01");//当前用户没有登录！
//                out.println(JsonUtil.toJSonByJackson(resultMap));
//                out.flush();
//                out.close();
//            }
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println(JsonUtil.toJSonByJackson(ResultModle.customError(ErrorConstants.INVALID_LOGIN_CODE, ErrorConstants.INVALID_LOGIN_MSG)));
            out.flush();
            out.close();

            return false;
        }
    }
}
