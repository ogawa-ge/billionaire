package model.user;

import org.springframework.stereotype.Component;

@Component("UserFactory")
public class UserFactory {
	public User create(){
		return new User();
	}
}
