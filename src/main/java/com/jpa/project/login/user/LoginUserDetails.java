package com.jpa.project.login.user;

import com.jpa.project.entity.T_USER;
import lombok.Getter;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by IMC021 on 2017. 9. 26..
 */
public class LoginUserDetails extends User {

    @Getter
    private long no;

    public LoginUserDetails(T_USER user)
    {
        // 일반적으로는 AuthorityUtils.createAuthorityList 에 다수의 룰을 넣어야 한다
        super(user.getUid(), user.getUpassword(), AuthorityUtils.createAuthorityList("ADMIN"));
        no = user.getIdx();
    }
}
