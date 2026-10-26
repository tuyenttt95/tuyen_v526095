package baitap2_3_1;

/**
 * Lớp DuongThang biểu diễn một đoạn thẳng nối giữa 2 điểm A và B.
 * Đóng vai trò là lớp lưu trữ dữ liệu (Data Model) thuần túy, cực kỳ đơn giản:
 * - Thuộc tính là 2 đối tượng Diem A và B
 * - Hàm tạo (Constructor)
 * - Getter và Setter
 * - Phương thức toString() để in thông tin đoạn thẳng
 */
public class DuongThang {
    // 1. THUỘC TÍNH: 2 đầu mút của đoạn thẳng
    private Diem A; // Điểm bắt đầu
    private Diem B; // Điểm kết thúc

    // 2. HÀM TẠO (Constructor) nhận vào 2 đối tượng Diem
    public DuongThang(Diem A, Diem B) {
        this.A = A;
        this.B = B;
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

    // 4. PHƯƠNG THỨC CHUYỂN THÀNH CHUỖI ĐỂ IN
    @Override
    public String toString() {
        return "Đoạn thẳng nối điểm " + A + " và " + B;
    }
}
