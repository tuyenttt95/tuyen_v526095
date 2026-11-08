package baitap4_1;

/**
 * Lớp Point2D biểu diễn một điểm trong mặt phẳng tọa độ Oxy (x, y).
 *
 * Bài tập buổi 4 - phần 1: Hoàn thành lớp điểm 2D với các phương thức:
 * - Tính khoảng cách giữa 2 điểm.
 * - Xác định điểm đối xứng qua gốc tọa độ.
 * - Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy.
 * Ngoài ra có thêm distance() (khoảng cách tới gốc tọa độ) và toString() theo mẫu.
 *
 * Đây là lớp cha để Point3D kế thừa ở phần tiếp theo.
 */
public class Point2D {

    // =========================================================================
    // ATTRIBUTES (thuộc tính - private, lớp con truy cập qua getter/setter)
    // =========================================================================
    private double x; // Hoành độ
    private double y; // Tung độ

    // =========================================================================
    // CONSTRUCTORS (hàm tạo)
    // =========================================================================

    // Hàm tạo mặc định: điểm tại gốc tọa độ (0, 0)
    public Point2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Hàm tạo có đối
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // =========================================================================
    // GETTERS AND SETTERS
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
    // METHODS (phương thức nghiệp vụ)
    // =========================================================================

    /**
     * Tính khoảng cách giữa điểm hiện tại và một điểm khác theo công thức Euclid:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    public double khoangCach(Point2D khac) {
        double dx = this.x - khac.x;
        double dy = this.y - khac.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Xác định điểm đối xứng qua gốc tọa độ O(0, 0).
     * Điểm đối xứng của (x, y) là (-x, -y). Trả về một điểm MỚI.
     */
    public Point2D doiXungQuaGoc() {
        return new Point2D(-this.x, -this.y);
    }

    /**
     * Tịnh tiến điểm đi một vị trí với độ lệch (dx, dy).
     * Thay đổi trực tiếp tọa độ của điểm hiện tại.
     */
    public void tinhTien(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Tính khoảng cách từ điểm hiện tại tới gốc tọa độ O(0, 0):
     * distance = sqrt(x^2 + y^2)
     */
    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }
}
