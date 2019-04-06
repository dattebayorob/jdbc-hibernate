package com.dtb.jdbc.model;

public class Client {
	private String cpf;
	private String name;
	private String email;
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(String cpf, String name, String email) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Client [cpf=" + cpf + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
