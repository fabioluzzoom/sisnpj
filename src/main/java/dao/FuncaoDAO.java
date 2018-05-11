package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FuncaoBean;
import connection.ConnectionFactory;

public class FuncaoDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(FuncaoBean funcao) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into funcao " + " (descricao, interno)" + " values(?,?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, funcao.getDescricao());
			preparedStatement.setString(2, String.valueOf(funcao.getInterno()));

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public FuncaoBean consultarPorId(FuncaoBean funcao) throws SQLException {

		try {

			FuncaoBean newFuncao = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from funcao where idfuncao = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, funcao.getIdFuncao());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newFuncao.setIdFuncao(resultSet.getInt("idfuncao"));
				newFuncao.setDescricao(resultSet.getString("descricao"));
				newFuncao.setInterno(resultSet.getString("interno").charAt(0));

			}

			return newFuncao;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<FuncaoBean> listar() throws SQLException {

		try {

			List<FuncaoBean> funcoes = new ArrayList<FuncaoBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from funcao";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				FuncaoBean funcao = new FuncaoBean();

				funcao.setIdFuncao(resultSet.getInt("idfuncao"));
				funcao.setDescricao(resultSet.getString("descricao"));
				funcao.setInterno(resultSet.getString("nome").charAt(0));

				funcoes.add(funcao);

			}

			return funcoes;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public void alterar(FuncaoBean funcao) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update funcao " + "set descricao = ?, interno = ?" + "Where idfuncao = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, funcao.getDescricao());
			preparedStatement.setString(2, String.valueOf(funcao.getInterno()));

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public void deletar(FuncaoBean funcao) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from funcao where idfuncao = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, funcao.getIdFuncao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();

		}

	}

}
