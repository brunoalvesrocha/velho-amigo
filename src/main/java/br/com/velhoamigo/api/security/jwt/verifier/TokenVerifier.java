package br.com.velhoamigo.api.security.jwt.verifier;

public interface TokenVerifier {
    boolean verify(String jwt);
}
