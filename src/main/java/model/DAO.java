package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO
{

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";

	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";

	/** The user. */
	private String user = "root";

	/** The password. */
	private String password = "12345678";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar()
	{
		Connection con = null;
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void insertContato(JavaBeans contato)
	{
		String sql = "insert into contatos (nome,fone,email) values(?,?,?);";
		Connection con = conectar();
		try
		{
			PreparedStatement preStat = con.prepareStatement(sql);
			preStat.setString(1, contato.getNome());
			preStat.setString(2, contato.getFone());
			preStat.setString(3, contato.getEmail());
			preStat.executeUpdate();
			preStat.close();
			con.close();

		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<JavaBeans> getContatos()
	{
		String sql = "select * from contatos order by nome;";
		ArrayList<JavaBeans> listContatos = new ArrayList<>();
		Connection con = conectar();
		try
		{
			PreparedStatement preStat = con.prepareStatement(sql);
			ResultSet resultSet = preStat.executeQuery();
			while (resultSet.next())
			{
				String id = resultSet.getString(1);
				String nome = resultSet.getString(2);
				String fone = resultSet.getString(3);
				String email = resultSet.getString(4);
				listContatos.add(new JavaBeans(id, nome, fone, email));
			}
			resultSet.close();
			preStat.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return listContatos;

	}

	public void getSelected(JavaBeans contato)
	{
		String sql = "select * from contatos where id = ?;";
		Connection con = conectar();
		try
		{
			PreparedStatement preStat = con.prepareStatement(sql);
			preStat.setString(1, contato.getId());
			ResultSet resultSet = preStat.executeQuery();
			while (resultSet.next())
			{
				contato.setId(resultSet.getString(1));
				contato.setNome(resultSet.getString(2));
				contato.setFone(resultSet.getString(3));
				contato.setEmail(resultSet.getString(4));
			}
			resultSet.close();
			preStat.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

	}

	public void updateSelected(JavaBeans contato)
	{
		String sql = "update contatos set nome=?, fone=?, email=? where id=?";
		Connection con = conectar();
		try
		{
			PreparedStatement preStat = con.prepareStatement(sql);
			preStat.setString(1, contato.getNome());
			preStat.setString(2, contato.getFone());
			preStat.setString(3, contato.getEmail());
			preStat.setString(4, contato.getId());
			preStat.executeUpdate();
			preStat.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void deleteSelected(JavaBeans contato)
	{
		String sql = "delete from contatos where id = ?";
		Connection con = conectar();
		try
		{
			PreparedStatement preStat = con.prepareStatement(sql);
			preStat.setString(1, contato.getId());
			preStat.executeUpdate();
			preStat.close();
			con.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
