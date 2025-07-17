package com.paulograbin.SimpleCRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

public class HibernateUtil {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCRUD");
	private Query query;
	
	public long getCount() {
		long retorno = 0;
		
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			query = em.createQuery("select count(*) from Pessoas");
						
			retorno = (Long) query.getSingleResult();
			
			em.getTransaction().commit();
			em.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public List<Pessoas> selectAll() {
		List<Pessoas> lista = null;

		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			query = em.createQuery("from Pessoas p");
			lista = query.getResultList();
			
			em.getTransaction().commit();
			em.close();
		} catch (HibernateException e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar Select.\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		query = null;
		return lista;
	}
	
	public void updatePessoa(Pessoas pessoa) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Pessoas p = em.find(Pessoas.class, pessoa.getId());
			
			p.setNome(pessoa.getNome());
			p.setIdade(pessoa.getIdade());
			p.setSexo(pessoa.getSexo());
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
		}
	}
 
	public void insert(Pessoas pessoa) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			em.persist(pessoa);

			em.getTransaction().commit();
			em.close();
			
			JOptionPane.showMessageDialog(null, "Registro salvo com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao persistir os dados.\n" + e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		query = null;
	}

	public void deletePessoa(long id) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			Pessoas p = em.getReference(Pessoas.class, id);
			em.remove(p);
			
			em.getTransaction().commit();
			em.close();
			
			JOptionPane.showMessageDialog(null,	"Registro deletado com sucesso.", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (HibernateException e) {
			JOptionPane.showMessageDialog(null, "Erro ao persistir os dados.\n"	+ e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		query = null;
	}
}