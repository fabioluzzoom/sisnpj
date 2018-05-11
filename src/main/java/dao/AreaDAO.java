package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AreaBean;
import connection.ConnectionFactory;

public class AreaDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(AreaBean area) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into area " 
					+ " (descricao)" 
							+ " values(?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, area.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public AreaBean consultarPorId(AreaBean area) throws SQLException {

		try {

			AreaBean newArea = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from area where idarea = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, area.getIdArea());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newArea.setIdArea(resultSet.getInt("idarea"));
				newArea.setDescricao(resultSet.getString("descricao"));

			}

			return newArea;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<AreaBean> listar() throws SQLException {

		try {

			List<AreaBean> areas = new ArrayList<AreaBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from area";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				AreaBean area = new AreaBean();

				area.setIdArea(resultSet.getInt("idarea"));
				area.setDescricao(resultSet.getString("descricao"));

				areas.add(area);
			}

			return areas;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public void alterar(AreaBean area) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update area " + "set descricao = ?" + "Where idarea = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, area.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public void deletar(AreaBean area) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from area where idarea = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, area.getIdArea());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();

		}

	}

}
