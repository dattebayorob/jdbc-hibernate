package com.dtb.jdbc;

import com.dtb.jdbc.model.Client;
import com.dtb.jdbc.model.ClientDao;

public class Main {
		public static void main(String[] args) {
			ClientDao dao = new ClientDao();
			try{
				dao.findAll();
				dao.deleteAll();
				dao.save(new Client("xxxxxxxxxxx","fulano 2","fulano@gmail.com"));
				dao.findAll().forEach(client -> System.out.println(client));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
