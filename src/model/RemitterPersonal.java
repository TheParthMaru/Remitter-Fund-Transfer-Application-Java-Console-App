package model;

public class RemitterPersonal {
	private Long rid;
	private String email;
	private Long mobile;
	private String address;

	public RemitterPersonal() {
	}

	public RemitterPersonal(Long rid, String email, Long mobile, String address) {
		this.rid = rid;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {

		return String.format("%-6s%-30s%-16s%s", rid, email, mobile, address);
	}

}
