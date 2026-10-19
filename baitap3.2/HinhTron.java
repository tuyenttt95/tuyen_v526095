package baitap2;

/**
 * Lớp HinhTron biểu diễn hình tròn trong mặt phẳng tọa độ Oxy.
 * Hình tròn được xác định bởi:
 * - Điểm tâm O (đối tượng kiểu Diem)
 * - Bán kính r (kiểu double)
 */
public class HinhTron {
    // 1. THUỘC TÍNH
    private Diem O;          // Tâm hình tròn
    private double banKinh;  // Bán kính r

    // 2. HÀM TẠO (Constructor) nhận vào tâm O và bán kính
    public HinhTron(Diem O, double banKinh) {
        this.O = O;
        this.banKinh = Math.max(0, banKinh);
    }

    // 3. GETTER VÀ SETTER
    public Diem getO() {
        return O;
    }

    public void setO(Diem O) {
        this.O = O;
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = Math.max(0, banKinh);
    }

    // 4. PHƯƠNG THỨC TÍNH CHU VI
    // Công thức: C = 2 * PI * r
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    // 5. PHƯƠNG THỨC TÍNH DIỆN TÍCH
    // Công thức: S = PI * r^2
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }

    @Override
    public String toString() {
        return "HinhTron[Tâm=" + O + ", Bán kính=" + banKinh + "]";
    }
}
