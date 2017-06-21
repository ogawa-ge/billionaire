package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.user.User;
import model.user.UserRepository;

@Service("userRegisterService")
public class UserRegisterServiceImpl implements UserRegisterService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(User user) {
		userRepository.register(user);
	}

}
