package baitap4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Lớp Main cho Bài tập 4.2: Kế thừa và Access Modifiers (Point2D & Point3D).
 *
 * Yêu cầu:
 * 1. Tạo một danh sách điểm bao gồm cả 2D và 3D (sử dụng tính đa hình trong Java).
 * 2. Tính tổng khoảng cách các điểm 2D và tổng khoảng cách các điểm 3D.
 * 3. Đưa các điểm đối xứng qua gốc tọa độ vào danh sách và hiển thị danh sách các điểm.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("   BÀI TẬP 4.2: CLASS - INHERITANCE / ACCESS MODIFIERS (POINT2D & POINT3D) ");
        System.out.println("==========================================================================\n");

        // ---------------------------------------------------------------------
        // 1. TẠO DANH SÁCH ĐIỂM BAO GỒM CẢ 2D VÀ 3D (TÍNH ĐA HÌNH - POLYMORPHISM)
        // ---------------------------------------------------------------------
        // Do Point3D kế thừa Point2D, một danh sách List<Point2D> có thể lưu trữ
        // cả đối tượng Point2D và đối tượng Point3D.
        List<Point2D> danhSach = new ArrayList<>();

        // Thêm các điểm 2D
        danhSach.add(new Point2D(1.0, 2.0));
        danhSach.add(new Point2D(4.0, 6.0));
        danhSach.add(new Point2D(7.0, 10.0));

        // Thêm các điểm 3D
        danhSach.add(new Point3D(1.0, 2.0, 2.0));
        danhSach.add(new Point3D(4.0, 6.0, 5.0));
        danhSach.add(new Point3D(7.0, 9.0, 11.0));

        System.out.println(">>> 1. DANH SÁCH ĐIỂM BAN ĐẦU (GỒM CẢ 2D VÀ 3D):");
        hienThiDanhSach(danhSach);

        // ---------------------------------------------------------------------
        // 2. TÍNH TỔNG KHOẢNG CÁCH CÁC ĐIỂM 2D VÀ TỔNG KHOẢNG CÁCH CÁC ĐIỂM 3D
        // ---------------------------------------------------------------------
        // Tách các điểm theo loại từ danh sách đa hình chung
        List<Point2D> ds2D = new ArrayList<>();
        List<Point3D> ds3D = new ArrayList<>();

        for (Point2D p : danhSach) {
            if (p instanceof Point3D) {
                ds3D.add((Point3D) p);
            } else {
                ds2D.add(p);
            }
        }

        System.out.println("\n>>> 2. TÍNH TỔNG KHOẢNG CÁCH:");

        // Cách A: Tổng khoảng cách giữa các điểm liên tiếp trong danh sách
        System.out.println("  [A] Tổng khoảng cách giữa các điểm liên tiếp trong từng nhóm:");
        double tongKCLienTiep2D = tinhTongKhoangCachLienTiep2D(ds2D);
        double tongKCLienTiep3D = tinhTongKhoangCachLienTiep3D(ds3D);
        System.out.printf(Locale.US, "      - Tổng khoảng cách các điểm 2D liên tiếp: %.4f%n", tongKCLienTiep2D);
        System.out.printf(Locale.US, "      - Tổng khoảng cách các điểm 3D liên tiếp: %.4f%n", tongKCLienTiep3D);

        // Cách B: Tổng khoảng cách từ tất cả các điểm đến gốc tọa độ O
        System.out.println("\n  [B] Tổng khoảng cách từ các điểm tới gốc tọa độ O:");
        double tongKCGoc2D = tinhTongKhoangCachToiGoc(ds2D);
        double tongKCGoc3D = tinhTongKhoangCachToiGoc(ds3D);
        System.out.printf(Locale.US, "      - Tổng khoảng cách các điểm 2D tới gốc tọa độ: %.4f%n", tongKCGoc2D);
        System.out.printf(Locale.US, "      - Tổng khoảng cách các điểm 3D tới gốc tọa độ: %.4f%n", tongKCGoc3D);

        // ---------------------------------------------------------------------
        // 3. ĐƯA CÁC ĐIỂM ĐỐI XỨNG VÀO DANH SÁCH VÀ HIỂN THỊ
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 3. ĐƯA CÁC ĐIỂM ĐỐI XỨNG QUA GỐC TỌA ĐỘ VÀO DANH SÁCH:");

        // Lấy số lượng ban đầu để tránh lặp vô hạn khi vừa thêm vừa duyệt
        int nBanDau = danhSach.size();
        for (int i = 0; i < nBanDau; i++) {
            Point2D pGoc = danhSach.get(i);
            // Nhờ tính Đa hình động (Dynamic Method Dispatch) và override:
            // Point2D gọi doiXungQuaGoc() -> trả về Point2D(-x, -y)
            // Point3D gọi doiXungQuaGoc() -> trả về Point3D(-x, -y, -z)
            Point2D pDoiXung = pGoc.doiXungQuaGoc();
            danhSach.add(pDoiXung);
        }

        System.out.println("  Danh sách sau khi thêm các điểm đối xứng (tổng cộng " + danhSach.size() + " điểm):");
        hienThiDanhSach(danhSach);

        // ---------------------------------------------------------------------
        // 4. MINH HỌA THÊM PHƯƠNG THỨC TỊNH TIẾN (tinhTien)
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 4. MINH HỌA PHƯƠNG THỨC TỊNH TIẾN:");
        Point2D demo2D = new Point2D(3.0, 4.0);
        System.out.println("  - Điểm 2D ban đầu:  " + demo2D);
        demo2D.tinhTien(2.0, -1.5);
        System.out.println("    Sau khi tịnh tiến (Δx=2.0, Δy=-1.5): " + demo2D);

        Point3D demo3D = new Point3D(1.0, 2.0, 3.0);
        System.out.println("  - Điểm 3D ban đầu:  " + demo3D);
        demo3D.tinhTien(3.0, 2.0, -1.0);
        System.out.println("    Sau khi tịnh tiến (Δx=3.0, Δy=2.0, Δz=-1.0): " + demo3D);

        System.out.println("\n==========================================================================");
        System.out.println("                          CHƯƠNG TRÌNH KẾT THÚC                           ");
        System.out.println("==========================================================================");
    }

    // =========================================================================
    // CÁC HÀM HỖ TRỢ XỬ LÝ DANH SÁCH
    // =========================================================================

    /**
     * Tính tổng khoảng cách giữa các điểm 2D liên tiếp:
     * d(P0, P1) + d(P1, P2) + ... + d(Pn-2, Pn-1).
     */
    public static double tinhTongKhoangCachLienTiep2D(List<Point2D> ds) {
        if (ds == null || ds.size() < 2) {
            return 0.0;
        }
        double tong = 0.0;
        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }
        return tong;
    }

    /**
     * Tính tổng khoảng cách giữa các điểm 3D liên tiếp:
     * d(P0, P1) + d(P1, P2) + ... + d(Pn-2, Pn-1).
     */
    public static double tinhTongKhoangCachLienTiep3D(List<Point3D> ds) {
        if (ds == null || ds.size() < 2) {
            return 0.0;
        }
        double tong = 0.0;
        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }
        return tong;
    }

    /**
     * Tính tổng khoảng cách từ tất cả các điểm trong danh sách tới gốc tọa độ O.
     * Áp dụng tính đa hình: p.distance() tự động gọi đúng distance() của Point2D hoặc Point3D.
     */
    public static double tinhTongKhoangCachToiGoc(List<? extends Point2D> ds) {
        if (ds == null) {
            return 0.0;
        }
        double tong = 0.0;
        for (Point2D p : ds) {
            tong += p.distance();
        }
        return tong;
    }

    /**
     * Hiển thị danh sách điểm. Nhờ tính đa hình, hàm toString() của từng lớp con
     * sẽ tự động được gọi tương ứng.
     */
    public static void hienThiDanhSach(List<Point2D> ds) {
        for (int i = 0; i < ds.size(); i++) {
            Point2D p = ds.get(i);
            String loai = (p instanceof Point3D) ? "3D" : "2D";
            System.out.printf("  [%2d] (%s) %s%n", (i + 1), loai, p);
        }
    }
}
