package web.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller("logoutController")
@RequestMapping("logout")
public class LogoutController {

	@RequestMapping(method=RequestMethod.POST)
	public String logout(WebRequest webRequest){
		webRequest.removeAttribute("user", WebRequest.SCOPE_SESSION);
		return "redirect:./top";
	}
}
