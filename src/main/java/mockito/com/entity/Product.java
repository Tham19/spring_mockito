package mockito.com.entity;

public class Product {
	private String proId;
	private String proName;
	private String catId;

	public Product(String proId, String proName,String catId) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.catId = catId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

}
