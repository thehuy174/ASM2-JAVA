
public class Manager extends Staff implements ICalculator{
    //Tạo các thuộc tính cho Manager
    private String chucVu;
   public static double luong;

   //Hàm constructor
    public Manager(){}
    public Manager(String maNV, String tenNV, int tuoiNV, double hsLuong, String ngayVaoLam, int soNgayNghi, String boPhanLam, String chucVu, double luong) {
        super(maNV, tenNV, tuoiNV, hsLuong, ngayVaoLam, soNgayNghi, boPhanLam);
        this.chucVu = chucVu;
        this.luong = luong;
    }
    //get và set cho các thuộc tính
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    //Hàm tính lương nhân viên quản lý
    @Override
    public double calculateSalary() {
        if(chucVu.equalsIgnoreCase("Business Leader")){
            luong = getHsLuong() * 5000000 + ICalculator.BUSINESS_LEADER;
        }else if (chucVu.equalsIgnoreCase("Project Leader")){
            luong = getHsLuong() * 5000000 + ICalculator.PROJECT_LEADER;
        }else if (chucVu.equalsIgnoreCase("Technical Leader")){
            luong = getHsLuong() * 5000000 + ICalculator.TECHNICAL_LEADER;
        }
        return luong;
    }
    //Hiển thị thông tin quản lý
    @Override
    public void displayInformation() {
        System.out.printf("%-12s | %-23s | %-4d | %-10.1f | %-13s | %-15d | %-20s | %-23s | %-15.1f\n",getMaNV(),
                getTenNV(),getTuoiNV(),getHsLuong(),getNgayVaoLam(),getSoNgayNghi(),getBoPhanLam(),getChucVu(),
                calculateSalary());
    }
}
