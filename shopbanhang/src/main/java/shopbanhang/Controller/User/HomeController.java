package shopbanhang.Controller.User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopbanhang.Entity.Users;
import shopbanhang.Service.User.AccountServiceImpl;

// hiển thị sản phẩm ở trang chủ
@Controller
public class HomeController extends BaseController {
	
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	@RequestMapping(value = { "/" })
	public ModelAndView Index() {
		_mvShare.addObject("slides",_homeHomeImplService.GetDataSlide());
		_mvShare.addObject("categorys",_homeHomeImplService.GetDataCategorys());
		_mvShare.addObject("new_products", _homeHomeImplService.GetDataNewProducts());
		_mvShare.addObject("hightlight_products", _homeHomeImplService.GetDataHightlightProducts());
		_mvShare.addObject("user", new Users());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
}
