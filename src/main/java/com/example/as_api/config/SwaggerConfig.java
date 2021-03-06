package com.example.as_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置文件
 * 通过http://localhost:你的端口号/swagger-ui.html 即可访问查看效果
 * 没有该类Swagger默认也是可以访问的
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String VERSION = "1.0.1";
    public static final String AUTHOR = "souean‘s Proj";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //Controller的位置
                .apis(RequestHandlerSelectors.basePackage("com.example.as_api.controller")) //这里填controller的路径
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class) //忽略注解
                .enableUrlTemplating(false)
                .tags(new Tag("Account", "账号模块"))
                .tags(new Tag("City", "新闻模块"))
                .tags(new Tag("HiConfig", "配置中心模块"))
                .tags(new Tag("Category", "类别"))
                .tags(new Tag("News", "新闻"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题
                .title("API文档")
                .description("Sounean's Proj -API文档")
                .version(VERSION)
                .contact(new Contact(AUTHOR, "https://sounean.github.io/2022/02/07/di-yi-pian/", "https://sounean.github.io/2022/02/07/di-yi-pian/"))
                .build();
    }
}
