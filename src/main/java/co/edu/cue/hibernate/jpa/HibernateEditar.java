package co.edu.cue.hibernate.jpa;

import co.edu.cue.hibernate.jpa.entity.Cliente;
import co.edu.cue.hibernate.jpa.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingresa el id del cliente a modificar"));
            Cliente c = em.find(Cliente.class,id);

            String nombre = JOptionPane.showInputDialog("Ingrese nombre:",c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese apellido:",c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese forma de pago:",c.getFormaPago());
            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.merge(c);
            em.getTransaction().commit();

            System.out.println(c);

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
