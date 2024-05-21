package co.edu.cue.hibernate.jpa;

import co.edu.cue.hibernate.jpa.entity.Cliente;
import co.edu.cue.hibernate.jpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {

        EntityManager cm = JpaUtil.getEntityManager();
        List<Cliente> clientes = cm.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        cm.close();
    }
}