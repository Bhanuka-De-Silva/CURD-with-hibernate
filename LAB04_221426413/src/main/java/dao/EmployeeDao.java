package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Employee;
import uril.HibernateUtil;

public class EmployeeDao implements IEmployeeDao {


	@Override
	public void saveEmployee(Employee employee) {
		if (employee == null) {
			return;
		}
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(employee);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}


	@Override
	public void updateEmployee(Employee employee) {
		if (employee == null) {
			return;
		}
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(employee);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}


	@Override
	public void deleteEmployee(int id) {
		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, id);
			if (employee != null) {
				session.remove(employee);
			}
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}


	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			employee = session.get(Employee.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return employee;
	}


	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
			cq.from(Employee.class);
			employees = session.createQuery(cq).getResultList();
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return employees;
	}


	@Override
	public Employee getEmployeeByPosition(String position) {
		Employee employee = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Book where position =:positionValue", Employee.class); 
			query.setParameter("positionValue", position);
			employee = query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return employee;
	}

}
