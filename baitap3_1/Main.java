package baitap3_1;

/**
 * Lớp Main: Nơi tập trung toàn bộ các hàm xử lý tính toán và điều phối chương trình cho Bài tập 3.1.
 * Giúp người mới bắt đầu dễ dàng quan sát luồng chạy từng bước.
 */
public class Main {

    // =========================================================================
    // 1. HÀM CHÍNH (MAIN): Chạy chương trình từ trên xuống dưới
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     BÀI TẬP 3.1: LỚP ĐIỂM & ĐƯỜNG THẲNG (OOP)   ");
        System.out.println("=================================================");

        // Bước 1: Khởi tạo 2 điểm A và B
        Diem A = new Diem(1.0, 2.0);
        Diem B = new Diem(4.0, 6.0);
        System.out.println("1. Tọa độ ban đầu:");
        System.out.println("   - Điểm A: " + A);
        System.out.println("   - Điểm B: " + B);

        // Bước 2: Tạo đối tượng đường thẳng nối A và B
        DuongThang dt = new DuongThang(A, B);
        System.out.println("\n2. Đã tạo: " + dt);

        // Bước 3: Tính và in độ dài đoạn thẳng AB bằng hàm xử lý trong Main
        // Khoảng cách lý thuyết: sqrt((4 - 1)^2 + (6 - 2)^2) = sqrt(3^2 + 4^2) = 5.0
        double doDai = tinhDoDaiDuongThang(dt);
        System.out.printf("   => Độ dài đoạn thẳng AB: %.2f\n", doDai);

        // Bước 4: Thử nghiệm thay đổi tọa độ điểm A bằng Setter
        System.out.println("\n3. Thử nghiệm đổi tọa độ điểm A về gốc (0.0, 0.0):");
        A.setX(0.0);
        A.setY(0.0);
        System.out.println("   - Tọa độ mới của điểm A: " + dt.getA());

        // Tính lại độ dài mới sau khi đổi tọa độ
        // Khoảng cách mới: sqrt((4 - 0)^2 + (6 - 0)^2) = sqrt(16 + 36) = sqrt(52) ≈ 7.21
        double doDaiMoi = tinhDoDaiDuongThang(dt);
        System.out.printf("   => Độ dài mới của đoạn thẳng AB: %.2f\n", doDaiMoi);

        System.out.println("\n================ Hoàn thành Bài tập 3.1 ================");
    }

    // =========================================================================
    // 2. CÁC HÀM XỬ LÝ TÍNH TOÁN (Được đặt trực tiếp tại Main)
    // =========================================================================

    /**
     * Hàm tính khoảng cách giữa 2 điểm bất kỳ d1 và d2 theo công thức Euclid:
     * d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     */
    public static double tinhKhoangCach(Diem d1, Diem d2) {
        // Lấy tọa độ thông qua Getter của 2 đối tượng Diem
        double x1 = d1.getX();
        double y1 = d1.getY();
        double x2 = d2.getX();
        double y2 = d2.getY();

        // Tính độ lệch
        double dx = x2 - x1;
        double dy = y2 - y1;

        // Áp dụng công thức căn bậc hai của tổng bình phương
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Hàm tính độ dài của một đoạn thẳng:
     * Lấy 2 điểm đầu mút A và B từ đối tượng DuongThang và gọi hàm tinhKhoangCach.
     */
    public static double tinhDoDaiDuongThang(DuongThang dt) {
        return tinhKhoangCach(dt.getA(), dt.getB());
    }
}
