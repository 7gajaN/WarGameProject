

public final class Card {
    String number;
    String sign;
    int power;

    public enum Numbers {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
        Ace
    }

    public enum Signs {
        Hearts,
        Diamonds,
        Clubs,
        Spades
    }
    

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

    public Card(Numbers number, Signs sign){
        this.number = number.toString();
        this.sign = sign.toString();
    }


}
