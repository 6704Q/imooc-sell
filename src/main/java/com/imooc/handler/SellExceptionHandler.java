package com.imooc.handler;

import com.imooc.VO.ResultVO;
import com.imooc.config.ProjectUrlConfig;
import com.imooc.exception.SellException;
import com.imooc.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/1 0001
 * Time:19:40
 * Desc 拦截器
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    ProjectUrlConfig urlConfig;


    @ExceptionHandler(SellerAuthorizeException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException(){
        //https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http://sell.springboot.cn/sell/qr/{OPENID}&response_type=code&scope=snsapi_login&state=
        return new ModelAndView("redirect:"
        .concat("www.imooc.com"));
    }

    @ExceptionHandler(SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        ResultVO vo = new ResultVO();
        vo.setCode(e.getCode());
        vo.setMsg(e.getMessage());
        return vo;
    }

}
