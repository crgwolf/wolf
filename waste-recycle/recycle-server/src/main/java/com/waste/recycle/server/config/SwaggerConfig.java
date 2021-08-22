package com.waste.recycle.server.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 定义分隔符,配置Swagger多包
    private static final String splitor = ";";

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2) //swagger版本
                // 详细定制
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                //扫描那些controller
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.waste.recycle.server.controller"))
//                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("垃圾回收APIs接口") //网站标题
                .description("垃圾回收APIs接口文档") //网站描述
                .version("1.0") //版本
//                .contact(new Contact("陈荣光","https://blog.csdn.net/Xiaodongge521","crgwolf@126.com")) //联系人
                .license("The Apache License") //协议
                .licenseUrl("http://www.baidu.com") //协议url
                .build();
    }


    /**
     * 重写basePackage方法，使能够实现多包访问，复制贴上去
     * @author  teavamc
     * @date 2019/1/26
     * @param [basePackage]
     * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}
