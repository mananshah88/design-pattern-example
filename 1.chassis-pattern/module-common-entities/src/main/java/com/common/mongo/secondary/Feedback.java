package com.common.mongo.secondary;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
public class Feedback {

	private String id;
	private String detail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Feedback(String id, String detail) {
		super();
		this.id = id;
		this.detail = detail;
	}

	public Feedback() {
		super();
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", detail=" + detail + "]";
	}

}
