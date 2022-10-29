package workingWithAbstractionExercise.cardWithPower;

public enum CardsSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    CardsSuit(int power){
        this.power = power;
    }

    public int getPower(){
        return power;
    }
}
