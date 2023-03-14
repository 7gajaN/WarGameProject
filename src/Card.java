

public final class Card {
    Numbers number;
    Signs sign;

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
    

    public Numbers getNumber() {
        return number;
    }

    public Signs getSign() {
        return sign;
    }


    public Card(Numbers number, Signs sign){
        this.number = number;
        this.sign = sign;
    }


}
