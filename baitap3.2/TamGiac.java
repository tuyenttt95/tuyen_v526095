package baitap2;

/**
 * Lớp TamGiac biểu diễn một hình tam giác trong mặt phẳng Oxy.
 * Tam giác được xác định bởi 3 đỉnh A, B, C (mỗi đỉnh là một đối tượng Diem).
 */
public class TamGiac {
    // 1. THUỘC TÍNH: 3 đỉnh của tam giác
    private Diem A;
    private Diem B;
    private Diem C;

    // 2. HÀM TẠO: Nhận vào 3 điểm A, B, C
    public TamGiac(Diem A, Diem B, Diem C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    // 3. GETTER VÀ SETTER
    public Diem getA() { return A; }
    public void setA(Diem A) { this.A = A; }

    public Diem getB() { return B; }
    public void setB(Diem B) { this.B = B; }

    public Diem getC() { return C; }
    public void setC(Diem C) { this.C = C; }

    // 4. PHƯƠNG THỨC TÍNH ĐỘ DÀI 3 CẠNH
    // Cạnh c = độ dài đoạn thẳng AB
    public double getCanhAB() {
        return A.tinhKhoangCach(B);
    }

    // Cạnh a = độ dài đoạn thẳng BC
    public double getCanhBC() {
        return B.tinhKhoangCach(C);
    }

    // Cạnh b = độ dài đoạn thẳng CA
    public double getCanhCA() {
        return C.tinhKhoangCach(A);
    }

    // Kiểm tra điều kiện 3 điểm có tạo thành một tam giác hợp lệ hay không
    // (Tổng 2 cạnh bất kỳ phải luôn lớn hơn cạnh còn lại)
    public boolean hopLe() {
        double a = getCanhBC();
        double b = getCanhCA();
        double c = getCanhAB();
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // 5. PHƯƠNG THỨC TÍNH CHU VI
    // Chu vi tam giác = tổng độ dài 3 cạnh: P = a + b + c
    public double tinhChuVi() {
        return getCanhAB() + getCanhBC() + getCanhCA();
    }

    // 6. PHƯƠNG THỨC TÍNH DIỆN TÍCH
    // Sử dụng công thức Heron:
    // S = sqrt(p * (p - a) * (p - b) * (p - c)), trong đó p = P / 2 (nửa chu vi)
    public double tinhDienTich() {
        if (!hopLe()) {
            return 0.0; // Nếu 3 điểm thẳng hàng thì diện tích bằng 0
        }
        double a = getCanhBC();
        double b = getCanhCA();
        double c = getCanhAB();
        double p = tinhChuVi() / 2.0; // Nửa chu vi

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "TamGiac[Đỉnh A=" + A + ", Đỉnh B=" + B + ", Đỉnh C=" + C + "]";
    }
}
