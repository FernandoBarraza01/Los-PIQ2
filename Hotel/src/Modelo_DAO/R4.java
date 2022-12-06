package Modelo_DAO;

public class R4 {
	
	private int idRes;
	private String status;
	
	public R4(int idRes, String status) {
		this.idRes = idRes;
		this.status = status;
		
	}
	
	public int getIdRes() {
		return idRes;
	}
	public void setIdRes(int idRes) {
		this.idRes = idRes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
