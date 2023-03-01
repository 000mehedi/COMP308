import jdk.jfr.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Restart extends Event {
    private final Boolean temp;
    private String eventsFile;
    private final Controller controller;

    public Restart(Boolean temp, Controller controller) {
        this.temp = temp;
        this.controller = controller;
    }

    public void action() {
        synchronized(controller) {
            controller.running(false);
            File file = new File(eventsFile);
            try {
                controller.setVariable("Events File", eventsFile);
                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    Pattern pattern = Pattern.compile("(\\w*)=(\\w*),?");
                    Matcher matcher = pattern.matcher(line);
                    HashMap<String, String> hash = new HashMap<>();

                    while(matcher.find()) {
                        String key = matcher.group(1);
                        String value = matcher.group(2);
                        hash.put(key, value);
                    }

                    long delayTime = Long.parseLong(hash.get("delay"));
                    controller.addEvent(hash.get("event"), delayTime);
                }

                scanner.close();

                if(temp) {
                    file.delete();
                }
            } catch(ControllerException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();

            } catch(FileNotFoundException e) {
                System.out.println("Settings file not found!");
            }
        }
    }

    public String toString() {
        return "Restarting system";
    }
}