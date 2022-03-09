package com.work.controller;


import com.work.core.api.ApiResult;
import com.work.core.api.ApiResultGenerator;
import com.work.handle.StringAlgorithmHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Validated
@RestController
@RequestMapping("/")
public class MainController {

    /**
     * 移除相邻重复字符
     * @param str
     * @param num
     * @return
     */
    @DeleteMapping("/removeDuplicates/{str}/{num}")
    public ApiResult removeDuplicates(@PathVariable String str,@PathVariable Integer num){
        log.info("请求参数：{},{}",str,num);
        List<String> list = StringAlgorithmHandler.removeDuplicates(str,num);
        return ApiResultGenerator.success(list);
    }
    /**
     * 替换相邻重复字符
     * @param str
     * @param num
     * @return
     */
    @PutMapping("/replacedDuplicates/{str}/{num}")
    public ApiResult replacedDuplicates(@PathVariable String str,@PathVariable Integer num){
        log.info("请求参数：{},{}",str,num);
        List<String> list = StringAlgorithmHandler.removeDuplicates(str,num);
        return ApiResultGenerator.success(list);
    }
}
