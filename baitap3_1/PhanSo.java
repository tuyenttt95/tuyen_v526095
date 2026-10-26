package baitap3_1;

/**
 * Lớp PhanSo biểu diễn một phân số P = T / M (Tử số / Mẫu số).
 *
 * Yêu cầu bài tập 1 - buổi 3:
 * - Định nghĩa các thuộc tính của lớp phân số.
 * - Xây dựng các hàm tạo: mặc định, có đối.
 * - Xây dựng các hàm getters, setters và hàm toString.
 * - Xây dựng hàm riêng:
 *     + Tính tổng, hiệu, tích, thương của 2 phân số.
 *     + So sánh 2 phân số.
 *     + Rút gọn phân số.
 */
public class PhanSo {
    // =========================================================================
    // 1. THUỘC TÍNH (Private - Đảm bảo tính đóng gói)
    // =========================================================================
    private int tuSo;  // Tử số (T)
    private int mauSo; // Mẫu số (M), luôn khác 0

    // =========================================================================
    // 2. HÀM TẠO (Constructor)
    // =========================================================================

    // Hàm tạo mặc định: phân số 0/1
    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    // Hàm tạo có đối: nhận vào tử số và mẫu số
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        // Mẫu số không được bằng 0; nếu bằng 0 thì gán mặc định là 1
        setMauSo(mauSo);
    }

    // =========================================================================
    // 3. GETTER VÀ SETTER
    // =========================================================================
    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        // Bảo vệ: mẫu số không được phép bằng 0
        if (mauSo == 0) {
            System.out.println("  [Cảnh báo] Mẫu số không được bằng 0. Đã gán mẫu số = 1.");
            this.mauSo = 1;
        } else {
            this.mauSo = mauSo;
        }
    }

    // =========================================================================
    // 4. PHƯƠNG THỨC toString()
    // =========================================================================
    @Override
    public String toString() {
        if (mauSo == 1) {
            return String.valueOf(tuSo);
        }
        return tuSo + "/" + mauSo;
    }

    // =========================================================================
    // 5. CÁC HÀM RIÊNG (Xử lý nghiệp vụ trên phân số)
    // =========================================================================

    /**
     * Tính ước số chung lớn nhất (USCLN) của 2 số nguyên bằng thuật toán Euclid.
     * Dùng cho việc rút gọn phân số.
     */
    private int uscln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 0 ? 1 : a;
    }

    /**
     * Rút gọn phân số về dạng tối giản.
     * - Chia cả tử và mẫu cho USCLN.
     * - Đưa dấu âm lên tử số (nếu mẫu số âm).
     * Trả về chính phân số này để có thể gọi nối tiếp.
     */
    public PhanSo rutGon() {
        // Trường hợp tử số bằng 0 thì chuẩn hóa về 0/1
        if (tuSo == 0) {
            mauSo = 1;
            return this;
        }
        int uoc = uscln(tuSo, mauSo);
        tuSo /= uoc;
        mauSo /= uoc;
        // Chuẩn hóa dấu: nếu mẫu số âm, đổi dấu cả tử và mẫu
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        return this;
    }

    /**
     * Tính TỔNG của phân số hiện tại và phân số p.
     * a/b + c/d = (a*d + c*b) / (b*d)
     * Kết quả được rút gọn.
     */
    public PhanSo cong(PhanSo p) {
        int tu = this.tuSo * p.mauSo + p.tuSo * this.mauSo;
        int mau = this.mauSo * p.mauSo;
        return new PhanSo(tu, mau).rutGon();
    }

    /**
     * Tính HIỆU của phân số hiện tại và phân số p.
     * a/b - c/d = (a*d - c*b) / (b*d)
     */
    public PhanSo tru(PhanSo p) {
        int tu = this.tuSo * p.mauSo - p.tuSo * this.mauSo;
        int mau = this.mauSo * p.mauSo;
        return new PhanSo(tu, mau).rutGon();
    }

    /**
     * Tính TÍCH của phân số hiện tại và phân số p.
     * a/b * c/d = (a*c) / (b*d)
     */
    public PhanSo nhan(PhanSo p) {
        int tu = this.tuSo * p.tuSo;
        int mau = this.mauSo * p.mauSo;
        return new PhanSo(tu, mau).rutGon();
    }

    /**
     * Tính THƯƠNG của phân số hiện tại và phân số p.
     * a/b : c/d = (a*d) / (b*c)
     */
    public PhanSo chia(PhanSo p) {
        if (p.tuSo == 0) {
            System.out.println("  [Lỗi] Không thể chia cho phân số bằng 0.");
            return new PhanSo();
        }
        int tu = this.tuSo * p.mauSo;
        int mau = this.mauSo * p.tuSo;
        return new PhanSo(tu, mau).rutGon();
    }

    /**
     * SO SÁNH phân số hiện tại với phân số p.
     * So sánh a/b và c/d bằng cách so sánh tích chéo a*d với c*b.
     * (có quy đồng dấu mẫu số để tránh sai lệch khi mẫu âm)
     * @return  1 nếu lớn hơn, -1 nếu nhỏ hơn, 0 nếu bằng p.
     */
    public int soSanh(PhanSo p) {
        // Đảm bảo mẫu số dương để phép so sánh tích chéo đúng dấu
        int a = this.tuSo, b = this.mauSo;
        int c = p.tuSo, d = p.mauSo;
        if (b < 0) { a = -a; b = -b; }
        if (d < 0) { c = -c; d = -d; }

        long trai = (long) a * d;
        long phai = (long) c * b;
        if (trai > phai) return 1;
        if (trai < phai) return -1;
        return 0;
    }

    /**
     * Kiểm tra phân số có phải là số nguyên hay không.
     * Phân số là số nguyên khi tử số chia hết cho mẫu số.
     */
    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }
}
