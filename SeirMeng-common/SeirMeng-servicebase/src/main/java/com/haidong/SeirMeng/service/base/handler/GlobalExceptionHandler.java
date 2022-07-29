package com.haidong.SeirMeng.service.base.handler;

import com.haidong.SeirMeng.service.base.result.R;
import com.haidong.SeirMeng.service.base.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
/**
 * @author Xiehd
 * @email xiehdwork@163.com
 * @date 2021/12/26 0026 0:29
 */
@ControllerAdvice
@Slf4j//引入静态实例
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){

        log.info("异常为：{}，时间为：{}", ExceptionUtils.getStackTrace(e),new Date());

        e.printStackTrace();
        return R.error();
    }


    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R exception(BadSqlGrammarException e){
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R exception(HttpMessageNotReadableException e){
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

}
