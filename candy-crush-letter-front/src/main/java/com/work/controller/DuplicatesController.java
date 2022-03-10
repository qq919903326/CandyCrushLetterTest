package com.work.controller;


import com.work.core.api.ApiResult;
import com.work.core.api.ApiResultCodeMsg;
import com.work.core.api.ApiResultGenerator;
import com.work.handle.StringAlgorithmHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Validated
@RestController
@RequestMapping("/duplicates")
public class DuplicatesController {

    /**
     * 移除相邻重复字符
     * @param str
     * @param num
     * @return
     */
    @GetMapping("/removeDuplicates/{str}/{num}")
    public ApiResult removeDuplicates(@PathVariable String str,@PathVariable Integer num){

        log.info("请求参数：{},{}",str,num);
        Optional<List<String>> optional = StringAlgorithmHandler.rmDuplicates(str,num);
        if(optional.isPresent()){
            return ApiResultGenerator.success(optional.get());
        }
        return ApiResultGenerator.success(null);
    }
    /**
     * 替换相邻重复字符
     * @param str
     * @param num
     * @return
     */
    @GetMapping("/replacedDuplicates/{str}/{num}")
    public ApiResult replacedDuplicates(@PathVariable String str,@PathVariable Integer num){
        log.info("请求参数：{},{}",str,num);
        Optional<List<String>> optional = StringAlgorithmHandler.replacedDuplicates(str,num);
        if(optional.isPresent()){
            return ApiResultGenerator.success(optional.get());
        }
        return ApiResultGenerator.error(ApiResultCodeMsg.NOT_FOUND,new ArrayList<>());
    }
}
