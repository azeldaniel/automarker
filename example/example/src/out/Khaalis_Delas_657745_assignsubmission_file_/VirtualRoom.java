package out.Khaalis_Delas_657745_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Khaalis De Las- 8160071114
public class VirtualRoom 
{
private String name;
private int breakoutRoomLimit;
private BreakoutRoom[] breakoutRooms;
 
//created my own open/close variable to compensate for rooms
private boolean isOpen;
int breakoutRoomsTotal=0;

//    BreakoutRoom[] breakoutRooms= new BreakoutRoom [5];

//constructor
public VirtualRoom (String name){
 name= name;
this.breakoutRoomLimit = 5;
}

//overloaded constructor
public VirtualRoom(String Name, int limit){
this.name= name;
this.breakoutRoomLimit= limit;
}

    //check over this
public int getNumberOfBreakoutRooms(){
int numRooms= breakoutRooms.length;
return numRooms;
}

public void createBreakoutRooms(){
    String breakoutRoomTemp= "";
    BreakoutRoom b= new BreakoutRoom(breakoutRoomTemp);
    breakoutRooms[breakoutRoomsTotal]=b;
    breakoutRoomsTotal++;
   /* if( getNumberOfBreakoutRooms() == breakoutRoomLimit){
    System.out.println("The BreakoutRoom limit has been met");
    }
    else{
    breakoutRoomsTotal++;
    }
/*
BreakoutRoom b1= new BreakoutRoom("Workshop1");
BreakoutRoom b2= new BreakoutRoom("Workshop2");
BreakoutRoom b3= new BreakoutRoom("Workshop3");
BreakoutRoom b4= new BreakoutRoom("Workshop4");
BreakoutRoom b5= new BreakoutRoom("Workshop5");

breakoutRooms[1]= b1;
breakoutRooms[2]= b2;
breakoutRooms[3]= b3;
breakoutRooms[4]= b4;
breakoutRooms[5]= b5;

*/



}


public BreakoutRoom findBreakoutRoom(int roomNumber){
for (int i=0; i<=5; i++){ //or from 0 till length of array
    if ( i == roomNumber){
        //if breakoutRooms[i] == num
    return breakoutRooms[i];
}
}
return null;
}

public boolean closeBreakoutRoom(int roomNumber){
    //&& (breakoutRooms[roomNumer] >=1 || breakoutRooms[roomNumer] <= 5)
if(breakoutRooms[roomNumber] != null ){
isOpen= false;
return isOpen;
}
else {
    isOpen= true;
return isOpen;}
}

public boolean openBreakoutRoom(int roomNumber){
    //&& (breakoutRooms[roomNumer] >=1 || breakoutRooms[roomNumer] <= 5)
if(breakoutRooms[roomNumber] != null ){
isOpen= true;
return isOpen;
}
else {
    isOpen= false;
return isOpen;}
}


//definitely check over
public String listBreakoutRooms(){
    for (int i=0; i<=breakoutRooms.length; i++){
        System.out.println(name + '\n');
 System.out.println(breakoutRooms[i]);
  // return listOfRooms.toString();
}
String lastline= "All rooms have been listed";
return lastline;
}



    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean confirm;
    if(breakoutRoomLimit < 5 && findBreakoutRoom(roomNumber)!= null){
    openBreakoutRoom(roomNumber);
    confirm= findBreakoutRoom(roomNumber).addParticipant(participantID);
    if(confirm==true)
    return true;
    }

return false;


}

/*
public String findParticipantBreakoutRoom(String participantID){
    
    
    for(int i=0; i<10; i++){
        if (breakoutRooms[i] == (participantID)){
        return breakoutRooms[i];
    }
        
    }
    
}
*/

public String listParticipantsInBreakoutRoom(int roomNumber){
    String list= "This is the list of participants:  " + "\n";
list += breakoutRooms[roomNumber].listParticipants();
return list;
    
}


}
