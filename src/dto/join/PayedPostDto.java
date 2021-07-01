package dto.join;

import java.sql.Timestamp;

public class PayedPostDto {
	private String thumbnail;
	private int payment_id;
	private int application_id;
	private int post_id;
	private String post_title;
	private String product_name;
	private int total_price;
	private int review_writable;
	private Timestamp paytime;
	
	private String content;//추가
	private int current_amount;//추가
	
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getReview_writable() {
		return review_writable;
	}
	public void setReview_writable(int review_writable) {
		this.review_writable = review_writable;
	}
	public Timestamp getPaytime() {
		return paytime;
	}
	public void setPaytime(Timestamp paytime) {
		this.paytime = paytime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(int current_amount) {
		this.current_amount = current_amount;
	}	
}
