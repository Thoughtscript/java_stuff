package com.thoughtscript.springmvcsecurity.transfer.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private com.thoughtscript.springmvcsecurity.domain.User user;

    public CustomUserDetails(com.thoughtscript.springmvcsecurity.domain.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public CustomUserDetails(com.thoughtscript.springmvcsecurity.domain.User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public com.thoughtscript.springmvcsecurity.domain.User getUser() {
        return user;
    }
}
