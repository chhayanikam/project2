package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ForumComment")
@Component

public class ForumComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE1")
	@SequenceGenerator(name = "SEQUENCE1", sequenceName = "IdGenerator", allocationSize = 1)
	int forumCommentId;
	int forumId; // comment is for which forum
	String fcomment;
	int userId;
	Date dateOfComment;
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getFcomment() {
		return fcomment;
	}
	public void setFcomment(String fcomment) {
		this.fcomment = fcomment;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateOfComment() {
		return dateOfComment;
	}
	public void setDateOfComment(Date dateOfComment) {
		this.dateOfComment = dateOfComment;
	}
	
	
}
