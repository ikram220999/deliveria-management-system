package branch;
import java.sql.Date;

public class Branch {
	int id;
	String state;
	String tel;
	String address;
	
	public Branch() {
		super();
	
		this.id=id;
		this.state=state;
		this.tel=tel;
		this.address=address;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
