package proje3;

public class Paylasim {

    private static int ID = 100000;
    public String yorum;
    public int begeniSayisi;
    public String paylasim;
    public String[] yorumlar = new String[10];
    public int yorumSayisi = 0;
    int id;

    public Paylasim(String paylasim) {
        this.paylasim = paylasim;
        id = ID + 1;
        ID = id;
    }


    public String[] getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(String[] yorumlar) {
        this.yorumlar = yorumlar;
    }

    public void yorumEkle(String yorum) {
        for (int i = 0; i < yorumlar.length; i++) {
            if (yorumlar[i] == null) {
                yorumlar[i] = yorum;
                yorumSayisi += 1;
                break;
            }
        }
    }
}
