package bookmall.vo;

public class MemberVo {
	private int no;
	private String name;
	private String tel;
	private String email;
	private String password;

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", tel=" + tel + ", email=" + email + ", password=" + password
				+ "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
