package model.user;

import org.springframework.stereotype.Component;

@Component("userSummaryFactory")
public class UserSummaryFactory {
	public UserSummary create(){
		return new UserSummary();
	}
}
