package model;

public abstract class TimFutsal {
    private String namaTim;
    private String kotaAsal;
    private final int kodeUnik = (int)(Math.random() * 10000);
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

    public final void tampilkanInfoDasar() {
        System.out.println("Nama Tim: " + namaTim);
        System.out.println("Kota Asal: " + kotaAsal);
        System.out.println("Jumlah Pemain: " + jumlahPemain);
        System.out.println("Kode Unik: " + kodeUnik);
    }

    public abstract void tampilkanInfo();
}
