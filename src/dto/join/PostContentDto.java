package dto.join;

import java.sql.Timestamp;

public class PostContentDto {
	private int post_id;
	private int product_id;
	private String category_name;
	private String post_title;
	private String post_status;
	private String product_name;
	private String image;
	private String product_model;
	private int current_amount;
	private int default_price;
	private String content;
	private int payment_amount;
	private int category_id;
	private String thumbnail;
	private int payment_id;
	private int application_id;
	private int total_price;
	private int review_writable;
	private Timestamp paytime;

	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProduct_model() {
		return product_model;
	}
	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}
	public int getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(int current_amount) {
		this.current_amount = current_amount;
	}
	public int getDefault_price() {
		return default_price;
	}
	public void setDefault_price(int default_price) {
		this.default_price = default_price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
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
}
