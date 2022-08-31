package com.dctmz.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import cn.hutool.json.JSONUtil;
import lombok.Data;

/**
 * 接口返回数据格式
 *
 * @author dctxf
 */
@Data
public class R<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 成功标志
   */
  private boolean success = true;

  /**
   * 返回处理消息
   */
  private String message = "操作成功！";

  /**
   * 返回代码
   */
  private Integer code = 0;

  /**
   * 返回数据对象 data
   */
  private T data;

  /**
   * 时间戳
   */
  private long timestamp = System.currentTimeMillis();

  public R() {

  }

  public static R<Object> ok() {
    return setResult(true, HttpStatus.OK.value(), "success", null);
  }

  public static <T> R<T> ok(T data) {
    return setResult(true, HttpStatus.OK.value(), "success", data);

  }

  public static R<Object> error403(String message) {
    return setResult(false, HttpStatus.FORBIDDEN.value(), message, null);
  }

  public static R<Object> error() {
    return setResult(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", null);
  }

  public static R<Object> error(String msg) {
    return setResult(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
  }

  /**
   * 无权限访问返回结果
   */
  public static R<Object> noAuth() {
    return setResult(false, HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), null);
  }

  /**
   * 无权限访问返回结果
   */
  public static R<String> noAuth(String msg) {
    return setResult(false, HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), msg);
  }

  public static <T> R<T> setResult(boolean success, Integer code, String message, T data) {
    R<T> apiResult = new R<>();

    apiResult.setSuccess(success);
    apiResult.setCode(code);
    apiResult.setMessage(message);
    apiResult.setData(data);

    return apiResult;
  }

  public String toJSONString() {
    return JSONUtil.toJsonStr(this);
  }

}
