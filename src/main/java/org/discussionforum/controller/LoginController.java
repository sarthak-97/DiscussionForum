package org.discussionforum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.discussionforum.models.Question;
import org.discussionforum.models.UserDet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * controller for handling signin and signup
 * @author sarthak-pc
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private UserDet userdet;
	private Question question;
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("userdet") org.discussionforum.models.UserDet userdet) {
		Session session = sessionFactory.openSession();
		ModelAndView model = new ModelAndView("index");
		if (session.get(UserDet.class, userdet.getEmail()) == null) {
			
			session.beginTransaction();
			session.save(userdet);
			
			session.getTransaction().commit();
			model.addObject("invalid", "Successfully registered, login to proceed!");

		} else
			model.addObject("invalid", "This email is already registered.");
		session.close();
		return model;

	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession httpSession, @RequestParam("id") String emailid,
			@RequestParam("pass") String password) {
		ModelAndView model;
		Session session = sessionFactory.openSession();
		userdet = (UserDet) session.get(UserDet.class, emailid);
		if (userdet != null) {
					if (userdet.getPassword().equals(password)) {
							httpSession.setAttribute("SESSION_email", userdet.getEmail());
							httpSession.setAttribute("SESSION_name", userdet.getName());
						
							if((String) httpSession.getAttribute("SESSION_email")!=null){
								model = new ModelAndView("dashboard");
								model.addObject("username", userdet.getName());
								List<Question> ques = session.createCriteria(Question.class).list();
								model.addObject("ques", ques);
				               }
							else{
								model = new ModelAndView("index");
								model.addObject("invalid", "LOG IN FIRST TO CONTINUE");
							}
			} else {
				model = new ModelAndView("index");
				model.addObject("invalid", "invalid details");
			}
		}

		else {
			model = new ModelAndView("index");
			model.addObject("norecord", "no record found");
		}
		session.close();
		return model;
	}

}
