/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comparify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ManagedBean;
import org.hibernate.Query;
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

    public void addUser() {
        u = new Userdetails("Nityanand");
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
    }

    public String getUser() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        u = (Userdetails) session.get(Userdetails.class, 1);
        return u.getName();
    }

    public List getVendorCustomer() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
         Query query = session.createQuery("select v.vendorName,c.customerName from  Vendors v left join v.children c");
        List<Map<String, Object>> l = query.list();
        Iterator it=l.iterator();
        while (it.hasNext()) {
            Object rows[] = (Object[]) it.next();
            System.out.println(rows[0] + " -- " + rows[1]);
        }
        System.out.println("Count -- " + l.size());
        return l;
    }

}
