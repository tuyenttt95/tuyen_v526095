package baitap4_2;

import java.util.Locale;
import java.util.Scanner;

/**
 * Lớp NhanVien dẫn xuất (kế thừa) từ lớp Nguoi.
 *
 * Yêu cầu Bài 1 - Buổi 4:
 * - Thuộc tính bổ sung:
 *     + snct: số năm công tác (int)
 *     + hsl:  hệ số lương (double)
 * - Phương thức:
 *     + Tính tiền lương: tienluong = lcb * hsl + phucap
 *       Trong đó: lcb là 1.5 triệu, phucap = 0.2 triệu * snct.
 *     + Ghi đè phương thức nhập, xuất từ lớp Nguoi.
 */
public class NhanVien extends Nguoi {

    // =========================================================================
    // HẰNG SỐ (Constants)
    // =========================================================================
    // Lương cơ bản: 1.5 triệu đồng (1.5)
    public static final double LCB = 1.5;

    // Hệ số phụ cấp thâm niên mỗi năm công tác: 0.2 triệu đồng (0.2)
    public static final double HE_SO_PHU_CAP = 0.2;

    // =========================================================================
    // 1. THUỘC TÍNH BỔ SUNG
    // =========================================================================
    protected int snct;    // Số năm công tác
    protected double hsl;  // Hệ số lương

    // =========================================================================
    // 2. HÀM TẠO (Constructors)
    // =========================================================================

    /**
     * Hàm tạo mặc định không đối số.
     */
    public NhanVien() {
        super();
        this.snct = 0;
        this.hsl = 1.0;
    }

    /**
     * Hàm tạo có tham số, gọi constructor của lớp cha Nguoi bằng từ khóa super.
     *
     * @param hoTen Họ tên
     * @param tuoi  Tuổi
     * @param snct  Số năm công tác
     * @param hsl   Hệ số lương
     */
    public NhanVien(String hoTen, int tuoi, int snct, double hsl) {
        super(hoTen, tuoi);
        this.snct = snct;
        this.hsl = hsl;
    }

    // =========================================================================
    // 3. GETTERS VÀ SETTERS
    // =========================================================================
    public int getSnct() {
        return snct;
    }

    public void setSnct(int snct) {
        this.snct = snct;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    // =========================================================================
    // 4. PHƯƠNG THỨC TÍNH PHỤ CẤP VÀ TIỀN LƯƠNG
    // =========================================================================

    /**
     * Tính phụ cấp theo công thức:
     * phucap = 0.2 triệu * snct (triệu đồng)
     *
     * @return Phụ cấp (triệu đồng)
     */
    public double tinhPhuCap() {
        return HE_SO_PHU_CAP * this.snct;
    }

    /**
     * Tính tiền lương theo công thức:
     * tienluong = lcb * hsl + phucap
     * trong đó: lcb là 1.5 triệu, phucap = 0.2 triệu * snct.
     *
     * @return Tiền lương (triệu đồng)
     */
    public double tinhTienLuong() {
        return LCB * this.hsl + tinhPhuCap();
    }

    /**
     * Alias phương thức tính lương để gọi linh hoạt.
     */
    public double tinhLuong() {
        return tinhTienLuong();
    }

    // =========================================================================
    // 5. GHI ĐÈ PHƯƠNG THỨC NHẬP VÀ XUẤT
    // =========================================================================

    /**
     * Nhập thông tin nhân viên từ bàn phím.
     * Gọi super.nhap(sc) để nhập họ tên và tuổi của lớp Nguoi,
     * sau đó nhập tiếp snct và hsl.
     *
     * @param sc Đối tượng Scanner
     */
    @Override
    public void nhap(Scanner sc) {
        // Gọi nhập của lớp cha Nguoi
        super.nhap(sc);

        // Nhập số năm công tác (snct >= 0)
        System.out.print("  - Nhập số năm công tác (snct): ");
        while (true) {
            try {
                this.snct = Integer.parseInt(sc.nextLine().trim());
                if (this.snct >= 0) {
                    break;
                }
                System.out.print("    Số năm công tác phải >= 0. Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("    Số năm công tác không hợp lệ. Vui lòng nhập số nguyên: ");
            }
        }

        // Nhập hệ số lương (hsl > 0)
        System.out.print("  - Nhập hệ số lương (hsl): ");
        while (true) {
            try {
                this.hsl = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                if (this.hsl > 0) {
                    break;
                }
                System.out.print("    Hệ số lương phải > 0. Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("    Hệ số lương không hợp lệ. Vui lòng nhập số thực (VD: 2.34): ");
            }
        }
    }

    /**
     * Xuất thông tin chi tiết nhân viên ra màn hình dạng dòng.
     */
    @Override
    public void xuat() {
        System.out.printf(Locale.US,
                "%-20s | Tuổi: %2d | SNCT: %2d năm | HSL: %5.2f | Phụ cấp: %5.2f tr | Lương: %6.2f triệu VNĐ%n",
                this.hoTen, this.tuoi, this.snct, this.hsl, tinhPhuCap(), tinhTienLuong());
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "NhanVien [hoTen=%s, tuoi=%d, snct=%d, hsl=%.2f, phuCap=%.2f tr, tienLuong=%.2f tr]",
                hoTen, tuoi, snct, hsl, tinhPhuCap(), tinhTienLuong());
    }
}
