public class Main {
    public static void main(String[] args) {
        double tarifKebersihanFakultas = 5000;
        double tarifKebersihanDepartemen = 7000;
        double tarifKebersihanDosen = 8000;
        
        RuangKelas rk = new RuangKelas("RK001", 10, 8, 3, 30, 25, 5);
        RuangDepartemen rd = new RuangDepartemen("RD001", 12, 10, 3, 10, 5, 10, 2, "Teknik Informatika", "Dr. Budi");
        RuangDosen rds = new RuangDosen("RDS001", 6, 5, 3, 2, "Dr. Andi", 1, 2);
        Laboratorium lab = new Laboratorium("LAB001", 15, 10, 3, 40, "Lab Umum", 1000000);
        LaboratoriumKomp labKomp = new LaboratoriumKomp("LABK02", 6 , 7, 8, 45, "LABSISCER", 150000, 50);
        LaboratoriumNonKomp labNonKomp =new LaboratoriumNonKomp("LAB004", 7,9,6,40,"LABFISIKA", 100000, "FISIKA");
        
        System.out.println("--- Informasi Ruang Kelas ---");
        rk.tampilkanInfo();
        System.out.println("Biaya Kebersihan: " + rk.hitungBiayaKebersihan(tarifKebersihanFakultas));
        
        System.out.println("\n--- Informasi Ruang Departemen ---");
        rd.tampilkanInfo();
        System.out.println("Biaya Kebersihan: " + rd.hitungBiayaKebersihan(tarifKebersihanDepartemen));
        
        System.out.println("\n--- Informasi Ruang Dosen ---");
        rds.tampilkanInfo();
        System.out.println("Biaya Kebersihan: " + rds.hitungBiayaKebersihan(tarifKebersihanDosen));
        
        System.out.println("\n--- Informasi Laboratorium ---");
        lab.tampilkanInfo();
        System.out.println("Biaya Kebersihan: " + lab.hitungBiayaKebersihan(tarifKebersihanFakultas));

        System.out.println("\n--- Informasi Laboratorium ---");
        labKomp.tampilkanInfo();
        System.out.println("Biaya Kebersihan: " + lab.hitungBiayaKebersihan(tarifKebersihanFakultas));

        System.out.println("\n--- Informasi Laboratorium ---");
        labNonKomp.tampilkanInfo();
        System.out.println("Biaya Kebersihan: " + lab.hitungBiayaKebersihan(tarifKebersihanFakultas));
    }

}
