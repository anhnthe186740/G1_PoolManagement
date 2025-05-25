package com.example.poolmanagement.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        // Chuyển hướng đến /api/auth/profile sau khi đăng nhập thành công
        response.sendRedirect("homepage");
    }
    // Bạn có thể thêm logic khác nếu cần, ví dụ: ghi log, gửi thông báo, v.v.
}