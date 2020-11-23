
public class Product {
	public String producerId, product;
	public float res;
	
	public Product(String producerId) {
		this.producerId = producerId;
		this.product = "";
		this.res = 0;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public void setProducerId(String id) {
		this.producerId = id;
	}
	public void setResult(float res) {
		this.res = res;
	}
	public String toString() {
		return this.product;
	}
}
