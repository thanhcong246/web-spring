package shopbanhang.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopbanhang.Dao.ProductsDao;
import shopbanhang.Dto.ProductsDto;
import shopbanhang.Entity.Products;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductsDao productsDao = new ProductsDao();
	
	@Override
	public List<ProductsDto> GetAllProduct() {
		return productsDao.GetAllProduct();
	}

	@Override
	public ProductsDto GetProductById(long id) {
		List<ProductsDto> listProducts = productsDao.GetProductById(id);
		return listProducts.get(0);
	}

	@Override
	public List<ProductsDto> GetProductByIdCategory(int id) {
		return productsDao.GetAllProductsByID(id);
	}


}
