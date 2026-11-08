package baitap4_1;

/**
 * Lớp Point3D biểu diễn một điểm trong không gian Oxyz (x, y, z).
 *
 * Bài tập buổi 4 - phần 2: Lớp điểm 3D KẾ THỪA (extends) từ Point2D:
 * - Thêm thuộc tính mới z.
 * - Định nghĩa lại hàm tạo cho phù hợp với lớp con (gọi super(x, y)).
 * - Thêm getter/setter cho thuộc tính mới z.
 * - Tính khoảng cách giữa 2 điểm 3D.
 * - Định nghĩa lại (override) hàm xác định điểm đối xứng qua gốc tọa độ.
 * - Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy và Δz.
 * - Định nghĩa lại (override) toString() và distance() cho phù hợp lớp con.
 */
public class Point3D extends Point2D {

    // =========================================================================
    // ATTRIBUTES (thêm thuộc tính mới)
    // =========================================================================
    private double z; // Cao độ

    // =========================================================================
    // CONSTRUCTORS (định nghĩa lại hàm tạo cho phù hợp với lớp con)
    // =========================================================================

    // Hàm tạo mặc định: điểm tại gốc tọa độ (0, 0, 0)
    public Point3D() {
        super();        // gọi hàm tạo mặc định của Point2D -> x = 0, y = 0
        this.z = 0.0;
    }

    // Hàm tạo có đối
    public Point3D(double x, double y, double z) {
        super(x, y);    // gọi hàm tạo có đối của Point2D để khởi tạo x, y
        this.z = z;
    }

    // =========================================================================
    // GETTERS AND SETTERS (thêm hàm getter/setter cho thuộc tính mới z)
    // =========================================================================
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // =========================================================================
    // METHODS (định nghĩa lại / bổ sung các hàm cho phù hợp với lớp con)
    // =========================================================================

    /**
     * Tính khoảng cách giữa 2 điểm 3D theo công thức Euclid mở rộng:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)
     */
    public double khoangCach(Point3D khac) {
        double dx = this.getX() - khac.getX();
        double dy = this.getY() - khac.getY();
        double dz = this.z - khac.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * ĐỊNH NGHĨA LẠI (override) hàm xác định điểm đối xứng qua gốc tọa độ.
     * Điểm đối xứng của (x, y, z) là (-x, -y, -z). Trả về một điểm MỚI.
     */
    @Override
    public Point3D doiXungQuaGoc() {
        return new Point3D(-this.getX(), -this.getY(), -this.z);
    }

    /**
     * Tịnh tiến điểm 3D đi một vị trí với độ lệch (dx, dy, dz).
     */
    public void tinhTien(double dx, double dy, double dz) {
        // Tận dụng lại tinhTien(dx, dy) của lớp cha cho x, y
        super.tinhTien(dx, dy);
        this.z += dz;
    }

    /**
     * Tính khoảng cách từ điểm 3D tới gốc tọa độ O(0, 0, 0):
     * distance = sqrt(x^2 + y^2 + z^2)
     *
     * Tận dụng lại distance() của lớp cha: super.distance()^2 = x^2 + y^2
     * nên distance 3D = sqrt(super.distance()^2 + z^2).
     */
    @Override
    public double distance() {
        return Math.sqrt(super.distance() * super.distance() + this.z * this.z);
    }

    @Override
    public String toString() {
        return "Point3D [x=" + this.getX()
                + ", y=" + this.getY()
                + ", z=" + this.z + "]";
    }
}
