package com.credmarg.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class EmailRecord 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	    private String recipient;
	    private String subject;
	    private String body;
	    private LocalDateTime sentTime;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public LocalDateTime getSentTime() {
			return sentTime;
		}
		public void setSentTime(LocalDateTime sentTime) {
			this.sentTime = sentTime;
		}
	    

}