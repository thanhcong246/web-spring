package shopbanhang.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopbanhang.Dao.CategorysDao;
import shopbanhang.Dao.MenusDao;
import shopbanhang.Dao.ProductsDao;
import shopbanhang.Dao.SlidesDao;
import shopbanhang.Dto.ProductsDto;
import shopbanhang.Entity.Categorys;
import shopbanhang.Entity.Menus;
import shopbanhang.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private SlidesDao slidesDao;

	@Autowired
	private CategorysDao categorysDao;

	@Autowired
	private MenusDao menuDao;

	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<Slides> GetDataSlide() { // xử lý slider
		return slidesDao.GetDataSlide();
	}

	public List<Categorys> GetDataCategorys() { // xử lý cateogry
		return categorysDao.GetDataCategory();
	}

	public List<Menus> GetDataMenus() { // xử lý menus
		return menuDao.GetDataMenus();
	}

	@Override
	public List<ProductsDto> GetDataNewProducts() {
		List<ProductsDto> listNewProducts = productsDao.GetDataNewProducts(); // sản phẩm mới
		return listNewProducts;
	}

	@Override
	public List<ProductsDto> GetDataHightlightProducts() { // sản phẩm nổi bật
		List<ProductsDto> listHightlightProducts = productsDao.GetDataHightlightProducts();
		return listHightlightProducts;
	}
}
