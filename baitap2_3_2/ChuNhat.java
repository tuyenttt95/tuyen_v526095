package baitap2_3_2;

/**
 * Lớp ChuNhat biểu diễn một hình chữ nhật với chiều dài và chiều rộng.
 * Đóng vai trò là lớp lưu trữ dữ liệu (Data Model) thuần túy:
 * - Thuộc tính chieuDai, chieuRong
 * - Hàm tạo (Constructor)
 * - Getter và Setter
 * - Phương thức toString()
 */
public class ChuNhat {
    // 1. THUỘC TÍNH
    private double chieuDai;
    private double chieuRong;

    // 2. HÀM TẠO (Constructor)
    public ChuNhat(double chieuDai, double chieuRong) {
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

    // 4. PHƯƠNG THỨC CHUYỂN THÀNH CHUỖI ĐỂ IN
    @Override
    public String toString() {
        return "ChuNhat[Dài=" + chieuDai + ", Rộng=" + chieuRong + "]";
    }
}
