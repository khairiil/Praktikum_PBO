package model;

public class TimJunior extends TimFutsal {
    private int rataRataUsia;

    public TimJunior(String namaTim, String kotaAsal, int jumlahPemain, int rataRataUsia) {
        super(namaTim, kotaAsal, jumlahPemain);
        this.rataRataUsia = rataRataUsia;
    }

    public int getRataRataUsia() {
        return rataRataUsia;
    }

    public void setRataRataUsia(int rataRataUsia) {
        this.rataRataUsia = rataRataUsia;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori: Junior");
        System.out.println("Rata-rata Usia: " + rataRataUsia + " tahun");
        System.out.println("-----------------------------");
    }
}
