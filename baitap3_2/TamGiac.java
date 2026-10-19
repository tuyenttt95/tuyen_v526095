package baitap3_2;

/**
 * Lớp TamGiac biểu diễn một hình tam giác xác định bởi 3 đỉnh A, B, C (kiểu Diem).
 * Đóng vai trò là lớp lưu trữ dữ liệu (Data Model) thuần túy:
 * - Thuộc tính: 3 đỉnh A, B, C
 * - Hàm tạo (Constructor)
 * - Getter và Setter
 * - Phương thức toString()
 */
public class TamGiac {
    // 1. THUỘC TÍNH: 3 đỉnh của tam giác
    private Diem A;
    private Diem B;
    private Diem C;

    // 2. HÀM TẠO (Constructor) nhận vào 3 điểm A, B, C
    public TamGiac(Diem A, Diem B, Diem C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    // 3. GETTER VÀ SETTER
    public Diem getA() {
        return A;
    }

    public void setA(Diem A) {
        this.A = A;
    }

    public Diem getB() {
        return B;
    }

    public void setB(Diem B) {
        this.B = B;
    }

    public Diem getC() {
        return C;
    }

    public void setC(Diem C) {
        this.C = C;
    }

    // 4. PHƯƠNG THỨC CHUYỂN THÀNH CHUỖI ĐỂ IN
    @Override
    public String toString() {
        return "TamGiac[Đỉnh A=" + A + ", Đỉnh B=" + B + ", Đỉnh C=" + C + "]";
    }
}
