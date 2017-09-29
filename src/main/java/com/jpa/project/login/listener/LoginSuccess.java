package com.jpa.project.login.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


/**
 * Created by IMC021 on 2017. 9. 27..
 */
@Service
public class LoginSuccess implements ApplicationListener<AuthenticationSuccessEvent>{

    Logger logger = LoggerFactory.getLogger(LoginSuccess.class);

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String uid = ((UserDetails)(event.getAuthentication().getPrincipal())).getUsername();
        logger.info("{} 로그인", uid);
    }
}

