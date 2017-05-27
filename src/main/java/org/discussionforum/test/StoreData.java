package org.discussionforum.test;

import java.util.ArrayList;



import org.discussionforum.models.Answer;
import org.discussionforum.models.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;


public class StoreData {
	
	
	
	public static void main(String[] args) {  
		
	
		
	      
	    Answer ans1=new Answer();  
	    ans1.setAnswername("java is a programming language");  
	    ans1.setPostedBy("Ravi Malik");  
	      
	    Answer ans2=new Answer();  
	    ans2.setAnswername("java is a platform");  
	    ans2.setPostedBy("Sudhir Kumar");  
	      
	    Answer ans3=new Answer();  
	    ans3.setAnswername("Servlet is an Interface");  
	    ans3.setPostedBy("Jai Kumar");  
	      
	    Answer ans4=new Answer();  
	    ans4.setAnswername("Servlet is an API");  
	    ans4.setPostedBy("Arun");  
	      
	    ArrayList<Answer> list1=new ArrayList<Answer>();  
	    list1.add(ans1);  
	    list1.add(ans2);  
	      
	    ArrayList<Answer> list2=new ArrayList<Answer>();  
	    list2.add(ans3);  
	    list2.add(ans4);  
	      
	    Question question1=new Question();  
	    question1.setQname("What is Java?");  
	    question1.setAnswers(list1);  
	      
	    Question question2=new Question();  
	    question2.setQname("What is Servlet?");  
	    question2.setAnswers(list2);  
	    SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory(); 
	 	   Session  session =	sessionFactory.openSession();
		       session.beginTransaction();
	      
	    session.save(question1);  
	    session.save(question2);  
	      
	    session.getTransaction().commit();  
	    session.close();  
	    System.out.println("success");  
	}  
}
