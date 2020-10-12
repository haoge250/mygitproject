package com.etc.feigninters;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huge
 * @date 2020/10/6 - 9:08
 */
@Component
public class StuFeignClientFallback implements StuFeignClient {
    @Override
    public Map<String, Object> getClassById(Integer claNo) {
        Map<String,Object> map = new HashMap<>();
        map.put("claNo","-1");
        map.put("claName","-1");
        return map;
    }
}
