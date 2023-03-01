//Name: Md. Abdullah Mehedi Patwary
////ID: 3619873
////Email: mpatwary1@athabasca.edu
////Date: 17/11/2022

//: innerclasses/GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct 21, 2005
 *
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tme3.*;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;

public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private boolean fans = false;
    private String thermostat = "Day";
    private String eventsFile = "examples1.txt";
    private boolean windowok = true;
    private boolean poweron = true;
    private int errorcode = 0;



    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }
        public String toString() {
            return "Light is on";
        }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }
        public String toString() {
            return "Light is off";
        }
    }
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here.
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here.
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }

    }
    public class FansOn extends Event{
        public FansOn(long delayTime){
            super(delayTime);
        }
        public void action(){
            fans = true;
        }
        public String toString(){
            return "Greenhouse fans are on";
        }
    }

    public class FansOff extends Event{
        public FansOff(long delayTime){
            super(delayTime);
        }
        public void action(){
            fans = false;
        }
        public String toString(){
            return "Greenhouse fans are off";
        }
    }
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here.
            thermostat = "Night";
        }
        public String toString() {
            return "Thermostat on night setting";
        }
    }
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here.
            thermostat = "Day";
        }
        public String toString() {
            return "Thermostat on day setting";
        }
    }
    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends Event {
        private int rings;
        private int rung;

        public Bell(long delayTime, int rings, int rung) {
            super(delayTime);
            this.rings = rings;
            this.rung = rung;
        }
        public void action() {
            rung++;
            if(rung< rings){
                addEvent(new Bell(delayTime, rings, rung));
            }

        }
        public String toString() {
            return "Bing!";
        }
    }

    public class WindowMalfunction extends Event{
        public WindowMalfunction(long delayTime){
            super(delayTime);
        }
        public void action() throws ControllerException{
            windowok =  false;
            errorcode = 1;
            eventList.remove(this);
            throw new ControllerException(this.toString());
        }public String toString() {
            return "Window Malfunction Detected!";
        }

    }
    public class FixWindow implements Fixable{
        @Override
        public void fix() {
            windowok = true;
        }

        @Override
        public void log() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();

            String fixLine = "[" + dateFormat.format(date) + "]";
            fixLine += "Windows Fixed";
            try (
                    FileWriter fileWriter = new FileWriter("fix.log", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ){
                printWriter.println(fixLine);
                System.out.println("Windows fixed on:\n " + fixLine);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public class PowerOut extends Event {
        public PowerOut(long delayTime) {
            super(delayTime);
        }
        public void action() throws ControllerException {
            poweron = false;
            errorcode = 2;

            eventList.remove(this);
            throw new ControllerException(this.toString());
        }
        public String toString() {
            return "There's no greenhouse power";
        }
    }

    public class PowerOn implements Fixable{
        @Override
        public void fix() {
            poweron = true;
        }

        @Override
        public void log() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();

            String fixLine = "[" + dateFormat.format(date) + "]";
            fixLine += "Greenhouse Power on";
            try (
                FileWriter fileWriter = new FileWriter("fix.log", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ){
                printWriter.println(fixLine);
                System.out.println("Power on:\n " + fixLine);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }



    public class Restart extends Event {
        private Boolean temp;
        public Restart(long delayTime, String filename, Boolean temp) {
            super(delayTime);
            eventsFile = filename;
            this.temp = temp;
        }

        public void action() {
            File file = new File(eventsFile);
            try{
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();

                    // pattern is [key] = [value]
                    Pattern pattern = Pattern.compile("(\\w*)=(\\w*),?");
                    Matcher matcher = pattern.matcher(line);

                    Map<String, String> map = new HashMap<>();

                    //for every key, value in line
                    while (matcher.find()) {
                        String key = matcher.group(1);
                        String value = matcher.group(2);
                        map.put(key, value);

                    }
                    long delayTime = Long.parseLong(map.get("time"));

                    if (map.get("Event").equals("LightOn")){
                        addEvent(new LightOn(delayTime));

                    }else if (map.get("Event").equals("LightOff")){
                        addEvent(new LightOff(delayTime));

                    }else if (map.get("Event").equals("WaterOn")){
                        addEvent(new WaterOn(delayTime));

                    }else if (map.get("Event").equals("WaterOff")){
                        addEvent(new WaterOff(delayTime));

                    }else if (map.get("Event").equals("FansOn")){
                        addEvent(new FansOn(delayTime));

                    }else if (map.get("Event").equals("FansOff")){
                        addEvent(new FansOff(delayTime));
                    }else if (map.get("Event").equals("ThermostatDay")){
                        addEvent(new ThermostatDay(delayTime));
                    }else if (map.get("Event").equals("ThermostatNight")){
                        addEvent(new ThermostatNight(delayTime));
                    }else if (map.get("Event").equals("Bell")){
                        int rings = 0;
                        if(map.containsKey("rings")) rings = Integer.parseInt(map.get("rings"));
                        addEvent(new Bell(delayTime, rings, 0));
                    }
                    else if (map.get("Event").equals("WindowMalfunction")){
                        addEvent(new WindowMalfunction(delayTime));
                    }else if (map.get("Event").equals("PowerOut")){
                        addEvent(new PowerOut(delayTime));
                    }
                    else if (map.get("Event").equals("Terminate")){
                        addEvent(new Terminate(delayTime));
                    }
                }
                scanner.close();
                if(temp){
                    file.delete();
                }
            }catch(FileNotFoundException e){
                System.out.println("File not found!");
            }
        }

        public String toString() {
            return "Restarting system";
        }
    }

    public class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }
        public void action() {
            System.exit(0);
        }
        public String toString() {
            return "Terminating";
        }
    }

    public class Restore{
        //empty string to store files
        public String events = "";
        private Restore(String dump){
            //dump file
            File file = new File(dump);
            String section = "";
            try{
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    if(line.length() <=0){ //ignores the blank lines
                        continue;
                    }else if(line.charAt(0) == '['){
                        section = line;
                    }else{
                        parse(section,line); //parse lines based on section
                    }

                }
                //after being parsed, restart GreenhouseControls
                apply();
                scanner.close();
            }catch(FileNotFoundException e){
                System.out.println("File not found");
            }

            }
            private void parse(String section, String line){
                Pattern pattern = Pattern.compile("(.*)\\:(.*)");
                Matcher matcher = pattern.matcher(line);
                String key= "";
                String value= "";
                if(matcher.find()) {
                    key = matcher.group(1);
                    value = matcher.group(2);
                }
                //parse lines based on section
                if(section.equals("[STATES]")){
                    parseStateLine(key,value);
                }else if(section.equals("[ERROR CONDITIONS]")){
                    parseErrorLine(key,value);
                }else if(section.equals("[EVENTS]")){
                    parseEventLine(line);
                }
            }

            private void parseStateLine(String key, String value){ //parse States
                if(key.equals("Lights")) {
                    light = Boolean.parseBoolean(value);
                }else if(key.equals("Water")) {
                    water = Boolean.parseBoolean(value);
                }else if(key.equals("Fans")) {
                    fans = Boolean.parseBoolean(value);
                }else if(key.equals("Thermostat")) {
                    thermostat = value;
                }else if(key.equals("Settings File")) {
                    eventsFile = value;
                }
            }

            private void parseErrorLine(String key, String value){ //parse ErrorLines
            if(key.equals("Window")){
                windowok = Boolean.parseBoolean(value);
            }else if(key.equals("Power")){
                    poweron = Boolean.parseBoolean(value);
            }else if(key.equals("Errorcode")){
                errorcode = Integer.parseInt(value);
            }
            }

            private void parseEventLine(String line){ //parse EventLines
            this.events += line;
            }

            private void apply(){
            try{
                Files.write(Paths.get("restart.temp"), events.getBytes(), StandardOpenOption.CREATE);
            }catch (IOException e){
                e.printStackTrace();
            }
            addEvent(new Restart(0, "restart.temp", true));
            }


    }

    public int getError(){
        return errorcode;
    }

    public  Fixable getFixable(int error){
        errorcode = 0;
        if (error == 1){
            return new FixWindow();
        }else if (error == 2){
            return new PowerOn();
        }
        return null;
    }
    public void shutdown(String message){
        //get current date using SimpleDateFormat
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        // prints the line by this format: [yyyy-MM-dd HH:mm:ss]
        String  errorLine = "[" + dateFormat.format(date) + "]";
        errorLine += message;

        //adds/appends to error log
        try(
                FileWriter fileWriter = new FileWriter("error.log", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); PrintWriter printWriter = new PrintWriter(bufferedWriter);

        ){
            printWriter.println(errorLine);
            System.out.println("Power off: " + errorLine);
        }catch (IOException e){
            e.printStackTrace();
        }
        //states are stored here
        String dump = toString(eventList);

        try{
            Files.write(Paths.get("dump.out"), dump.getBytes(), StandardOpenOption.CREATE);

        }catch (IOException e){
            e.printStackTrace();
        }

        eventList.clear();
        addEvent(new Terminate(0));

    }

    public String toString(List<Event> eventList){
        //appends the states to dump
        StringBuilder state = new StringBuilder("[STATES]\n");
        state.append("Lights:").append(light).append("\n");
        state.append("Water:").append(water).append("\n");
        state.append("Fans:").append(fans).append("\n");
        state.append("Thermostat:").append(thermostat).append("\n");
        state.append("Settings File:").append(eventsFile).append("\n");
        state.append("[ERROR CONDITIONS]:" + "\n");
        state.append("Window:").append(windowok).append("\n");
        state.append("Power:").append(poweron).append("\n");
        state.append("Errorcode:").append(errorcode).append("\n");
        state.append("[EVENTS]" + "\n");

        for(Event e: eventList){
            state.append(e.toString(true));
        }
        return state.toString();
    }



    public static void printUsage() {
        out.println("Correct format: ");
        out.println("  java GreenhouseControls -f <filename>, or");
        out.println("  java GreenhouseControls -d dump.out");
    }

    //---------------------------------------------------------
    public static void main(String[] args) {
        try {
            String option = args[0];
            String filename = args[1];

            if ( !(option.equals("-f")) && !(option.equals("-d")) ) {
                out.println("Invalid option");
                printUsage();
            }

            GreenhouseControls gc = new GreenhouseControls();

            if (option.equals("-f"))  {
                gc.addEvent(gc.new Restart(0,filename, false));
            }else if(option.equals("-d")) {

                GreenhouseControls.Restore restore = gc.new Restore(filename);
            }

            gc.run();
        }
        catch (ArrayIndexOutOfBoundsException | ControllerException e) {
            System.out.println("Invalid number of parameters");
            printUsage();
        }
    }

} ///:~
