package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ClassifProcessoBean;
import connection.ConnectionFactory;

public class ClassifProcessoDAO {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(ClassifProcessoBean classifProcesso) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into classifprocesso " 
					+ " (idarea,descricao)"
							+ " values(?, ?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, classifProcesso.getArea().getIdArea());
			preparedStatement.setString(2, classifProcesso.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public ClassifProcessoBean consultarPorId(ClassifProcessoBean classifProcesso) throws SQLException {

		try {

			ClassifProcessoBean newClassifProcesso = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from classifprocesso where idarea = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, classifProcesso.getIdClassif());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newClassifProcesso.setIdClassif(resultSet.getInt("idclassif"));
				newClassifProcesso.setIdClassif(resultSet.getInt("idarea"));
				newClassifProcesso.setDescricao(resultSet.getString("descricao"));

			}

			return newClassifProcesso;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<ClassifProcessoBean> listar() throws SQLException {

		try {

			List<ClassifProcessoBean> classifProcessos = new ArrayList<ClassifProcessoBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from classifprocesso";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ClassifProcessoBean classifProcesso = new ClassifProcessoBean();

				classifProcesso.setIdClassif(resultSet.getInt("idclassif"));
				classifProcesso.setIdClassif(resultSet.getInt("idarea"));
				classifProcesso.setDescricao(resultSet.getString("descricao"));

				classifProcessos.add(classifProcesso);
				
			}

			return classifProcessos;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public void alterar(ClassifProcessoBean classifProcesso) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update classifprocesso " + "set idarea = ?, set descricao = ?" + "Where idclassif = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, classifProcesso.getArea().getIdArea());
			preparedStatement.setString(2, classifProcesso.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public void deletar(ClassifProcessoBean classifProcesso) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from classifprocesso where idclassif = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, classifProcesso.getIdClassif());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();

		}

	}

}
