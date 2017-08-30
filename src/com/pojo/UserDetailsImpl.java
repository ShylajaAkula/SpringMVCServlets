package com.pojo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class UserDetailsImpl implements UserDetails {
	
	private Integer id;
	private Collection<GrantedAuthorityImpl> authorities;
	private String password;
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToMany
	@JoinTable(
			name="user_authority",
	        joinColumns={@JoinColumn(name="uid")},
	        inverseJoinColumns={@JoinColumn(name="aid")})
	public Collection<GrantedAuthorityImpl> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	
	public void setAuthorities(Collection<GrantedAuthorityImpl> authorities) {
		this.authorities = authorities;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.credentialsNonExpired;
	}
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	
}
