package com.pfe.Model;


import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="useremail")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="to", length = 100, nullable = false)
	private String to;
	 
	 @Column(name="messageSubject", length = 100, nullable = false)
	private String messageSubject;
	 
	 
	 @Column(name="messageBody", length = 100, nullable = false)
	 private String messageBody;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "user_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
	 private User user;
	
	
	
	public Email() {
	}
	
	public Email(String to, String messageSubject, String messageBody, User user) {
		
		this.to = to;
		this.messageSubject = messageSubject;
		this.messageBody = messageBody;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	

}
