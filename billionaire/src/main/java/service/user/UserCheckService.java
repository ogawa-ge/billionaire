package service.user;

import model.user.UserMail;
import model.user.UserPassword;

public interface UserCheckService {
	public boolean isNotExists(UserMail userMail, UserPassword userPassword);
	public boolean isExists(UserMail userMail, UserPassword userPassword);
}
