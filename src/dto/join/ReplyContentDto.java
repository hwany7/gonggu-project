package dto.join;

import java.sql.Timestamp;

public class ReplyContentDto {
	private String nickname;
	private int member_id;
	private int reply_num;
	private int review_num;
	private Timestamp upload_date;
	private String content;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public Timestamp getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Timestamp upload_date) {
		this.upload_date = upload_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
