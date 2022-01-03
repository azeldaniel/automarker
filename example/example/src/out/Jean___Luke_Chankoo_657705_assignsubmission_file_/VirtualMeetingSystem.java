package out.Jean___Luke_Chankoo_657705_assignsubmission_file_;//816006490
import java.util.*;
import java.io.FileNotFoundException; 
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class VirtualMeetingSystem
{
    
    public void loadParticipantData(String filename)
    {
        
        try{
            Scanner s1= new Scanner(new File(filename));
            int linecount=0;
            while(s1.hasNextLine()){ // counts lines in file
                linecount=linecount+1;
                s1.next();
            }
            String [] participantsArray=new String[linecount]; 
            Scanner s2= new Scanner(new File(filename));
            for(int i=0; i<linecount; i++){
                
                participantsArray[i]=s2.next();
                //tests if data is read
                //System.out.println(participantsArray[i]);
            }
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
      
        }        
    }


    public void createVirtualRoom(String name){
       
    VirtualRoom v=   new VirtualRoom(name);
    v.createBreakoutRooms();
    
    }
    
    
    public void allocateParticipants(String code){
    
    if(code.equals("C5") || (code.equals("c5"))){
        try{
            Scanner s1= new Scanner(new File("participant.dat"));
            int linecount=0;
            while(s1.hasNextLine()){ // counts lines in file
                linecount=linecount+1;
                s1.next();
            }
            String [] participantsArray=new String[linecount]; 
            Scanner s2= new Scanner(new File("participant.dat"));
            for(int i=0; i<linecount; i++){
                
                if(i>=0 && i<10){
                 addParticipant(s2.next(),1);
                }
                if(i>=10 && i<20){
                addParticipant(s2.next(),2);
                }
                if(i>=20 && i<30){
                addParticipant(s2.next(),3);
                }
                if(i>=30 && i<40){
                addParticipant(s2.next(),4);
                }
                if(i>=40 && i<50){
                addParticipant(s2.next(),5);
                }
                
            }
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
      
        }           
        
    }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        
       VirtualRoom v= new VirtualRoom("Workshop");
        
        if(roomNumber>=1 && roomNumber<=5){
           
        v.addParticipantToBreakoutRoom(participantID,roomNumber);   
        return true;
        }
            return false;
    }
    
    public String listParticipants(int roomNumber){
    
    VirtualRoom v= new VirtualRoom("Workshop");
    if(v.listParticipantsInBreakoutRoom(roomNumber)!=null){
        return (v.listParticipantsInBreakoutRoom(roomNumber));
    }
    return null;    
    }
    
    public boolean openBreakoutRoom(int roomNumber){
    
    VirtualRoom v= new VirtualRoom("Workshop");
    boolean check=v.openBreakoutRoom(roomNumber);
    if(check=true){
    return true;
    }
    else{
    return false;
    }   
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
    VirtualRoom v= new VirtualRoom("Workshop");
    boolean check=v.closeBreakoutRoom(roomNumber);
    if(check=true){
    return true;
    }
    else{
    return false;
    }
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        
    VirtualRoom v= new VirtualRoom("Workshop");  
    String check=v.findParticipantBreakoutRoom(participantID);
    if(check!=null){
    return check;
    }
    else{
    return null;
    }

    }
    
    public String listAllBreakoutRooms(){
    String list; 
    VirtualRoom v= new VirtualRoom("Workshop");
    list=v.listBreakoutRooms();
    return list;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
    
    VirtualRoom v= new VirtualRoom("Workshop");
    
    for(int i=0; i<5; i++){
    v.listParticipantsInBreakoutRoom(i);
    }
        
    return null;    
    } 
    
}
