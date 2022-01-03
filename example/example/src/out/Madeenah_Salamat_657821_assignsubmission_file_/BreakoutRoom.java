package out.Madeenah_Salamat_657821_assignsubmission_file_;// ID: 816020303

import java.util.Scanner;   

public class BreakoutRoom{
    //attributes
    private String name;
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    //constructor
    public BreakoutRoom(String name){
        this.name = name;
        this.breakoutRoomID = String.valueOf(breakoutRoomNumberCounter);
        this.breakoutRoomNumberCounter ++;
        this.breakoutRoomSize = 10;
        this.participants= new Participant[breakoutRoomSize]; //intilalizes array size to limit
        this.numberOfParticipants = 0;
        this.open = true;
    }
    
    //methods
    public boolean addParticipant(String participantID){
        Participant newPerson = new Participant(participantID);
        String ID = newPerson.getParticipantID();
        
        if(this.numberOfParticipants != breakoutRoomSize){
            if(newPerson.verifyID(ID) == true){
                if(this.open == true){
                    //System.out.println("Adding ID");
                    participants[numberOfParticipants] = newPerson;
                    this.numberOfParticipants++;
                    return true;
                    }
                }
            }
            return false;
        }
     
    public Participant findParticipant(String participantID){
        for(int i = 0; i < participants.length; i++){
            if(participants[i].getParticipantID().equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String listOfParticipants = "BreakoutRoom ID: " + this.breakoutRoomID + "\n";
        for(int i = 0; i < numberOfParticipants; i++){
            listOfParticipants += participants[i].getParticipantID() + "\n";
        }
        return listOfParticipants;
    }
    
    public String toString(){
        String details = "Breakout Room ID: " + this.breakoutRoomID + "\n";
        details += "BreakoutRoom Name: " + this.name + "\n";
        details += "Number of Participants: " + this.numberOfParticipants + "\n";
        details += "Breakout Room Size: " + this.breakoutRoomSize + "\n";
        details += "Breakout Room State: " + this.open + "\n";
        return details;
    }
    
    public void closeBreakoutRoom(){
        this.open = false;
        this.numberOfParticipants = 0;
        this.participants = null;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }

    //accessors for the breakoutRoomID, numberOfParticipants and open variables
    public String getBreakOutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    /* public static void main(){
        Scanner cin = new Scanner(System.in);
        BreakoutRoom b1 = new BreakoutRoom("TestRoom");
        
        System.out.println("Enter IDS!");
        
        String ID = cin.nextLine();
        b1.addParticipant(ID);
        ID = cin.nextLine();
        b1.addParticipant(ID);
        ID = cin.nextLine();
        b1.addParticipant(ID);
        
        System.out.println(b1.listPartipants());
        System.out.println(b1.toString());
        
        b1.closeBreakoutRoom();
        System.out.println(b1.toString());
    } */
}

 