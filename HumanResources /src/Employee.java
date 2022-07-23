
public class Employee extends Staff implements ICalculator {
    //Tạo các thuộc tính cho Employee
    private double soGioLamThem;
    public static double luong;
    //Hàm constructor
    public Employee(){}
    public Employee(String maNV, String tenNV, int tuoiNV, double hsLuong, String ngayVaoLam, int soNgayNghi, String boPhanLam, double soGioLamThem, double luong) {
        super(maNV, tenNV, tuoiNV, hsLuong, ngayVaoLam, soNgayNghi, boPhanLam);
        this.soGioLamThem = soGioLamThem;
        this.luong = luong;
    }
    //get và set cho các thuộc tính
    public double getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(double soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    //Hàm Tính Lương cho nhân viên
    @Override
    public double calculateSalary(){
        luong = getHsLuong() * 3000000 + soGioLamThem * 200000;
        return luong;
    }
    //Hiển thị nhân viên công ty
    @Override
    public void displayInformation() {
        System.out.printf("%-12s | %-23s | %-4d | %-10.1f | %-13s | %-15d | %-20s | %-23s | %-15.1f\n",
                getMaNV(),getTenNV(),getTuoiNV(),getHsLuong(),getNgayVaoLam(),getSoNgayNghi(), getBoPhanLam(),
                getSoGioLamThem(),calculateSalary());
    }
}
