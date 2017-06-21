package model.user;

public interface UserRepository {
	public User findBy(UserMail userMail, UserPassword userPassword);
	public void register(User user);
}
