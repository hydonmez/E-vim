
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import javax.swing.JOptionPane;

public class veritabanibaglanti {

    static Connection baglanti;
    static Statement statment;

    ResultSet soneklenefaturalar() {

        ResultSet res = null;

        try {
            //https://kod5.org/mysql-the-server-time-zone-value-eest-is-unrecognized-hatasinin-cozumu/
            //https://www.youtube.com/watch?v=kUApu7Ooes8&list=PLzIWkToFwqHSZuhkX5NEojR7ZMWE1XQu7&index=51
            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");//veritabanıyla baglantı kuruyoruz diger acıklamalar yukarıda var
            Statement sorgu = baglanti.createStatement(); //sql sorgusu icin yeni bir ifade nesnesi olusturuyoruz
            res = sorgu.executeQuery("select*from fatura_tbl  order by fatura_kayitno desc ");//sorgu bir icin bir tane sorgu cumlecigi yaziyoruz ve sonucunu res degerine atiyoruz

        } catch (Exception e) {
            e.printStackTrace();//hatay� otomatik yakala ve g�ster
        }
        return res;

    }

    ResultSet garantisisuresiazalanurunler() {

        ResultSet res = null;

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            res = sorgu.executeQuery("select*from garantibelge_tbl order by garantibelge_urunungarantibitissuresi asc");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);//hatayı yakala ve ekranda goster 

        }
        return res;

    }

    ResultSet garantisonkayit() {

        ResultSet res = null;

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            res = sorgu.executeQuery("select garantibelge_kayitno from garantibelge_tbl ");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    ResultSet faturasonkayit() {

        ResultSet res = null;

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            res = sorgu.executeQuery("select fatura_kayitno from fatura_tbl ");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;

    }

    public void garantibelgesiveyafaturaekle(String sorgucumlecigi) {

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            sorgu.executeUpdate(sorgucumlecigi);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void sqlislemler(String sorgucumlecigi) {

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            sorgu.executeUpdate(sorgucumlecigi);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    ResultSet verilisteleme(String sqlsorgu) {

        ResultSet res = null;

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            res = sorgu.executeQuery(sqlsorgu);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return res;

    }

    public void guncelleme(String sorgucumlecigi) {

        try {

            Connection baglanti = DriverManager.getConnection("jdbc:mysql://localhost:3306/evim?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "1234");
            Statement sorgu = baglanti.createStatement();
            sorgu.executeUpdate(sorgucumlecigi);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
