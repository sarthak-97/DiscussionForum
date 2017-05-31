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
		
		model.addObject("ans",ans);
		model.addObject("qid",quesid);
		model.addObject("ques",question.getTitle());
		return model;
	}
	
	
}

