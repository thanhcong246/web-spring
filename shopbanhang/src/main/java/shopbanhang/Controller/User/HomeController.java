package shopbanhang.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// hiển thị sản phẩm ở trang chủ
@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "trang-chu" })
	public ModelAndView Index() {
		_mvShare.addObject("slides",_homeHomeImplService.GetDataSlide());
		_mvShare.addObject("categorys",_homeHomeImplService.GetDataCategorys());
		_mvShare.addObject("new_products", _homeHomeImplService.GetDataNewProducts());
		_mvShare.addObject("hightlight_products", _homeHomeImplService.GetDataHightlightProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
 	
	@RequestMapping(value = { "/product" })
	public ModelAndView Product() {
		ModelAndView modelAndView = new ModelAndView("user/product");
		return modelAndView;
	}
}
