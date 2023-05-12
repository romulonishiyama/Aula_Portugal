package aulas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Aula01 {

	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost:3306";
		final String USER = "root";
		final String PASS = "";
		
		try {
			Connection conexao = DriverManager.getConnection(URL, USER, PASS);
			String sql = "create database if not exists sucos";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			
			sql = "use sucos";
			stmt = conexao.prepareStatement(sql);
			stmt.execute();
			stmt.close();

			sql = "create table tb_produtos (MATRICULA INT(5),NOME  VARCHAR(100),PERCENTUAL_COMISSAO FLOAT);";
			PreparedStatement stmt2 = conexao.prepareStatement(sql);
			stmt2.execute();
			stmt2.close();
			
			
			
			System.out.println(" criado com sucesso!");
			
		}catch(SQLException e) {
			e.getStackTrace();
			System.out.println("Erro ao criar banco!");
		}
		
		

	}

}
