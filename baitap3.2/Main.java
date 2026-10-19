package baitap2;

/**
 * Chương trình chính cho Bài tập 2:
 * Khởi tạo 2 TamGiac, 2 ChuNhat, 2 HinhTron bất kỳ và in ra chu vi, diện tích.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("       BÀI TẬP 2: TÍNH CHU VI VÀ DIỆN TÍCH CÁC HÌNH HỌC (OOP)        ");
        System.out.println("======================================================================\n");

        // ---------------------------------------------------------
        // 1. KHỞI TẠO 2 HÌNH TAM GIÁC BẤT KỲ
        // ---------------------------------------------------------
        // Tam giác 1: Đỉnh A(0, 0), B(3, 0), C(0, 4) - Tam giác vuông có cạnh 3, 4, 5
        TamGiac tg1 = new TamGiac(new Diem(0, 0), new Diem(3, 0), new Diem(0, 4));

        // Tam giác 2: Đỉnh A(1, 1), B(5, 1), C(3, 4) - Tam giác cân
        TamGiac tg2 = new TamGiac(new Diem(1, 1), new Diem(5, 1), new Diem(3, 4));

        System.out.println(">>> 1. DANH SÁCH HÌNH TAM GIÁC:");
        inThongTinTamGiac("Tam giác 1 (vuông)", tg1);
        inThongTinTamGiac("Tam giác 2 (cân)", tg2);

        // ---------------------------------------------------------
        // 2. KHỞI TẠO 2 HÌNH CHỮ NHẬT BẤT KỲ
        // ---------------------------------------------------------
        // Hình chữ nhật 1: Chiều dài = 8.0, Chiều rộng = 5.0
        ChuNhat cn1 = new ChuNhat(8.0, 5.0);

        // Hình chữ nhật 2: Chiều dài = 12.5, Chiều rộng = 4.2
        ChuNhat cn2 = new ChuNhat(12.5, 4.2);

        System.out.println("\n>>> 2. DANH SÁCH HÌNH CHỮ NHẬT:");
        inThongTinChuNhat("Hình chữ nhật 1", cn1);
        inThongTinChuNhat("Hình chữ nhật 2", cn2);

        // ---------------------------------------------------------
        // 3. KHỞI TẠO 2 HÌNH TRÒN BẤT KỲ
        // ---------------------------------------------------------
        // Hình tròn 1: Tâm O(0, 0), bán kính = 5.0
        HinhTron ht1 = new HinhTron(new Diem(0, 0), 5.0);

        // Hình tròn 2: Tâm O(3.5, 7.0), bán kính = 2.5
        HinhTron ht2 = new HinhTron(new Diem(3.5, 7.0), 2.5);

        System.out.println("\n>>> 3. DANH SÁCH HÌNH TRÒN:");
        inThongTinHinhTron("Hình tròn 1", ht1);
        inThongTinHinhTron("Hình tròn 2", ht2);

        System.out.println("\n======================================================================");
        System.out.println("                      HOÀN THÀNH CHƯƠNG TRÌNH                         ");
        System.out.println("======================================================================");
    }

    /**
     * Hàm phụ trợ in thông tin Tam giác rõ ràng, định dạng 2 chữ số thập phân
     */
    private static void inThongTinTamGiac(String ten, TamGiac tg) {
        System.out.println("  * " + ten + ": " + tg);
        if (tg.hopLe()) {
            System.out.printf("      - Độ dài 3 cạnh : AB = %.2f, BC = %.2f, CA = %.2f\n", 
                              tg.getCanhAB(), tg.getCanhBC(), tg.getCanhCA());
            System.out.printf("      - Chu vi        : %.2f\n", tg.tinhChuVi());
            System.out.printf("      - Diện tích     : %.2f (theo công thức Heron)\n", tg.tinhDienTich());
        } else {
            System.out.println("      ! Cảnh báo: 3 điểm thẳng hàng, không tạo thành tam giác hợp lệ.");
        }
    }

    /**
     * Hàm phụ trợ in thông tin Hình chữ nhật
     */
    private static void inThongTinChuNhat(String ten, ChuNhat cn) {
        System.out.println("  * " + ten + ": " + cn);
        System.out.printf("      - Chu vi   : %.2f\n", cn.tinhChuVi());
        System.out.printf("      - Diện tích: %.2f\n", cn.tinhDienTich());
    }

    /**
     * Hàm phụ trợ in thông tin Hình tròn
     */
    private static void inThongTinHinhTron(String ten, HinhTron ht) {
        System.out.println("  * " + ten + ": " + ht);
        System.out.printf("      - Chu vi   : %.2f\n", ht.tinhChuVi());
        System.out.printf("      - Diện tích: %.2f\n", ht.tinhDienTich());
    }
}
