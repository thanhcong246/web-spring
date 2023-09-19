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
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategory();
	}
	
	public List<Menus> GetDataMenus(){
		return menuDao.GetDataMenus();
	}
	@Override
	public List<ProductsDto> GetDataProducts() {
		List<ProductsDto> listProducts = productsDao.GetDataProducts();
		return listProducts;
	}
}