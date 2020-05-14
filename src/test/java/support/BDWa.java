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

public class BDWa {
	
	public int tipoCompraVarejo = 30;
	public int tipoCompraCorp = 29;
	
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
	
	public List<HashMap<String,Object>> consultaSimCard(int tipoCompra, String ddd) {
		
		ResultSet rs = null;
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String query = "SELECT "
						+ "a.rp_package_value AS ICCID, "
						+ "c.rrs_resource_value AS IMSI, "
						+ "(CASE "
						+ "WHEN("
						+ "SUBSTR(c.rrs_resource_value, 6, 1) = SUBSTR(a.rp_package_value, 9, 1)) AND "
						+ "(SUBSTR(c.rrs_resource_value, 6, 2) <> '00') -- valida se o HLR existe "
						+ "THEN 'Valid' ELSE 'Invalid' END) AS"
						+ " IMSI_CHECK, "
						+ "rrs_resource_sts Status "
						+ "FROM "
						+ "rm_packages a, rm_package_content b, rm_resource_stock c "
						+ "WHERE a.rp_package_value IN ("
						+ "SELECT "
						+ "RRS_RESOURCE_VALUE "
						+ "FROM rm_resource_stock c "
						+ "WHERE c.rrs_resource_tp_id = 6 AND "
						+ "c.rrs_resource_pool = " + tipoCompra + " -- 29 CORP OU 30 VAREJO -- AND "
						+ "a.rp_package_value in () AND "
						+ "SUBSTR(RRS_RESOURCE_VALUE, 9, 2) = " + ddd + " -- ÁREA DE SIMCARD NECESSÁRIO "
						+ "AND c.rrs_resource_sts = 'ASSIGNED') AND "
						+ "a.rp_package_id = b.rpc_package_id AND "
						+ "c.rrs_resource_sts = a.rp_package_sts AND "
						+ "b.rpc_component_tp_id = 5 AND "
						+ "b.rpc_component_vl_id = c.rrs_id "
						+ "ORDER BY "
						+ "a.sys_creation_date DESC";
		
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
			
			System.out.println("*** Dados obtidos banco <<" + banco + ">> ***");
			fechaConexao();
			
		} catch (SQLException e) {
			System.out.println("*** Não foi possível obter dados do banco <<" + banco + ">> ***\n" + e.getMessage());
			fechaConexao();
		}
		
		return list;
	}
	
	public List<HashMap<String,Object>> validaMsisdn(String msisdn) {
    	
    	ResultSet rs = null;
    	List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
    	
    	String query = "SELECT" + 
						" T.Cd_Fase," +
						" F.ds_Fase," +
						" T.Nu_Msisdn Msisdn," +
						" T.Nu_Iccid Simcard," +
						" Sq_Transacao," +
						" To_Char(Dh_Entrada,'DD/MM/YY, HH24:MI:SS') Data," +
						" T.Cd_Erro_Api" +
						" FROM" +
						" Transacao T," +
						" Fase_Processamento F" +
						" WHERE" +
						" F.Cd_Fase = T.Cd_Fase AND Nu_Msisdn In (?)";
    	
    	abreConexao();
    	
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, msisdn);
			
			rs = preparedStmt.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			
			while(rs.next()) {
				HashMap<String,Object> linha = new HashMap<String, Object>(columns);
		        for(int i=1; i<=columns; ++i) {
		            linha.put(md.getColumnName(i),rs.getObject(i));
		        }
		        list.add(linha);
			}
			
			
			System.out.println("*** Consultando MSISDN <<" + msisdn + ">> ***");
			fechaConexao();
			
		} catch (SQLException e) {
			System.out.println("*** Erro ao tentar consultar MSISDN <<" + msisdn + ">> ***");
			fechaConexao();
		}
    	
		return list;
    }
	
	/*public String retornaCdFase(String msisdn) {
    	
    	ResultSet rs = null;
    	String cdFase = null;
    	
    	String query = "SELECT" + 
						" T.Cd_Fase," +
						" F.ds_Fase," +
						" T.Nu_Msisdn Msisdn," +
						" T.Nu_Iccid Simcard," +
						" Sq_Transacao," +
						" To_Char(Dh_Entrada,'DD/MM/YY, HH24:MI:SS') Data," +
						" T.Cd_Erro_Api" +
						" FROM" +
						" Transacao T," +
						" Fase_Processamento F" +
						" WHERE" +
						" F.Cd_Fase = T.Cd_Fase AND Nu_Msisdn In (?)";
    	
    	abreConexao();
    	
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, msisdn);
			
			rs = preparedStmt.executeQuery();
			rs.last();
			
			int rows = rs.getRow();
			
			if(rows == 1) {
				rs.first();
				cdFase = rs.getString("Cd_Fase");
			}
			
			fechaConexao();
			
		} catch (SQLException e) {
			System.out.println("*** Erro ao tentar retornar o valor do Cd_Fase ***\n" + e.getMessage());
			fechaConexao();
		}
    	
		return cdFase;
    }*/

}
