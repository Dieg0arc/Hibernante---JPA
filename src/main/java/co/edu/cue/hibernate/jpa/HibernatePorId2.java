package co.edu.cue.hibernate.jpa;

import co.edu.cue.hibernate.jpa.entity.Cliente;
import co.edu.cue.hibernate.jpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernatePorId2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el Id");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);
        em.close();
    }
}
