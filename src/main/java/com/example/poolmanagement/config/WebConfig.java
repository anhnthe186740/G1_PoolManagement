package com.example.poolmanagement.config; // Thay đổi package theo dự án của bạn

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Ánh xạ tất cả các tài nguyên tĩnh từ thư mục /static/**
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600); // (Tùy chọn) Caching tài nguyên trong 1 giờ (3600 giây)
    }
}