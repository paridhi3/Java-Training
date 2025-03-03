package MovieTicketBooking;

public class User {
	int user_id;
	String username;
	String pwd;
	boolean isAdmin;
	
	public User(int user_id, String username, String pwd, boolean isAdmin) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.pwd = pwd;
		this.isAdmin = isAdmin;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", pwd=" + pwd + ", isAdmin=" + isAdmin + "]";
	}
	
}
