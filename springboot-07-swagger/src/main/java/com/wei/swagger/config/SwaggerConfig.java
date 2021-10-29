package com.wei.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
//dispensable
@EnableSwagger2
public class SwaggerConfig {

    @Bean
//    @Profile("dev")//equals line 25 and 26.
    public Docket docket(Environment environment) {
        Profiles profile = Profiles.of("prod", "test");
        Boolean flag = environment.acceptsProfiles(profile);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cosmos")
                .enable(flag)    //开光Swagger
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.wei.swagger.controller"))
                //.paths(PathSelectors.ant("/wei/**"))    //paths过滤什么路径
                .build();
    }

    //swagger2 version =3+: New access path:http://localhost:8080/swagger-ui/index.html
    private ApiInfo apiInfo() {
        Contact contact = new Contact("宇宙伟", "https://www.baidu.com/", "2117008741@qq.com");
        return new ApiInfo("宇宙伟的SWAGGER"
                , "知行合一"
                , "1.0"
                , "hut"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList<>());
    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("wei");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("huang");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("xu");
    }
}
