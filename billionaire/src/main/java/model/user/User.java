package model.user;

import java.io.Serializable;

import javax.validation.Valid;

public class User implements Serializable{
	private UserId userId;
	@Valid
	private UserMail userMail;
	@Valid
	private UserName userName;
	@Valid
	private UserPassword userPassword;

	public User(UserId userId, UserMail userMail, UserName userName, UserPassword userPassword){
		this.userId = userId;
		this.userMail = userMail;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public User(){
		userId = new UserId();
		userMail = new UserMail();
		userName = new UserName();
		userPassword = new UserPassword();
	}

	public UserId userId(){
		return userId;
	}

	@Deprecated
	public UserId getUserId(){
		return userId;
	}
	@Deprecated
	public UserMail getUserMail(){
		return userMail;
	}
	@Deprecated
	public UserName getUserName(){
		return userName;
	}
	@Deprecated
	public UserPassword getUserPassword(){
		return userPassword;
	}

	@Override
	public String toString() {
		return String.format("User [userId=%s, userMail=%s, userName=%s, userPassword=%s]", userId, userMail, userName,
				userPassword);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1635484404176765734L;

}
