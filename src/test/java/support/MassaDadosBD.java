package support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MassaDadosBD {
	
	private String servidor = "localhost";
	private String banco = "massateste";
	private String usuario = "root";
	private String senha = "";
	private Connection conn;
	
	private void abreConexao() {
		
		conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + banco + "?useTimezone=true&serverTimezone=UTC", usuario, senha);
			System.out.println("*** Conectado ao banco <<" + banco + ">> ***");
		} catch (SQLException e) {
			System.out.println("*** Erro ao conectar no banco <<" + banco + ">> ***\n" + e.getMessage());
		}
	}
	
	private void fechaConexao() {
		
		try {			
			conn.close();
			System.out.println("*** Fechada a conexão com o banco <<" + banco + ">> ***");
		} catch (SQLException e) {
			System.out.println("*** Erro ao fechar a conexão com o banco <<" + banco + ">> ***\n" + e.getMessage());
		}
		
		conn = null;
	}
	
	public List<HashMap<String,Object>> consultaDados(String tabela) {
		
		ResultSet rs = null;
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String query = "";
		
		switch (tabela) {
		case "massa":
			query = "SELECT * FROM massa";
			break;
		case "automacao":
			query = "SELECT" + 
					" auto.id," + 
					" auto.status," + 
					" sist.sistema," + 
					" auto.planta," + 
					" auto.url," + 
					" auto.estado," + 
					" auto.ddd," + 
					" auto.usuario," + 
					" auto.senha" + 
					" FROM" + 
					" massateste.automacao auto" + 
					" INNER JOIN" + 
					" massateste.sistemas sist" + 
					" ON" + 
					" auto.sistema = sist.id";
			break;
		}
		
		abreConexao();
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			
			while(rs.next()) {
				HashMap<String,Object> linha = new HashMap<String, Object>(columns);
		        for(int i=1; i<=columns; ++i) {
		            linha.put(md.getColumnName(i),rs.getObject(i));
		        }
		        list.add(linha);
			}
			
			System.out.println("*** Dados obtidos banco <<" + banco + ">>, tabela <<" + tabela + ">> ***");
			fechaConexao();
			
		} catch (SQLException e) {
			System.out.println("*** Não foi possível obter dados do banco <<" + banco + ">> , tabela <<" + tabela + ">> ***\n" + e.getMessage());
			fechaConexao();
		}
		
		return list;
	}
	
	public void inserirNovaMassaDados(String[] massa) {
		
		String query = "INSERT INTO massa VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		abreConexao();
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, null);
			preparedStmt.setString (2, massa[0]);
			preparedStmt.setString (3, "PRONTA");
			preparedStmt.setString (4, massa[1]);
			preparedStmt.setString (5, massa[2]);
			preparedStmt.setString (6, massa[3]);
			preparedStmt.setString (7, massa[4]);
			
			preparedStmt.execute();
			
			System.out.println("*** Massa de dados inserida no banco <<" + banco + ">> ***\n"
								+ "\"PRONTA\", "
								+ "\"" + massa[0] + "\", "
								+ "\"" + massa[1] + "\", "
								+ "\"" + massa[2] + "\", "
								+ "\"" + massa[3] + "\", "
								+ "\"" + massa[4] + "\"");
			fechaConexao();
			
		} catch (SQLException e) {
			System.out.println("*** Não foi possível inserir nova massa de dados ***\n"
								+ "\"PRONTA\", "
								+ "\"" + massa[0] + "\", "
								+ "\"" + massa[1] + "\", "
								+ "\"" + massa[2] + "\", "
								+ "\"" + massa[3] + "\", "
								+ "\"" + massa[4] + "\"");
			fechaConexao();
		}		
	}
	
	public void mudaStatusMassaDados(String id) {
		
		String query = "UPDATE massa SET status = ? WHERE id = ?";
		
		abreConexao();
		
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, "USADA");
			preparedStmt.setString (2, id);
			
			preparedStmt.execute();
			
			System.out.println("*** Status da massa de dados id <<" + id + ">> foi alterado para <<USADA>> ***");
			fechaConexao();
			
		} catch (SQLException e) {
			System.out.println("*** Erro ao tentar alterar status da massa de dados id <<" + id + ">> ***");
			fechaConexao();
		}
	}
}