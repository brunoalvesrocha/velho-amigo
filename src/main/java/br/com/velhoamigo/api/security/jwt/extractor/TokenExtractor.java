package br.com.velhoamigo.api.security.jwt.extractor;

public interface TokenExtractor {
    String extract(String payload);
}
