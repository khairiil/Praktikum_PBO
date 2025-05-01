import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.TimFutsal;
import model.TimJunior;
import model.TimSenior;
import model.Pendaftaran;

public class App {
    private static ArrayList<TimFutsal> daftarTim = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Manajemen Liga Futsal ===");
            System.out.println("1. Tambah Tim");
            System.out.println("2. Lihat Semua Tim");
            System.out.println("3. Perbarui Tim");
            System.out.println("4. Hapus Tim");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> tambahTim();
                    case 2 -> lihatSemuaTim();
                    case 3 -> perbaruiTim();
                    case 4 -> hapusTim();
                    case 5 -> {
                        System.out.println("Total tim terdaftar: " + TimFutsal.getTotalTim());
                        System.out.println("Terima kasih telah menggunakan program.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }

    private static void tambahTim() {
        try {
            System.out.print("Masukkan nama tim: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan kota asal: ");
            String kota = scanner.nextLine();

            int jumlah;
            do {
                System.out.print("Masukkan jumlah pemain (minimal 10): ");
                jumlah = scanner.nextInt();
                if (jumlah < 10) {
                    System.out.println("Jumlah pemain tidak boleh kurang dari 10!");
                }
            } while (jumlah < 10);

            System.out.print("Masukkan rata-rata usia pemain: ");
            int usia = scanner.nextInt();
            scanner.nextLine();

            TimFutsal tim;
            if (usia <= 20) {
                tim = new TimJunior(nama, kota, jumlah, usia);
            } else {
                tim = new TimSenior(nama, kota, jumlah, usia);
            }

            Pendaftaran pendaftaran = (Pendaftaran) tim;
            pendaftaran.cekKelayakan();

            if ((tim instanceof TimJunior && jumlah >= 10 && usia <= 20) ||
                (tim instanceof TimSenior && jumlah >= 10 && usia > 20)) {
                daftarTim.add(tim);
                TimFutsal.incrementTotalTim();
                pendaftaran.cetakPendaftaran();
                System.out.println("Tim berhasil didaftarkan!");
            } else {
                System.out.println("Tim gagal didaftarkan karena tidak memenuhi syarat.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka yang sesuai.");
            scanner.nextLine();
        }
    }

    private static void lihatSemuaTim() {
        if (daftarTim.isEmpty()) {
            System.out.println("Belum ada tim yang terdaftar.");
            return;
        }
        System.out.println("\n=== Daftar Tim Futsal ===");
        for (int i = 0; i < daftarTim.size(); i++) {
            System.out.println("\nTim #" + (i + 1));
            daftarTim.get(i).tampilkanInfo();
        }
    }

    private static void perbaruiTim() {
        lihatSemuaTim();
        if (daftarTim.isEmpty()) return;

        try {
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

            System.out.print("Jumlah pemain baru (-1 jika tidak ingin mengubah): ");
            int jumlahBaru = scanner.nextInt();
            scanner.nextLine();
            if (jumlahBaru != -1) tim.setJumlahPemain(jumlahBaru);

            System.out.println("Tim berhasil diperbarui!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }

    private static void hapusTim() {
        lihatSemuaTim();
        if (daftarTim.isEmpty()) return;

        try {
            System.out.print("Masukkan nomor tim yang ingin dihapus: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index < 1 || index > daftarTim.size()) {
                System.out.println("Nomor tim tidak valid!");
                return;
            }

            daftarTim.remove(index - 1);
            System.out.println("Tim berhasil dihapus!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }
}