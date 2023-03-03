package ti2cc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CelularDAO extends DAO {
	public CelularDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Celular celular) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO celular (memoria, marca, modelo, preco) "
				       + "VALUES ("+celular.getMemoria()+ ", ' " + celular.getMarca() + " ', ' "  
				       + celular.getModelo() + " ',  " + celular.getPreco() + " );";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Celular get(int memoria) {
		Celular celular = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + memoria;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 celular = new Celular(rs.getInt("memoria"), rs.getString("marca"), rs.getString("modelo"), rs.getDouble("preco"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return celular;
	}
	
	
	public List<Celular> get() {
		return get("");
	}

	
	public List<Celular> getOrderByMemoria() {
		return get("memoria");		
	}
	
	
	public List<Celular> getOrderByMarca() {
		return get("marca");		
	}
	
	
	public List<Celular> getOrderByPreco() {
		return get("preco");		
	}
	
	
	private List<Celular> get(String orderBy) {	
	
		List<Celular> celulares = new ArrayList<Celular>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM celular" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Celular u = new Celular(rs.getInt("memoria"), rs.getString("marca"), rs.getString("modelo"), rs.getDouble("preco"));
	            celulares.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return celulares;
	}


	public List<Celular> getMarca() {
		List<Celular> celulares = new ArrayList<Celular>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM celular WHERE celular.marca LIKE 'apple'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Celular u = new Celular(rs.getInt("memoria"), rs.getString("marca"), rs.getString("modelo"), rs.getDouble("preco"));
	            celulares.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return celulares;
	}
	
	
	public boolean update(Celular celular) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE celular SET marca = '" + celular.getMarca() + "', modelo = '"  
				       + celular.getModelo() + "', preco = '" + celular.getPreco() + "'"
					   + " WHERE memoria = " + celular.getMemoria();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(String marca) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM celular WHERE marca = " + marca;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String modelo, String marca) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM celular WHERE modelo LIKE ' " + modelo + " ' AND marca LIKE ' " + marca  + " ' ";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}