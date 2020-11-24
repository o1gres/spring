package com.prova.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.prova.model.interfaces.UtentiDaoInterface;

public class UtentiDao implements UtentiDaoInterface<Utenti, String>
{
	
	private Session currentSession;
	
	private Transaction currentTransaction;

	
	public UtentiDao() {}
	

	public Session openCurrentSession() 
	{
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	
	public Session openCurrentSessionwithTransaction() 
	{
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	
	public void closeCurrentSession() 
	{
		currentSession.close();
	}
	
	
	public void closeCurrentSessionwithTransaction() 
	{
		currentTransaction.commit();
		currentSession.close();
	}
	
	
	private static SessionFactory getSessionFactory() 
	{
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.prova.model.Utenti.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	
	public Session getCurrentSession() 
	{
		return currentSession;
	}

	
	public void setCurrentSession(Session currentSession) 
	{
		this.currentSession = currentSession;
	}

	
	public Transaction getCurrentTransaction() 
	{
		return currentTransaction;
	}

	
	public void setCurrentTransaction(Transaction currentTransaction) 
	{
		this.currentTransaction = currentTransaction;
	}

	
	
	
	
	@Override
	public void persist(Utenti entity) 
	{
		getCurrentSession().save(entity);
	}

	
	@Override
	public void update(Utenti entity) 
	{
		getCurrentSession().update(entity);
	}

	
	@Override
	 public Utenti findById(String id) 
	{ 
		Utenti book = (Utenti) getCurrentSession().get(Utenti.class, id);
		return book; 
	}

	
	@Override
	public void delete(Utenti entity) 
	{  
		getCurrentSession().delete(entity);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utenti> findAll() 
	{
		List<Utenti> utenti = new ArrayList<Utenti>(); 
		utenti = (List<Utenti>) getCurrentSession().createQuery("from Utenti", Utenti.class).getResultList();
		return utenti;
	}

	
	@Override
	public void deleteAll() 
	 {
	 	List<Utenti> entityList = findAll();
	 	
		for (Utenti entity : entityList) 
		{
			delete(entity);
		}
	}

}
