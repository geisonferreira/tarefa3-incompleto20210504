package br.CadEvent.com;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {

private EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_testeDep_war_1.0-SNAPSHOTPU");
private EntityManager em = factory.createEntityManager();

public EntityManager getEntityManager(){
return em;
}
}
