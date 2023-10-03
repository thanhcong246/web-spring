package shopbanhang.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shopbanhang.Entity.Users;
import shopbanhang.Service.User.AccountServiceImpl;

@Controller
@Validated
public class UserController extends BaseController {
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult) {
		final Logger logger = LoggerFactory.getLogger(UserController.class);
		ModelAndView modelAndView = new ModelAndView("user/account/register");

		// Kiểm tra xem có lỗi trong các trường không
		if (bindingResult.hasErrors()) {
			logger.error("Đăng ký tài khoản thất bại vì lỗi kiểm tra trường");
			return modelAndView;
		}

		// Kiểm tra xem mật khẩu và mật khẩu nhập lại có khớp nhau không
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "error.user", "Mật khẩu nhập lại không khớp");
			return modelAndView;
		}

		// Kiểm tra xem email đã tồn tại trong database không
		Users existingUser = accountService.GetUserByEmail(user.getUser());
		if (existingUser != null) {
			modelAndView.addObject("status", "Email đã tồn tại trong hệ thống");
			return modelAndView;
		}

		int count = accountService.AddAccount(user);
		if (count > 0) {
			modelAndView.addObject("status", "Đăng ký tài khoản thành công");
			return new ModelAndView("redirect:/dang-nhap");
		} else {
			modelAndView.addObject("status", "Đăng ký tài khoản thất bại");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView Login() {
		_mvShare.setViewName("user/account/login");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
		user = accountService.CheckAccount(user);
		if (user != null) {
			_mvShare.setViewName("redirect:/");
			session.setAttribute("LoginInfo", user);
		} else {
			_mvShare.addObject("statusLogin", "Đăng nhập thất bại");
		}
		return _mvShare;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:" + request.getHeader("Referer");
	}

}
