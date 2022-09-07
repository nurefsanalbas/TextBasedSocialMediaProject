package proje3;

public abstract class Kullanici {

    private static int ID = 100000;
    int id;
    private Boolean gizliHesap = false;
    private String adSoyad;
    private Kullanici[] arkadasListesi;
    private Kullanici[] beklemeListesi;
    private Mesaj[] mesajListesi;
    private Paylasim[] paylasimListesi;
    private String kullaniciAdi;

    public Kullanici(String kullaniciAdi, String adSoyad, Boolean gizliHesap) {
        this.kullaniciAdi = kullaniciAdi;
        this.adSoyad = adSoyad;
        arkadasListesi = new Kullanici[10];
        beklemeListesi = new Kullanici[10];
        paylasimListesi = new Paylasim[10];
        mesajListesi = new Mesaj[10];
        this.gizliHesap = gizliHesap;
        id = ID + 1;
        ID = id;
    }

    public abstract void indirim();

    public Kullanici[] getBeklemeListesi() {
        return beklemeListesi;
    }

    public void setBeklemeListesi(Kullanici[] beklemeListesi) {
        this.beklemeListesi = beklemeListesi;
    }

    public Paylasim[] getPaylasimListesi() {
        return paylasimListesi;
    }

    public Mesaj[] getMesajListesi() {
        return mesajListesi;
    }

    public void setMesajListesi(Mesaj[] mesajListesi) {
        this.mesajListesi = mesajListesi;
    }

    public void setPaylasimListesi(Paylasim[] paylasimListesi) {
        this.paylasimListesi = paylasimListesi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kullanici[] getArkadasListesi() {
        return arkadasListesi;
    }

    public void setArkadasListesi(Kullanici[] arkadasListesi) {
        this.arkadasListesi = arkadasListesi;
    }

    public Boolean getGizliHesap() {
        return gizliHesap;
    }

    public void setGizliHesap(Boolean gizliHesap) {
        this.gizliHesap = gizliHesap;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public static int getID() {
        return ID;
    }

    public void mesajGonder(Kullanici alici, String mesaj) {
        for (int i = 0; i < alici.getMesajListesi().length; i++) {
            if (alici.getMesajListesi()[i] != null
                    && (alici.getMesajListesi()[i].gonderen.kullaniciAdi.equals(this.kullaniciAdi)
                    || alici.getMesajListesi()[i].alici.kullaniciAdi.equals(this.kullaniciAdi))) {
                alici.getMesajListesi()[i].setMesaj(this.kullaniciAdi + " : " + mesaj);
                for (int j = 0; j < this.getMesajListesi().length; j++) {
                    if (this.getMesajListesi()[j] != null
                            && (this.getMesajListesi()[j].gonderen.kullaniciAdi.equals(this.kullaniciAdi)
                            || this.getMesajListesi()[j].alici.kullaniciAdi.equals(this.kullaniciAdi))) {
                        this.getMesajListesi()[j].setMesaj(this.kullaniciAdi + " : " + mesaj);
                         return;
                    }
                }
            }
        }
        for (int i = 0; i < alici.getMesajListesi().length; i++) {
            if (alici.getMesajListesi()[i] == null) {
                alici.getMesajListesi()[i] = new Mesaj(this.kullaniciAdi + " : " + mesaj, alici, this);
                for (int j = 0; j < this.getMesajListesi().length; j++) {
                    if (this.getMesajListesi()[j] == null) {
                        this.getMesajListesi()[j] = new Mesaj(this.kullaniciAdi + " : " + mesaj, alici, this);
                       return;
                    }
                }
            }
        }
        System.out.println("Mesaj kutusu dolu");
    }

    public void mesajGoruntule(Kullanici alici) {
        for (int i = 0; i < getMesajListesi().length; i++) {
            if (getMesajListesi()[i] != null && (getMesajListesi()[i].alici.kullaniciAdi.equals(alici.kullaniciAdi)
                    || getMesajListesi()[i].gonderen.kullaniciAdi.equals(alici.kullaniciAdi))) {
                for (int j = 0; j < alici.getMesajListesi()[i].getMesaj().length; j++) {
                    if (alici.getMesajListesi()[i].getMesaj()[j] != null) {
                        System.out.println(alici.getMesajListesi()[i].getMesaj()[j]);
                    }
                }
                break;
            }
        }
    }

    public void arkadasListele() {
        for (int i = 0; i < getArkadasListesi().length; i++) {
            if (getArkadasListesi()[i] != null) {
                System.out.println(getArkadasListesi()[i].getKullaniciAdi() + " : " + getArkadasListesi()[i].getAdSoyad());
            }
        }
    }

    public void arkadasSil(Kullanici kullanici) {
      
        for (int i = 0; i < getArkadasListesi().length; i++) {
            if (getArkadasListesi()[i] == kullanici) {
                getArkadasListesi()[i] = null;
                break;
            }
        }
    }

    public void beklemeListesineEkle(Kullanici kullanici) {
        for (int i = 0; i < getBeklemeListesi().length; i++) {
            if (getBeklemeListesi()[i] == null) {
                getBeklemeListesi()[i] = kullanici;
                break;
            }

        }
    }

    public void paylasimEkle(String paylasim) {
        for (int i = 0; i < getPaylasimListesi().length; i++) {
            if (getPaylasimListesi()[i] == null) {
                getPaylasimListesi()[i] = new Paylasim(paylasim);
                break;
            }
        }
    }

    public void paylasimGoruntule(Kullanici alici) {
        for (Paylasim paylasimListesi1 : alici.getPaylasimListesi()) {
            if (paylasimListesi1 != null) {
                System.out.println(paylasimListesi1.paylasim);
                System.out.println("Beğeni sayısı: " + paylasimListesi1.begeniSayisi);
                System.out.println("Yorum sayısı: " + paylasimListesi1.yorumSayisi);
                System.out.println("Paylaşım numarası: " + paylasimListesi1.id);
            }
        }
    }

    public void arkadasEkle(Kullanici yeniKullanici) {

        for (int i = 0; i < getArkadasListesi().length; i++) {
            if (getArkadasListesi()[i] == null) {
                getArkadasListesi()[i] = yeniKullanici;
                break;
            }
        }
    }

}
