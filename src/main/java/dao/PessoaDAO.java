package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PessoaBean;
import connection.ConnectionFactory;

public class PessoaDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(PessoaBean pessoa) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into pessoa "
				+ " (cpf, nome, email, fone01, fone02, idfuncao, logradouro, numero, complemento, bairro, estado, municipio, cep)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, pessoa.getCpf());
			preparedStatement.setString(2, pessoa.getNome());
			preparedStatement.setString(3, pessoa.getEmail());
			preparedStatement.setString(4, pessoa.getFone01());
			preparedStatement.setString(5, pessoa.getFone02());
			preparedStatement.setInt(6, pessoa.getFuncao().getIdFuncao());
			preparedStatement.setString(7, pessoa.getLogradouro());
			preparedStatement.setString(8, pessoa.getNumero());
			preparedStatement.setString(9, pessoa.getComplemento());
			preparedStatement.setString(10, pessoa.getBairro());
			preparedStatement.setString(11, pessoa.getEstado());
			preparedStatement.setString(12, pessoa.getMunicipio());
			preparedStatement.setString(13, pessoa.getCep());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public PessoaBean consultarPorId(PessoaBean pessoa) throws SQLException {

		try {

			PessoaBean newPessoa = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from pessoa where idpessoa = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, pessoa.getIdPessoa());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newPessoa.setIdPessoa(resultSet.getInt("idpessoa"));
				newPessoa.setCpf(resultSet.getString("cpf"));
				newPessoa.setNome(resultSet.getString("nome"));
				newPessoa.setEmail(resultSet.getString("email"));
				newPessoa.setFone01(resultSet.getString("fone01"));
				newPessoa.setFone02(resultSet.getString("fone02"));
				newPessoa.getFuncao().setIdFuncao(resultSet.getInt("idfuncao"));
				newPessoa.setLogradouro(resultSet.getString("logradouro"));
				newPessoa.setNumero(resultSet.getString("numero"));
				newPessoa.setComplemento(resultSet.getString("complemento"));
				newPessoa.setBairro(resultSet.getString("bairrro"));
				newPessoa.setEstado(resultSet.getString("estado"));
				newPessoa.setMunicipio(resultSet.getString("municipio"));
				newPessoa.setCep(resultSet.getString("cep"));

			}

			return newPessoa;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<PessoaBean> listar() throws SQLException {

		try {

			List<PessoaBean> pessoas = new ArrayList<PessoaBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from pessoa";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				PessoaBean pessoa = new PessoaBean();

				pessoa.setIdPessoa(resultSet.getInt("idpessoa"));
				pessoa.setCpf(resultSet.getString("cpf"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("email"));
				pessoa.setFone01(resultSet.getString("fone01"));
				pessoa.setFone02(resultSet.getString("fone02"));
				pessoa.getFuncao().setIdFuncao(resultSet.getInt("idfuncao"));
				pessoa.setLogradouro(resultSet.getString("logradouro"));
				pessoa.setNumero(resultSet.getString("numero"));
				pessoa.setComplemento(resultSet.getString("complemento"));
				pessoa.setBairro(resultSet.getString("bairrro"));
				pessoa.setEstado(resultSet.getString("estado"));
				pessoa.setMunicipio(resultSet.getString("municipio"));
				pessoa.setCep(resultSet.getString("cep"));

				pessoas.add(pessoa);
				
			}

			return pessoas;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(PessoaBean pessoa) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update pessoa "
					+ "set cpf = ?, nome = ?, email = ?, fone01 = ?, fone02 = ?, idfuncao = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, estado = ?, municipio = ?, cep = ? "
					+ "Where idpessoa = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, pessoa.getCpf());
			preparedStatement.setString(2, pessoa.getNome());
			preparedStatement.setString(3, pessoa.getEmail());
			preparedStatement.setString(4, pessoa.getFone01());
			preparedStatement.setString(5, pessoa.getFone02());
			preparedStatement.setLong(6, pessoa.getFuncao().getIdFuncao());
			preparedStatement.setString(7, pessoa.getLogradouro());
			preparedStatement.setString(8, pessoa.getNumero());
			preparedStatement.setString(9, pessoa.getComplemento());
			preparedStatement.setString(10, pessoa.getBairro());
			preparedStatement.setString(11, pessoa.getEstado());
			preparedStatement.setString(12, pessoa.getMunicipio());
			preparedStatement.setString(13, pessoa.getCep());
			preparedStatement.setInt(13, pessoa.getIdPessoa());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(PessoaBean pessoa) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from pessoa where idpessoa = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, pessoa.getIdPessoa());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}

}