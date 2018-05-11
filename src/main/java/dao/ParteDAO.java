package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ParteBean;
import connection.ConnectionFactory;

public class ParteDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(ParteBean parte) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into parte "
				+ " (idpessoa, idprocesso, idformapart)"
				+ " values(?,?,?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, parte.getPartePK().getIdPessoa());
			preparedStatement.setInt(2, parte.getPartePK().getIdProcesso());
			preparedStatement.setInt(3, parte.getFormaPart().getIdFormaPart());
			
			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public ParteBean consultarPorId(ParteBean parte) throws SQLException {

		try {

			ParteBean newParte = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from parte where idprdouto = ? and idprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, parte.getPartePK().getIdPessoa());
			preparedStatement.setInt(1, parte.getPartePK().getIdProcesso());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newParte.getPartePK().setIdPessoa(resultSet.getInt("idpessoa"));
				newParte.getPartePK().setIdProcesso(resultSet.getInt("idprocesso"));
				newParte.getFormaPart().setIdFormaPart((resultSet.getInt("idformapart")));

			}

			return newParte;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<ParteBean> listar() throws SQLException {

		try {

			List<ParteBean> partes = new ArrayList<ParteBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from parte";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ParteBean parte = new ParteBean();

				parte.getPartePK().setIdPessoa((resultSet.getInt("idpessoa")));
				parte.getPartePK().setIdProcesso((resultSet.getInt("idprocesso")));
				parte.getFormaPart().setIdFormaPart((resultSet.getInt("idformapart")));
		
				partes.add(parte);
				
			}

			return partes;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(ParteBean parte) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update parte "
					+ "set idpessoa = ?, idprocesso = ?, idformapart = ?, fone01 = ?, fone02 = ?, idfuncao = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, estado = ?, municipio = ?, cep = ? "
					+ "Where idpessoa = ? and idprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, parte.getPartePK().getIdPessoa());
			preparedStatement.setInt(2, parte.getPartePK().getIdProcesso());
			preparedStatement.setInt(3, parte.getFormaPart().getIdFormaPart());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(ParteBean parte) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from parte where idpessoa = ? and idprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, parte.getPartePK().getIdPessoa());
			preparedStatement.setInt(1, parte.getPartePK().getIdProcesso());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}
	
}
