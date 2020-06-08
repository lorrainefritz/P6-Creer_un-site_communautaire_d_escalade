package com.openclassrooms.LesAmisDeLEscaladeApplication.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	public static Connection getConnection() throws Exception {

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/bddLesAmisDeLEscalade");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Problème d'accès à la base de données", e); 
		}
	}
}
