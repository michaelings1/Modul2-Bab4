public class Customer {

    private String nomorPelanggan;
    private String nama;
    private double saldo;
    private String pin;
    private int salahPin = 0;
    private boolean blokir = false;

    public Customer(String nomorPelanggan, String nama, double saldo, String pin){
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
    }

    public boolean verifikasi(String inputPin){

        if(blokir){
            return false;
        }

        if(pin.equals(inputPin)){
            salahPin = 0;
            return true;
        } 
        else{
            salahPin++;
            System.out.println("PIN anda salah!");

            if(salahPin == 3){
                blokir = true;
                System.out.println("Akun anda diblokir.");
            }

            return false;
        }
    }

    public void topUp(double jumlah){
        saldo += jumlah;
        System.out.println("Top up berhasil.");
        System.out.println("Saldo sekarang : " + (int)saldo);
    }

    public void pembeli(double jumlah){

        double cashback = hitungCashback(jumlah);
        double saldoAkhir = saldo - jumlah + cashback;

        if(saldoAkhir < 10000){
            System.out.println("Transaksi gagal. Saldo anda minimal Rp10.000");
            return;
        }

        saldo = saldoAkhir;

        System.out.println("Pembelian berhasil");
        System.out.println("Cashback : " + (int)cashback);
        System.out.println("Saldo sekarang : " + (int)saldo);
    }

    private double hitungCashback(double jumlah){

        String kode = nomorPelanggan.substring(0,2);

        if(kode.equals("38")){
            if(jumlah > 1000000){
                return jumlah * 0.05;
            }
        }

        if(kode.equals("56")){
            if(jumlah > 1000000){
                return jumlah * 0.07;
            } 
            else{
                return jumlah * 0.02;
            }
        }

        if(kode.equals("74")){
            if(jumlah > 1000000){
                return jumlah * 0.10;
            } 
            else{
                return jumlah * 0.05;
            }
        }

        return 0;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getNama(){
        return nama;
    }
}