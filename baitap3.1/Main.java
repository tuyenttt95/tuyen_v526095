package baitap1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          BÀI TẬP 1: LỚP ĐIỂM & ĐƯỜNG THẲNG      ");
        System.out.println("=================================================");

        // Bước 1: Khởi tạo 2 đối tượng Điểm bằng hàm tạo có tham số
        // Điểm A có tọa độ (1, 2)
        Diem A = new Diem(1.0, 2.0);
        // Điểm B có tọa độ (4, 6)
        Diem B = new Diem(4.0, 6.0);

        // In thông tin tọa độ của A và B (nhờ phương thức toString trong Diem)
        System.out.println("1. Tọa độ điểm A ban đầu : " + A);
        System.out.println("   Tọa độ điểm B ban đầu : " + B);

        // Bước 2: Khởi tạo đường thẳng AB nhận vào 2 đối tượng A và B
        DuongThang dt = new DuongThang(A, B);
        System.out.println("\n2. Đã khởi tạo: " + dt);

        // Bước 3: Gọi phương thức tính độ dài đường thẳng
        // Khoảng cách theo lý thuyết: sqrt((4 - 1)^2 + (6 - 2)^2) = sqrt(3^2 + 4^2) = 5.0
        double doDai = dt.tinhDoDai();
        System.out.printf("   => Độ dài đường thẳng AB là: %.2f\n", doDai);

        // Bước 4: Getter và Setter
        System.out.println("\n3. Thử nghiệm thay đổi tọa độ điểm A bằng Setter:");
        A.setX(0.0);
        A.setY(0.0);
        System.out.println("   Tọa độ mới của điểm A: " + dt.getA());
        System.out.printf("   => Độ dài mới của đoạn thẳng AB: %.2f\n", dt.tinhDoDai());

        System.out.println("\n================ Hoàn thành Bài tập 1 ================");
    }
}
