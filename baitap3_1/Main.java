package baitap3_1;

/**
 * Lớp Main cho Bài tập 1 - buổi 3 (Class - Object: Lớp Phân Số).
 *
 * Chương trình minh họa:
 * 1. Các phép toán trên 2 phân số: tổng, hiệu, tích, thương, so sánh, rút gọn.
 * 2. Xử lý trên một TẬP HỢP các phân số:
 *    - Tìm phân số lớn nhất.
 *    - Tính tổng tất cả các phân số.
 *    - Đếm số phân số KHÔNG phải là số nguyên.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("            BÀI TẬP 1 - BUỔI 3: LỚP PHÂN SỐ (CLASS - OBJECT)         ");
        System.out.println("======================================================================\n");

        // ---------------------------------------------------------
        // PHẦN 1: CÁC PHÉP TOÁN TRÊN 2 PHÂN SỐ
        // ---------------------------------------------------------
        System.out.println(">>> PHẦN 1: CÁC PHÉP TOÁN TRÊN 2 PHÂN SỐ\n");

        PhanSo p1 = new PhanSo(1, 2);  // 1/2
        PhanSo p2 = new PhanSo(2, 3);  // 2/3

        System.out.println("  Phân số thứ nhất : p1 = " + p1);
        System.out.println("  Phân số thứ hai  : p2 = " + p2);
        System.out.println("  ----------------------------------------");
        System.out.println("  Tổng   p1 + p2 = " + p1.cong(p2));
        System.out.println("  Hiệu   p1 - p2 = " + p1.tru(p2));
        System.out.println("  Tích   p1 * p2 = " + p1.nhan(p2));
        System.out.println("  Thương p1 : p2 = " + p1.chia(p2));
        System.out.println("  ----------------------------------------");
        System.out.println("  So sánh p1 và p2: " + moTaSoSanh(p1, p2, p1.soSanh(p2)));

        // Minh họa rút gọn phân số
        PhanSo p3 = new PhanSo(12, 18); // 12/18
        System.out.print("\n  Rút gọn phân số " + p3.getTuSo() + "/" + p3.getMauSo());
        p3.rutGon();
        System.out.println("  =>  " + p3);

        // ---------------------------------------------------------
        // PHẦN 2: XỬ LÝ TRÊN MỘT TẬP HỢP CÁC PHÂN SỐ
        // ---------------------------------------------------------
        System.out.println("\n>>> PHẦN 2: XỬ LÝ TRÊN MỘT TẬP HỢP CÁC PHÂN SỐ\n");

        // Tạo một mảng (tập hợp) các phân số
        PhanSo[] tapPhanSo = {
            new PhanSo(1, 2),   // 1/2
            new PhanSo(3, 4),   // 3/4
            new PhanSo(6, 3),   // 6/3 = 2  (số nguyên)
            new PhanSo(5, 10),  // 5/10 = 1/2
            new PhanSo(7, 1),   // 7      (số nguyên)
            new PhanSo(2, 5)    // 2/5
        };

        System.out.println("  Tập hợp phân số:");
        for (int i = 0; i < tapPhanSo.length; i++) {
            System.out.printf("      - Phân số [%d]: %s%n", i, tapPhanSo[i]);
        }

        // 1. Tìm phân số lớn nhất
        PhanSo lonNhat = timPhanSoLonNhat(tapPhanSo);
        System.out.println("\n  1. Phân số lớn nhất trong tập hợp: " + lonNhat);

        // 2. Tính tổng các phân số
        PhanSo tong = tinhTong(tapPhanSo);
        System.out.println("  2. Tổng tất cả các phân số       : " + tong);

        // 3. Xác định số phân số KHÔNG phải số nguyên
        int demKhongNguyen = demPhanSoKhongNguyen(tapPhanSo);
        System.out.println("  3. Số phân số KHÔNG phải số nguyên: " + demKhongNguyen);

        System.out.println("\n======================================================================");
        System.out.println("                      HOÀN THÀNH CHƯƠNG TRÌNH                        ");
        System.out.println("======================================================================");
    }

    // =========================================================================
    // CÁC HÀM XỬ LÝ TRÊN TẬP HỢP PHÂN SỐ
    // =========================================================================

    /**
     * Tìm phân số lớn nhất trong mảng bằng cách so sánh lần lượt.
     */
    public static PhanSo timPhanSoLonNhat(PhanSo[] ds) {
        PhanSo max = ds[0];
        for (int i = 1; i < ds.length; i++) {
            if (ds[i].soSanh(max) > 0) {
                max = ds[i];
            }
        }
        return max;
    }

    /**
     * Tính tổng tất cả các phân số trong mảng (kết quả đã rút gọn).
     */
    public static PhanSo tinhTong(PhanSo[] ds) {
        PhanSo tong = new PhanSo(0, 1); // bắt đầu từ 0/1
        for (PhanSo p : ds) {
            tong = tong.cong(p);
        }
        return tong;
    }

    /**
     * Đếm số phân số KHÔNG phải là số nguyên trong mảng.
     */
    public static int demPhanSoKhongNguyen(PhanSo[] ds) {
        int dem = 0;
        for (PhanSo p : ds) {
            if (!p.laSoNguyen()) {
                dem++;
            }
        }
        return dem;
    }

    /**
     * Diễn giải kết quả so sánh 2 phân số thành chuỗi dễ đọc.
     */
    public static String moTaSoSanh(PhanSo a, PhanSo b, int ketQua) {
        if (ketQua > 0) return a + " > " + b;
        if (ketQua < 0) return a + " < " + b;
        return a + " = " + b;
    }
}
