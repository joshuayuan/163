package me.joshuayuan.a163;

/**
 * Created by JoshuaYuan on 8/19/2016.
 * CardNode should never be empty. Always needs a value.
 */
public class CardNode {

    private final int NOOP = 0;
    private final int PLUS = 1;
    private final int SUB = 2;
    private final int MULT = 3;
    private final int DIV = 4;

    private CardNode child1; //left
    private CardNode child2; //right
    private int operation;
    private double value;

    private int position;

    public CardNode(double value){ //creating card with only a value EX starting the game
        this.child1 = null;
        this.child2 = null;
        this.value = value;
        this.operation = NOOP;
    }
    public CardNode(CardNode a, CardNode b, int operation){ //creating a new cardnode from 2 w/ operation
        this.child1 = a;
        this.child2 = b;
        this.value = eval(a.getValue(), b.getValue(), operation);
        this.operation = operation;

    }

    public double getValue(){
        return this.value;
    }

    private double eval(double aVal, double bVal, int operation){
        switch (operation){
            case PLUS:
                return aVal + bVal;
            case SUB:
                return aVal - bVal;
            case MULT:
                return aVal * bVal;
            case DIV:
                if(bVal == 0){
                    return Double.MAX_VALUE;
                }
                return aVal/bVal;
            default:
                return this.value;
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}