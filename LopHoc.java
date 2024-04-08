package TestHS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien {
	private static int soLuongSinhVien = 0;
    private String ten;
    private int namSinh;
    private double diem;

    // Constructor có tham số
    public SinhVien(String ten, int namSinh, double diem) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.diem = diem;
        soLuongSinhVien++;
    }
    
    public static int getSoLuongSinhVien() {
        return soLuongSinhVien;
    }

    // Getters và Setters
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + ten + '\'' +
                ", namSinh=" + namSinh +
                ", diem=" + diem +
                '}';
    }
}

public class LopHoc {
    private ArrayList<SinhVien> danhSachSinhVien;

    // Constructor không tham số
    public LopHoc() {
        danhSachSinhVien = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int soLuong = sc.nextInt();
        sc.nextLine(); // Consume newline left-over

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhập tên sinh viên " + (i + 1) + ": ");
            String ten = sc.nextLine();
            System.out.print("Nhập năm sinh sinh viên " + (i + 1) + ": ");
            int namSinh = sc.nextInt();
            System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
            double diem = sc.nextDouble();
            sc.nextLine(); // Consume newline left-over
            danhSachSinhVien.add(new SinhVien(ten, namSinh, diem));
            System.out.println("Số lượng sinh viên đã được tạo: " + SinhVien.getSoLuongSinhVien()); //minh họa cách thức sử dụng??????
        }
    }

    // Constructor có tham số
    public LopHoc(int soLuong) {
        danhSachSinhVien = new ArrayList<>();
        for (int i = 0; i < soLuong; i++) {
            // Tạo thông tin ngẫu nhiên cho sinh viên
            String ten = "SinhVien" + (i + 1);
            int namSinh = (int) (Math.random() * (2004 - 1990 + 1)) + 1990;
            double diem1 = (int) (Math.random() * 101);
            double diem = diem1/10;
            danhSachSinhVien.add(new SinhVien(ten, namSinh, diem));
            System.out.println("Số lượng sinh viên đã được tạo: " + SinhVien.getSoLuongSinhVien()); //minh họa cách thức sử dụng??????
        }
    }

    // Phương thức sắp xếp theo điểm
    public void sapXepTheoDiem() {
        Collections.sort(danhSachSinhVien, Comparator.comparingDouble(SinhVien::getDiem));
    }

    // Phương thức sắp xếp theo năm sinh
    public void sapXepTheoNamSinh() {
        Collections.sort(danhSachSinhVien, Comparator.comparingInt(SinhVien::getNamSinh));
    }

    // In danh sách sinh viên
    public void inDanhSach() {
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv);
        }
    }

    // Main method
    public static void main(String[] args) {
    	for (;;) {
    	System.out.println("chọn 1 hoặc 2:");
    	System.out.println("1. Tạo danh sách sinh viên ngẫu nhiên.");
    	System.out.println("2. Nhập danh sách sinh viên từ bàn phím.");
    	Scanner sc = new Scanner(System.in);
    	int f = sc.nextInt();
    	
    	switch (f) {
    	case 2:
            LopHoc lopHoc1 = new LopHoc();
            System.out.println("Danh sách sinh viên theo điểm:");
            lopHoc1.sapXepTheoDiem();
            lopHoc1.inDanhSach();

            System.out.println("\nDanh sách sinh viên theo năm sinh:");
            lopHoc1.sapXepTheoNamSinh();
            lopHoc1.inDanhSach();
    		break;
    	case 1:
    		System.out.println("Nhập tổng số sinh viên: ");
    		int Tongsv = sc.nextInt();
            LopHoc lopHoc2 = new LopHoc(Tongsv);
            System.out.println("Danh sách sinh viên theo điểm:");
            lopHoc2.sapXepTheoDiem();
            lopHoc2.inDanhSach();

            System.out.println("\nDanh sách sinh viên theo năm sinh:");
            lopHoc2.sapXepTheoNamSinh();
            lopHoc2.inDanhSach();
            break;
    	}
    	if (f==1 || f==2) break;
    	System.out.println("Hãy nhập lại.");
    	}
    }
}
