import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TerribleSceduler
 */
public class TerribleSceduler {
    final static int ARG_COUNT = 1;

    private static String fileAdress;

    public static void main(String[] args) {
        try{
            parseArgs(args);
            ArrayList<task> taskList = LoadFromFile(fileAdress);
            for (task task : taskList) {
                System.out.println(task.toFormattedString());
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Incorrect parameter due to:");
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("fuck: "+e.getMessage());
        }
    }

    /*
     * Parses arguments, throws exceptions if arguments are incorrect
     */
    private static void parseArgs(String[] args){
        if (args.length != ARG_COUNT){
            IllegalArgumentException e = new IllegalArgumentException("Invalid argument count\n Expected "+ARG_COUNT+", got "+args.length);
            throw e;
        }
        System.out.print("Running TerribleSceduler with arguments: ");
        for (String arg : args) {
            System.out.print(arg);
        }
        System.out.println();
        fileAdress = args[0];
    }

    /*
     * Main menu
     */
    private static void mainMenu(){
        System.out.println("Main Menu");
    }

    /*
     * Load and parse tags
     */
    private static ArrayList<task> LoadFromFile(String fileName) throws FileNotFoundException{
        try {
            ArrayList<task> tasks = new ArrayList<>();
            File myObj = new File(fileName + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                if (data.charAt(0) != '/'){
                    String[] splitStrings = data.split("; "); 
                    task newTask = new task(splitStrings[0], Integer.parseInt(splitStrings[1]), Integer.parseInt(splitStrings[2]));
                    tasks.add(newTask);
                }
            }
            myReader.close();
            return tasks;
        } catch (FileNotFoundException e) {
            throw e;
        }   
    }
}