package web.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller("logoutController")
@RequestMapping("logout")
public class LogoutController {

	@RequestMapping
	public String logout(WebRequest webRequest){
		webRequest.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "redirect:./";
	}
}
