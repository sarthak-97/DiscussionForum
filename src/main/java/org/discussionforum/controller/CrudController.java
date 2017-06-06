package org.discussionforum.controller;

import java.util.Arrays;

import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.discussionforum.models.Answer;
import org.discussionforum.models.Question;
import org.discussionforum.models.UserDet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CrudController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private UserDet userdet;
	private Question question;
	private Answer answer;
	
	
	@RequestMapping(value = "/ques", method = RequestMethod.GET)
	public ModelAndView ques(HttpSession httpSession) {
		Session session = sessionFactory.openSession();
		ModelAndView model=new ModelAndView("ques");
		
		List<Question> ques = session.createCriteria(Question.class).list();
		  
		model.addObject("ques",ques);
		
		
		return model;
	}
	
	@RequestMapping(value = "/ans", method = RequestMethod.GET)
	public ModelAndView ans(HttpSession httpSession, @RequestParam("id") int quesid) {
		Session session = sessionFactory.openSession();
		ModelAndView model=new ModelAndView("ans");
		
		
		question = (Question) session.get(Question.class, quesid);
		
		List<Answer> ans = session.createCriteria(Answer.class).list();
		Answer  userans= new Answer();
	
		model.addObject("ans",ans);
		model.addObject("qid",quesid);
		model.addObject("ques",question.getTitle());
		model.addObject("uname",(String)httpSession.getAttribute("SESSION_name"));
		return model;
	}
	
	@RequestMapping(value = "/addans", method = RequestMethod.POST)
	public ModelAndView addans(HttpSession httpSession, @RequestParam("userans") String answer, @RequestParam("id") String qid ) {
		Session session = sessionFactory.openSession();
		ModelAndView model=new ModelAndView("ans");
		session.beginTransaction();
	     Answer  userans= new Answer();
	     userans.setAnswername(answer);
	     userans.setQid(Integer.parseInt(qid));
	     userans.setPostedBy((String)httpSession.getAttribute("SESSION_name"));   
		 
	     session.save(userans);
	     session.getTransaction().commit();
	     
	     question = (Question) session.get(Question.class, Integer.parseInt( qid));
			
		List<Answer> ans = session.createCriteria(Answer.class).list();
		

		model.addObject("ans",ans);
		model.addObject("qid",qid);
		model.addObject("uname",(String)httpSession.getAttribute("SESSION_name"));
		model.addObject("ques",question.getTitle());
		model.addObject("invalid","ans successfully submitted");
		return model;
	}
	
	
}

