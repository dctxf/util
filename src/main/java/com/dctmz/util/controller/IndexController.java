package com.dctmz.util.controller;

import com.dctmz.util.R;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @RequestMapping("/")
  public R<String> index() {
    return R.ok("ok");
  }
}
