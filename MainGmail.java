import java.util.ArrayList;   //Fungsi digunakan untuk menyimpan elemen-elemen dalam urutan tertentu
import java.util.List;   //Fungsi digunakan untuk menyimpan daftar email
import java.util.Scanner;   //Fungsi digunakan untuk menerima input dari pengguna

class User {
    private String username, password;

    // Method untuk mendaftarkan akun baru
    public void registrasiAkun() {
        Scanner input = new Scanner(System.in);

        System.out.println("== DAFTAR AKUN ==");
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();

        System.out.println("Akun Anda berhasil didaftarkan.");
    }

    //Method untuk login ke akun yang sudah terdaftar
    public boolean loginAkun() {
        Scanner input = new Scanner(System.in);

        System.out.println("== LOGIN  ==");
        System.out.print("Username: ");
        String inputUsername = input.nextLine();
        System.out.print("Password: ");
        String inputPassword = input.nextLine();

        //Memeriksa apakah inputUsername sama dengan username dan inputPassword sama dengan password.
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login berhasil.");
            return true;
        } else {
            System.out.println("Username atau password salah.");
            return false;
        }
    }

    // Method untuk logout dari akun
    public void logoutAkun() {
        System.out.println("Anda berhasil logout.");
    }

    // Fungsi Getter untuk mendapatkan username
    public String getUsername() {
        return username;
    }
}

abstract class Email {
    //Daftar email yang disimpan dalam bentuk List.
    protected List<String> emails;

    //Konstruktor untuk kelas Email yang inisialisasi emails sebagai objek ArrayList
    public Email() {
        emails = new ArrayList<>();
    }

    // Method abstrak untuk anak kelas untuk menampilkan informasi email.
    public abstract void tampilkan();

    // Fungsi untuk menambahkan email ke dalam list emails
    public void tambahEmail(String email) {
        emails.add(email);
    }

    // Method untuk menghitung jumlah email dalam list emails.
    public int hitungJumlahEmail() {
        return emails.size();
    }

    // Methode untuk mendapatkan daftar email dalam bentuk List.
    public List<String> getEmails() {
        return emails;
    }
}

//Turunan dari kelas Email
class KotakMasuk extends Email {

    //menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public void tampilkan() {
        System.out.println("== Kotak Masuk ==");
        //Memeriksa apakah daftar email kosong
        if (emails.isEmpty()) {
            System.out.println("Tidak ada email dalam kotak masuk.");
        } else {
            for (String email : emails) {  //perulangan setiap elemen dalam emails.
                System.out.println(email);
            }
        }
    }

    //menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public int hitungJumlahEmail() {
        int jumlahEmail = emails.size();
        System.out.println("Jumlah email dalam kotak masuk: " + jumlahEmail);
        return jumlahEmail;
    }
}

//Turunan dari kelas Email
class Terkirim extends Email {
    //Menyimpan status pengiriman setiap email yang terkirim.
    private List<String> statusPengiriman;

     //Konstruktor kelas Terkirim yang digunakan untuk menginisialisasi statusPengiriman sebagai objek ArrayList.
    public Terkirim() {
        statusPengiriman = new ArrayList<>();
    }

    // Method untuk menambahkan status pengiriman email ke dalam statusPengiriman
    public void tambahStatusPengiriman(String status) {
        statusPengiriman.add(status);
    }

    // Menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public void tampilkan() {
        System.out.println("== Kotak Terkirim ==");
        if (emails.isEmpty()) {  // Memeriksa apakah daftar email kosong
            System.out.println("Tidak ada email terkirim.");
        } else {
            for (int i = 0; i < emails.size(); i++) { // Melakukan perulangan untuk setiap elemen dalam emails menggunakan indeks.
                System.out.println(emails.get(i)); // Menampilkan email pada indeks i 
                System.out.println("Status Pengiriman: " + statusPengiriman.get(i));
                System.out.println();
            }
        }
    }

    // Menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public int hitungJumlahEmail() {
        int jumlahEmail = emails.size();
        System.out.println("Jumlah email terkirim: " + jumlahEmail);
        return jumlahEmail;
    }
}

//Turunan dari kelas Email
class Draf extends Email {
    // Menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public void tampilkan() {
        System.out.println("== Draf ==");
        if (emails.isEmpty()) {  //Memeriksa apakah daftar email kosong
            System.out.println("Tidak ada email dalam draf.");
        } else {
            for (String email : emails) {  //perulangan setiap elemen dalam emails. Pada setiap iterasi, elemen email saat ini akan disimpan dalam variabel email yang memiliki tipe data String.
                System.out.println(email);
            }
        }
    }
    // Menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public int hitungJumlahEmail() {
        int jumlahEmail = emails.size();
        System.out.println("Jumlah email dalam draf: " + jumlahEmail);
        return jumlahEmail;
    }
}

//Turunan dari kelas Email
class Buat extends Email {
    private String email;
    private String pengirim;
    private String tujuan;
    private String subjek;
    private String isi;

    // Fungsi getter yang digunakan untuk mengembalikan isi email yang baru dibuat.
    public String getEmail() {
        return email;
    }

    // Menandakan bahwa metode di bawahnya merupakan override (Polymorhpism) dari metode yang ada dalam kelas induk.
    @Override
    public void tampilkan() {
        System.out.println("== Buat Email Baru ==");
        Scanner input = new Scanner(System.in);
        System.out.print("Pengirim: ");
        pengirim = input.nextLine();
        System.out.print("Tujuan: ");
        tujuan = input.nextLine();
        System.out.print("Subjek: ");
        subjek = input.nextLine();
        System.out.print("Isi: ");
        isi = input.nextLine();

        //Menggabungkan informasi ke dalam string email
        email = "Pengirim: " + pengirim + "\n" +
                "Subjek: " + subjek + "\n" +
                "Isi: " + isi + "\n";

        //Memanggil Method untuk menambahkan email baru ke dalam daftar email.
        tambahEmail(email);
        System.out.println("Email berhasil dibuat dan terkirim ke " + tujuan);
    }
}

class PencarianEmail {
    // Method untuk mencari email berdasarkan keyword tertentu di dalam daftar email, di buat static agar dapat dipannggil tanpa menginisialisasi objek baru.
    public static void cariEmail(List<Email> daftarEmail, String keyword) {
        boolean ditemukan = false;
        for (Email email : daftarEmail) {
            for (String emailContent : email.getEmails()) {
                if (emailContent.contains(keyword)) {
                    System.out.println("== Hasil Pencarian ==");
                    email.tampilkan();
                    ditemukan = true;
                    break;
                }
            }
        }
        if (!ditemukan) {
            System.out.println("Email tidak ditemukan.");
        }
    }
}

class MainMenu {
     // Method untuk menampilkan menu utama setelah login,di buat static agar dapat dipannggil tanpa menginisialisasi objek baru.
    public static void tampilkan(String username) {
        int Menupilihan;
        Scanner input = new Scanner(System.in);

         //Inisialisasi objek 
        User user = new User();
        KotakMasuk kotakMasuk = new KotakMasuk();
        Terkirim terkirim = new Terkirim();
        Draf draf = new Draf();
        Buat buat = new Buat();
        List<Email> daftarEmail = new ArrayList<>();
        daftarEmail.add(kotakMasuk);
        daftarEmail.add(terkirim);
        daftarEmail.add(draf);

        do {
            System.out.println("\nSelamat Datang di Gmail, " + username);
            System.out.println("----------------------\n");
            System.out.println("== Silahkan Memilih Menu ==");
            System.out.println("1. Kotak Masuk");
            System.out.println("2. Terkirim");
            System.out.println("3. Draf");
            System.out.println("4. Buat Email Baru");
            System.out.println("5. Cari Email");
            System.out.println("6. Logout");
            System.out.println();
            System.out.print("Pilihan: ");
           Menupilihan = input.nextInt();

            switch (Menupilihan) {
                case 1:
                    kotakMasuk.tampilkan();    //memanggil method tampilkan() pada objek kotakMasuk
                    kotakMasuk.hitungJumlahEmail();
                    break;
                case 2:
                    terkirim.tampilkan();  
                    terkirim.hitungJumlahEmail();
                    break;
                case 3:
                    draf.tampilkan();
                    draf.hitungJumlahEmail();
                    break;
                case 4:
                    buat.tampilkan();  // memanggil method tampilkan() dari objek buat untuk membuat email baru. Selanjutnya, email baru tersebut ditambahkan ke kotak masuk dan terkirim dengan menggunakan method tambahEmail() dari objek kotakMasuk dan terkirim. Status pengiriman juga ditambahkan ke objek terkirim menggunakan metode tambahStatusPengiriman().
                    kotakMasuk.tambahEmail(((Buat) buat).getEmail());
                    terkirim.tambahEmail(((Buat) buat).getEmail());
                    terkirim.tambahStatusPengiriman("Terkirim");
                    break;
                case 5:
                    input.nextLine(); // Membersihkan newline character
                    System.out.print("Masukkan kata kunci: ");
                    String keyword = input.nextLine();
                    PencarianEmail.cariEmail(daftarEmail, keyword);
                    break;
                case 6:
                    user.logoutAkun();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (Menupilihan != 6);
    }
}

//Kelas utama 
public class MainGmail {  //Mehod utama yang akan dieksekusi ketika program dijalankan.
    public static void main(String[] args) {
        int pilihanMenu;
        Scanner input = new Scanner(System.in);

        //Inisialisasi objek 
        User user = new User();

        do {
            System.out.println("\nSelamat Datang Di Gmail");
            System.out.println("----------------------\n");
            System.out.println("== Silahkan Memilih Menu ==");
            System.out.println("1. Daftar Akun");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.println();
            System.out.print("Pilihan: ");
            pilihanMenu = input.nextInt();

            switch (pilihanMenu) {
                case 1:
                    user.registrasiAkun();  //memanggil method registrasiAkun() pada objek user untuk melakukan proses registrasi akun.
                    break;
                case 2:
                    if (user.loginAkun()) {  //memanggil metode loginAkun() pada objek user untuk melakukan proses login. Jika login berhasil, memanggil metode tampilkan() pada kelas MainMenu dengan menyediakan username pengguna yang berhasil login.
                        MainMenu.tampilkan(user.getUsername());
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan Gmail. Semoga Hari-Hari Anda Menyenangkan");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanMenu != 3);
    }
}