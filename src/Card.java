

public class Card {
    String number;
    String sign;
    int power;

    public String getNumber() {
        return number;
    }

    public String getSign() {
        return sign;
    }

    public int getPower() {
        return power;
    }


    public Card(String number, String sign, int power){
        this.number = number;
        this.sign = sign;
        this.power = power;
    }


}
