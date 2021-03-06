package com.navita.patrimonio.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="Usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 15484545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Email
	private String email;
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	public Usuario() {
		
	}
	
	

	public Usuario(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}



	@Override
	public String getPassword() {
		return this.senha;
	}



	@Override
	public String getUsername() {
		return this.email;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}



	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
