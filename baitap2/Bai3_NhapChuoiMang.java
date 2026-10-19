package baitap2;

import java.util.Scanner;

/**
 * BÀI 3:
 * Viết chương trình cho phép người dùng nhập vào 1 mảng các số nguyên bằng 1 chuỗi duy nhất
 * với các phần tử cách nhau bởi dấu cách " ".
 * In ra số phần tử và tổng các phần tử.
 * 
 * Ví dụ đề bài:
 * Người dùng nhập: "3 4 5 33 554 67 23 6 8 5"
 * In ra: Số phần tử: 10; Tổng: 708
 */
public class Bai3_NhapChuoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BÀI 3: NHẬP MẢNG TỪ CHUỖI CÁCH NHAU BỞI DẤU CÁCH ===");
        System.out.println("Nhập các số nguyên trên cùng một dòng (cách nhau bởi dấu cách):");
        System.out.print("Ví dụ: 3 4 5 33 554 67 23 6 8 5\nNhập tại đây: ");

        // 1. Đọc toàn bộ dòng người dùng nhập vào
        String line = scanner.nextLine().trim();

        // Kiểm tra trường hợp người dùng không nhập gì mà bấm Enter ngay
        if (line.isEmpty()) {
            System.out.println("\nKết quả:");
            System.out.println("Số phần tử: 0; Tổng: 0");
            scanner.close();
            return;
        }

        // 2. Tách chuỗi thành mảng các chuỗi con bằng split("\\s+")
        // "\\s+" là biểu thức chính quy đại diện cho một hoặc nhiều khoảng trắng liên tiếp.
        // Điều này giúp code chạy đúng ngay cả khi người dùng lỡ tay gõ 2 hoặc 3 dấu cách giữa các số.
        String[] tokens = line.split("\\s+");

        // 3. Khởi tạo mảng số nguyên để lưu các giá trị chuyển đổi
        int soPhanTu = tokens.length;
        int[] mangSo = new int[soPhanTu];
        long tong = 0; // Dùng long để tránh tràn số

        // 4. Duyệt qua từng chuỗi, chuyển đổi (parse) sang kiểu int và cộng dồn
        for (int i = 0; i < soPhanTu; i++) {
            mangSo[i] = Integer.parseInt(tokens[i]);
            tong += mangSo[i];
        }

        // 5. In kết quả theo đúng định dạng mẫu của đề bài:
        // "Số phần tử: 10; Tổng: 708"
        System.out.println("\n-------------------------------------------");
        System.out.printf("Số phần tử: %d; Tổng: %d\n", soPhanTu, tong);
        System.out.println("-------------------------------------------");

        scanner.close();
    }
}
