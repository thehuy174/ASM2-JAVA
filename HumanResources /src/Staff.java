public abstract class Staff {

    //Tạo các thuộc tính cho nhân viên
    private  String maNV;
    private  String tenNV;
    private  int tuoiNV;
    private  double hsLuong;
    private  String ngayVaoLam;
    private  String boPhanLam;
    private  int soNgayNghi;

    //Get và Set cho các thuộc tính của nhân viên
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) { this.maNV = maNV; }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTuoiNV() {
        return tuoiNV;
    }

    public void setTuoiNV(int tuoiNV) {
        this.tuoiNV = tuoiNV;
    }

    public double getHsLuong() {
        return hsLuong;
    }

    public void setHsLuong(double hsLuong) {
        this.hsLuong = hsLuong;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getBoPhanLam() {
        return boPhanLam;
    }

    public void setBoPhanLam(String boPhanLam) {
        this.boPhanLam = boPhanLam;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    //Gọi hàm constructor cho lớp Staff
    public Staff() {
    }
    public Staff(String maNV, String tenNV, int tuoiNV, double hsLuong,
                 String ngayVaoLam, int soNgayNghi, String boPhanLam) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tuoiNV = tuoiNV;
        this.hsLuong = hsLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLam = boPhanLam;
        this.soNgayNghi = soNgayNghi;
    }
    //Tạo abstract displayInformation()
    public abstract void displayInformation();
}
