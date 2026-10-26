package baitap3_2;

/**
 * Lớp Diem3D biểu diễn một điểm trong không gian Oxyz (x, y, z).
 *
 * Yêu cầu bài tập 2 - buổi 3 (phần 2): Hoàn thành lớp điểm 3D KẾ THỪA từ lớp điểm 2D:
 * - Tính khoảng cách giữa 2 điểm 3D.
 * - Định nghĩa lại (override) hàm xác định điểm đối xứng qua gốc tọa độ.
 * - Tịnh tiến điểm đi một vị trí với độ lệch Δx, Δy và Δz.
 *
 * Diem3D kế thừa x, y (protected) từ Diem2D và bổ sung thêm thuộc tính z.
 */
public class Diem3D extends Diem2D {
    // =========================================================================
    // 1. THUỘC TÍNH BỔ SUNG
    // =========================================================================
    protected double z; // Cao độ

    // =========================================================================
    // 2. HÀM TẠO (Constructor)
    // =========================================================================

    // Hàm tạo mặc định: điểm tại gốc tọa độ (0, 0, 0)
    public Diem3D() {
        super();        // gọi hàm tạo mặc định của Diem2D -> x = 0, y = 0
        this.z = 0.0;
    }

    // Hàm tạo có đối
    public Diem3D(double x, double y, double z) {
        super(x, y);    // gọi hàm tạo có đối của Diem2D để khởi tạo x, y
        this.z = z;
    }

    // =========================================================================
    // 3. GETTER VÀ SETTER cho thuộc tính z
    // =========================================================================
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // =========================================================================
    // 4. CÁC PHƯƠNG THỨC NGHIỆP VỤ
    // =========================================================================

    /**
     * Tính khoảng cách giữa 2 điểm 3D theo công thức Euclid mở rộng:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2)
     */
    public double khoangCach(Diem3D khac) {
        double dx = this.x - khac.x;
        double dy = this.y - khac.y;
        double dz = this.z - khac.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * ĐỊNH NGHĨA LẠI (override) hàm xác định điểm đối xứng qua gốc tọa độ.
     * Điểm đối xứng của (x, y, z) là (-x, -y, -z).
     */
    @Override
    public Diem3D doiXungQuaGoc() {
        return new Diem3D(-x, -y, -z);
    }

    /**
     * Tịnh tiến điểm 3D đi một vị trí với độ lệch (dx, dy, dz).
     */
    public void tinhTien(double dx, double dy, double dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }

    // =========================================================================
    // 5. PHƯƠNG THỨC toString()
    // =========================================================================
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
