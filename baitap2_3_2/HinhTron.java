package baitap2_3_2;

/**
 * Lớp HinhTron biểu diễn hình tròn với tâm O (kiểu Diem) và bán kính r.
 * Đóng vai trò là lớp lưu trữ dữ liệu (Data Model) thuần túy:
 * - Thuộc tính: O, banKinh
 * - Hàm tạo (Constructor)
 * - Getter và Setter
 * - Phương thức toString()
 */
public class HinhTron {
    // 1. THUỘC TÍNH
    private Diem O;          // Tâm hình tròn
    private double banKinh;  // Bán kính r

    // 2. HÀM TẠO (Constructor)
    public HinhTron(Diem O, double banKinh) {
        this.O = O;
        this.banKinh = Math.max(0, banKinh);
    }

    // 3. GETTER VÀ SETTER
    public Diem getO() {
        return O;
    }

    public void setO(Diem O) {
        this.O = O;
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = Math.max(0, banKinh);
    }

    // 4. PHƯƠNG THỨC CHUYỂN THÀNH CHUỖI ĐỂ IN
    @Override
    public String toString() {
        return "HinhTron[Tâm=" + O + ", Bán kính=" + banKinh + "]";
    }
}
