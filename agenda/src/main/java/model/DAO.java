package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "db123";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection conexao = null;
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email) values(?,?,?)";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(read);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String id = result.getString(1);
				String nome = result.getString(2);
				String fone = result.getString(3);
				String email = result.getString(4);
				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			conexao.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read = "select * from contatos where id = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(read);
			pst.setString(1, contato.getId());
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				contato.setId(result.getString(1));
				contato.setNome(result.getString(2));
				contato.setFone(result.getString(3));
				contato.setEmail(result.getString(4));
			}
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome=?,fone=?,email=? where id=?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Excluir contato.
	 *
	 * @param contato the contato
	 */
	public void excluirContato(JavaBeans contato) {
		String delete = "delete from contatos where id =?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
