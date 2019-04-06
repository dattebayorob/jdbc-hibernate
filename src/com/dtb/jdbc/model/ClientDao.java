package com.dtb.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClientDao {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/jdbctestes?currentSchema=teste";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWD = "postgres";
	private Connection connection;
	
	public void connect() throws SQLException{
		connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
	}
	
	public void close() throws SQLException{
		connection.close();
	}
	
	public List<Client> findAll() throws SQLException{
		String sql = "SELECT * FROM cliente";
		connect();
		ResultSet rs = connection.createStatement().executeQuery(sql);
		List<Client> clients = new LinkedList<>();
		while (rs.next()) {
			clients.add(new Client(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		close();
		return clients;
	}
	
	public Client findByCpf(String cpf) throws SQLException{
		String sql = "SELECT * FROM cliente WHERE cpf = '"+cpf+"'";
		connect();
		ResultSet rs = connection.createStatement().executeQuery(sql);
		Client client = new Client();
		while(rs.next()) {
			client.setCpf(rs.getString(1));
			client.setName(rs.getString(2));
			client.setEmail(rs.getString(3));
		}
		close();
		return client;
	}
	
	public Client save(Client client) throws SQLException{
		String sql = "INSERT INTO cliente (cpf, nome, email) VALUES (?,?,?)";
		connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, client.getCpf());
		ps.setString(2, client.getName());
		ps.setString(3, client.getEmail());
		ps.execute();
		close();
		return client;
	}
	
	public void deleteAll() throws SQLException {
		String sql = "DELETE FROM cliente";
		connect();
		connection.createStatement().execute(sql);
		close();
	}
}
