package br.com.velhoamigo.api.entity;

public enum Role {

    ADMIN, USER, MEMBER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
