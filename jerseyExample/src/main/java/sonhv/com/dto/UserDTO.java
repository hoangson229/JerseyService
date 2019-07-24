package sonhv.com.dto;

/**
 * @author sonhv.ho
 *
 */
public class UserDTO {
	
	String loginID;
	String name;
	String mobile;
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public UserDTO(String loginID, String name, String mobile) {
		super();
		this.loginID = loginID;
		this.name = name;
		this.mobile = mobile;
	}
	
}
