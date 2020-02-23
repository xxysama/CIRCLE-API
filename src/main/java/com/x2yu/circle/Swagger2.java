package com.x2yu.circle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: x2yu
 * @Date: 2020/2/23 15:38
 * @Describe：Swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2{
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("x2yu", "x2yu.cn", "374439529@qq.com");
        return new ApiInfoBuilder()
                .title("圈子Api接口")
                .description("包含前后端的接口一览")
                .contact(contact)   // 联系方式
                .version("1.1.0")  // 版本
                .build();
    }
}
