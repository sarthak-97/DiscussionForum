package org.discussionforum.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Answer")
public class Answer {
	
	@Id
	@GeneratedValue
	private int aid; 
	private int qid;
	@Lob
	private String answername;  
	private String postedBy;
	
	public String getAnswername() {
		return answername;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setAnswername(String answername) {
		this.answername = answername;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}  

}
