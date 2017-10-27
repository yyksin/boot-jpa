package com.jpa.project.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by IMC021 on 2017. 9. 26..
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 메인페이지 : css나 js 같은것들도 여기에 포함시켜준다.
        web.ignoring().antMatchers("/","/css/**","/js/**","/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //허용
        http.authorizeRequests()
                // 회원가입과 처리부분이 추가
                .antMatchers("/login","/user/create").permitAll()
                .antMatchers("/**").authenticated();
        //로그인
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("uid")
                .passwordParameter("upassword")
                .loginProcessingUrl("/login_process")
                .successForwardUrl("/")
                .failureUrl("/login?error")
                .and()
                //에러페이지
                .exceptionHandling().accessDeniedPage("/error");
        //로그아웃
        http.logout()
                // /logout 을 호출할 경우 로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // 로그아웃이 성공했을 경우 이동할 페이지
                .logoutSuccessUrl("/");
        //CSRF (Cross Site Request Forgery) 설정이 디폴트 (Default)로 활성화 (Enable)되기 때문에 POST 처리가 안되어 비활성화 한다
        http.csrf().disable().httpBasic();
    }


//    @Configuration
//    public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//        @Autowired
//        UserDetailsService userDetailsService;
//
//        @Bean
//        PasswordEncoder passwordEncoder()
//        {
//            // 인증에 기본 스프링 해시를 사용
//            return new BCryptPasswordEncoder();
//        }
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception
//        {
//            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//        }
//    }
}