package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/29 0029
 * Time:10:46
 * Desc
 */
public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
