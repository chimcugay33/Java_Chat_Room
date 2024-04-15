package messege;

import java.io.*;

public class msg implements Serializable {
	private String user_id; //find the way.
	private String content;
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String get_User_id() {
		return this.user_id;
	}
	public String get_Content() {
		return this.content;
	}
	
}
