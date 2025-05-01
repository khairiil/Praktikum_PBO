package model;

public final class TimSenior extends TimFutsal implements Pendaftaran {
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
        super.tampilkanInfoDasar();
        System.out.println("Kategori: Senior");
        System.out.println("Rata-rata Usia: " + rataRataUsia + " tahun");
        System.out.println("-----------------------------");
    }

    @Override
    public void cekKelayakan() {
        if (getJumlahPemain() >= 10 && rataRataUsia > 20) {
            System.out.println("Tim Senior memenuhi syarat pendaftaran.");
        } else {
            System.out.println("Tim Senior tidak memenuhi syarat pendaftaran.");
        }
    }

    @Override
    public void cetakPendaftaran() {
        System.out.println("Pendaftaran Tim Senior: " + getNamaTim());
    }
}