package baitap4_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Main cho Bài tập buổi 4 - phần 1: Kế thừa lớp điểm 2D & 3D.
 *
 * Xây dựng chương trình chính theo đề:
 * 1. Tạo một danh sách điểm bao gồm cả 2D và 3D (tính đa hình).
 * 2. Tính tổng khoảng cách các điểm 2D và tổng khoảng cách các điểm 3D.
 * 3. Đưa các điểm đối xứng vào danh sách và hiển thị danh sách các điểm.
 *
 * Ghi chú: Point3D kế thừa Point2D nên List<Point2D> chứa được cả Point3D.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("     BÀI TẬP BUỔI 4 - PHẦN 1: KẾ THỪA LỚP ĐIỂM 2D & 3D (INHERITANCE)  ");
        System.out.println("======================================================================\n");

        // ---------------------------------------------------------
        // 1. TẠO DANH SÁCH ĐIỂM GỒM CẢ 2D VÀ 3D
        // ---------------------------------------------------------
        // Tách riêng 2 danh sách để tính tổng khoảng cách cho từng loại.
        List<Point2D> ds2D = new ArrayList<Point2D>();
        ds2D.add(new Point2D(1.0, 5.0));
        ds2D.add(new Point2D(3.0, 7.0));
        ds2D.add(new Point2D(6.0, 8.0));

        List<Point3D> ds3D = new ArrayList<Point3D>();
        ds3D.add(new Point3D(1.0, 5.0, 3.5));
        ds3D.add(new Point3D(3.0, 7.0, 2.0));
        ds3D.add(new Point3D(4.0, 4.0, 2.0));

        // Danh sách tổng hợp (đa hình: Point2D chứa được cả Point3D)
        List<Point2D> danhSach = new ArrayList<Point2D>();
        danhSach.addAll(ds2D);
        danhSach.addAll(ds3D);

        System.out.println(">>> 1. DANH SÁCH ĐIỂM BAN ĐẦU:");
        hienThiDanhSach(danhSach);

        // ---------------------------------------------------------
        // 2. TÍNH TỔNG KHOẢNG CÁCH GIỮA CÁC ĐIỂM LIÊN TIẾP
        // ---------------------------------------------------------
        System.out.println("\n>>> 2. TỔNG KHOẢNG CÁCH GIỮA CÁC ĐIỂM LIÊN TIẾP:");

        double tongKC2D = tinhTongKhoangCach2D(ds2D);
        System.out.printf("  - Tổng khoảng cách các điểm 2D: %.4f%n", tongKC2D);

        double tongKC3D = tinhTongKhoangCach3D(ds3D);
        System.out.printf("  - Tổng khoảng cách các điểm 3D: %.4f%n", tongKC3D);

        // ---------------------------------------------------------
        // 3. ĐƯA CÁC ĐIỂM ĐỐI XỨNG QUA GỐC TỌA ĐỘ VÀO DANH SÁCH
        // ---------------------------------------------------------
        System.out.println("\n>>> 3. THÊM CÁC ĐIỂM ĐỐI XỨNG QUA GỐC TỌA ĐỘ:");

        // Duyệt theo kích thước ban đầu để không lặp vô hạn khi vừa thêm vừa duyệt.
        int soLuongGoc = danhSach.size();
        for (int i = 0; i < soLuongGoc; i++) {
            // Nhờ override doiXungQuaGoc(): Point3D trả về Point3D, Point2D trả về Point2D.
            danhSach.add(danhSach.get(i).doiXungQuaGoc());
        }

        System.out.println("  Danh sách sau khi thêm các điểm đối xứng:");
        hienThiDanhSach(danhSach);

        System.out.println("\n======================================================================");
        System.out.println("                      HOÀN THÀNH CHƯƠNG TRÌNH                        ");
        System.out.println("======================================================================");
    }

    // =========================================================================
    // CÁC HÀM HỖ TRỢ
    // =========================================================================

    /**
     * Tính tổng khoảng cách giữa các điểm 2D liên tiếp:
     * d(p0,p1) + d(p1,p2) + ... + d(p[n-2], p[n-1]).
     */
    public static double tinhTongKhoangCach2D(List<Point2D> ds) {
        double tong = 0.0;
        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }
        return tong;
    }

    /**
     * Tính tổng khoảng cách giữa các điểm 3D liên tiếp.
     */
    public static double tinhTongKhoangCach3D(List<Point3D> ds) {
        double tong = 0.0;
        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }
        return tong;
    }

    /**
     * Hiển thị danh sách các điểm. Nhờ đa hình, mỗi điểm tự in theo toString()
     * của lớp thực tế (Point2D hoặc Point3D).
     */
    public static void hienThiDanhSach(List<Point2D> ds) {
        for (int i = 0; i < ds.size(); i++) {
            Point2D d = ds.get(i);
            String loai = (d instanceof Point3D) ? "3D" : "2D";
            System.out.printf("      - Điểm [%d] (%s): %s%n", i, loai, d);
        }
    }
}
