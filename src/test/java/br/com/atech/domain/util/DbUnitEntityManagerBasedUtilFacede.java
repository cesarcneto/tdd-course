package br.com.atech.domain.util;

import java.io.InputStream;

import javax.persistence.EntityManager;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.impl.SessionImpl;

public class DbUnitEntityManagerBasedUtilFacede {

	private IDatabaseConnection conn;
	private IDataSet dataset;

	public DbUnitEntityManagerBasedUtilFacede(final EntityManager em, final InputStream inputDataset) {

		if (em == null || !em.isOpen()) {
			throw new IllegalArgumentException("EntityManager cannot be null or closed.");
		}

		try {
			conn = new DatabaseConnection(((SessionImpl) em.getDelegate()).connection());
			conn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
			dataset = createDataSet(inputDataset);
		} catch (final Exception e) {

		}
	}

	public void cleanInitDatabase() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(conn, dataset);
	}

	private IDataSet createDataSet(final InputStream is) throws DataSetException {
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		flatXmlDataSetBuilder.setColumnSensing(true);
		return flatXmlDataSetBuilder.build(is);
	}

}
