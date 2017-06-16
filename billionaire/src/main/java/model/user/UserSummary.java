package model.user;

import java.io.Serializable;

import javax.validation.Valid;

public class UserSummary implements Serializable{
	@Valid
	private UserMail userMail;
	@Valid
	private UserPassword userPassword;

	public UserSummary(UserMail userMail, UserPassword userPassword){
		this.userMail = userMail;
		this.userPassword = userPassword;
	}
	public UserSummary(){
		userMail = new UserMail();
		userPassword = new UserPassword();
	}

	public UserMail userMail(){
		return userMail;
	}
	public UserPassword userPassword(){
		return userPassword;
	}

	@Deprecated
	public UserMail getUserMail(){
		return userMail;
	}
	@Deprecated
	public UserPassword getUserPassword(){
		return userPassword;
	}

	@Override
	public String toString() {
		return String.format("UserSummary [userMail=%s, userPassword=%s]", userMail, userPassword);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -283986940425592826L;
}
