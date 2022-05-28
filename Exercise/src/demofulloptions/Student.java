package demofulloptions;

import java.sql.Date;

public class Student {
	private String maSV = "";
	private String hoTen;
	private String dienThoai;
	private String email;
	private String diaChi;
	private String maKhoa;
	private int gioiTinh;
	private Date ngaySinh;

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		if(maSV.contains("SF")) {
			System.out.println("becom a sutdent of SF");
		}
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Student() {

	}

	public Student(String maSV, String hoTen, String dienThoai, String email, String diaChi) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.dienThoai = dienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}

}
