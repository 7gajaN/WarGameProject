import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

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

    public void setPower(int power) {
        this.power = power;
    }

    public Card(String number, String sign, int power){
        this.number = number;
        this.sign = sign;
        this.power = power;
    }


}
