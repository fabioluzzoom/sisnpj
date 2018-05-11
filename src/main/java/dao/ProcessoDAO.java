package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ProcessoBean;
import connection.ConnectionFactory;

public class ProcessoDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(ProcessoBean processo) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into processo "
				+ " (datahoraentrada, vara, numprocessovara, relatofato, obsinicial, obsfinal, situacao, idclassif)"
				+ " values(?,?,?,?,?,?,?,?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setTimestamp(1, processo.getDataHoraEntrada());
			preparedStatement.setString(2, processo.getVara());
			preparedStatement.setString(3, processo.getNumProcessoVara());
			preparedStatement.setString(4, processo.getRelatoFato());
			preparedStatement.setString(5, processo.getObsInicial());
			preparedStatement.setString(6, processo.getObsFinal());
			preparedStatement.setInt(7, processo.getSituacao());
			preparedStatement.setInt(8, processo.getClassif().getIdClassif());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public ProcessoBean consultarPorId(ProcessoBean processo) throws SQLException {

		try {

			ProcessoBean newProcesso = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from processo where idprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, processo.getIdProcesso());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newProcesso.setIdProcesso(resultSet.getInt("idprocesso"));
				newProcesso.setDataHoraEntrada(resultSet.getTimestamp("datahoraentrada"));
				newProcesso.setVara(resultSet.getString("vara"));
				newProcesso.setNumProcessoVara(resultSet.getString("vara"));
				newProcesso.setRelatoFato(resultSet.getString("relatofato"));
				newProcesso.setObsInicial(resultSet.getString("obsinicial"));
				newProcesso.setObsFinal(resultSet.getString("obsfinal"));
				newProcesso.setSituacao(resultSet.getInt("situacao"));
				newProcesso.getClassif().setIdClassif(resultSet.getInt("idclassif"));
				
			}

			return newProcesso;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<ProcessoBean> listar() throws SQLException {

		try {

			List<ProcessoBean> processos = new ArrayList<ProcessoBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from processo";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ProcessoBean processo = new ProcessoBean();

				processo.setIdProcesso(resultSet.getInt("idprocesso"));
				processo.setDataHoraEntrada(resultSet.getTimestamp("datahoraentrada"));
				processo.setVara(resultSet.getString("vara"));
				processo.setNumProcessoVara(resultSet.getString("vara"));
				processo.setRelatoFato(resultSet.getString("relatofato"));
				processo.setObsInicial(resultSet.getString("obsinicial"));
				processo.setObsFinal(resultSet.getString("obsfinal"));
				processo.setSituacao(resultSet.getInt("situacao"));
				processo.getClassif().setIdClassif(resultSet.getInt("idclassif"));

				processos.add(processo);
				
			}

			return processos;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(ProcessoBean processo) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update processo "
					+ "set datahoraentrada = ?, vara = ?, numprocessovara = ?, relatofato = ?, obsinicial = ?, obsfinal = ?, situacao = ?, idclassif = ?"
					+ "Where idprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setTimestamp(1, processo.getDataHoraEntrada());
			preparedStatement.setString(2, processo.getVara());
			preparedStatement.setString(3, processo.getNumProcessoVara());
			preparedStatement.setString(4, processo.getRelatoFato());
			preparedStatement.setString(5, processo.getObsInicial());
			preparedStatement.setString(6, processo.getObsFinal());
			preparedStatement.setInt(7, processo.getSituacao());
			preparedStatement.setInt(8, processo.getClassif().getIdClassif());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(ProcessoBean processo) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from processo where idprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, processo.getIdProcesso());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}

	
}
