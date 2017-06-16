package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.user.User;
import model.user.UserMail;
import model.user.UserPassword;
import model.user.UserRepository;

@Service("userFindService")
public class UserFindServiceImpl implements UserFindService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findBy(UserMail userMail, UserPassword userPassword) {
		return userRepository.findBy(userMail, userPassword);
	}

}
