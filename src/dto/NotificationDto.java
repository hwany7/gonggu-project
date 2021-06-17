package dto;

import java.sql.Timestamp;

public class NotificationDto {
	private int notify_id;
    private String manager_id;
    private int member_id;
    private int post_id;
    private Timestamp notify_time;
    private int read_status;
    private String content;
    
	public int getNotify_id() {
		return notify_id;
	}
	public void setNotify_id(int notify_id) {
		this.notify_id = notify_id;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public Timestamp getNotify_time() {
		return notify_time;
	}
	public void setNotify_time(Timestamp notify_time) {
		this.notify_time = notify_time;
	}
	public int getRead_status() {
		return read_status;
	}
	public void setRead_status(int read_status) {
		this.read_status = read_status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
}
