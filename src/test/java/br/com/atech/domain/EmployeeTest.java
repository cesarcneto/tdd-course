package br.com.atech.domain;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.impl.SessionImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.atech.domain.util.EntityManagerUtil;

public class EmployeeTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static IDatabaseConnection conn;
	private static IDataSet dataset;

	@BeforeClass
	public static void beforeClass() throws Exception {
		emf = EntityManagerUtil.getEntityManagerFactory();
		em = emf.createEntityManager();
		conn = new DatabaseConnection(
				((SessionImpl) (em.getDelegate())).connection());
		conn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new HsqldbDataTypeFactory());

		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		flatXmlDataSetBuilder.setColumnSensing(true);
		dataset = flatXmlDataSetBuilder.build(Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("test-dataset.xml"));
	}

	@AfterClass
	public static void afterClass() {
		em.close();
		emf.close();
	}

	@Before
	public void cleanDB() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(conn, dataset);
	}

	@Test
	public void shouldHaveValidDbSetup() throws DataSetException {
		Employee employee = em.find(Employee.class, 1l);
		assertEquals("Cesar", employee.getName());

		Department department = employee.getDepartment();
		assertNotNull(department);
		assertEquals("TDD", department.getName());
	}

	@Test
	public void shouldPersistDepartmentCorrectly() {

		Department department = new Department("java");
		EntityManagerUtil.persistEntity(em, department);
		
		Long id = department.getId();
		Department find = em.find(Department.class, id);
		assertEquals(department.getName(), find.getName());
	}

	private void createEmployees() {
		int numOfEmployees = em.createQuery("Select a From Employee a")
				.getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			em.persist(department);

			em.persist(new Employee("Jakab Gipsz", department));
			em.persist(new Employee("Captain Nemo", department));

		}
	}

	@SuppressWarnings("unchecked")
	private void listEmployees() {
		List<Employee> resultList = em.createQuery("Select a From Employee a")
				.getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

}
