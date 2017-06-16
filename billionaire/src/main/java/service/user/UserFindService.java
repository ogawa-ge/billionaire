package service.user;

import model.user.User;
import model.user.UserMail;
import model.user.UserPassword;

public interface UserFindService {
	public User findBy(UserMail userMail, UserPassword userPassword);
}
