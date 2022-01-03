package out.Marc_Mungal_657841_assignsubmission_file_;
//816018788
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{   
    public void loadParticipantData(String[] arg){
        try{
            File myObj= new File("participant.dat");
            Scanner myReader= new Scanner (myObj);
            while(myReader.hasNextLine()){
                String data= myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
    }catch(FileNotFoundException e)
      {
        System.out.println("An error occured.");
        e.printStackTrace();
      }
    }
    public void createVirtualRoom(String name){
         String breakoutRoom1;
         String breakoutRoom2;
         String breakoutRoom3;
         String breakoutRoom4;
         String breakoutRoom5;       
    }
    
    public void allocateParticipants(String code){
        
        
    }
}
