package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FormaPartBean;
import connection.ConnectionFactory;

public class FormaPartDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(FormaPartBean formapart) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into formapart "
				+ " (descricao)"
				+ " values(?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, formapart.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public FormaPartBean consultarPorId(FormaPartBean formapart) throws SQLException {

		try {

			FormaPartBean newFormaPart = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from formapart where idformapart = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, formapart.getIdFormaPart());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newFormaPart.setIdFormaPart(resultSet.getInt("idformapart"));
				newFormaPart.setDescricao(resultSet.getString("descricao"));

			}

			return newFormaPart;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<FormaPartBean> listar() throws SQLException {

		try {

			List<FormaPartBean> formaparts = new ArrayList<FormaPartBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from formapart";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				FormaPartBean formapart = new FormaPartBean();

				formapart.setIdFormaPart(resultSet.getInt("idformapart"));
				formapart.setDescricao(resultSet.getString("descricao"));
				
				formaparts.add(formapart);
				
			}

			return formaparts;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(FormaPartBean formapart) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update formapart"
					+ "set descricao = ?"
					+ "Where idformapart = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, formapart.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(FormaPartBean formapart) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from formapart where idformapart = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, formapart.getIdFormaPart());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}

}
