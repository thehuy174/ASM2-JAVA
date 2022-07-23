import java.util.*;

public class HumanResources {
    //Khai báo ArrayList để lưu nhân viên và bộ phận trong công ty
    static ArrayList<Staff> StaffList = new ArrayList<Staff>();
    static ArrayList<Department> DepartmentList = new ArrayList<Department>();

    //Khai báo biến và các object
    static int chonBoPhan;
    static Scanner input = new Scanner(System.in);
    static Employee employee = new Employee();
    static Manager manager = new Manager();

    // Hàm main xử lý luồng chính của chương trình
    public static void main(String[] args) {
        //List danh sách nhân viên, bộ phận
        nhanVien();
        boPhan();
        //Hiển thị chương trình
        menu();
    }
    //Hàm hiển thị lựa chọn
    public static void menu(){
        do {
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty: ");
            System.out.println("2. Hiển thị các bộ phận trong công ty: ");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận: ");
            System.out.println("4. Thêm nhân viên mới vào công ty: ");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên: ");
            System.out.println("6. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần: ");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần: ");
            System.out.println("8. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = input.nextInt();
            // Chức năng 1 Hiển thị danh sách nhân viên
            if(luaChon == 1){
                System.out.println();
                System.out.printf("%-12s | %-23s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %-15s\n",
                        "Mã nhân viên","Tên nhân viên","Tuổi","HS Luong","Ngày vào làm","Ngày nghỉ phép",
                        "Bộ phận","Số giờ làm thêm/Chức vụ","Lương");
                System.out.println("-----------------------------------------------------------------------------------" +
                        "-------------------------------------------------------------------------------");
                inDanhSach();
                System.out.println("-----------------------------------------------------------------------------------" +
                        "-------------------------------------------------------------------------------");
                System.out.println();
                // Chức năng 2 Hiển thị các bộ phận trong công ty
            }else if(luaChon == 2){
                System.out.println();
                System.out.printf("%-15s | %-25s | %-35s\n","Mã bộ phận", "Tên bộ phận", "Số lượng nhân viên hiện tại");
                System.out.println("------------------------------------------------------------------");
                inBoPhan();
                System.out.println();
                // Chức năng 3 Hiển thị nhân viên theo bộ phận
            }else if(luaChon == 3){
                inNhanVienTheoBoPhan();
                // Chức năng 4 Thêm nhân viên
            }else if(luaChon == 4){
                addNhanVien();
                //Chức năng 5 tìm kiếm nhân viên
            }else if (luaChon == 5){
                timKiemNhanVien();
                //Chức năng 6 sắp xếp lương giảm dần
            }else if (luaChon == 6){
                sapXepLuongGiamDan();
                //Chức năng 7 sắp xếp lương tăng dần
            }else if (luaChon == 7){
                sapXepLuongTangDan();
            }else {
                return;
            }
        }while(true);
    }
    //Hàm nhận dữ liệu từ bàn phím và thêm nhân viên và bộ phận trong công ty vào ArrayList
    public static void addNhanVien(){
        System.out.println("1. Thêm nhân viên thông thường: ");
        System.out.println("2. Thêm nhân viên là cấp quản lý ( có thêm chức vụ ): ");
        System.out.print("Bạn chọn: ");
        int chon = input.nextInt();
        input.nextLine();
        if(chon == 1){ // Thêm nhân viên thông thường
            System.out.print("Nhập mã nhân viên: ");
            employee.setMaNV(input.nextLine());
            System.out.print("Nhập tên nhân viên: " );
            employee.setTenNV(input.nextLine());
            System.out.print("Nhập tuối nhân viên: ");
            employee.setTuoiNV(input.nextInt());
            System.out.print("Nhập hệ số lương của nhân viên: ");
            employee.setHsLuong(input.nextDouble());
            System.out.print("Nhập ngày vào làm của nhân viên: ");
            employee.setNgayVaoLam(input.next());
            System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
            employee.setSoNgayNghi(input.nextInt());
            System.out.println("1. HC - Hành chính nhân sự ");
            System.out.println("2. IT - Công nghệ thông tin ");
            System.out.println("3. MKT - Marketing ");
            System.out.print("Bạn chọn bộ phận: ");
            chonBoPhan = input.nextInt();
            if (chonBoPhan == 1){
                employee.setBoPhanLam("Hành chính nhân sự");
            }else if (chonBoPhan == 2) {
                employee.setBoPhanLam("Công nghệ thông tin");
            }else {
                employee.setBoPhanLam("Marketing");
            }
            System.out.print("Nhập số giờ làm thêm: ");
            employee.setSoGioLamThem(input.nextDouble());
            StaffList.add(employee);
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            //Tăng tổng số nhân viên trong từng bộ phận
            for (Staff x : StaffList) {
                if (x.getBoPhanLam().equalsIgnoreCase("Công nghệ thông tin")) {
                    sum1++;
                }
                if (x.getBoPhanLam().equalsIgnoreCase("Marketing")) {
                    sum2++;
                }
                if (x.getBoPhanLam().equalsIgnoreCase("Hành chính nhân sự")) {
                    sum3++;
                }
            }
            //Tạo ra các bộ phận của công ty
            Department it = new Department("IT","Công nghệ thông tin",sum1);
            Department mkt = new Department("MKT","Marketing",sum2);
            Department hc = new Department("HC","Hành chính nhân sự",sum3);
            DepartmentList.removeAll(DepartmentList); // Xoá phần tử trong danh sách
            //Thêm các bộ phận vào ArrayList
            DepartmentList.add(it);
            DepartmentList.add(mkt);
            DepartmentList.add(hc);
        }else if(chon == 2){ // Thêm nhân viên quản lý
            System.out.print("Nhập mã nhân viên: ");
            manager.setMaNV(input.nextLine());
            System.out.print("Nhập tên nhân viên: " );
            manager.setTenNV(input.nextLine());
            System.out.print("Nhập tuối nhân viên: ");
            manager.setTuoiNV(input.nextInt());
            System.out.print("Nhập hệ số lương của nhân viên: ");
            manager.setHsLuong(input.nextDouble());
            System.out.print("Nhập ngày vào làm của nhân viên: ");
            manager.setNgayVaoLam(input.next());
            System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
            manager.setSoNgayNghi(input.nextInt());
            System.out.println("1. HC - Hành chính nhân sự ");
            System.out.println("2. IT - Công nghệ thông tin ");
            System.out.println("3. MKT - Marketing ");
            System.out.print("Bạn chọn bộ phận: ");
            chonBoPhan = input.nextInt();
            if (chonBoPhan == 1){
                manager.setBoPhanLam("Hành chính nhân sự");
            }else if (chonBoPhan == 2) {
                manager.setBoPhanLam("Công nghệ thông tin");
            }else {
                manager.setBoPhanLam("Marketing");
            }
            System.out.println("Chức danh: ");
            System.out.println("1. Business Leader ");
            System.out.println("2. Project Leader ");
            System.out.println("3. Technical Leader");
            System.out.print("Nhập chức danh: ");
            int chonChucDanh = input.nextInt();
            if (chonChucDanh == 1){
                manager.setChucVu("Business Leader");
            }else if (chonChucDanh == 2){
                manager.setChucVu("Project Leader");
            }else {
                manager.setChucVu("Technical Leader");
            }
            StaffList.add(manager);
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            //Tăng tổng số nhân viên trong từng bộ phận
            for (Staff x : StaffList) {
                if (x.getBoPhanLam().equalsIgnoreCase("Công nghệ thông tin")) {
                    sum1++;
                }
                if (x.getBoPhanLam().equalsIgnoreCase("Marketing")) {
                    sum2++;
                }
                if (x.getBoPhanLam().equalsIgnoreCase("Hành chính nhân sự")) {
                    sum3++;
                }
            }
            //Tạo ra các bộ phận của công ty
            Department it = new Department("IT","Công nghệ thông tin",sum1);
            Department mkt = new Department("MKT","Marketing",sum2);
            Department hc = new Department("HC","Hành chính nhân sự",sum3);
            DepartmentList.removeAll(DepartmentList); // Xoá phần tử trong danh sách
            //Thêm các bộ phận vào ArrayList
            DepartmentList.add(it);
            DepartmentList.add(mkt);
            DepartmentList.add(hc);
        }
    }
    //Hàm tìm kiếm nhân viên
    public static  void timKiemNhanVien(){
        //Nhận dữ liệu từ bàn phím
        System.out.println("1. Tìm nhân viên bằng tên: ");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên: ");
        System.out.print("Bạn chọn: ");
        int chon = input.nextInt();
        input.nextLine();
        String timKiem;
        if (chon == 1 ) { //tìm nhân viên bằng tên
            System.out.print("Nhập tên nhân viên cần tìm: ");
            timKiem = input.nextLine();
            StaffList.forEach(x -> { //Lặp qua danh sách và tìm kiếm sau đó in ra consle
                if (x.getTenNV().contains(timKiem) || x.getTenNV().equalsIgnoreCase(timKiem)
                || x.getTenNV().toLowerCase().contains(timKiem) || x.getTenNV().toLowerCase().equalsIgnoreCase(timKiem)) {
                    System.out.println();
                    System.out.printf("%-12s | %-23s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %-15s\n",
                            "Mã nhân viên","Tên nhân viên","Tuổi","HS Luong","Ngày vào làm","Ngày nghỉ phép",
                            "Bộ phận","Số giờ làm thêm/Chức vụ","Lương");
                    System.out.println("-----------------------------------------------------------------------------------" +
                            "-------------------------------------------------------------------------------");
                    x.displayInformation();
                    System.out.println("-----------------------------------------------------------------------------------" +
                            "-------------------------------------------------------------------------------");
                    System.out.println();
                    return;
                }else {
                    return;
                }
            });
        }else if (chon == 2 ) { //Tìm kiếm nhân viên bằng mã nhân viên
            System.out.print("Nhập mã nhân viên cần tìm: ");
            timKiem = input.nextLine();
            StaffList.forEach(x -> { //Lặp qua danh sách và tìm kiếm sau đó in ra console
                if(x.getMaNV().contains(timKiem) || x.getMaNV().equalsIgnoreCase(timKiem)
                        || x.getMaNV().toLowerCase().contains(timKiem) || x.getMaNV().toLowerCase().equalsIgnoreCase(timKiem)){
                    System.out.println();
                    System.out.printf("%-12s | %-23s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %-15s\n",
                            "Mã nhân viên","Tên nhân viên","Tuổi","HS Luong","Ngày vào làm","Ngày nghỉ phép",
                            "Bộ phận","Số giờ làm thêm/Chức vụ","Lương");
                    System.out.println("-----------------------------------------------------------------------------------" +
                            "-----------------------------------------------------------------------------------------");
                    x.displayInformation();
                    System.out.println("-----------------------------------------------------------------------------------" +
                            "-----------------------------------------------------------------------------------------");
                    System.out.println();
                    return;
                }else {
                    return;
                }
            });
        }
    }
    //Hàm tạo danh sách nhân viên và quản lý
    public static void nhanVien(){
        //Danh sách nhân viên
        Employee nv1 = new Employee("E001", "Phong Tuyết Hoa", 28, 3.2 ,"10/01/2010", 10, "Hành chính nhân sự", 4.0, 10400000.0);
        Employee nv2 = new Employee("E002","Trần Thị Bảo",24,2.2,"09/10/2019",7, "Marketing", 3.0, 7200000.0);
        //Danh sách quản lý
        Manager ql1 = new Manager("M001", "Phạm Văn An", 25, 2.5, "11/11/2010", 5, "Công nghệ thông tin", "Business Leader", 20500000.0);
        Manager ql2 = new Manager("M002", "Nguyễn Minh Nhật", 24, 4.5, "01/11/2021", 1, "Công nghệ thông tin", "Technical Leader", 28500000.0);
        //Thêm nhân viên và quản lý vào danh sách mảng
        StaffList.add(nv1);
        StaffList.add(nv2);

        StaffList.add(ql1);
        StaffList.add(ql2);

    }
    //Hàm in danh sách nhân viên
    static void inDanhSach(){
        StaffList.forEach(x -> {
            x.displayInformation();
        });
    }
    //Hàm tạo các bộ phận trong công ty
    static void boPhan(){
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (Staff x : StaffList) {
            if (x.getBoPhanLam().equalsIgnoreCase("Công nghệ thông tin")) {
                sum1++;
            }
            if (x.getBoPhanLam().equalsIgnoreCase("Marketing")) {
                sum2++;
            }
            if (x.getBoPhanLam().equalsIgnoreCase("Hành chính nhân sự")) {
                sum3++;
            }
        }
        //Tạo ra các bộ phận của công ty
        Department it = new Department("IT","Công nghệ thông tin",sum1);
        Department mkt = new Department("MKT","Marketing",sum2);
        Department hc = new Department("HC","Hành chính nhân sự",sum3);
//        ADD các bộ phận vào danh sách mảng
        DepartmentList.add(it);
        DepartmentList.add(mkt);
        DepartmentList.add(hc);
    }
    //Hàm in các bộ phận của công ty
    public static void inBoPhan(){
        for (Department x: DepartmentList) {
            System.out.println(x.toString());
        }
    }
    //Hàm in danh sách sinh viên theo từng bộ phận
    public static void inNhanVienTheoBoPhan() {
        System.out.println();
        for (Department x: DepartmentList) {
            System.out.println();
            System.out.println(x.getTenBoPhan());
            System.out.println("-------------------------------");
            System.out.printf("%-12s | %-23s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %-15s\n",
                    "Mã nhân viên","Tên nhân viên","Tuổi","HS Luong","Ngày vào làm","Ngày nghỉ phép",
                    "Bộ phận","Số giờ làm thêm/Chức vụ","Lương");
            for (Staff y: StaffList) {
                if(y.getBoPhanLam().equals(x.getTenBoPhan())){
                    y.displayInformation();
                }
            }
        }
        System.out.println();
    }
    //Hàm sắp xếp lương giảm dần
    public static void sapXepLuongGiamDan(){
        Collections.sort(StaffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff nv1, Staff nv2) {
                if(((ICalculator)nv1).calculateSalary() < ((ICalculator)nv2).calculateSalary()) {
                    return 1;
                }else {
                    if(((ICalculator)nv1).calculateSalary() == ((ICalculator)nv2).calculateSalary()) {
                        return 0;
                    }else {
                        return -1;
                    }
                }
            }
        });
        //in ra console
        System.out.println();
        System.out.printf("%-12s | %-23s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %-15s\n",
                "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Luong", "Ngày vào làm", "Ngày nghỉ phép",
                "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println("-----------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------");
        StaffList.forEach(x -> {
            x.displayInformation();
        });
        System.out.println("-----------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------");
        System.out.println();
    }
    //Hàm sắp xếp lương tăng dần
    public static void sapXepLuongTangDan(){
        Collections.sort(StaffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff nv1, Staff nv2) {
                if(((ICalculator)nv1).calculateSalary() < ((ICalculator)nv2).calculateSalary()) {
                    return -1;
                }else {
                    if(((ICalculator)nv1).calculateSalary() == ((ICalculator)nv2).calculateSalary()) {
                        return 0;
                    }else {
                        return 1;
                    }
                }
            }
        });
        // in ra console
        System.out.println();
        System.out.printf("%-12s | %-23s | %-4s | %-10s | %-13s | %-15s | %-20s | %-23s | %-15s\n",
                "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Luong", "Ngày vào làm", "Ngày nghỉ phép",
                "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println("-----------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------");
        StaffList.forEach(x -> {
            x.displayInformation();
        });
        System.out.println("-----------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------");
        System.out.println();
    }
}
