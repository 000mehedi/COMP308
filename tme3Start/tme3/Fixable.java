package tme3;

public interface Fixable {
// turns Power on, fix window and zeros out error codes

    void fix ();

// logs to a text file in the current directory called fix.log

// prints to the console, and identify time and nature of

// the fix

    void log();

}