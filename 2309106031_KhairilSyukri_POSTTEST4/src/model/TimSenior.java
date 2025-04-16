package model;

public class TimSenior extends TimFutsal {
    private int rataRataUsia;

    public TimSenior(String namaTim, String kotaAsal, int jumlahPemain, int rataRataUsia) {
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
        System.out.println("Kategori: Senior");
        System.out.println("Rata-rata Usia: " + rataRataUsia + " tahun");
        System.out.println("-----------------------------");
    }
}
