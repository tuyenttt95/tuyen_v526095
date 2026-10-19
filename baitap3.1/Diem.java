package baitap1;

public class Diem {
    private double x; // Hoành độ
    private double y; // Tung độ

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Khởi tạo điểm mặc định tại gốc tọa độ (0, 0)
    public Diem() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // GETTER VÀ SETTER
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // PHƯƠNG THỨC TÍNH TOÁN
    // Tính khoảng cách từ điểm hiện tại (this) tới một điểm khác (other)
    // Công thức toán học: d = sqrt((x2 - x1)^2 + (y2 - y1)^2) 
    public double tinhKhoangCach(Diem other) {
        double deltaX = other.x - this.x;
        double deltaY = other.y - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Phương thức chuyển thông tin điểm thành dạng chuỗi để in ra màn hình: (x, y)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
