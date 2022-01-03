package out.Jamie_Mahabir_657666_assignsubmission_file_;
/**
 Virtual Meeting System class
 
 816019893
 
 */

import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class VirtualMeetingSystem   
{
    
    private VirtualRoom system;
    private String[] data=new String[50];
    private int numberOfParticipants=0;
    
    //methods
    
    public void loadParticipantData(String filename){
        
        int i=0;
        
        try{

            File file=new File(filename);
            Scanner reader= new Scanner(file);
            
            
            data[i]=reader.nextLine();
            i++;
            while(reader.hasNextLine()){
                
                this.data[i]=reader.nextLine();
                i++;
            }
        
        }
        catch (FileNotFoundException exception){
            System.out.println("Error! File not found");
        }
        
        this.numberOfParticipants=i;
    
    
    }
    
    
    public void createVirtualRoom(String name){
    
        this.system=new VirtualRoom(name);
        this.system.createBreakoutRooms();
    }
    
    
    public void allocateParticipants(String code){
        
        int limit=0;
        int i=0; 
        int j=0;
        boolean allocate;
        
        if(code.equals("C5")){
            
            for(i=0; i<system.getNumberOfBreakoutRooms(); i++){
                
                while(limit<10){
                    
                    allocate=system.addParticipantToBreakoutRoom(data[j],i);
                    
                    j++;
                    limit++;
                    
                
                }
                limit=0;
        }
    
    }
    else{
        if(code.equals("RR")){
            j =0;
            limit = 0;
            i = 0;
            
            
            while(limit<numberOfParticipants){
                
                for(i=0; i<system.getNumberOfBreakoutRooms(); i++){
                    allocate=system.addParticipantToBreakoutRoom(data[j],i);
                    j++;
                }
               
                limit+=5;
    }
}
}
}
    
  public boolean addParticipant(String participantID, int roomNumber){
    
      return (system.addParticipantToBreakoutRoom(participantID, roomNumber));
   
    }
    
    
    public String listParticipants(int roomNumber){
    
        return system.listParticipantsInBreakoutRoom(roomNumber);
        
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
    
        return system.openBreakoutRoom(roomNumber);
        
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
    
        return system.closeBreakoutRoom(roomNumber);
        
    
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        String details=system.findParticipantBreakoutRoom(participantID);
        return details;
        
    
    }
    
    
    public String listAllBreakoutRooms(){
        
        return system.listBreakoutRooms();
        
    }
    
    
    public String listParticipantsInAllBreakoutRooms(){
    
        String participantList;
        int i=0;
        
        participantList=system.listParticipantsInBreakoutRoom(0);
        
        for(i=1; i<system.getNumberOfBreakoutRooms(); i++){
            participantList+=system.listParticipantsInBreakoutRoom(i);
        }
        
        return participantList;
       
    }
    
}



//material referenced:
//https://www.tutorialspoint.com/java/java_object_classes.htm
//https://www.w3schools.com/java/java_files_read.asp


