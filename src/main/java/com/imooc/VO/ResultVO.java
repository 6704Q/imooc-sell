package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:16:03
 * Desc
 */
@Data
public class ResultVO <T> implements Serializable {


    private static final long serialVersionUID = 3068837394742385883L;

    /*提示码*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*数据*/
    private T data;

}
