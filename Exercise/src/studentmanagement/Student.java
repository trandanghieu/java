package studentmanagement;

public class Student {
	private String maSV, hoTen, email, soDT, diaChi;
	private int gioiTinh;

	public Student() {

	}

	public Student(String maSV, String hoTen, String email, String soDT, String diaChi, int gioiTinh) {

		this.maSV = maSV;
		this.hoTen = hoTen;
		this.email = email;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
