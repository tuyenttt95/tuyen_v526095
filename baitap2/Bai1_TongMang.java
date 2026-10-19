package baitap2;

import java.util.Arrays;
import java.util.Scanner;

public class Bai1_TongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BÀI 1: NHẬP MẢNG N PHẦN TỬ VÀ TÍNH TỔNG ===");

        // Bước 1: Nhập số lượng phần tử n
        System.out.print("Nhập số lượng phần tử của mảng (n): ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện n phải dương
        while (n <= 0) {
            System.out.print("Số phần tử n phải lớn hơn 0. Vui lòng nhập lại: ");
            n = scanner.nextInt();
        }

        // Bước 2: Khai báo và cấp phát bộ nhớ cho mảng có n phần tử
        int[] arr = new int[n];

        // Bước 3: Dùng vòng lặp for để nhập từng phần tử
        System.out.println("\nNhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = scanner.nextInt();
        }

        // Bước 4: Tính tổng các phần tử trong mảng
        long tong = 0; // Dùng kiểu long để tránh tràn số nếu tổng các số quá lớn
        for (int i = 0; i < n; i++) {
            tong += arr[i];
        }

        // Bước 5: In kết quả mảng và tổng ra màn hình
        System.out.println("\n-------------------------------------------");
        System.out.println("Mảng vừa nhập: " + Arrays.toString(arr));
        System.out.println("Tổng các phần tử trong mảng: " + tong);
        System.out.println("-------------------------------------------");

        scanner.close();
    }
}
