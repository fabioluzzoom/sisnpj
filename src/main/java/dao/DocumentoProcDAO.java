package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.DocumentoProcBean;
import connection.ConnectionFactory;

public class DocumentoProcDAO {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public void inserir(DocumentoProcBean documentoproc) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = ("insert into documentoproc "
				+ " (idprocesso, idtipodoc, documento)"
				+ " values(?,?,?)");

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, documentoproc.getProcesso().getIdProcesso());
			preparedStatement.setInt(2, documentoproc.getTipoDoc().getIdTipoDoc());
			preparedStatement.setByte(3, documentoproc.getDocumento());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();

			connection.close();

		}

	}

	public DocumentoProcBean consultarPorId(DocumentoProcBean documentoproc) throws SQLException {

		try {

			DocumentoProcBean newDocumentoProc = null;

			connection = ConnectionFactory.getConnection();

			sql = "select * from documentoproc where iddocumentoproc = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, documentoproc.getIdDocumentoProc());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				newDocumentoProc.setIdDocumentoProc(resultSet.getInt("iddocumentoproc"));
				newDocumentoProc.getProcesso().setIdProcesso(resultSet.getInt("idprocesso"));
				newDocumentoProc.getTipoDoc().setIdTipoDoc((resultSet.getInt("idtipodoc")));
				newDocumentoProc.setDocumento(resultSet.getByte("documento"));

			}

			return newDocumentoProc;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}

	}

	public List<DocumentoProcBean> listar() throws SQLException {

		try {

			List<DocumentoProcBean> documentoprocs = new ArrayList<DocumentoProcBean>();

			connection = ConnectionFactory.getConnection();

			sql = "select * from documentoproc";

			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DocumentoProcBean documentoproc = new DocumentoProcBean();

				documentoproc.setIdDocumentoProc(resultSet.getInt("iddocumentoproc"));
				documentoproc.getProcesso().setIdProcesso(resultSet.getInt("idprocesso"));
				documentoproc.getTipoDoc().setIdTipoDoc((resultSet.getInt("idtipodoc")));
				documentoproc.setDocumento(resultSet.getByte("documento"));


				documentoprocs.add(documentoproc);
				
			}

			return documentoprocs;

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void alterar(DocumentoProcBean documentoproc) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "update pessoa "
					+ "set idprocesso = ?, idtipodoc = ?, documento = ? "
					+ "Where iddocumentoprocesso = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, documentoproc.getProcesso().getIdProcesso());
			preparedStatement.setInt(2, documentoproc.getTipoDoc().getIdTipoDoc());
			preparedStatement.setByte(3, documentoproc.getDocumento());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			resultSet.close();
			connection.close();

		}
		
	}

	public void deletar(DocumentoProcBean documentoproc) throws SQLException {

		try {

			connection = ConnectionFactory.getConnection();

			sql = "delete from documentoproc where iddocumentoproc = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, documentoproc.getIdDocumentoProc());

			preparedStatement.execute();

		} finally {

			preparedStatement.close();
			connection.close();
			
		}

	}
	
}
