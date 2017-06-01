/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package com.kh.admin.common.utils;

import com.fshows.liquidator.platform.openapi.common.result.ValidateResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static com.google.common.collect.Iterables.getFirst;

/**
 * 项目：liquidator-platform-openapi
 * 包名：com.fshows.liquidator.platform.openapi.common.utils
 * 功能：验证utils
 * 时间：2016-08-10 14:25
 * 作者：Mr.Kiwi
 */
public class ValidateUtils {

    public static <T> ValidateResult validate(T object) {

        ValidateResult validateResult = new ValidateResult();
        validateResult.setSuccess(true);
        validateResult.setMsg("验证成功！");

        //获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //执行验证
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        //如果有验证信息，则将第一个取出来包装成异常返回
        ConstraintViolation<T> constraintViolation = getFirst(constraintViolations, null);
        if (constraintViolation != null) {

            validateResult.setSuccess(false);
            validateResult.setMsg("[" + constraintViolation.getPropertyPath() + "]" + constraintViolation.getMessage());
        }

        return validateResult;
    }


}


