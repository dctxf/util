package com.dctmz.util;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 接口返回数据格式
 *
 * @author dctxf
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

  public static R<String> ok() {
    return setResult(true, HttpStatus.OK.value(), "success", "");
  }

  public static <T> R<T> ok(T data) {
    return setResult(true, HttpStatus.OK.value(), "success", data);

  }

  public static R<String> error403(String message) {
    return setResult(false, HttpStatus.FORBIDDEN.value(), message, "");
  }

  public static R<String> error() {
    return setResult(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", "");
  }

  public static R<String> error(String msg) {
    return setResult(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, "");
  }

  /**
   * 无权限访问返回结果
   */
  public static R<String> noAuth() {
    return setResult(false, HttpStatus.UNAUTHORIZED.value(), "没有权限！", "");
  }

  /**
   * 无权限访问返回结果
   */
  public static R<String> noAuth(String msg) {
    return setResult(false, HttpStatus.UNAUTHORIZED.value(), msg, "");
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
    return JSONObject.toJSONString(this);

  }

}
