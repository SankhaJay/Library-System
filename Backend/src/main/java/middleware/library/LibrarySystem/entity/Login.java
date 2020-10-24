package middleware.library.LibrarySystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@Column(length = 25)
	private String username;
	@Column(length = 25)
	private String password;
	
	public Login() {}
	
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
