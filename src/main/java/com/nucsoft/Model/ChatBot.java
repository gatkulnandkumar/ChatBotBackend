package com.nucsoft.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_journey_cruds")
public class ChatBot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "message_type")
	private String message_type;

	@Column(name = "message")
	private String message;

	@Column(name = "context_id")
	private String context_id;

	@Column(name = "next_action")
	private String next_action;

	@Column(name = "execution_detail")
	private String execution_detail;

	@Column(name = "issue_types")
	private String issue_types;

//		@Column(columnDefinition = "jsonb")
	@Lob
	private String payload;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContext_id() {
		return context_id;
	}

	public void setContext_id(String context_id) {
		this.context_id = context_id;
	}

	public String getNext_action() {
		return next_action;
	}

	public void setNext_action(String next_action) {
		this.next_action = next_action;
	}

	public String getExecution_detail() {
		return execution_detail;
	}

	public void setExecution_detail(String execution_detail) {
		this.execution_detail = execution_detail;
	}

	public String getIssue_types() {
		return issue_types;
	}

	public void setIssue_types(String issue_types) {
		this.issue_types = issue_types;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
