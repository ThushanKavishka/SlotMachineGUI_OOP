/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

/**
 *
 * @author THUSHAN
 */
public class Symbol implements ISymbol {

    int matchSymbols = 0;

    String image; // stores path of the image
    int value; // credit of the symbol

    //create contructor of Symbol class..
    public Symbol() {

    }
    //public method to set Image..
    @Override
    public void setImage(String image) {

        this.image = image;

    }
    //public method to return image..
    @Override
    public String getImage() {
        return this.image;

    }
    //public method to set value
    @Override
    public void setValue(int value) {
        this.value = value;
    }
    //public method to return value
    @Override
    public int getValue() {
        return this.value;
    }
    //check if three symbols are matched or not from their values
    public int checkThreeSymbols(Symbol s1, Symbol s2, Symbol s3) {
        if (s1.getValue() == s2.getValue() && s2.getValue() == s3.getValue()) {
            matchSymbols = 3;
        } else if (s1.getValue() == s2.getValue()) {
            matchSymbols = 2;
        } else if (s2.getValue() == s3.getValue()) {
            matchSymbols = 2;
        } else if (s1.getValue() == s3.getValue()) {
            matchSymbols = 2;
        } else {
            matchSymbols = 0;
        }
        return matchSymbols;

    }
}
