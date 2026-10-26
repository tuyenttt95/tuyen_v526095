package baitap3_2;

import java.util.ArrayList;

/**
 * Lớp Main cho Bài tập 2 - buổi 3 (Class - Inheritance / Modifiers).
 *
 * Chương trình chính:
 * 1. Tạo một danh sách điểm bao gồm cả điểm 2D và điểm 3D.
 * 2. Tính tổng khoảng cách các điểm 2D và tổng khoảng cách các điểm 3D.
 * 3. Đưa các điểm đối xứng vào danh sách và hiển thị danh sách các điểm.
 *
 * Ghi chú về kế thừa: Diem3D kế thừa Diem2D, nên một danh sách kiểu Diem2D
 * có thể chứa cả đối tượng Diem3D (tính đa hình - polymorphism).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("     BÀI TẬP 2 - BUỔI 3: KẾ THỪA LỚP ĐIỂM 2D & 3D (INHERITANCE)      ");
        System.out.println("======================================================================\n");

        // ---------------------------------------------------------
        // 1. TẠO DANH SÁCH ĐIỂM GỒM CẢ 2D VÀ 3D
        // ---------------------------------------------------------
        // Tách riêng 2 danh sách để tính tổng khoảng cách cho từng loại.
        ArrayList<Diem2D> dsDiem2D = new ArrayList<>();
        dsDiem2D.add(new Diem2D(0.0, 0.0));
        dsDiem2D.add(new Diem2D(3.0, 4.0));
        dsDiem2D.add(new Diem2D(6.0, 8.0));

        ArrayList<Diem3D> dsDiem3D = new ArrayList<>();
        dsDiem3D.add(new Diem3D(0.0, 0.0, 0.0));
        dsDiem3D.add(new Diem3D(1.0, 2.0, 2.0));
        dsDiem3D.add(new Diem3D(4.0, 4.0, 2.0));

        // Danh sách tổng hợp (dùng tính đa hình: Diem2D chứa cả Diem3D)
        ArrayList<Diem2D> danhSach = new ArrayList<>();
        danhSach.addAll(dsDiem2D);
        danhSach.addAll(dsDiem3D);

        System.out.println(">>> 1. DANH SÁCH ĐIỂM BAN ĐẦU:");
        hienThiDanhSach(danhSach);

        // ---------------------------------------------------------
        // 2. TÍNH TỔNG KHOẢNG CÁCH
        // ---------------------------------------------------------
        System.out.println("\n>>> 2. TỔNG KHOẢNG CÁCH GIỮA CÁC ĐIỂM LIÊN TIẾP:");

        double tongKC2D = tinhTongKhoangCach2D(dsDiem2D);
        System.out.printf("  - Tổng khoảng cách các điểm 2D: %.2f%n", tongKC2D);

        double tongKC3D = tinhTongKhoangCach3D(dsDiem3D);
        System.out.printf("  - Tổng khoảng cách các điểm 3D: %.2f%n", tongKC3D);

        // ---------------------------------------------------------
        // 3. ĐƯA CÁC ĐIỂM ĐỐI XỨNG VÀO DANH SÁCH VÀ HIỂN THỊ
        // ---------------------------------------------------------
        System.out.println("\n>>> 3. THÊM CÁC ĐIỂM ĐỐI XỨNG QUA GỐC TỌA ĐỘ:");

        // Duyệt bản sao kích thước ban đầu để không lặp vô hạn khi vừa thêm vừa duyệt
        int soLuongGoc = danhSach.size();
        for (int i = 0; i < soLuongGoc; i++) {
            // Nhờ override doiXungQuaGoc(), Diem3D sẽ trả về Diem3D, Diem2D trả về Diem2D
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
     * Tính tổng khoảng cách giữa các điểm 2D liên tiếp trong danh sách:
     * d(p0,p1) + d(p1,p2) + ... + d(p[n-2], p[n-1]).
     */
    public static double tinhTongKhoangCach2D(ArrayList<Diem2D> ds) {
        double tong = 0.0;
        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }
        return tong;
    }

    /**
     * Tính tổng khoảng cách giữa các điểm 3D liên tiếp trong danh sách.
     */
    public static double tinhTongKhoangCach3D(ArrayList<Diem3D> ds) {
        double tong = 0.0;
        for (int i = 0; i < ds.size() - 1; i++) {
            tong += ds.get(i).khoangCach(ds.get(i + 1));
        }
        return tong;
    }

    /**
     * Hiển thị danh sách các điểm. Phân biệt rõ điểm 2D và 3D nhờ instanceof.
     */
    public static void hienThiDanhSach(ArrayList<Diem2D> ds) {
        for (int i = 0; i < ds.size(); i++) {
            Diem2D d = ds.get(i);
            String loai = (d instanceof Diem3D) ? "3D" : "2D";
            System.out.printf("      - Điểm [%d] (%s): %s%n", i, loai, d);
        }
    }
}
