//Name: Md. Abdullah Mehedi Patwary
//ID: 3619873
//Email: mpatwary1@athabasca.edu
//Date: 07/11/2022

//Task: Modify Music5.java by adding a Playable interface. Move the play( ) declaration from Instrument to Playable.
//      Add Playable to the derived classes by including it in the implements list.
//      Change tune( ) so that it takes a Playable instead of an Instrument.

//Simply, run the Music5.java if the print statements match with the expected result of testPlan.txt, then it works.

enum Note{
    //An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
    MIDDLE_C
}
interface Instrument{
    int VALUE = 5;
    void adjust();
}

interface Playable{
    void play(Note n);
}

class Wind implements Instrument, Playable{
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString(){
        return "Wind";
    }
    public void adjust(){
        System.out.println(this + ".adjust()");
    }
}

class Percussion implements Instrument, Playable{
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString(){
        return "Percussion";
    }
    public void adjust(){
        System.out.println(this + ".adjust()");
    }

}

class Stringed implements Instrument, Playable{
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString(){
        return "Stringed";
    }
    public void adjust(){
        System.out.println(this + ".adjust()");
    }
}


class Woodwind extends Wind{
    public String toString(){
        return "Woodwind";
    }
}

class Brass extends Wind{
    public String toString(){
        return "Brass";
    }
}

public class Music5 {
    static void tune(Playable i){
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e){
        for(Playable i : e)
            tune(i);
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Woodwind(),
                new Brass(),

        };
        tuneAll(orchestra);
    }
}