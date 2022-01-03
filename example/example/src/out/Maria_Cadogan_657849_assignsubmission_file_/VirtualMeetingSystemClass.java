package out.Maria_Cadogan_657849_assignsubmission_file_;//816013573

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;


public class VirtualMeetingSystemClass{
    
    ArrayList<String> participants = new ArrayList<String>();
    
   
    //Code sourced from W3Schools
    public void loadParticipantData(String filename){
        try {
            File f1 = new File(filename);
            Scanner myReader = new Scanner(f1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                participants.add(data);
                //System.out.println(data);
            }
            System.out.println(participants);
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    
        }
        
    }
    
    public void createVirtualRoom(String name){
        VirtualRoom vRoom = new VirtualRoom(name); 
        
    }
    
    public void allocateParticipants(String code){
        
        for(int i = 0; i < 5; i++){
            participants.get(i);
        }
    }
    
    
    
    
    
    
    /*
    //Tests
    public static void main(String[] args){
        VirtualMeetingSystemClass vm = new VirtualMeetingSystemClass();
        vm.loadParticipantData("participant.dat");
        
    }
    */
    
    
}