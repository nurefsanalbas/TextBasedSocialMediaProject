package proje3;

public class PremiumKullanici extends Kullanici {

    private int uyelikUcreti = 20;

    public PremiumKullanici(String kullaniciAdi, String adSoyad, Boolean gizliHesap) {
        super(kullaniciAdi, adSoyad, gizliHesap);
        this.uyelikUcreti = uyelikUcreti;
    }

    public int getUyelikUcreti() {
        return uyelikUcreti;
    }

    public void setUyelikUcreti(int uyelikUcreti) {
        this.uyelikUcreti = uyelikUcreti;
    }

    @Override
    public void indirim() {
        for (int i = 0; i < getPaylasimListesi().length; i++) {
            if (getPaylasimListesi()[i] != null && getPaylasimListesi().length > 1) {
                setUyelikUcreti(getUyelikUcreti() - (getUyelikUcreti() * 10) / 100);
                break;
            } else {
                System.out.println("Paylaşım sayınız indirim almak için yeterli değil.");
                break;
            }
        }
        System.out.println("Yeni Üyelik Ücretiniz:" + uyelikUcreti + "₺ dir.");

    }
}
