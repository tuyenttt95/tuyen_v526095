package baitap2_3_2;

/**
 * Lớp Main cho Bài tập 3.2:
 * Nơi tập trung toàn bộ các hàm xử lý tính toán chu vi, diện tích cho các hình học:
 * - Hình Tam Giác (kiểm tra hợp lệ, chu vi, diện tích theo Heron)
 * - Hình Chữ Nhật (chu vi, diện tích)
 * - Hình Tròn (chu vi, diện tích)
 */
public class Main {

    // =========================================================================
    // 1. HÀM CHÍNH (MAIN): Khởi tạo đối tượng và gọi các hàm tính toán
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("       BÀI TẬP 3.2: TÍNH CHU VI VÀ DIỆN TÍCH CÁC HÌNH HỌC (OOP)       ");
        System.out.println("======================================================================\n");

        // ---------------------------------------------------------
        // 1. KHỞI TẠO VÀ TÍNH TOÁN 2 HÌNH TAM GIÁC
        // ---------------------------------------------------------
        // Tam giác 1: tam giác vuông tại A (đỉnh A(0,0), B(3,0), C(0,4))
        TamGiac tg1 = new TamGiac(new Diem(0.0, 0.0), new Diem(3.0, 0.0), new Diem(0.0, 4.0));
        // Tam giác 2: tam giác cân (đỉnh A(1,1), B(5,1), C(3,4))
        TamGiac tg2 = new TamGiac(new Diem(1.0, 1.0), new Diem(5.0, 1.0), new Diem(3.0, 4.0));

        System.out.println(">>> 1. DANH SÁCH HÌNH TAM GIÁC:");
        inThongTinTamGiac("Tam giác 1 (vuông)", tg1);
        inThongTinTamGiac("Tam giác 2 (cân)", tg2);

        // ---------------------------------------------------------
        // 2. KHỞI TẠO VÀ TÍNH TOÁN 2 HÌNH CHỮ NHẬT
        // ---------------------------------------------------------
        ChuNhat cn1 = new ChuNhat(8.0, 5.0);
        ChuNhat cn2 = new ChuNhat(12.5, 4.2);

        System.out.println("\n>>> 2. DANH SÁCH HÌNH CHỮ NHẬT:");
        inThongTinChuNhat("Hình chữ nhật 1", cn1);
        inThongTinChuNhat("Hình chữ nhật 2", cn2);

        // ---------------------------------------------------------
        // 3. KHỞI TẠO VÀ TÍNH TOÁN 2 HÌNH TRÒN
        // ---------------------------------------------------------
        HinhTron ht1 = new HinhTron(new Diem(0.0, 0.0), 5.0);
        HinhTron ht2 = new HinhTron(new Diem(3.5, 7.0), 2.5);

        System.out.println("\n>>> 3. DANH SÁCH HÌNH TRÒN:");
        inThongTinHinhTron("Hình tròn 1", ht1);
        inThongTinHinhTron("Hình tròn 2", ht2);

        System.out.println("\n======================================================================");
        System.out.println("                      HOÀN THÀNH CHƯƠNG TRÌNH                         ");
        System.out.println("======================================================================");
    }

    // =========================================================================
    // 2. CÁC HÀM XỬ LÝ TÍNH TOÁN CHO ĐIỂM VÀ ĐOẠN THẲNG
    // =========================================================================

    /**
     * Tính khoảng cách giữa 2 điểm d1 và d2 theo công thức Euclid:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    public static double tinhKhoangCach(Diem d1, Diem d2) {
        double dx = d2.getX() - d1.getX();
        double dy = d2.getY() - d1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // =========================================================================
    // 3. CÁC HÀM XỬ LÝ TÍNH TOÁN CHO HÌNH CHỮ NHẬT
    // =========================================================================

    public static double tinhChuViChuNhat(ChuNhat cn) {
        return (cn.getChieuDai() + cn.getChieuRong()) * 2;
    }

    public static double tinhDienTichChuNhat(ChuNhat cn) {
        return cn.getChieuDai() * cn.getChieuRong();
    }

    public static void inThongTinChuNhat(String ten, ChuNhat cn) {
        System.out.printf("  * %s: %s\n", ten, cn);
        System.out.printf("      - Chu vi   : %.2f\n", tinhChuViChuNhat(cn));
        System.out.printf("      - Diện tích: %.2f\n", tinhDienTichChuNhat(cn));
    }

    // =========================================================================
    // 4. CÁC HÀM XỬ LÝ TÍNH TOÁN CHO HÌNH TRÒN
    // =========================================================================

    public static double tinhChuViHinhTron(HinhTron ht) {
        return 2 * Math.PI * ht.getBanKinh();
    }

    public static double tinhDienTichHinhTron(HinhTron ht) {
        return Math.PI * ht.getBanKinh() * ht.getBanKinh();
    }

    public static void inThongTinHinhTron(String ten, HinhTron ht) {
        System.out.printf("  * %s: %s\n", ten, ht);
        System.out.printf("      - Chu vi   : %.2f\n", tinhChuViHinhTron(ht));
        System.out.printf("      - Diện tích: %.2f\n", tinhDienTichHinhTron(ht));
    }

    // =========================================================================
    // 5. CÁC HÀM XỬ LÝ TÍNH TOÁN CHO HÌNH TAM GIÁC
    // =========================================================================

    /**
     * Tính độ dài 3 cạnh của tam giác:
     * return mảng double[] gồm [canhAB, canhBC, canhCA]
     */
    public static double[] layDoDai3CanhTamGiac(TamGiac tg) {
        double c = tinhKhoangCach(tg.getA(), tg.getB()); // Cạnh AB
        double a = tinhKhoangCach(tg.getB(), tg.getC()); // Cạnh BC
        double b = tinhKhoangCach(tg.getC(), tg.getA()); // Cạnh CA
        return new double[]{c, a, b};
    }

    /**
     * Kiểm tra điều kiện 3 đỉnh có tạo thành tam giác hợp lệ:
     * Tổng 2 cạnh bất kỳ phải luôn lớn hơn cạnh còn lại
     */
    public static boolean kiemTraTamGiacHopLe(TamGiac tg) {
        double[] canh = layDoDai3CanhTamGiac(tg);
        double c = canh[0], a = canh[1], b = canh[2];
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /**
     * Tính chu vi tam giác = tổng độ dài 3 cạnh: P = a + b + c
     */
    public static double tinhChuViTamGiac(TamGiac tg) {
        double[] canh = layDoDai3CanhTamGiac(tg);
        return canh[0] + canh[1] + canh[2];
    }

    /**
     * Tính diện tích tam giác theo công thức Heron:
     * S = sqrt(p * (p - a) * (p - b) * (p - c)), với p = Chu vi / 2
     */
    public static double tinhDienTichTamGiac(TamGiac tg) {
        if (!kiemTraTamGiacHopLe(tg)) {
            return 0.0;
        }
        double[] canh = layDoDai3CanhTamGiac(tg);
        double c = canh[0], a = canh[1], b = canh[2];
        double p = tinhChuViTamGiac(tg) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void inThongTinTamGiac(String ten, TamGiac tg) {
        double[] canh = layDoDai3CanhTamGiac(tg);
        System.out.printf("  * %s: %s\n", ten, tg);
        System.out.printf("      - Độ dài 3 cạnh : AB = %.2f, BC = %.2f, CA = %.2f\n", canh[0], canh[1], canh[2]);
        System.out.printf("      - Chu vi        : %.2f\n", tinhChuViTamGiac(tg));
        System.out.printf("      - Diện tích     : %.2f (theo công thức Heron)\n", tinhDienTichTamGiac(tg));
    }
}
