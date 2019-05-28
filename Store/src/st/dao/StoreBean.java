package st.dao;

public class StoreBean {
	private String town;
	private String store;
	private String telephone;
	private String addr;
	private String product;

	public String getTown() {
		return town;
	}

	public String getStore() {
		return store;
	}

	public String getTelephone() {
		return telephone;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public String getProduct() {
		return product;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setStore(String store) {
		this.store = store;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
}
