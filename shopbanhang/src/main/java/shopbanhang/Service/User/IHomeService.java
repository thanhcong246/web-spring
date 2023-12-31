package shopbanhang.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopbanhang.Dto.ProductsDto;
import shopbanhang.Entity.Categorys;
import shopbanhang.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();

	@Autowired
	public List<Categorys> GetDataCategorys();

	@Autowired
	public List<ProductsDto> GetDataNewProducts();

	@Autowired
	public List<ProductsDto> GetDataHightlightProducts();

}
