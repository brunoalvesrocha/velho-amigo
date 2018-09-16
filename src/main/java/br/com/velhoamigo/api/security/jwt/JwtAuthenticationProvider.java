package br.com.velhoamigo.api.security.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.velhoamigo.api.model.UserContext;
import br.com.velhoamigo.api.model.token.RawAccessJwtToken;
import br.com.velhoamigo.api.security.config.JwtSettings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtSettings settings;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings settings) {
        this.settings = settings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        RawAccessJwtToken rawAccessJwtToken = (RawAccessJwtToken) authentication.getCredentials();
        Jws<Claims> jwsClaims = rawAccessJwtToken.parseClaims(settings.getTokenSigningKey());
        String subject = jwsClaims.getBody().getSubject();
        List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        String identUser = jwsClaims.getBody().get("ident_user", String.class);
        UserContext context = UserContext.create(subject, authorities, identUser);

        return new JwtAuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
