package baitap3_2;

/**
 * Lớp Diem2D biểu diễn một điểm trong mặt phẳng tọa độ Oxy (x, y).
 *
 * Yêu cầu bài tập 2 - buổi 3 (phần 1): Hoàn thành lớp điểm 2D với các phương thức:
 * - Tính khoảng cách giữa 2 điểm.
 * - Xác định điểm đối xứng qua gốc tọa độ.
 * - Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy.
 *
 * Chú ý về access modifier:
 * - Thuộc tính để 'protected' để lớp con Diem3D có thể truy cập trực tiếp khi kế thừa.
 */
public class Diem2D {
    // =========================================================================
    // 1. THUỘC TÍNH (protected để lớp con kế thừa truy cập được)
    // =========================================================================
    protected double x; // Hoành độ
    protected double y; // Tung độ

    // =========================================================================
    // 2. HÀM TẠO (Constructor)
    // =========================================================================

    // Hàm tạo mặc định: điểm tại gốc tọa độ (0, 0)
    public Diem2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Hàm tạo có đối
    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // =========================================================================
    // 3. GETTER VÀ SETTER
    // =========================================================================
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

    // =========================================================================
    // 4. CÁC PHƯƠNG THỨC NGHIỆP VỤ
    // =========================================================================

    /**
     * Tính khoảng cách từ điểm hiện tại đến điểm khac theo công thức Euclid:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    public double khoangCach(Diem2D khac) {
        double dx = this.x - khac.x;
        double dy = this.y - khac.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Xác định điểm đối xứng qua gốc tọa độ O(0,0).
     * Điểm đối xứng của (x, y) là (-x, -y).
     * Trả về một điểm MỚI, không làm thay đổi điểm hiện tại.
     */
    public Diem2D doiXungQuaGoc() {
        return new Diem2D(-x, -y);
    }

    /**
     * Tịnh tiến điểm đi một vị trí với độ lệch (dx, dy).
     * Thay đổi trực tiếp tọa độ của điểm hiện tại.
     */
    public void tinhTien(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // =========================================================================
    // 5. PHƯƠNG THỨC toString()
    // =========================================================================
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
