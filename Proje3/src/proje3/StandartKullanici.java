package proje3;

public class StandartKullanici extends Kullanici {

    public StandartKullanici(String kullaniciAdi, String adSoyad, Boolean gizliHesap) {
        super(kullaniciAdi, adSoyad, gizliHesap);
    }

    @Override
    public void indirim() {
        System.out.println("İndirimden faydalanamazssınız.");

    }

}
