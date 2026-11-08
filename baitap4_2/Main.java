package baitap4_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Lớp Main cho Bài tập 4.2: Kế thừa lớp Nguoi và NhanVien.
 *
 * Yêu cầu:
 * 1. Nhập vào n nhân viên.
 * 2. Tìm nhân viên có số năm công tác (snct) nhiều nhất.
 * 3. In danh sách nhân viên theo thứ tự lương từ cao đến thấp.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<NhanVien> dsNhanVien = new ArrayList<>();

        System.out.println("=========================================================================================");
        System.out.println("          BÀI TẬP 4.2: QUẢN LÝ NHÂN VIÊN (KẾ THỪA LỚP NGUOI VÀ NHANVIEN)                 ");
        System.out.println("=========================================================================================\n");

        System.out.println("Chọn chế độ nhập dữ liệu:");
        System.out.println("  1. Nhập danh sách nhân viên từ bàn phím");
        System.out.println("  2. Khởi tạo dữ liệu mẫu sẵn có để kiểm tra nhanh");
        System.out.print("Lựa chọn của bạn (1 hoặc 2, mặc định là 1): ");

        String luaChon = sc.nextLine().trim();

        if ("2".equals(luaChon)) {
            // Khởi tạo dữ liệu mẫu phong phú để kiểm tra
            dsNhanVien.add(new NhanVien("Nguyễn Văn An", 28, 3, 2.34));
            dsNhanVien.add(new NhanVien("Trần Thị Bình", 35, 10, 4.00));
            dsNhanVien.add(new NhanVien("Lê Hoàng Cường", 42, 15, 4.98));
            dsNhanVien.add(new NhanVien("Phạm Thu Dung", 45, 15, 5.32));
            dsNhanVien.add(new NhanVien("Vũ Minh Đức", 24, 1, 1.86));
            System.out.println("\n>>> Đã nạp thành công 5 nhân viên mẫu vào hệ thống!");
        } else {
            // -----------------------------------------------------------------
            // 1. NHẬP VÀO n NHÂN VIÊN TỪ BÀN PHÍM
            // -----------------------------------------------------------------
            int n = 0;
            System.out.print("\nNhập số lượng nhân viên n: ");
            while (true) {
                try {
                    n = Integer.parseInt(sc.nextLine().trim());
                    if (n > 0) {
                        break;
                    }
                    System.out.print("Số lượng nhân viên phải là số nguyên > 0. Vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Định dạng không hợp lệ. Vui lòng nhập số nguyên: ");
                }
            }

            System.out.println("\n>>> TIẾN HÀNH NHẬP THÔNG TIN CHO " + n + " NHÂN VIÊN:");
            for (int i = 0; i < n; i++) {
                System.out.println("\n[Nhân viên " + (i + 1) + "/" + n + "]:");
                NhanVien nv = new NhanVien();
                nv.nhap(sc);
                dsNhanVien.add(nv);
            }
        }

        // Hiển thị danh sách nhân viên vừa nhập
        System.out.println("\n=========================================================================================");
        System.out.println("                      DANH SÁCH NHÂN VIÊN BAN ĐẦU                                        ");
        System.out.println("=========================================================================================");
        inBangDanhSach(dsNhanVien);

        // ---------------------------------------------------------------------
        // 2. TÌM NHÂN VIÊN CÓ SỐ NĂM CÔNG TÁC (snct) NHIỀU NHẤT
        // ---------------------------------------------------------------------
        System.out.println("\n=========================================================================================");
        System.out.println("                 NHÂN VIÊN CÓ SỐ NĂM CÔNG TÁC NHIỀU NHẤT                                 ");
        System.out.println("=========================================================================================");

        if (dsNhanVien.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
        } else {
            // Tìm giá trị snct lớn nhất
            int maxSnct = dsNhanVien.get(0).getSnct();
            for (NhanVien nv : dsNhanVien) {
                if (nv.getSnct() > maxSnct) {
                    maxSnct = nv.getSnct();
                }
            }

            // Lấy tất cả nhân viên đạt maxSnct (xử lý trường hợp có nhiều người cùng có số năm công tác cao nhất)
            List<NhanVien> dsMaxSnct = new ArrayList<>();
            for (NhanVien nv : dsNhanVien) {
                if (nv.getSnct() == maxSnct) {
                    dsMaxSnct.add(nv);
                }
            }

            System.out.printf(Locale.US, ">>> Số năm công tác nhiều nhất là: %d năm (Có %d nhân viên đạt được):%n",
                    maxSnct, dsMaxSnct.size());
            inBangDanhSach(dsMaxSnct);
        }

        // ---------------------------------------------------------------------
        // 3. IN DANH SÁCH NHÂN VIÊN THEO THỨ TỰ LƯƠNG TỪ CAO ĐẾN THẤP
        // ---------------------------------------------------------------------
        System.out.println("\n=========================================================================================");
        System.out.println("          DANH SÁCH NHÂN VIÊN SẮP XẾP THEO THỨ TỰ LƯƠNG TỪ CAO ĐẾN THẤP                  ");
        System.out.println("=========================================================================================");

        // Sắp xếp giảm dần theo tiền lương: nv2.tinhTienLuong() so với nv1.tinhTienLuong()
        dsNhanVien.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return Double.compare(nv2.tinhTienLuong(), nv1.tinhTienLuong());
            }
        });

        inBangDanhSach(dsNhanVien);

        System.out.println("\n=========================================================================================");
        System.out.println("                                HOÀN THÀNH CHƯƠNG TRÌNH                                  ");
        System.out.println("=========================================================================================");
    }

    /**
     * In danh sách nhân viên dưới dạng bảng định dạng chuẩn và dễ theo dõi.
     *
     * @param ds Danh sách nhân viên cần hiển thị
     */
    public static void inBangDanhSach(List<NhanVien> ds) {
        if (ds == null || ds.isEmpty()) {
            System.out.println("  (Không có dữ liệu nhân viên để hiển thị)");
            return;
        }

        String dinhDangTieuDe = "| %-4s | %-22s | %-5s | %-15s | %-6s | %-15s | %-18s |%n";
        String dinhDangHang   = "| %-4d | %-22s | %-5d | %-15s | %-6.2f | %-15.2f | %-18.2f |%n";
        String duongKeNgang   = "+------+------------------------+-------+-----------------+--------+-----------------+--------------------+";

        System.out.println(duongKeNgang);
        System.out.printf(dinhDangTieuDe, "STT", "Họ và tên", "Tuổi", "Số năm CT (năm)", "HSL", "Phụ cấp (tr.VNĐ)", "Tiền lương (tr.VNĐ)");
        System.out.println(duongKeNgang);

        int stt = 1;
        for (NhanVien nv : ds) {
            System.out.printf(Locale.US, dinhDangHang,
                    stt++,
                    nv.getHoTen(),
                    nv.getTuoi(),
                    nv.getSnct() + " năm",
                    nv.getHsl(),
                    nv.tinhPhuCap(),
                    nv.tinhTienLuong());
        }
        System.out.println(duongKeNgang);
    }
}
