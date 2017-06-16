package datasource.user;

import org.apache.ibatis.annotations.Param;

import model.user.User;
import model.user.UserMail;
import model.user.UserPassword;

public interface UserMapper {
	public User findBy(@Param("userMail") UserMail userMail, @Param("userPassword") UserPassword userPassword);
}
