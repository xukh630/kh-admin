package com.kh.admin.common.utils;

import javax.servlet.ServletRequest;

import com.alibaba.fastjson.JSON;

public class ServletUtils {
    
    /**
     * 生成请求参数的dump字符串。
     * @param request
     * @return
     */
    public static String dumpParams(ServletRequest request) {
        final String paramsDumpKey = "params-dump";
        String paramsDump = (String) request.getAttribute(paramsDumpKey);
        if (paramsDump == null) {
            try {
                paramsDump = JSON.toJSONString(request.getParameterMap());
            }catch(Exception e) {
                paramsDump = "request params to json failed.";
            }
            request.setAttribute(paramsDumpKey, paramsDump);
        }
        return paramsDump;
    }  
    
}
