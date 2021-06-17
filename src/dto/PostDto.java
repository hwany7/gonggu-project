package dto;

import java.sql.Timestamp;

public class PostDto {
    private int post_id;
    private String post_title;
    private int product_id;
    private int default_price;              
    private int fixed_price;       
    private int minimum_amount;  
    private int current_amount;
    private int payment_amount;
    private String post_status;
    private String content;
    private Timestamp post_time;
        
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
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDefault_price() {
		return default_price;
	}
	public void setDefault_price(int default_price) {
		this.default_price = default_price;
	}
	public int getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(int fixed_price) {
		this.fixed_price = fixed_price;
	}
	public int getMinimum_amount() {
		return minimum_amount;
	}
	public void setMinimum_amount(int minimum_amount) {
		this.minimum_amount = minimum_amount;
	}

	public int getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(int current_amount) {
		this.current_amount = current_amount;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getPost_time() {
		return post_time;
	}
	public void setPost_time(Timestamp post_time) {
		this.post_time = post_time;
	}
	public int getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}
    
    
}
