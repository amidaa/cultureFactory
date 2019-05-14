package com.first.group.config;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.CorsRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//配置CORS，解决同源策略
@Configuration
public class CORSConfigration extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry)
    { registry.addMapping("/**") .allowedOrigins("*") .allowCredentials(true) .allowedMethods("GET", "POST", "DELETE", "PUT") .maxAge(3600); } }
