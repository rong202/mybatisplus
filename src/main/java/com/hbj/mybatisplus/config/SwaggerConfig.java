package com.hbj.mybatisplus.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        Contact contact = new Contact("wangjialong", "https://baidu.com", "fei202s@163.com");
        return new ApiInfo("爸爸龙的API",
                "who im I",
                "v1.0111",
                "https://baidu.com",
                contact,"P1","as1",
                new ArrayList()
                );
    }

}
