package proje3;

import java.util.Scanner;

/*
@author:Nur Efsan Albas
@description:Metin tabanlı sosyal medya uygulaması
@file:proje3
@assigment:3
@date:03.12.2021-30.12.2021

 */
public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String islem = "0";

        Kullanici logginUser = null;

        Kullanici k1 = new StandartKullanici("yılmazMehmet", "Mehmet Yılmaz", false);
        Kullanici k2 = new StandartKullanici("eliff", "Elif akgün", false);
        Kullanici k3 = new PremiumKullanici("zeynepp", "Zeynep Koçer", false);
        Kullanici k4 = new PremiumKullanici("aslii", "Aslı Güner", true);

        Kullanici[] arrKullanicilar = new Kullanici[4];
        arrKullanicilar[0] = k1;
        arrKullanicilar[1] = k2;
        arrKullanicilar[2] = k3;
        arrKullanicilar[3] = k4;

        String kullanici_adi;

        do {
            System.out.println("Menü");
            System.out.println("0.Giriş yap:");
            System.out.println("1.Paylaşımı Beğen");
            System.out.println("2.Yorum Yap");
            System.out.println("3.Hesap Değiştir.");
            System.out.println("4.Mesaj at");
            System.out.println("5.Arkadaş Ekle");
            System.out.println("6.Arkadaş Sil");
            System.out.println("7.Arkadaş isteklerini Listele");
            System.out.println("8.Güncel paylaşımlar");
            System.out.println("9.Paylaşım Yap");
            System.out.println("10.Mesajlarımı göster");
            System.out.println("11.İndirimlerimi Göster(Bu kısım premium kullanıcılarımız içindir..)");
            System.out.println("12.Çıkış");
            islem = s.next();

            switch (islem) {
                case "0":
                    System.out.print("Giriş yapmak için kullanıcı adınızı giriniz:");
                    kullanici_adi = s.next();

                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i].getKullaniciAdi().equals(kullanici_adi)) {
                            System.out.println(arrKullanicilar[i].getAdSoyad() + " hesabınıza giriş yapılıyor...");
                            logginUser = arrKullanicilar[i];

                        }
                    }
                    break;

                case "1":

                    System.out.println("Hangi kullanıcının paylaşımını beğenmek istersiniz?");
                    kullanici_adi = s.next();

                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i] != null && arrKullanicilar[i].getKullaniciAdi().equals(kullanici_adi)) {
                            System.out.println("Beğenmek istediğiniz paylaşımın numarasını giriniz");
                            int begeni_no = s.nextInt();
                            for (int j = 0; j < arrKullanicilar[i].getPaylasimListesi().length; j++) {
                                if (arrKullanicilar[i].getPaylasimListesi()[j] != null
                                        && arrKullanicilar[i].getPaylasimListesi()[j].id == begeni_no) {
                                    arrKullanicilar[i].getPaylasimListesi()[j].begeniSayisi += 1;
                                    System.out.println("Paylaşımı beğendiniz");
                                }
                            }
                        }
                    }
                    break;
                case "2":
                    System.out.println("Hangi kullanıcının paylaşımına yorum yapmak istersiniz?");
                    kullanici_adi = s.next();

                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i] != null && arrKullanicilar[i].getKullaniciAdi().equals(kullanici_adi)) {
                            System.out.println("Yorum yapmak istediğiniz paylaşımın numarasını giriniz");
                            int yorum_no = s.nextInt();
                            for (int j = 0; j < arrKullanicilar[i].getPaylasimListesi().length; j++) {
                                if (arrKullanicilar[i].getPaylasimListesi()[j] != null
                                        && arrKullanicilar[i].getPaylasimListesi()[j].id == yorum_no) {
                                    System.out.println("Yorumunuz nedir?");
                                    String yorum = s.next();
                                    arrKullanicilar[i].getPaylasimListesi()[j].yorumEkle(yorum);
                                    System.out.println("Yorumunuz eklendi.");
                                }
                            }
                        }
                    }
                    break;
                case "3":
                    System.out.print("Hesap değiştirmek için kullanici adı giriniz:");
                    String hesapkullaniciAdi = s.next();
                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (hesapkullaniciAdi.equals(arrKullanicilar[i].getKullaniciAdi()) && arrKullanicilar[i] != null) {
                            logginUser = arrKullanicilar[i];
                            System.out.println(logginUser.getAdSoyad() + " hesabınıza giriş yapılıyor...");
                        }
                    }
                    break;

                case "4":
                    System.out.println("Mesaj göndermek istediğiniz kullanıcı adını giriniz:");
                    kullanici_adi = s.next();

                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i].getKullaniciAdi().equals(kullanici_adi)) {
                            if (arrKullanicilar[i] != null) {
                                System.out.println("Göndermek istediğiniz mesajı giriniz");
                                String mesaj = s.next();
                                logginUser.mesajGonder(arrKullanicilar[i], mesaj);
                                System.out.println("Mesajınız gönderildi..");
                            }
                        }
                    }
                    break;
                case "5":
                    System.out.println("Eklemek istediğiniz kullanıcı adını giriniz:");
                    String kullanici = s.next();

                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i].getKullaniciAdi().equals(kullanici)) {
                            if (!arrKullanicilar[i].getGizliHesap()) {
                                logginUser.arkadasEkle(arrKullanicilar[i]);
                                System.out.println("Kullanıcı eklendi, yeni arkadaş Listeniz");
                                logginUser.arkadasListele();
                            } else {

                                arrKullanicilar[i].beklemeListesineEkle(logginUser);
                                System.out.println(arrKullanicilar[i].getKullaniciAdi() + "'a istek gönderdiniz...");

                            }
                        }
                    }

                    break;
                case "6":
                    System.out.println("Silmek istediğiniz kullaniciyi giriniz:");
                    kullanici = s.next();
                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i].getKullaniciAdi().equals(kullanici)) {
                            logginUser.arkadasSil(arrKullanicilar[i]);
                            logginUser.arkadasListele();

                        }
                        System.out.println(arrKullanicilar[i].getKullaniciAdi() + "başarıyla sildiniz.");
                    }
                    break;
                case "7":
                    for (int i = 0; i < logginUser.getBeklemeListesi().length; i++) {
                        if (logginUser.getBeklemeListesi()[i] != null) {
                            System.out.println("Listenizde bekleyenler:" + logginUser.getBeklemeListesi()[i].getKullaniciAdi());
                        }
                    }

                    break;
                case "8":
                    System.out.println("Hangi kullanıcının paylaşımını görüntülemek istersiniz?");
                    kullanici_adi = s.next();

                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i] != null && arrKullanicilar[i].getKullaniciAdi().equals(kullanici_adi)) {
                            logginUser.paylasimGoruntule(arrKullanicilar[i]);
                        }
                    }
                    break;
                case "9":

                    System.out.println("Yapmak istediğiniz paylaşımınızı giriniz...");
                    String paylasim = s.next();
                    logginUser.paylasimEkle(paylasim);
                    System.out.println("Paylaşımınız eklendi...");

                    break;

                case "10":

                    System.out.println("Hangi kullanıcı ile olan konuşmalarınızı görüntülemek istiyorsunuz?");
                    kullanici_adi = s.next();
                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i] != null && arrKullanicilar[i].getKullaniciAdi().equals(kullanici_adi)) {
                            logginUser.mesajGoruntule(arrKullanicilar[i]);
                        }
                    }
                    System.out.println("****************************");

                    break;
                case "11":
                    for (int i = 0; i < arrKullanicilar.length; i++) {
                        if (arrKullanicilar[i] != null && arrKullanicilar[i] == logginUser) {
                            logginUser.indirim();
                        }

                    }

                    break;
                case "12":
                    
                    System.exit(12);

                    break;

            }

        } while (islem != "12");
    }

}
