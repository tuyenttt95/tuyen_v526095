package baitap2;

public class Diem {
    private double x;
    private double y;

    // Hàm tạo nhận vào tọa độ x và y
    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Hàm tạo mặc định tại gốc tọa độ (0, 0)
    public Diem() {
        this.x = 0.0;
        this.y = 0.0;
    }

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

    // Tính khoảng cách giữa điểm hiện tại (this) và điểm đích (other)
    public double tinhKhoangCach(Diem other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
