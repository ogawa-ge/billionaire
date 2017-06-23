package web.user;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import model.groups.RegisterGroup;
import model.user.User;
import model.user.UserFactory;
import service.user.UserFindService;
import service.user.UserRegisterService;

@Controller("userRegisterController")
@RequestMapping("user_register")
public class UserRegisterController {
	@Autowired
	private UserFactory userFactory;
	@Autowired
	private UserRegisterService userRegisterService;
	@Autowired
	private UserFindService userFindService;

	@RequestMapping
	public String register(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) != null){
			return "redirect:./login";
		}
		model.addAttribute("user", userFactory.create());

		return "user/user_register";
	}

	@RequestMapping(value="confirm", method=RequestMethod.POST)
	public String confirm(Model model, @Validated({RegisterGroup.class, Default.class}) @ModelAttribute("user") User user, Errors errors, WebRequest webRequest){
		if(errors.hasErrors()){
			return "user/user_register";
		}

		model.addAttribute("user", user);

		return "user/user_confirm";
	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String execute(Model model, @ModelAttribute("user") User user, WebRequest webRequest){
		userRegisterService.register(user);
		webRequest.setAttribute("user", userFindService.findBy(user.userMail(), user.userPassword()), WebRequest.SCOPE_SESSION);

		return "redirect:../login";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Model model, @ModelAttribute("user") User user){
		model.addAttribute("user", user);

		return "user/user_register";
	}


}
