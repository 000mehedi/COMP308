

//Student ID: 3619873
//   Student Name: Md Abdullah Mehedi Patwary
//    Student email: mpatwary1@athabasca.edu
//Date: 07/12/2022


import java.awt.*;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




public class GreenhouseControls extends Controller {
    protected ArrayList<Tuple<String, String>> state;

    public GreenhouseControls(TextArea outPut, Object o, Method m) {
        super(outPut, o, m);

        //creates an empty arraylist(default)
        this.state = new ArrayList<>();

        // Set initial state
        setLights(false);
        setWater(false);
        setFans(false);
        setThermostat("Day");
        setEventsFile("");
        setWindowOk(true);
        setPowerOn(true);
        setErrorCode(0);
    }

    public void setVariable(String key, Object o, String message) throws ControllerException {
        String value;
        if ("Integer".equals(o.getClass().getSimpleName())) {
            value = "" + (int) o;
        } else {
            value = o.toString();
        }

        for(int i = 0; i < state.size(); i++) {
            Tuple<String, String> state = this.state.get(i);

            if(state.key.equals(key)) {

                this.state.set(i, new Tuple<>(key, value));

            }
        }
        //adds the tuple data to the state
        state.add(new Tuple<>(key, value));
    }

    public void setVariable(String key, Object value) throws ControllerException {
        setVariable(key, value, "Setting " + key);
    }

    public Object getVariable(String key) {
        for(Tuple<String, String> state : state) {
            if(state.key.equals(key)) {
                return state.value;
            }
        }
     return null;
    }

    //setters and getters
    public void setLights(Boolean state) {
        try {
            setVariable("Lights", state.toString());
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }

    public Boolean getLights() {
        return Boolean.parseBoolean((String)getVariable("Lights"));
    }

    public void setWater(Boolean state) {
        try {
            setVariable("Water", state.toString());
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }

    public Boolean getWater() {
        return Boolean.parseBoolean((String)getVariable("Water"));
    }

    public void setFans(Boolean state) {
        try {
        setVariable("Fans", state.toString());
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }
    public Boolean getFans() {
        return Boolean.parseBoolean((String)getVariable("Fans"));
    }

    public void setThermostat(String state) {
        try {
            setVariable("Thermostat", state);
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }
    public String getThermostat() {
        return (String)getVariable("Thermostat");
    }

    public void setEventsFile(String filename) {
        try {
            setVariable("Events File", filename);
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }
    public String getEventsFile() {
        return (String)getVariable("Events File");
    }

    public void setWindowOk(Boolean state) {
        try {
            setVariable("Window Ok", state.toString());
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }
    public Boolean getWindowOk() {
        return Boolean.parseBoolean((String)getVariable("Window Ok"));
    }

    public void setPowerOn(Boolean state) {
        try {
            setVariable("Power On", state.toString());
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }
    public Boolean getPowerOn() {
        return Boolean.parseBoolean((String)getVariable("Power On"));
    }

    public void setErrorCode(int code) {
        try {
            setVariable("Error Code ",+ code);
        } catch(ControllerException e) {
            e.printStackTrace();
        }
    }
    public int getErrorCode() {
        return Integer.parseInt((String)getVariable("Error Code"));
    }

    public void shutdown(String message) {
        // Get the current date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        // Line to print to console and error log
        String errLine = "[" + dateFormat.format(date) + "] ";
        errLine += message;

        // Appends to error.log
        try(FileWriter fileWriter = new FileWriter("error.log", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter ignored = new PrintWriter(bufferedWriter)
        ) {

            System.out.println("Logged: " + errLine);
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            StringBuilder dump = new StringBuilder();
            for(Tuple<String, String> t : state) {
                dump.append(t.key).append("=").append(t.value).append("\n");
            }
            Files.write(Paths.get("dump.out"), dump.toString().getBytes(), StandardOpenOption.CREATE);

            StringBuilder events = new StringBuilder();
            for(Event e : this.events) {
                if(e.getTime() > 0) {
                    events.append(e.serialize()).append("\n");
                }
            }
            Files.write(Paths.get("dump.settings"), events.toString().getBytes(), StandardOpenOption.CREATE);
        } catch(IOException e) {
            e.printStackTrace();
        }

        //clears the whole arraylist state
        state.clear();
        addEvent(new Terminate(0, this));
    }


    public String toString() {
        String data = "";
        data += "Lights: " + getLights() + "\n";
        data += "Water: " + getWater() + "\n";
        data += "Fans: " + getFans() + "\n";
        data += "Thermostat: " + getThermostat() + "\n";
        data += "Events File: " + getEventsFile() + "\n";
        data += "Window Ok: " + getWindowOk() + "\n";
        data += "Power On: " + getPowerOn() + "\n";
        data += "Error Code: " + getErrorCode() + "\n";
        return data;
    }
}