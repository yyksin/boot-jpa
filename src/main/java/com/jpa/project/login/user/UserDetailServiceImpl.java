package com.jpa.project.login.user;

import com.jpa.project.entity.T_USER;
import com.jpa.project.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by IMC021 on 2017. 9. 26..
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{
    Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        T_USER user = userRepository.findOneByUid(uid);
        if(user == null){
            logger.info("{}, 유저 정보 없음",uid);
            throw new UsernameNotFoundException("login fail");
        }else if(user.getUseyn() == 0){
            logger.info("{}, 비활성화 상태",uid);
            throw new UsernameNotFoundException("login fail");
        }
        return new LoginUserDetails(user);
    }
}
