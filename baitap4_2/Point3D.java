package baitap4_2;

/**
 * Lớp Point3D biểu diễn một điểm trong không gian 3 chiều Oxyz (x, y, z).
 *
 * Yêu cầu Bài tập 4.2 - Phần 2:
 * - Kế thừa (extends) từ lớp Point2D.
 * - Bổ sung thuộc tính cao độ (z) với access modifier phù hợp.
 * - Định nghĩa các hàm tạo (gọi constructor lớp cha super).
 * - Tính khoảng cách giữa 2 điểm 3D.
 * - Định nghĩa lại (override) hàm xác định điểm đối xứng qua gốc tọa độ O(0, 0, 0).
 * - Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy và Δz.
 */
public class Point3D extends Point2D {

    // =========================================================================
    // 1. THUỘC TÍNH BỔ SUNG (Kế thừa x, y từ Point2D; bổ sung thêm z)
    // =========================================================================
    protected double z; // Cao độ

    // =========================================================================
    // 2. HÀM TẠO (Constructors)
    // =========================================================================

    /**
     * Hàm tạo mặc định: Khởi tạo điểm tại gốc tọa độ O(0, 0, 0).
     * Gọi super() để khởi tạo x = 0.0, y = 0.0 của lớp cha Point2D.
     */
    public Point3D() {
        super();
        this.z = 0.0;
    }

    /**
     * Hàm tạo có tham số: Khởi tạo điểm 3D với tọa độ (x, y, z).
     * Gọi super(x, y) để thiết lập hoành độ và tung độ của lớp cha Point2D.
     *
     * @param x Hoành độ
     * @param y Tung độ
     * @param z Cao độ
     */
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    // =========================================================================
    // 3. GETTER VÀ SETTER CHO THUỘC TÍNH z
    // =========================================================================
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // =========================================================================
    // 4. CÁC PHƯƠNG THỨC NGHIỆP VỤ THEO YÊU CẦU ĐỀ BÀI
    // =========================================================================

    /**
     * Tính khoảng cách giữa 2 điểm 3D theo công thức Euclid trong không gian:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)
     *
     * Do x, y ở lớp Point2D có access modifier là 'protected', lớp con Point3D
     * có thể truy cập trực tiếp this.x, khac.x, this.y, khac.y mà không cần getter.
     *
     * @param khac Điểm 3D cần tính khoảng cách tới
     * @return Khoảng cách trong không gian giữa 2 điểm 3D
     */
    public double khoangCach(Point3D khac) {
        if (khac == null) {
            return 0.0;
        }
        double dx = this.x - khac.x;
        double dy = this.y - khac.y;
        double dz = this.z - khac.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Nạp chồng / Ghi đè phương thức khoangCach nhận tham số Point2D để hỗ trợ
     * tính toán đa hình khi làm việc với danh sách chứa Point2D.
     */
    @Override
    public double khoangCach(Point2D khac) {
        if (khac == null) {
            return 0.0;
        }
        if (khac instanceof Point3D) {
            return this.khoangCach((Point3D) khac);
        }
        // Nếu khac là điểm 2D thuần túy, coi z = 0
        double dx = this.x - khac.getX();
        double dy = this.y - khac.getY();
        double dz = this.z - 0.0;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * ĐỊNH NGHĨA LẠI (Override) hàm xác định điểm đối xứng qua gốc tọa độ.
     * Trong không gian 3 chiều, điểm đối xứng của P(x, y, z) qua gốc O(0, 0, 0)
     * là P'(-x, -y, -z).
     *
     * Áp dụng Covariant Return Type: Phương thức trả về kiểu Point3D thay vì Point2D.
     *
     * @return Điểm đối xứng mới trong không gian 3D
     */
    @Override
    public Point3D doiXungQuaGoc() {
        return new Point3D(-this.x, -this.y, -this.z);
    }

    /**
     * Tịnh tiến điểm 3D đi một vị trí với độ lệch Δx, Δy và Δz.
     * Tận dụng lại phương thức tinhTien(dx, dy) của lớp cha Point2D bằng từ khóa 'super',
     * sau đó cập nhật thêm độ lệch dz cho trục z.
     *
     * @param dx Độ lệch theo trục hoành (Δx)
     * @param dy Độ lệch theo trục tung (Δy)
     * @param dz Độ lệch theo trục cao (Δz)
     */
    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy); // Tịnh tiến x và y theo lớp cha
        this.z += dz;           // Tịnh tiến z của lớp con
    }

    /**
     * Tính khoảng cách từ điểm 3D tới gốc tọa độ O(0, 0, 0):
     * distance = sqrt(x^2 + y^2 + z^2)
     *
     * @return Khoảng cách tới gốc tọa độ trong không gian 3D
     */
    @Override
    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    // =========================================================================
    // 5. PHƯƠNG THỨC toString()
    // =========================================================================
    @Override
    public String toString() {
        return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
    }
}

