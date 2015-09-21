package com.notonly.php.backend.model;

import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.notonly.php.backend.User;
import com.notonly.php.backend.model.record.UserRecord;


public class AmazingObjectStore {

	private static AmazingObjectStore store = null;
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private AmazingObjectStore(){
	}
	
	public static AmazingObjectStore getInstance(){
		if (store == null) {
			store = new AmazingObjectStore();
		}
		return store;
	}
	
	public User store(User user) {

		UserRecord record = getEntityManager().find(UserRecord.class, user.getId());

		try {
			getEntityManager().getTransaction().begin();

			if (record != null) {

				user.setStatusCode(IUsersManager.STATUS_ERROR);
				user.setStatus(user.getId() + " 使用者帳號已存在!");	
				
			} else {

				record = new UserRecord();
				record.setUserId(user.getId());
				record.setPassword(user.getPassword());
				record = parseParameters(record, user.getTicket());
				getEntityManager().persist(record);

				user.setStatusCode(IUsersManager.STATUS_OK);
				user.setStatus(" 使用者註冊完成. " );	
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
			user.setStatusCode(IUsersManager.STATUS_ERROR);
			user.setStatus(" 使用者註冊處理出現錯誤!! - " + e.getMessage() );	
		} finally {
			getEntityManager().getTransaction().commit();
		}

		return user;
	}
	
	private UserRecord parseParameters(UserRecord record, String parameters) {
		
		if (parameters == null) {
			return record;
		}
		
		StringTokenizer tokenizer = new StringTokenizer(parameters, ",");
		
		while (tokenizer.hasMoreTokens()) {
			String aToken = tokenizer.nextToken();
			if ("name".equals(aToken.substring(0, aToken.indexOf('=')))) {
				record.setName(aToken.substring(aToken.indexOf('=')+1));
			}
			if ("mobile".equals(aToken.substring(0, aToken.indexOf('=')))) {
				record.setMobile(aToken.substring(aToken.indexOf('=')+1));
			}
			if ("phone".equals(aToken.substring(0, aToken.indexOf('=')))) {
				record.setPhone(aToken.substring(aToken.indexOf('=')+1));
			}
			if ("fax".equals(aToken.substring(0, aToken.indexOf('=')))) {
				record.setFax(aToken.substring(aToken.indexOf('=')+1));
			}
			if ("address".equals(aToken.substring(0, aToken.indexOf('=')))) {
				record.setAddress(aToken.substring(aToken.indexOf('=')+1));
			}
			if ("eMail".equals(aToken.substring(0, aToken.indexOf('=')))) {
				record.seteMail(aToken.substring(aToken.indexOf('=')+1));
			}
		}
		
		return record;
	}

	public String getPassword(String id) {

		UserRecord record = getEntityManager().find(UserRecord.class, id);
		
		if (record != null) {
			return record.getPassword();
		}
		
		return null;
	}
	
	public UserRecord getUser(String id) {

		return getEntityManager().find(UserRecord.class, id);
		
	}
	
	public User createUser(){
		User user = new User();
		
		user.setId("u" + System.currentTimeMillis());
		
		return user;
	}
	
//	public ServiceProviderRecord store(ServiceProviderRecord provider) {
//
//		List<ServiceProviderRecord> records = getServiceProviderRecords(provider.getProvider().getUserId());
//
//		try {
//			getEntityManager().getTransaction().begin();
//
//			for (Iterator iterator = records.iterator(); iterator.hasNext();) {
//				ServiceProviderRecord serviceProviderRecord = (ServiceProviderRecord) iterator.next();
//				getEntityManager().remove(serviceProviderRecord);
//			}
//			
//			getEntityManager().persist(provider);
//			
//		} catch (Throwable e) {
//			e.printStackTrace();
//		} finally {
//			getEntityManager().getTransaction().commit();
//		}
//		
//		return provider;
//	}
//	
//	public ServiceProviderRecord getServiceProvider(String userId){
//		
//		try {
//			Query query = getEntityManager().createQuery("SELECT m FROM ServiceProviderRecord m WHERE m.provider.userId = :userId");
//			System.out.println(query);
//			query.setParameter("userId", userId);
//			return (ServiceProviderRecord)query.getSingleResult();
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//	
//	public List<ServiceProviderRecord> getServiceProviderRecords(String userId) {
//		try {
//			Query query = getEntityManager().createQuery("SELECT m FROM ServiceProviderRecord m WHERE m.provider.userId = :userId");
//			System.out.println(query);
//			query.setParameter("userId", userId);
//			return query.getResultList();
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return new ArrayList<ServiceProviderRecord>();
//		}
//	}
//	
//	public List<ServiceProviderRecord> getServiceProviders() {
//		try {
//			Query query = getEntityManager().createQuery("SELECT m FROM ServiceProviderRecord m");
//			System.out.println(query);
//			return query.getResultList();
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return new ArrayList<ServiceProviderRecord>();
//		}
//	}
	
	private EntityManager getEntityManager() {
		if (em == null) {
			em = getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

	private EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
//			HashMap properties = new HashMap();
//			properties.put(PersistenceUnitProperties.CLASSLOADER, this.getClass().getClassLoader());
//			emf = new PersistenceProvider().createEntityManagerFactory(PU_NAME, properties);
			emf = Persistence.createEntityManagerFactory("com.notonly.php.backend.model");
		}
		return emf;
	}
	
}
