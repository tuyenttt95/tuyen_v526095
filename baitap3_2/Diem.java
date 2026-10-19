package baitap3_2;

/**
 * Lớp Diem biểu diễn một điểm trên mặt phẳng tọa độ Oxy (x, y).
 * Đóng vai trò là lớp lưu trữ dữ liệu (Data Model) thuần túy:
 * - Chỉ gồm thuộc tính x, y
 * - Hàm tạo (Constructor)
 * - Getter và Setter
 * - Phương thức toString() để in tọa độ
 */
public class Diem {
    // 1. THUỘC TÍNH
    private double x;
    private double y;

    // 2. HÀM TẠO (Constructor)
    // Hàm tạo nhận vào tọa độ x và y
    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Hàm tạo mặc định tại gốc tọa độ (0, 0)
    public Diem() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // 3. GETTER VÀ SETTER
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // 4. PHƯƠNG THỨC CHUYỂN THÀNH CHUỖI ĐỂ IN DẠNG (x, y)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
