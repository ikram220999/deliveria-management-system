package inventory;
import java.sql.Date;
import java.util.*;

public class Inventory {
	
	
	String trackno;
	String type;
	String sendname;
	String sendadd;
	String recname;
	String recadd;
	
	public Inventory() {
		super();
	
		this.trackno = trackno;
		this.type = type;
		this.sendname = sendname;
		this.sendadd = sendadd;
		this.recname = recname;
		this.recadd = recadd;
	}



	public String getTrackno() {
		return trackno;
	}

	public void setTrackno(String trackno) {
		this.trackno = trackno;
	}

	public String getType() {
		return type;
	}

	public void setType(String Type) {
		this.type = type;
	}
	
	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getSendadd() {
		return sendadd;
	}

	public void setSendadd(String sendadd) {
		this.sendadd = sendadd;
	}
	
	public String getRecname() {
		return recname;
	}

	public void setRecname(String Recname) {
		this.recname = recname;
	}

	public String getRecadd() {
		return recadd;
	}

	public void setRecadd(String recadd) {
		this.recadd = recadd;
	}
	
	

}
