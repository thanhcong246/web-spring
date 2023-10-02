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
	public List<ProductsDto> GetAllProductsByID(int id) { // lấy tất cả sản phẩm theo id category
		return productsDao.GetAllProductsByID(id);
	}

	@Override
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) { // phân trang
		return productsDao.GetDataProductsPaginate(id, start, totalPage);
	}

}
