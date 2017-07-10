/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comparify;

import javax.annotation.ManagedBean;
import org.hibernate.Session;

/**
 *
 * @author Vineet
 */
@ManagedBean
public class Data {
    private Userdetails u;
    private HibernateUtil helper;
    private Session session;
    
    public void addUser(){
       u=new Userdetails("Nityanand");
       session =helper.getSessionFactory().openSession();
       session.beginTransaction();
       session.save(u);
       session.getTransaction().commit();
       session.close();               
    }
    
    public String getUser(){
       session=helper.getSessionFactory().openSession();
       session.beginTransaction();
       u=(Userdetails) session.get(Userdetails.class, 1);
       return u.getName();
    }
    
}
