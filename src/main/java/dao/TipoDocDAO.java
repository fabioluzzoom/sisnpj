package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.TipoDocBean;
import connection.ConnectionFactory;

public class TipoDocDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(TipoDocBean tipodoc) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into tipodoc "
				+ " (descricao)"
				+ " values(?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tipodoc.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public TipoDocBean consultarPorId(TipoDocBean tipodoc) throws SQLException {

		try {

			TipoDocBean newTipoDoc = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from tipodoc where idtipodoc = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, tipodoc.getIdTipoDoc());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newTipoDoc.setIdTipoDoc(resultSet.getInt("idtipodoc"));
				newTipoDoc.setDescricao(resultSet.getString("descricao"));

			}

			return newTipoDoc;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<TipoDocBean> listar() throws SQLException {

		try {

			List<TipoDocBean> tipodocs = new ArrayList<TipoDocBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from tipodoc";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				TipoDocBean tipodoc = new TipoDocBean();

				tipodoc.setIdTipoDoc(resultSet.getInt("idtipodoc"));
				tipodoc.setDescricao(resultSet.getString("descricao"));
				
				tipodocs.add(tipodoc);
				
			}

			return tipodocs;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(TipoDocBean tipodoc) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update tipodoc"
					+ "set descricao = ?"
					+ "Where idtipodoc = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tipodoc.getDescricao());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(TipoDocBean tipodoc) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from tipodoc where idtipodoc = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, tipodoc.getIdTipoDoc());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}
	
}
