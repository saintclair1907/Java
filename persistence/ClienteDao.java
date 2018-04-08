package persistence;

import java.util.ArrayList;

import entity.Cliente;

public class ClienteDao extends Dao{
	
	ArrayList<Cliente> listaExterna = new ArrayList<>();
	
	public void create() {
		Cliente c = new Cliente();
		
		try {
			con.prepareStatement("insert into cliente values(null,?,?,?");
			stmt.setString(0, c.getNome());
			stmt.setString(1, c.getEmail());
			stmt.setInt(2, c.getIdade());
			stmt.execute();
			
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
	}
	
	public ArrayList<Cliente> findAll(){
		ArrayList<Cliente> lista = new ArrayList<>();
		
		try {
			con.prepareStatement("select * from cliente");
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt(0));
				c.setNome(rs.getString(1));
				c.setEmail(rs.getString(2));
				c.setIdade(rs.getInt(3));
				lista.add(c);
				
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return lista;
	}
	
	public Cliente findById(Integer id){
		Cliente c = new Cliente();
		
		try {
			con.prepareStatement("select * from cliente where idCliente=?");
			stmt.setInt(1, id);
			rs= stmt.executeQuery();
			
			while(rs.next()) {
				
				c.setId(rs.getInt(0));
				c.setNome(rs.getString(1));
				c.setEmail(rs.getString(2));
				c.setIdade(rs.getInt(3));
								
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return c;
	}
	
	public void delete(Cliente c){
		
				
		try {
			con.prepareStatement("delete from cliente where idCliente=?");
			stmt.setInt(1, c.getId());
			stmt.execute();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void update(Cliente c) {
		
		try {
			con.prepareStatement("updade cliente set nome=?, email=?, idade=? where idCliente=?");
			stmt.setInt(3, c.getId());
			
			stmt.setString(0, c.getNome());
			stmt.setString(1, c.getEmail());
			stmt.setInt(2, c.getIdade());
			
			stmt.execute();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
	}

}
