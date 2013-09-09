package br.com.atech.tddcourse.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.dbunit.dataset.DataSetException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.atech.tddcourse.domain.util.DbUnitEntityManagerBasedUtilFacede;
import br.com.atech.tddcourse.domain.util.EntityManagerUtil;

public class EmployeePersistenceTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static DbUnitEntityManagerBasedUtilFacede dbUnitFacede;

	@AfterClass
	public static void afterClass() {
		em.close();
		emf.close();
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		emf = EntityManagerUtil.getEntityManagerFactory();
		em = emf.createEntityManager();

		final InputStream resource = Thread.currentThread().getContextClassLoader()//
				.getResourceAsStream("test-dataset.xml");
		dbUnitFacede = new DbUnitEntityManagerBasedUtilFacede(em, resource);
	}

	@Before
	public void cleanDB() throws Exception {
		dbUnitFacede.cleanInitDatabase();
	}

	private void createEmployees() {
		final int numOfEmployees = em.createQuery("Select a From Employee a").getResultList().size();
		if (numOfEmployees == 0) {
			final Department department = new Department("java");
			em.persist(department);

			em.persist(new Employee("Jakab Gipsz", department));
			em.persist(new Employee("Captain Nemo", department));

		}
	}

	@SuppressWarnings("unchecked")
	private void listEmployees() {
		final List<Employee> resultList = em.createQuery("Select a From Employee a").getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (final Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

	@Test
	public void shouldGetEmployeeOrderedCorrectly() {

		// http://stackoverflow.com/questions/2922879/best-way-to-unit-test-collection

	}

	@Test
	public void shouldHaveValidDbSetup() throws DataSetException {
		final Employee employee = em.find(Employee.class, 1l);
		assertEquals("Cesar", employee.getName());

		final Department department = employee.getDepartment();
		assertNotNull(department);
		assertEquals("TDD", department.getName());
	}

	@Test
	public void shouldPersistDepartmentCorrectly() {

		final Department department = new Department("java");
		EntityManagerUtil.persistEntity(em, department);

		final Long id = department.getId();
		final Department find = em.find(Department.class, id);
		assertEquals(department.getName(), find.getName());
	}

}
