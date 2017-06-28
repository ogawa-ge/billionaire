package web.additionalIncome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller("additionalIncomeListingController")
@RequestMapping("additional_income/list")
@SessionAttributes("user")
public interface AdditionalIncomeListingController {

}
