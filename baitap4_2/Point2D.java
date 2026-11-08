package baitap4_2;

/**
 * Lớp Point2D biểu diễn một điểm trong không gian 2 chiều Oxy (x, y).
 *
 * Yêu cầu Bài tập 4.2 - Phần 1:
 * - Thuộc tính hoành độ (x) và tung độ (y).
 * - Sử dụng access modifier phù hợp (protected để lớp con Point3D có thể kế thừa và truy cập trực tiếp).
 * - Phương thức tính khoảng cách giữa 2 điểm.
 * - Phương thức xác định điểm đối xứng qua gốc tọa độ O(0, 0).
 * - Phương thức tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy.
 */
public class Point2D {

    // =========================================================================
    // 1. THUỘC TÍNH (Access modifier: protected để lớp con Point3D kế thừa trực tiếp)
    // =========================================================================
    protected double x; // Hoành độ
    protected double y; // Tung độ

    // =========================================================================
    // 2. HÀM TẠO (Constructors)
    // =========================================================================

    /**
     * Hàm tạo mặc định: Khởi tạo điểm tại gốc tọa độ O(0, 0).
     */
    public Point2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Hàm tạo có tham số: Khởi tạo điểm với tọa độ (x, y).
     *
     * @param x Hoành độ
     * @param y Tung độ
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // =========================================================================
    // 3. GETTERS VÀ SETTERS (Đảm bảo tính đóng gói - Encapsulation)
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
    // 4. CÁC PHƯƠNG THỨC NGHIỆP VỤ THEO YÊU CẦU ĐỀ BÀI
    // =========================================================================

    /**
     * Tính khoảng cách giữa điểm hiện tại và một điểm 2D khác theo công thức Euclid:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     *
     * @param khac Điểm cần tính khoảng cách tới
     * @return Khoảng cách giữa 2 điểm
     */
    public double khoangCach(Point2D khac) {
        if (khac == null) {
            return 0.0;
        }
        double dx = this.x - khac.x;
        double dy = this.y - khac.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Xác định điểm đối xứng qua gốc tọa độ O(0, 0).
     * Điểm đối xứng của P(x, y) qua O(0, 0) là P'(-x, -y).
     * Trả về một đối tượng Point2D mới, không làm biến đổi điểm hiện tại.
     *
     * @return Điểm đối xứng mới qua gốc tọa độ
     */
    public Point2D doiXungQuaGoc() {
        return new Point2D(-this.x, -this.y);
    }

    /**
     * Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy.
     * Cập nhật trực tiếp tọa độ của điểm hiện tại:
     * x' = x + dx, y' = y + dy.
     *
     * @param dx Độ lệch theo trục hoành (Δx)
     * @param dy Độ lệch theo trục tung (Δy)
     */
    public void tinhTien(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Tính khoảng cách từ điểm hiện tại tới gốc tọa độ O(0, 0):
     * distance = sqrt(x^2 + y^2)
     *
     * @return Khoảng cách tới gốc tọa độ
     */
    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    // =========================================================================
    // 5. PHƯƠNG THỨC toString()
    // =========================================================================
    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }
}

