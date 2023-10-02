package shopbanhang.Dto;

public class CartDto {
	private int quanty;
	private double totalPrice;
	ProductsDto product;

	public CartDto(int quanty, double totalPrice, ProductsDto product) {
		super();
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public CartDto() {
	}
 
	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductsDto getProduct() {
		return product;
	}

	public void setProduct(ProductsDto product) {
		this.product = product;
	}

}
