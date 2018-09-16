package br.com.velhoamigo.api.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class UserContext {

    private final String username;
    private final String identUser;
    private final List<GrantedAuthority> authorities;

    public UserContext(String username, List<GrantedAuthority> authorities, 
    		String identUser) {
        this.username = username;
        this.identUser = identUser;
        this.authorities = authorities;
    }

    public static UserContext create(String username, List<GrantedAuthority> authorities,
    		String identUser) {
        if(StringUtils.isBlank(username)) throw new IllegalArgumentException("Username is blank: " + username);
        return new UserContext(username, authorities, identUser);
    }

    public String getIdentUser() {
		return identUser;
	}
    
    public String getUsername() {
        return username;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
