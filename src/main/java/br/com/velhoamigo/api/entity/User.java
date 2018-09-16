package br.com.velhoamigo.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "APP_USER")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
    		name = "UUID",
    		strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "IDENT_USER")
    private UUID identUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "APP_USER_ID", referencedColumnName = "IDENT_USER")
    private List<UserRole> roles;

    public User() {
    }

    public User(String username, String password, List<UserRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    
    public UUID getIdentUser() {
		return identUser;
	}

	public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }


}
