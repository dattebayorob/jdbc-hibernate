package com.dtb.jdbc;

import com.dtb.jdbc.model.Cliente;
import com.dtb.jdbc.model.ClienteDao;

public class Main {
	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.findById(Long.valueOf(1));
		if(cliente == null ) {
			System.out.println("Persisting...");
			cliente = new Cliente(Long.valueOf(1), "xxxxxxxxxxx", "Robson William", "robson.william65@gmail.com");
			dao.persist(cliente);
		}else {
			System.out.println(dao.findByCpf("xxxxxxxxxxx"));
		}
		System.out.println(dao.findById(Long.valueOf(1)));
	}
}
