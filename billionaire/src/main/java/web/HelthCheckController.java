package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("helthcheck")
public class HelthCheckController {

	@RequestMapping
	public @ResponseBody String helthCheck(){
		return "OK";
	}
	@RequestMapping("test")
	public String helthCheck( Model model ){
		model.addAttribute("sample_test", "OK!!!");
		return "sample";
	}
}
