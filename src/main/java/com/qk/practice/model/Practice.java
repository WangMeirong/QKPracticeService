package com.qk.practice.model;import java.util.List;import org.apache.ibatis.type.Alias;/******************************************************************************* * javaBeans * practice --> Practice  * <table explanation> * @author 2016-09-29 22:11:50 *  */	@Alias("practice")public class Practice implements java.io.Serializable {	//field	/**  **/	private String practiceId;	/** **/	private String answerId;	/** **/	private String subjectId;	/**  **/	private Subject subject;	/**  **/	private Answer answer;	/**  **/	private String code;	/**  **/	private String title;	/**  **/	private String description;	/**  **/	private String attachment;	/**  **/	private String isPublic;	/**  **/	private String statusId;	/**  **/	private String isDelete;	/**  **/	private long createdTime;	/**  **/	private String lastModifiedBy;	/**  **/	private long lastModifiedTime;	/** **/	private List<Tag> tags;	//method	public String getPracticeId() {		return practiceId;	}	public void setPracticeId(String practiceId) {		this.practiceId = practiceId;	}	public Subject getSubject() {		return subject;	}	public void setSubject(Subject subject) {		this.subject = subject;	}	public Answer getAnswer() {		return answer;	}	public void setAnswer(Answer answer) {		this.answer = answer;	}	public String getCode() {		return code;	}	public void setCode(String code) {		this.code = code;	}	public String getTitle() {		return title;	}	public void setTitle(String title) {		this.title = title;	}	public String getDescription() {		return description;	}	public void setDescription(String description) {		this.description = description;	}	public String getAttachment() {		return attachment;	}	public void setAttachment(String attachment) {		this.attachment = attachment;	}	public String getIsPublic() {		return isPublic;	}	public void setIsPublic(String isPublic) {		this.isPublic = isPublic;	}	public String getStatusId() {		return statusId;	}	public void setStatusId(String statusId) {		this.statusId = statusId;	}	public String getIsDelete() {		return isDelete;	}	public void setIsDelete(String isDelete) {		this.isDelete = isDelete;	}	public Object getCreatedTime() {		return createdTime;	}	public void setCreatedTime(long createdTime) {		this.createdTime = createdTime;	}	public String getLastModifiedBy() {		return lastModifiedBy;	}	public void setLastModifiedBy(String lastModifiedBy) {		this.lastModifiedBy = lastModifiedBy;	}	public Object getLastModifiedTime() {		return lastModifiedTime;	}	public void setLastModifiedTime(long lastModifiedTime) {		this.lastModifiedTime = lastModifiedTime;	}		public List<Tag> getTags() {		return tags;	}	public void setTags(List<Tag> tags) {		this.tags = tags;	}	public String getAnswerId() {		return answerId;	}	public void setAnswerId(String answerId) {		this.answerId = answerId;	}	public String getSubjectId() {		return subjectId;	}	public void setSubjectId(String subjectId) {		this.subjectId = subjectId;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'practiceId':'"+this.getPracticeId()+"',");		sb.append("'subjectId':'"+this.getSubjectId()+"',");		sb.append("'answerId':'"+this.getAnswerId()+"',");		sb.append("'subject':'"+this.getSubject().toString()+"',");		sb.append("'answer':'"+this.getAnswer().toString()+"',");		sb.append("'code':'"+this.getCode()+"',");		sb.append("'title':'"+this.getTitle()+"',");		sb.append("'description':'"+this.getDescription()+"',");		sb.append("'attachment':'"+this.getAttachment()+"',");		sb.append("'isPublic':'"+this.getIsPublic()+"',");		sb.append("'statusId':'"+this.getStatusId()+"',");		sb.append("'isDelete':'"+this.getIsDelete()+"',");		sb.append("'createdTime':'"+this.getCreatedTime()+"',");		sb.append("'lastModifiedBy':'"+this.getLastModifiedBy()+"',");		sb.append("'lastModifiedTime':'"+this.getLastModifiedTime()+"',");		sb.append("'tags.size':'"+this.getTags().size()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"practiceId","subjectId","answerId","subject","answer","code","title","description","attachment","isPublic","statusId","isDelete","createdTime","lastModifiedBy","lastModifiedTime","tags"};	}}