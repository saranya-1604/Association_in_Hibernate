package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;



public class TestRetrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tr=null;
		try(Session ses=HBUtil.getSesFactory().openSession()){
			tr=ses.beginTransaction();
		
       Query<Employee> qry=ses.createQuery("from Employee",Employee.class);
       List<Employee> li=qry.list();
       for(Employee e:li) {
       System.out.println(e.getEmpId()+"\t"+e.getName()+"\t"+e.getEmail());
       Address ad=e.getAddress();
       System.out.println("Address is "+ad.getLine1()+ad.getLine2()+ad.getCity()+ad.getState()+ad.getPin());
	}
       tr.commit();
       ses.close();
       }
		catch(Exception e) {e.printStackTrace();}

}}
