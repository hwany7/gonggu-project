package dto.join;

public class PostSearchAndCaterogy {
	private int category_id;
	private String search;
	
	public PostSearchAndCaterogy() {}
	public PostSearchAndCaterogy(int category_id, String search) {
		this.category_id = category_id;
		this.search = search;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
