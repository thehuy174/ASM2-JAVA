public class Department {
    //Tạo các thuộc tính cho Department
    private String maBoPhan;
    private String tenBoPhan;
    private int soLuongNV ;
    static int count = 0;
    public Department(){}
    public Department(String maBoPhan, String tenBoPhan, int soLuongNV) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNV = soLuongNV;
    }
    //Get và Set cho các thuộc tính của Department
    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoLuongNV() {
        return soLuongNV;
    }

    public void setSoLuongNV(int soLuongNV) {
        this.soLuongNV = soLuongNV;
    }
    //Hàm toString hiển thị thông tin về bộ phận công ty
    @Override
    public String toString() {
        return String.format("%-15s | %-25s | %-30s", maBoPhan, tenBoPhan, soLuongNV);
    }
}
