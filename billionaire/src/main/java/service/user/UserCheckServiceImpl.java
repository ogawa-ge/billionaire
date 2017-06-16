package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.user.UserMail;
import model.user.UserPassword;
import model.user.UserRepository;

@Service("loginCheckService")
public class UserCheckServiceImpl implements UserCheckService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean isNotExists(UserMail userMail, UserPassword userPassword) {
		return userRepository.findBy(userMail, userPassword) == null;
	}
	@Override
	public boolean isExists(UserMail userMail, UserPassword userPassword) {
		return !isExists(userMail, userPassword);
	}
}