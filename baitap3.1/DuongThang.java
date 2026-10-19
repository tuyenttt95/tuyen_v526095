package baitap1;

public class DuongThang {
    // 1. THUỘC TÍNH (Thuộc tính có kiểu dữ liệu là một Đối tượng khác - Lớp Diem)
    private Diem A; // Điểm bắt đầu
    private Diem B; // Điểm kết thúc

    // 2. HÀM TẠO (Constructor) nhận vào 2 điểm A và B
    public DuongThang(Diem A, Diem B) {
        this.A = A;
        this.B = B;
    }

    // 3. GETTER VÀ SETTER
    // Trả về đối tượng Diem A
    public Diem getA() {
        return A;
    }

    public void setA(Diem A) {
        this.A = A;
    }

    // Trả về đối tượng Diem B
    public Diem getB() {
        return B;
    }

    public void setB(Diem B) {
        this.B = B;
    }

    // 4. PHƯƠNG THỨC TÍNH ĐỘ DÀI ĐƯỜNG THẲNG
    // Độ dài đường thẳng nối 2 điểm A và B chính là khoảng cách giữa A và B:
    // d = sqrt((B.x - A.x)^2 + (B.y - A.y)^2)
    public double tinhDoDai() {
        return this.A.tinhKhoangCach(this.B);
    }

    @Override
    public String toString() {
        return "DuongThang nối điểm " + A + " và " + B;
    }
}
