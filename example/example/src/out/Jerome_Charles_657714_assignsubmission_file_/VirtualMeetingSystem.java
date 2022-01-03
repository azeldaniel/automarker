package out.Jerome_Charles_657714_assignsubmission_file_;/*
Jerome Charles 816021939
Assignment 1
 */
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
public class VirtualMeetingSystem
{
 String store[]=new String[50];
 int count;
public static VirtualRoom VirtualRooms;
    
 public void loadParticipantData(String filename){
     
     
     count =0;
    //filename="participant.dat";  
      try {
      
      File file = new File(filename);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
          
        String data = myReader.nextLine();
        store[count]=data;
        //System.out.println(data);
        count=count+1;
        //System.out.println(count);
      }
      myReader.close();
      //System.out.println("COUNT AMOUNT-"+count);
    } catch (FileNotFoundException error) {
      System.out.println("An error occurred.");
      error.printStackTrace();
    } 
    //System.out.println(store[0]);
    //System.out.println(store[count-1]);
}


public void createVirtualRoom(String name){
//System.out.println("string name-"+name);    
VirtualRooms= new VirtualRoom(name);  
//System.out.println("name-"+VirtualRooms.getname());
VirtualRooms.createBreakoutRooms();
//System.out.println(VirtualRooms.breakoutRooms[0].participants[0]); 

}

public void allocateParticipants(String code){
int z=0;
if(code.equals("C5")){
    System.out.println("OPTION C5"); 
    for(int i=0;i<5;i++){
        VirtualRooms.openBreakoutRoom(i+1); 
     for(int y=0;y<5;y++){
         
         addParticipant(store[z],(i+1));
         z++;
        }   
        
       
    }
    //System.out.println("space");
    //System.out.println(VirtualRooms.listParticipantsInBreakoutRoom(1)); 
}


else if(code.equals("RR")){
    z=0;
    for(int y=0;y<5;y++){
    VirtualRooms.openBreakoutRoom(y+1);}
    for(int i=0;i<5;i++){
    
        
        for(int y=0;y<5;y++){
            
        addParticipant(store[z],y+1);
         z++;
        }
    }

    
}
else{System.out.println("Invalid Code");}

}


public boolean addParticipant(String participantID,int roomNumber){

//System.out.println(participantID+"space"+roomNumber);
//test=VirtualRooms.addParticipantToBreakoutRoom(participantID,roomNumber);

return VirtualRooms.addParticipantToBreakoutRoom(participantID,roomNumber);
}


public String listParticipants(int roomNumber){
String test;
test=VirtualRooms.listParticipantsInBreakoutRoom(roomNumber);
return test;
}

public boolean openBreakoutRoom(int roomNumber){
boolean test;
test=VirtualRooms.openBreakoutRoom(roomNumber);
return test;

}

public boolean closeBreakoutRoom(int roomNumber){
boolean test;
test=VirtualRooms.closeBreakoutRoom(roomNumber);
return test;

}

public String findParticipantBreakoutRoom(String participantID){
String test;
test=VirtualRooms.findParticipantBreakoutRoom(participantID);
return test;

}

public String listAllBreakoutRooms(){
  /*System.out.println("Virtual Room");
for(int i=0;i<5;i++){
 if(VirtualRooms.getbreakoutRooms()[i].getopen()==true){ 
     System.out.println(VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID());}
}*/
String holder=("Virtual Room"+"\r\n");

for(int i=0;i<5;i++){
 if(VirtualRooms.getbreakoutRooms()[i].getopen()==true){ 
   holder=(holder+VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID()+"\r\n"); }
}
//System.out.println(holder);
return holder;
}
 

public String listParticipantInAllBreakoutRooms(){
 //System.out.println("Managed Rooms and Participants");
 /*
for(int i=0;i<5;i++){
 if(VirtualRooms.getbreakoutRooms()[i].getopen()==true){ 
     //System.out.println(VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID());
    System.out.println(listParticipants(i+1));
    
    }
    
  else if(VirtualRooms.getbreakoutRooms()[i].getopen()==false){
    System.out.println(VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID());  
    System.out.println("Empty");
    }
}*/
String holder=("Managed Rooms and Participants"+"\r\n");

for(int i=0;i<5;i++){
 if(VirtualRooms.getbreakoutRooms()[i].getopen()==true){ 
     //System.out.println(VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID());
    //System.out.println(listParticipants(i+1));
    holder=(holder+listParticipants(i+1)+"\r\n");
    }
    
  else if(VirtualRooms.getbreakoutRooms()[i].getopen()==false){
    //System.out.println(VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID());  
    //System.out.println("Empty");
    holder=(holder+VirtualRooms.getbreakoutRooms()[i].getbreakoutRoomID()+"\r\n"+"Empty"+"\r\n");
    }
}


return holder;

} 



}  

