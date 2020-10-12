package com.etc.feigninters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author huge
 * @date 2020/10/6 - 9:11
 */
//定义一个feign接口，通过@ FeignClient（“服务名”），来指定消费哪个服务。
//接口类上加入的注解中添加属性fallback,指定回调类
@FeignClient(name = "springcloudclaclient",fallback = StuFeignClientFallback.class)
public interface StuFeignClient {
    @RequestMapping("/cla/getcla/{claNo}")
    public Map<String,Object> getClassById(@PathVariable Integer claNo);
}
