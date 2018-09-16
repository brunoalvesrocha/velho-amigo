package br.com.velhoamigo.api.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.velhoamigo.api.model.UserContext;
import br.com.velhoamigo.api.model.token.JwtToken;
import br.com.velhoamigo.api.model.token.JwtTokenFactory;

@Component
public class AwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper mapper;
    private final JwtTokenFactory tokenFactory;

    public AwareAuthenticationSuccessHandler(ObjectMapper mapper, JwtTokenFactory tokenFactory) {
        this.mapper = mapper;
        this.tokenFactory = tokenFactory;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {

    	UserContext userContext = (UserContext) auth.getPrincipal();

        JwtToken accessToken = tokenFactory.createAccessJwtToken(userContext);
        // JwtToken refreshToken = tokenFactory.createRefreshToken(userContext);

        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("username", userContext.getUsername());
        tokenMap.put("token_type", "Bearer");
        tokenMap.put("access_token", accessToken.getToken());
        tokenMap.put("ident_user",userContext.getIdentUser());
//        tokenMap.put("scopes", String.valueOf(userContext.getAuthorities()));

        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        mapper.writeValue(response.getWriter(), tokenMap);

        clearAuthenticationAttributes(request);
    }

    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session == null) return;

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
