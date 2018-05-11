package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.TramitacaoBean;
import connection.ConnectionFactory;

public class TramitacaoDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(TramitacaoBean tramitacao) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into tramitacao "
				+ " (datatramitacao, textotramitacao, idpessoa)"
				+ " values(?,?,?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setTimestamp(1, tramitacao.getDataTramitacao());
			preparedStatement.setString(2, tramitacao.getTextoTramitacao());
			preparedStatement.setInt(3, tramitacao.getPessoa().getIdPessoa()); 

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public TramitacaoBean consultarPorId(TramitacaoBean tramitacao) throws SQLException {

		try {

			TramitacaoBean newTramitacao = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from tramitacao where idtramitacao = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, tramitacao.getIdTramitacao());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newTramitacao.setIdTramitacao(resultSet.getInt("idtramitacao"));
				newTramitacao.setDataTramitacao(resultSet.getTimestamp("datatramitacao"));
				newTramitacao.setTextoTramitacao(resultSet.getString("textotramitacao"));
				newTramitacao.getPessoa().setIdPessoa(resultSet.getInt("idpessoa"));
				
			}

			return newTramitacao;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<TramitacaoBean> listar() throws SQLException {

		try {

			List<TramitacaoBean> tramitacoes = new ArrayList<TramitacaoBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from tramitacao";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				TramitacaoBean tramitacao = new TramitacaoBean();

				tramitacao.setIdTramitacao(resultSet.getInt("idtramitacao"));
				tramitacao.setDataTramitacao(resultSet.getTimestamp("datatramitacao"));
				tramitacao.setTextoTramitacao(resultSet.getString("textotramitacao"));
				tramitacao.getPessoa().setIdPessoa(resultSet.getInt("idpessoa"));
				
				tramitacoes.add(tramitacao);
				
			}

			return tramitacoes;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(TramitacaoBean tramitacao) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update tramitacao"
					+ "set datatramitacao = ?, textotramitacao = ?, idpessoa = ?"
					+ "Where idtramitcao = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setTimestamp(1, tramitacao.getDataTramitacao());
			preparedStatement.setString(2, tramitacao.getTextoTramitacao());
			preparedStatement.setInt(3, tramitacao.getPessoa().getIdPessoa()); 

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(TramitacaoBean tramitacao) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from tramitacao where idtramitacao = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, tramitacao.getIdTramitacao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}
	
}
