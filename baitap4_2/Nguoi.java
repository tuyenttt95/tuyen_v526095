package baitap4_2;

import java.util.Scanner;

/**
 * Lớp Nguoi biểu diễn thông tin cơ bản của một người.
 *
 * Yêu cầu Bài 1 - Buổi 4:
 * - Thuộc tính: họ tên, tuổi.
 * - Phương thức: Nhập, xuất và các phương thức khác.
 *
 * Thuộc tính được khai báo 'protected' để lớp con NhanVien có thể kế thừa
 * và truy cập trực tiếp thuận tiện, đồng thời cung cấp đầy đủ getter/setter
 * theo chuẩn đóng gói (encapsulation) trong OOP.
 */
public class Nguoi {

    // =========================================================================
    // 1. THUỘC TÍNH (Attributes)
    // =========================================================================
    protected String hoTen; // Họ và tên
    protected int tuoi;     // Tuổi

    // =========================================================================
    // 2. HÀM TẠO (Constructors)
    // =========================================================================

    /**
     * Hàm tạo mặc định không đối số.
     */
    public Nguoi() {
        this.hoTen = "";
        this.tuoi = 0;
    }

    /**
     * Hàm tạo có tham số.
     *
     * @param hoTen Họ và tên
     * @param tuoi  Tuổi
     */
    public Nguoi(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    // =========================================================================
    // 3. GETTERS VÀ SETTERS
    // =========================================================================
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    // =========================================================================
    // 4. PHƯƠNG THỨC NHẬP VÀ XUẤT
    // =========================================================================

    /**
     * Nhập thông tin người từ bàn phím qua đối tượng Scanner.
     * Dùng sc.nextLine() để tránh lỗi trôi lệnh khi nhập chuỗi sau số.
     *
     * @param sc Đối tượng Scanner dùng để đọc dữ liệu
     */
    public void nhap(Scanner sc) {
        System.out.print("  - Nhập họ tên: ");
        this.hoTen = sc.nextLine().trim();

        System.out.print("  - Nhập tuổi: ");
        while (true) {
            try {
                this.tuoi = Integer.parseInt(sc.nextLine().trim());
                if (this.tuoi > 0) {
                    break;
                }
                System.out.print("    Tuổi phải là số nguyên dương (> 0). Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("    Tuổi không hợp lệ. Vui lòng nhập số nguyên: ");
            }
        }
    }

    /**
     * Xuất thông tin người ra màn hình console.
     */
    public void xuat() {
        System.out.printf("Họ tên: %-20s | Tuổi: %2d", this.hoTen, this.tuoi);
    }

    @Override
    public String toString() {
        return "Nguoi [hoTen=" + hoTen + ", tuoi=" + tuoi + "]";
    }
}
