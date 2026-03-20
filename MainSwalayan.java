import java.util.Scanner;
public class MainSwalayan {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); 
        
        Customer cus = new Customer("255150707","Michael",200000,"2222");

        System.out.println("=== Tiny Swalayan ===");

        boolean login = false;

        for(int i = 0; i < 3; i++){

            System.out.print("Masukkan PIN anda : ");
            String pin = input.nextLine();

            if(cus.verifikasi(pin)){
                login = true;
                break;
            }
        }

        if(!login){
            return;
        }

        System.out.println("1. Pembelian");
        System.out.println("2. Top Up");
        System.out.print("Pilih : ");
        int pilih = input.nextInt();

        if(pilih == 1){

            System.out.print("Jumlah pembelian : ");
            double jumlah = input.nextDouble();

            cus.pembeli(jumlah);

        } else if(pilih == 2){

            System.out.print("Jumlah top up : ");
            double jumlah = input.nextDouble();

            cus.topUp(jumlah);
        }

        System.out.println("Saldo akhir: " + (int)cus.getSaldo());
    }
}