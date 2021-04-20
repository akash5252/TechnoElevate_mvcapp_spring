package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmployeeBean;
import com.te.springmvc.customeexception.EmployeeExp;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeeBean authenticate(int id, String password) {

		EntityManager entityManager = factory.createEntityManager();
		try {
			EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
			System.out.println(bean);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("login successfull");
					return bean;

				} else {
					System.out.println("invalid Credentials");
					return null;
				}
			} else {
				System.out.println("user not found");
				throw new EmployeeExp("user not found");

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new EmployeeExp("user not found");
		}

	}

	@Override
	public EmployeeBean getEmployee(int id) {

		EntityManager manager = factory.createEntityManager();
		EmployeeBean bean2 = manager.find(EmployeeBean.class, id);
		return bean2;
	}

	@Override
	public boolean deleteEmploye(int id) {

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			System.out.println("deleted su");
			transaction.commit();
			return true;
		} else {
			System.out.println("not del");
			return false;
		}
	}

	@Override
	public List<EmployeeBean> getAllData() {

		EntityManager manager = factory.createEntityManager();

		String query = "from EmployeeBean";

		javax.persistence.Query query2 = manager.createQuery(query);

		List<EmployeeBean> list = query2.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;
		}

	}

	@Override
	public boolean addEmploye(EmployeeBean bean) {

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		boolean check = false;

		try {

			transaction.begin();
			manager.persist(bean);

			transaction.commit();
			check = true;

		} catch (Exception e) {
			transaction.rollback();
			check = false;
			e.printStackTrace();
		}
		return check;

	}

	@Override
	public boolean updateEmp(EmployeeBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			EmployeeBean info=manager.find(EmployeeBean.class, bean.getId());
			if(bean.getName()!=null && bean.getName()!="") {
				info.setName(bean.getName());
			}
			if(bean.getBirthdate()!=null) {
				info.setBirthdate(bean.getBirthdate());
			}
			if(bean.getPassword()!=null && bean.getPassword()!="") {
				info.setPassword(bean.getPassword());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

}
