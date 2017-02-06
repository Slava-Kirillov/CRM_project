package mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class MainBean {

    public MainBean() {
    }

    private int days = 5, price = 19, estimatedCost = 1140;
    private String email = "", nameClient = "", rate = "", tarif_1 = "butjet", tarif = "", lengthAudio = "60";
    private String tarif_2 = "st", tarif_3 = "Eng", category = "standart", linkToFile = "";
    private String categRus = "", other = "", messageOther = "", nameMessage = "", emailMessage = "", linkMessage = "", lengthMess = "";
    private boolean textOn = true, dump = true;

    //Methods
    public void costCalculation() {
        validField();
        if (lengthMess.equals("")) {
            estimatedCost = price * Integer.parseInt(lengthAudio);
        } else {
            estimatedCost = 0;
        }
    }

    public void engToRus() {
        if (category.equals("standart")) {
            this.categRus = "Стандарт";
            if (tarif_1.equals("butjet")) {
                this.tarif = "Бютжет";
            }
            if (tarif_1.equals("econom")) {
                this.tarif = "Эконом";
            }
            if (tarif_1.equals("optim")) {
                this.tarif = "Оптимум";
            }
            if (tarif_1.equals("fast")) {
                this.tarif = "Срочно";
            }
        }
        if (category.equals("sud")) {
            this.categRus = "Для суда";
            if (tarif_2.equals("st")) {
                this.tarif = "Стандарт";
            }
            if (tarif_2.equals("bad")) {
                this.tarif = "Пониженное качество";
            }
            if (tarif_2.equals("fast")) {
                this.tarif = "Срочно";
            }
        }
        if (category.equals("Lang")) {
            this.categRus = "Иностранный язык";
            if (tarif_3.equals("Eng")) {
                this.tarif = "Английский";
            }
            if (tarif_3.equals("Fren")) {
                this.tarif = "Французкий";
            }
            if (tarif_3.equals("Esp")) {
                this.tarif = "Испанский";
            }
            if (tarif_3.equals("Other")) {
                this.tarif = other;
            }
        }
    }

    public void detDaysAndPrice() {
        if (category.equals("standart")) {
            if (tarif_1.equals("butjet")) {
                this.days = 5;
                this.price = 19;
            }
            if (tarif_1.equals("econom")) {
                this.days = 3;
                this.price = 25;
            }
            if (tarif_1.equals("optim")) {
                this.days = 1;
                this.price = 29;
            }
            if (tarif_1.equals("fast")) {
                this.days = 1;
                this.price = 50;
            }
            dump = true;
            costCalculation();
        }
        if (category.equals("sud")) {
            if (tarif_2.equals("st")) {
                this.days = 2;
                this.price = 39;
            }
            if (tarif_2.equals("bad")) {
                this.days = 3;
                this.price = 59;
            }
            if (tarif_2.equals("fast")) {
                this.days = 1;
                this.price = 78;
            }
            dump = false;
            costCalculation();
        }

        if (category.equals("Lang")) {
            if (tarif_3.equals("Eng")) {
                this.days = 2;
                this.price = 65;
                this.textOn = true;
            }
            if (tarif_3.equals("Fren")) {
                this.days = 3;
                this.price = 85;
                this.textOn = true;
            }
            if (tarif_3.equals("Esp")) {
                this.days = 1;
                this.price = 85;
                this.textOn = true;
            }
            if (tarif_3.equals("Other")) {
                this.days = 1;
                this.price = 100;
                this.textOn = false;
            }
            costCalculation();
        }
    }

    public void insertDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/manformdb?useUnicode=true&characterEncoding=utf8";
            String login = "root";
            String password = "pandora";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                stmt.execute("set character set utf8");
                stmt.execute("set names utf8");
//                ResultSet rs = stmt.executeQuery("SELECT * FROM main");
//                while (rs.next()) {
//                    String str = rs.getString("name");
//                    System.out.println("Name:" + str);
//                }
                String query = "INSERT INTO main (name, email, category, cost, length, tarif, day, link) \n"
                        + " VALUES ('" + nameClient + "', '" + email + "', '" + categRus + "', '" + estimatedCost + "', '" + lengthAudio + "', '" + tarif + "', '" + days + "', '" + linkToFile + "');";
                stmt.executeUpdate(query);
//                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validField() {
        if (tarif_3.equals("Other")) {
            if (other.equals("")) {
                messageOther = "*Введите язык";
                return null;
            } else {
                messageOther = "";
                return "confirm";
            }
        } else {
            messageOther = "";
            return "confirm";
        }
    }

//<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getLengthMess() {
        return lengthMess;
    }

    public void setLengthMess(String lengthMess) {
        this.lengthMess = lengthMess;
    }

    public boolean isDump() {
        return dump;
    }

    public void setDump(boolean dump) {
        this.dump = dump;
    }

    public void setMessageOther(String messageOther) {
        this.messageOther = messageOther;
    }

    public String getMessageOther() {
        return messageOther;
    }

    public String getCategRus() {
        return categRus;
    }

    public void setCategRus(String categRus) {
        this.categRus = categRus;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getLinkToFile() {
        return linkToFile;
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getLengthAudio() {
        return lengthAudio;
    }

    public void setLengthAudio(String lengthAudio) {
        this.lengthAudio = lengthAudio;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTarif_1() {
        return tarif_1;
    }

    public void setTarif_1(String tarif_1) {
        this.tarif_1 = tarif_1;
    }

    public String getTarif_2() {
        return tarif_2;
    }

    public void setTarif_2(String tarif_2) {
        this.tarif_2 = tarif_2;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTarif_3() {
        return tarif_3;
    }

    public void setTarif_3(String tarif_3) {
        this.tarif_3 = tarif_3;
    }

    public boolean isTextOn() {
        return textOn;
    }

    public void setTextOn(boolean textOn) {
        this.textOn = textOn;
    }

    public String getNameMessage() {
        return nameMessage;
    }

    public void setNameMessage(String nameMessage) {
        this.nameMessage = nameMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getLinkMessage() {
        return linkMessage;
    }

    public void setLinkMessage(String linkMessage) {
        this.linkMessage = linkMessage;
    }
//</editor-fold>
}
