import java.util.ArrayList;
import java.util.Scanner;

class TimFutsal {
    private String namaTim;
    private String kotaAsal;
    private int jumlahPemain;

    public TimFutsal(String namaTim, String kotaAsal, int jumlahPemain) {
        this.namaTim = namaTim;
        this.kotaAsal = kotaAsal;
        this.jumlahPemain = jumlahPemain;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public int getJumlahPemain() {
        return jumlahPemain;
    }

    public void setJumlahPemain(int jumlahPemain) {
        this.jumlahPemain = jumlahPemain;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Tim: " + namaTim);
        System.out.println("Kota Asal: " + kotaAsal);
        System.out.println("Jumlah Pemain: " + jumlahPemain);
        System.out.println("-----------------------------");
    }
}

public class App {
    private static ArrayList<TimFutsal> daftarTim = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Manajemen Liga Futsal Indonesia ===");
            System.out.println("1. Tambah Tim");
            System.out.println("2. Lihat Semua Tim");
            System.out.println("3. Perbarui Tim");
            System.out.println("4. Hapus Tim");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahTim();
                    break;
                case 2:
                    lihatSemuaTim();
                    break;
                case 3:
                    perbaruiTim();
                    break;
                case 4:
                    hapusTim();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    private static void tambahTim() {
        System.out.print("Masukkan nama tim: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kota asal: ");
        String kota = scanner.nextLine();
        System.out.print("Masukkan jumlah pemain: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); 

        daftarTim.add(new TimFutsal(nama, kota, jumlah));
        System.out.println("Tim berhasil ditambahkan!");
    }

    private static void lihatSemuaTim() {
        if (daftarTim.isEmpty()) {
            System.out.println("Belum ada tim yang terdaftar.");
            return;
        }
        System.out.println("\n=== Daftar Tim Futsal ===");
        for (int i = 0; i < daftarTim.size(); i++) {
            System.out.println("Tim #" + (i + 1));
            daftarTim.get(i).tampilkanInfo();
        }
    }

    private static void perbaruiTim() {
        lihatSemuaTim();
        if (daftarTim.isEmpty()) return;

        System.out.print("Masukkan nomor tim yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index < 1 || index > daftarTim.size()) {
            System.out.println("Nomor tim tidak valid!");
            return;
        }

        TimFutsal tim = daftarTim.get(index - 1);
        System.out.print("Nama baru (kosongkan jika tidak ingin mengubah): ");
        String namaBaru = scanner.nextLine();
        if (!namaBaru.isEmpty()) tim.setNamaTim(namaBaru);

        System.out.print("Kota baru (kosongkan jika tidak ingin mengubah): ");
        String kotaBaru = scanner.nextLine();
        if (!kotaBaru.isEmpty()) tim.setKotaAsal(kotaBaru);

        System.out.print("Jumlah pemain baru (atau -1 jika tidak ingin mengubah): ");
        int jumlahBaru = scanner.nextInt();
        scanner.nextLine(); 
        if (jumlahBaru != -1) tim.setJumlahPemain(jumlahBaru);

        System.out.println("Tim berhasil diperbarui!");
    }

    private static void hapusTim() {
        lihatSemuaTim();
        if (daftarTim.isEmpty()) return;

        System.out.print("Masukkan nomor tim yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > daftarTim.size()) {
            System.out.println("Nomor tim tidak valid!");
            return;
        }

        daftarTim.remove(index - 1);
        System.out.println("Tim berhasil dihapus!");
    }
}