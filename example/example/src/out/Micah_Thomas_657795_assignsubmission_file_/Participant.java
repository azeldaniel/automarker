package out.Micah_Thomas_657795_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Participant{
    private String participantID;
    
    /*public static void main(String[] args){
        String[] arr= new String[100];
        int i=0;
        try{
            File myObj=new File("participant.dat");
            Scanner myReader=new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data=myReader.nextLine();
                arr[i]=data;
                i++;
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(arr[1]);
    }**/
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID){        
        // initialise instance variables
        this.participantID= participantID;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    static boolean verifyID(String participantID){
        if(participantID.length()!=8){
            return false;
        }else{
            return true;
        }
    }
    
    //public
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details ="Participant: " + participantID;
        return details;
    }
}
