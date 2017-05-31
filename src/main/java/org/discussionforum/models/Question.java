package org.discussionforum.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Question")

public class Question {
	
	

	@Id
	@GeneratedValue
	private int id;  
	@Lob
	private String title;  
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Answer> answers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	} 
}
