package shopbanhang.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopbanhang.Dao.ProductsDao;
import shopbanhang.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<ProductsDto> GetAllProductsByID(int id) {
		return productsDao.GetAllProductsByID(id);
	}

	@Override
	public List<ProductsDto> GetDataProductsPaginate(int start, int end) {
		return productsDao.GetDataProductsPaginate(start, end);
	}

}
