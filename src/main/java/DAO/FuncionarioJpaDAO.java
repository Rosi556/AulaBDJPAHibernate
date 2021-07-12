package DAO;

import Entity.Fucionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioJpaDAO {
    private static FuncionarioJpaDAO instance;
    protected EntityManager entityManager;

    public static FuncionarioJpaDAO getInstance(){
        if(instance == null){
            instance = new FuncionarioJpaDAO();
        }
        return instance;
    }

    private FuncionarioJpaDAO(){
        entityManager= getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("Sales");
        if(entityManager ==null){
           entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Fucionario getByMatricula(final int matricula){
        return entityManager.find(Fucionario.class, matricula);
    }

    @SuppressWarnings("unchercked")
    public List<Fucionario> findAll() {
        return entityManager.createQuery("FROM" +
               Fucionario.class.getName()).getResultList();
    }

    public void persist (Fucionario funcionario){
        try {
            entityManager. getTransaction().begin();
            entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Fucionario funcionario){
        try {
            entityManager. getTransaction().begin();
            entityManager.merge(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();

    public void remove(Fucionario funcionario){
        try {
            entityManager. getTransaction().begin();
            funcionario = entityManager.find(Fucionario.class, funcionario.getMatricula());
            entityManager.remove(funcionario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
            }
            public void removeByMatricula(final int matricula) {
                try {
                    Fucionario funcionario = getByMatricula(matricula);
                    remove(funcionario);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }