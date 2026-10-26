package baitap2_2;

import java.util.Arrays;

public class Bai2_TongHaiMang {

    public static int[] tinhMangTong(int[] a, int[] b) {
        // 1. Tìm số phần tử lớn hơn giữa 2 mảng
        int maxLen = Math.max(a.length, b.length);

        // 2. Tạo mảng kết quả có kích thước bằng mảng nhiều phần tử hơn
        int[] result = new int[maxLen];

        // 3. Duyệt từ vị trí 0 đến maxLen - 1
        for (int i = 0; i < maxLen; i++) {
            // Nếu i còn nằm trong phạm vi của mảng a thì lấy a[i], ngược lại coi là 0
            int giaTriA = (i < a.length) ? a[i] : 0;

            // Nếu i còn nằm trong phạm vi của mảng b thì lấy b[i], ngược lại coi là 0
            int giaTriB = (i < b.length) ? b[i] : 0;

            // Cộng hai giá trị tương ứng
            result[i] = giaTriA + giaTriB;
        }

        return result;
    }

    public static void inMangTong(int[] a, int[] b) {
        int[] mangTong = tinhMangTong(a, b);

        System.out.println("Mảng A        : " + Arrays.toString(a));
        System.out.println("Mảng B        : " + Arrays.toString(b));
        System.out.println("=> Mảng tổng  : " + Arrays.toString(mangTong));
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== BÀI 2: HÀM CỘNG HAI MẢNG CÓ ĐỘ DÀI KHÁC NHAU ===\n");

        // Ví dụ 1: Mảng A ngắn hơn mảng B
        // a có 3 phần tử, b có 5 phần tử
        int[] a1 = {1, 2, 3};
        int[] b1 = {4, 5, 6, 7, 8};
        System.out.println("Ví dụ 1 (Mảng A ngắn hơn Mảng B):");
        inMangTong(a1, b1);

        // Ví dụ 2: Mảng A dài hơn mảng B
        int[] a2 = {10, 20, 30, 40, 50, 60};
        int[] b2 = {1, 2, 3};
        System.out.println("Ví dụ 2 (Mảng A dài hơn Mảng B):");
        inMangTong(a2, b2);

        // Ví dụ 3: Hai mảng có cùng độ dài
        int[] a3 = {5, 10, 15};
        int[] b3 = {2, 4, 6};
        System.out.println("Ví dụ 3 (Hai mảng bằng nhau):");
        inMangTong(a3, b3);
    }
}
