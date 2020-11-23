package com.prova.services;

import java.util.List;

import com.prova.model.Utenti;
import com.prova.model.UtentiDao;

public class UtentiService {

	
	private static UtentiDao utentiDao;

	
	public UtentiService() 
	{
		utentiDao = new UtentiDao();
	}

	
	public void persist(Utenti entity) 
	{
		utentiDao.openCurrentSessionwithTransaction();
		utentiDao.persist(entity);
		utentiDao.closeCurrentSessionwithTransaction();
	}

	
	public void update(Utenti entity) 
	{
		utentiDao.openCurrentSessionwithTransaction();
		utentiDao.update(entity);
		utentiDao.closeCurrentSessionwithTransaction();
	}

	
	public Utenti findById(String id) 
	{
		utentiDao.openCurrentSession();
		Utenti book = utentiDao.findById(id);
		utentiDao.closeCurrentSession();
		return book;
	}

	
	public void delete(String id) 
	{
		utentiDao.openCurrentSessionwithTransaction();
		Utenti book = utentiDao.findById(id);
		utentiDao.delete(book);
		utentiDao.closeCurrentSessionwithTransaction();
	}

	
	public List<Utenti> findAll() 
	{
		utentiDao.openCurrentSession();
		List<Utenti> books = utentiDao.findAll();
		utentiDao.closeCurrentSession();
		return books;
	}

	
	public void deleteAll() 
	{
		utentiDao.openCurrentSessionwithTransaction();
		utentiDao.deleteAll();
		utentiDao.closeCurrentSessionwithTransaction();
	}

	
	public UtentiDao bookDao() 
	{
		return utentiDao;
	}
}
