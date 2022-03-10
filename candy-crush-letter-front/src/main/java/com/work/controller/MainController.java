package com.work.controller;


import com.work.core.api.ApiResult;
import com.work.core.api.ApiResultCodeMsg;
import com.work.core.api.ApiResultGenerator;
import com.work.handle.StringAlgorithmHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Slf4j
@Validated
@Controller
@RequestMapping("/")
public class MainController {

    /**
     * 移除相邻重复字符
     * @param str
     * @param num
     * @return
     *//*
    @GetMapping("/removeDuplicates/{str}/{num}")
    public ApiResult removeDuplicates(@PathVariable String str,@PathVariable Integer num){

        log.info("请求参数：{},{}",str,num);
        Optional<List<String>> optional = StringAlgorithmHandler.rmDuplicates(str,num);
        if(optional.isPresent()){
            return ApiResultGenerator.success(optional.get());
        }
        return ApiResultGenerator.error(ApiResultCodeMsg.NOT_FOUND,new ArrayList<>());
    }
    *//**
     * 替换相邻重复字符
     * @param str
     * @param num
     * @return
     *//*
    @GetMapping("/replacedDuplicates/{str}/{num}")
    public ApiResult replacedDuplicates(@PathVariable String str,@PathVariable Integer num){
        log.info("请求参数：{},{}",str,num);
        Optional<List<String>> optional = StringAlgorithmHandler.removeDuplicates(str,num);
        if(optional.isPresent()){
            return ApiResultGenerator.success(optional.get());
        }
        return ApiResultGenerator.error(ApiResultCodeMsg.NOT_FOUND,new ArrayList<>());
    }*/
    @RequestMapping("/index")
    public String thymeleaf() {
        return "example/index";
    }
}
