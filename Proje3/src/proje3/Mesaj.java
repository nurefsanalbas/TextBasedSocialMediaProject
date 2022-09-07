package proje3;

public class Mesaj {

    public String[] mesajList;
    public Kullanici alici;
    public Kullanici gonderen;

    public Mesaj(String mesaj, Kullanici alici, Kullanici gonderen) {
        this.mesajList = new String[10];
        this.mesajList[0] = mesaj;
        this.alici = alici;
        this.gonderen = gonderen;
    }

    public String[] getMesaj() {
        return mesajList;//iki kişinin konuşmaları
    }

    public void setMesaj(String mesaj) {
        for (int i = 0; i < mesajList.length; i++) {
            if (mesajList[i] == null) {
                mesajList[i] = mesaj;
                break;
            }
        }
    }

    public Kullanici getAlici() {
        return alici;
    }

    public void setAlici(Kullanici alici) {
        this.alici = alici;
    }

    public Kullanici getGonderen() {
        return gonderen;
    }

    public void setGonderen(Kullanici gonderen) {
        this.gonderen = gonderen;
    }
}
