package com.jpa.project.login.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Service;


/**
 * Created by IMC021 on 2017. 9. 27..
 */
@Service
public class LoginFail implements ApplicationListener<AuthenticationFailureBadCredentialsEvent>{
    Logger logger = LoggerFactory.getLogger(LoginFail.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String id = (String)event.getAuthentication().getPrincipal();
        String password = (String)event.getAuthentication().getCredentials();

        logger.info("로그인 실패, {}/{}",id,password);
    }
}
