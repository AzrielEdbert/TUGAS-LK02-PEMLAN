import java.util.Scanner;

class Kendaraan {
    public String platNomor;
    public int kapasitas;
    public int jumlahPenumpang;
    public Penumpang[] penumpang;
    public Driver driver;

    public Kendaraan(String platNomor, int kapasitas, Driver driver) {
        this.platNomor = platNomor;
        this.kapasitas = kapasitas;
        this.jumlahPenumpang = 0;
        this.penumpang = new Penumpang[kapasitas];
        this.driver = driver;
    }

    public void infoKendaraan() {
        System.out.println("\n====================");
        System.out.println("Informasi Kendaraan :");
        System.out.println("Plat Nomor : " + platNomor);
        System.out.println("Kapasitas Penumpang : " + kapasitas);
        System.out.println("Nama Driver : " + driver.nama);
    }

    public void naikPenumpang(Penumpang penumpang) {
        if (jumlahPenumpang < kapasitas) {
            this.penumpang[jumlahPenumpang] = penumpang;
            jumlahPenumpang++;
            System.out.println(penumpang.nama + " ingin naik ke dalam kendaraan");
        } else {
            System.out.println("Kendaraan sudah penuh, tidak bisa menambah penumpang lagi");
        }
    }

    public void turunPenumpang(Penumpang penumpang) {
        boolean found = false;
        for (int i = 0; i < jumlahPenumpang; i++) {
            if (this.penumpang[i].nama.equals(penumpang.nama)) {
                for (int j = i; j < jumlahPenumpang - 1; j++) {
                    this.penumpang[j] = this.penumpang[j + 1];
                }
                this.penumpang[jumlahPenumpang - 1] = null;
                jumlahPenumpang--;
                found = true;
                System.out.println(penumpang.nama + " ingin turun dari kendaraan");
                break;
            }
        }
        if (!found) {
            System.out.println("Penumpang tidak ditemukan di dalam kendaraan");
        }
    }

    public void turunPenumpang(String namaPenumpang) {
        Penumpang penumpang = new Penumpang(namaPenumpang);
        turunPenumpang(penumpang);
    }
}

class Penumpang {
    public String nama;

    public Penumpang(String nama) {
        this.nama = nama;
    }
}

class Driver {
    public String nama;

    public Driver(String nama) {
        this.nama = nama;
    }
}

class Mobil extends Kendaraan {
    public Mobil(String platNomor, int kapasitas, Driver driver) {
        super(platNomor, kapasitas, driver);
    }

    public void naikPenumpang(Penumpang penumpang) {
        if (jumlahPenumpang < kapasitas) {
            super.naikPenumpang(penumpang);
            System.out.println("Penumpang telah naik ke dalam mobil");
        } else {
            System.out.println("Mobil sudah penuh, tidak bisa menambah penumpang lagi");
        }
    }

    public void turunPenumpang(Penumpang penumpang) {
        super.turunPenumpang(penumpang);
        System.out.println("Penumpang telah turun dari mobil");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=====");
            System.out.println("Menu:");
            System.out.println("1. Penumpang naik");
            System.out.println("2. Penumpang turun");
            System.out.println("3. Lihat total penumpang");
            System.out.println("4. Exit");
            System.out.print("Pilihan Anda: ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.print("Masukkan nama penumpang yang naik : ");
                    String namaPenumpangNaik = scanner.next();
                    naikPenumpang(new Penumpang(namaPenumpangNaik));
                    break;
                case 2:
                    System.out.print("Masukkan nama penumpang yang turun : ");
                    String namaPenumpangTurun = scanner.next();
                    turunPenumpang(namaPenumpangTurun);
                    break;
                case 3:
                    System.out.println("Total penumpang saat ini : " + jumlahPenumpang);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
        System.out.println("Terima kasih telah mengakses sistem murah ini :)");
    }
}

class Bus extends Kendaraan {
    private boolean toiletSedangDipakai;

    public Bus(String platNomor, int kapasitas, Driver driver) {
        super(platNomor, kapasitas, driver);
        this.toiletSedangDipakai = false;
    }

    public void naikPenumpang(Penumpang penumpang) {
        if (jumlahPenumpang < kapasitas) {
            super.naikPenumpang(penumpang);
            System.out.println("Penumpang telah naik ke dalam bus");
        } else {
            System.out.println("Bus sudah penuh, tidak bisa menambah penumpang lagi");
        }
    }

    public void turunPenumpang(Penumpang penumpang) {
        super.turunPenumpang(penumpang);
        System.out.println("Penumpang telah turun dari bus");
    }

    public void infoKendaraan() {
        super.infoKendaraan();
        System.out.println("Bus ini memiliki toilet");
    }

    public void ToiletPenumpang(Penumpang penumpang) {
        if (toiletSedangDipakai) {
            System.out.println("Maaf, toilet sedang dipakai. Silakan coba lagi nanti");
        } else {
            System.out.println(penumpang.nama + " menggunakan toilet di dalam bus");
            toiletSedangDipakai = true;
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=====");
            System.out.println("Menu:");
            System.out.println("1. Penumpang naik");
            System.out.println("2. Penumpang turun");
            System.out.println("3. Toilet");
            System.out.println("4. Lihat total penumpang");
            System.out.println("5. Exit");
            System.out.print("Pilihan Anda: ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.print("Masukkan nama penumpang yang naik : ");
                    String namaPenumpangNaik = scanner.next();
                    naikPenumpang(new Penumpang(namaPenumpangNaik));
                    break;
                case 2:
                    System.out.print("Masukkan nama penumpang yang turun : ");
                    String namaPenumpangTurun = scanner.next();
                    turunPenumpang(namaPenumpangTurun);
                    break;
                case 3:
                    System.out.print("Masukkan nama penumpang yang ingin menggunakan toilet : ");
                    String namaPenumpangToilet = scanner.next();
                    ToiletPenumpang(new Penumpang(namaPenumpangToilet));
                    break;
                case 4:
                    System.out.println("Total penumpang saat ini : " + jumlahPenumpang);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
        System.out.println("Terima kasih telah mengakses sistem murah ini :)");
    }
}

class Truk extends Kendaraan {
    private double kapasitasMuatan;
    private double muatanSaatIni;

    public Truk(String platNomor, int kapasitas, Driver driver, double kapasitasMuatan) {
        super(platNomor, kapasitas, driver);
        this.kapasitasMuatan = kapasitasMuatan;
        this.muatanSaatIni = 0;
    }

    public void naikPenumpang(Penumpang penumpang) {
        if (jumlahPenumpang < kapasitas) {
            super.naikPenumpang(penumpang);
            System.out.println("Penumpang telah naik ke dalam truk");
        } else {
            System.out.println("Truk, tidak bisa menambah penumpang lagi");
        }
    }

    public void turunPenumpang(Penumpang penumpang) {
        super.turunPenumpang(penumpang);
        System.out.println("Penumpang turun dari truk");
    }

    public void infoKendaraan() {
        super.infoKendaraan();
        System.out.println("Kapasitas Muatan: " + kapasitasMuatan + " ton");
        System.out.println("Muatan Saat Ini: " + muatanSaatIni + " ton");
    }

    public void muatBarang(double beratBarang) {
        if (muatanSaatIni + beratBarang <= kapasitasMuatan) {
            muatanSaatIni += beratBarang;
            System.out.println("Barang dengan berat " + muatanSaatIni + " ton " + "berhasil dimuat");
        } else {
            System.out.println("Barang terlalu berat, melebihi kapasitas muatan truk");
        }
    }

    public void turunkanMuatan(double beratBarang) {
        if (beratBarang <= muatanSaatIni) {
            muatanSaatIni -= beratBarang;
            System.out.println("Barang dengan berat " + beratBarang + " ton berhasil diturunkan dari truk");
        } else {
            System.out.println("Berat barang yang akan diturunkan melebihi muatan saat ini di truk");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=====");
            System.out.println("Menu:");
            System.out.println("1. Penumpang naik");
            System.out.println("2. Penumpang turun");
            System.out.println("3. Muat Barang");
            System.out.println("4. Turunkan barang");
            System.out.println("5. Lihat total penumpang");
            System.out.println("6. Exit");
            System.out.print("Pilihan Anda: ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.print("Masukkan nama penumpang yang naik : ");
                    String namaPenumpangNaik = scanner.next();
                    naikPenumpang(new Penumpang(namaPenumpangNaik));
                    break;
                case 2:
                    System.out.print("Masukkan nama penumpang yang turun : ");
                    String namaPenumpangTurun = scanner.next();
                    turunPenumpang(namaPenumpangTurun);
                    break;
                case 3:
                    System.out.print("Masukkan berat barang yang akan dimuat (ton) : ");
                    double beratBarang = scanner.nextDouble();
                    muatBarang(beratBarang);
                    break;
                case 4:
                    System.out.print("Masukkan berat barang yang akan diturunkan (ton) : ");
                    double beratTurun = scanner.nextDouble();
                    turunkanMuatan(beratTurun);
                    break;
                case 5:
                    System.out.println("Total penumpang saat ini : " + jumlahPenumpang);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
        System.out.println("Terima kasih telah mengakses sistem murah ini :)");
    }
}

public class Nyeeeeng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================");
        System.out.println("Silakan pilih kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Bus");
        System.out.println("3. Truk");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();

        Kendaraan kendaraan = null;
        switch (choice) {
            case 1:
                kendaraan = new Mobil("B 1234 CD", 5, new Driver("Azriel Edbert"));
                kendaraan.infoKendaraan();
                ((Mobil) kendaraan).start();
                break;
            case 2:
                kendaraan = new Bus("X 9999 ZZ", 60, new Driver("Irgi Aufa"));
                kendaraan.infoKendaraan();
                ((Bus) kendaraan).start();
                break;
            case 3:
                kendaraan = new Truk("Z 4321 AB", 3, new Driver("Zidky Cahyo"), 5.0);
                kendaraan.infoKendaraan();
                ((Truk) kendaraan).start();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        scanner.close();
    }
}
