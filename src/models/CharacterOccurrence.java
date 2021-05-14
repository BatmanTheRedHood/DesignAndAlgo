package models;

public class CharacterOccurrence {
    // properties:
    public char c;
    public int firstOccurrence;
    public int lastOccurrence;

    // methods:
    public CharacterOccurrence(char c, int f){
        this.c = c;
        this.firstOccurrence = this.lastOccurrence = f;
    }
}
