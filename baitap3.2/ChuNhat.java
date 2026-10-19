package baitap2;

public class ChuNhat {
    // 1. THUỘC TÍNH
    private double chieuDai;
    private double chieuRong;

    // 2. HÀM TẠO (Constructor) nhận vào độ dài 2 cạnh
    public ChuNhat(double chieuDai, double chieuRong) {
        // Đảm bảo kích thước không âm (kiểm tra an toàn)
        this.chieuDai = Math.max(0, chieuDai);
        this.chieuRong = Math.max(0, chieuRong);
    }

    // 3. GETTER VÀ SETTER
    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = Math.max(0, chieuDai);
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = Math.max(0, chieuRong);
    }

    // 4. PHƯƠNG THỨC TÍNH CHU VI
    // Công thức: Chu vi = (chiều dài + chiều rộng) * 2
    public double tinhChuVi() {
        return (chieuDai + chieuRong) * 2;
    }

    // 5. PHƯƠNG THỨC TÍNH DIỆN TÍCH
    // Công thức: Diện tích = chiều dài * chiều rộng
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    @Override
    public String toString() {
        return "ChuNhat[Dài=" + chieuDai + ", Rộng=" + chieuRong + "]";
    }
}
