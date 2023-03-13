

public final class Card {
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

    public void setPower(int power) {
        this.power = power;
    }

    public Card(String number, String sign){
        this.number = number;
        this.sign = sign;
    }


}
