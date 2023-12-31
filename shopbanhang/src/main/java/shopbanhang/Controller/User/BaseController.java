package shopbanhang.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import shopbanhang.Service.User.HomeServiceImpl;

// hàm gọi Controller chung cho user
@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeHomeImplService;
	public ModelAndView _mvShare = new ModelAndView();

	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("menus", _homeHomeImplService.GetDataMenus());
		return _mvShare;
	}
}
