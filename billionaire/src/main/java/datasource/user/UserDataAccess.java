package datasource.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.user.User;
import model.user.UserMail;
import model.user.UserPassword;
import model.user.UserRepository;

@Repository("userRepository")
public class UserDataAccess implements UserRepository{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findBy(UserMail userMail, UserPassword userPassword) {
		return userMapper.findBy(userMail, userPassword);
	}

	@Override
	public void register(User user) {
		userMapper.register(user);
	}

	@Override
	public boolean isUsed(UserMail userMail) {
		return userMapper.isUsed(userMail);
	}


}
