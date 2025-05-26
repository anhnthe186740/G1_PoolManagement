package com.example.poolmanagement.config;

import com.example.poolmanagement.service.CustomOAuth2UserService;
import com.example.poolmanagement.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
<<<<<<< HEAD
    private CustomOAuth2UserService customOAuth2UserService; // ✅ OAuth2 service
=======
    private CustomOAuth2UserService customOAuth2UserService;
>>>>>>> feature/nguyen

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
<<<<<<< HEAD
                        .requestMatchers("/","/homepage", "/login", "/register", "/api/auth/register", "/api/auth/login") 
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll() 
                        .requestMatchers("/api/auth/profile").authenticated() 
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login") 
=======
                        .requestMatchers("/", "/login", "/register", "/api/auth/register", "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                        .requestMatchers("/editprofile", "/api/user/profile").authenticated()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
>>>>>>> feature/nguyen
                        .successHandler(customSuccessHandler())
                        .permitAll())
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
<<<<<<< HEAD
                        .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService)) // xử lý thông tin người dùng từ OAuth2
                        .defaultSuccessUrl("/dashboard", true) // chuyển hướng sau khi đăng nhập thành công
                )
                .rememberMe(remember -> remember
                        .key("your-secure-key") // chuỗi bất kỳ
                        .tokenValiditySeconds(7 * 24 * 60 * 60) // 7 ngày
                )
=======
                        .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                        .defaultSuccessUrl("/dashboard", true))
                .rememberMe(remember -> remember
                        .key("your-secure-key")
                        .tokenValiditySeconds(7 * 24 * 60 * 60))
>>>>>>> feature/nguyen
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }
}
