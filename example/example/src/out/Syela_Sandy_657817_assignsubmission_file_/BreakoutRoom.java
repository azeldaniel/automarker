package out.Syela_Sandy_657817_assignsubmission_file_;
/**
 * 
 * Name: Syela Sandy
 * @Student ID: 816020390
 * @version (a version number or a date)
 */
import java.util.Arrays;
//import java.util.Random;
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
   private String breakoutRoomID;
   private static int breakoutRoomNumberCounter = 0;
   final private int breakoutRoomSize;
   private Participant[] participants;
   private int numberOfParticipants;
   private boolean open;
   private Participant participant;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
      breakoutRoomNumberCounter= breakoutRoomNumberCounter + 1;
      breakoutRoomID = name + breakoutRoomNumberCounter;
      breakoutRoomSize =10;
      participants = new Participant[breakoutRoomSize];
      numberOfParticipants = 0;
      open = true;  
    }

    public String getBreakoutRoomID(){
       return breakoutRoomID;
    }
    
    public Participant getParticipant(int counter){
       return participants[counter];
    }
    
    public int getbreakoutRoomNumberCounter(){
              return breakoutRoomNumberCounter;
    }
    
    public int getNumberOfParticipants(){
              return numberOfParticipants;
    }
    
    public boolean getOpen(){
              return open;
    }
    
    public int getbreakoutRoomSize(){
              return breakoutRoomSize;
    }
    
    public boolean addParticipant(String participantID){
        
               participant = new Participant(participantID);
              
              if (numberOfParticipants < breakoutRoomSize && open == true){
                  

                  if (participant.verifyID(participantID) == true ){

                      //Participant p = new Participant(participantID);
                      participants[numberOfParticipants] = participant;
                      //participants[numberOfParticipants] = participantID;
                      numberOfParticipants ++;
                      return true;
                   }
              
                   else{
                         System.out.println("This is an invalid ParticipantID");
                         return false;
                   }
              
              }
              else{
                    System.out.println("Failed to add participant. Breakout Room is either closed or filled");
                    return false;
              }
    }
    
    public Participant findParticipant(String participantID){
            
             participant = new Participant(participantID);

              if (participant.verifyID(participantID) == true ){

                for (int i=0; i < numberOfParticipants; i++){

                  if(participants[i].getParticipantID().equals(participantID) ){
                         return participants[i];
                  }

                }
            
                System.out.println("The participant " + participantID + " was not found.");    
                return null;
             }
             else {
                     System.out.println("This is an invalid ParticipantID");
                     return null;
              }
    }
    
    public String listParticipants(){

              //System.out.println(breakoutRoomID);
              
              String s = breakoutRoomID + "\n";
              for (int i=0; i < numberOfParticipants; i++){
                    s = s + participants[i].toString() + "\n";
              }
              return s;
    }
    
    public String toString(){

              //String details = "Breakout RoomID: "+ breakoutRoomID; //+ breakoutRoomNumberCounter;
              String details = breakoutRoomID;
              //details += " \nBreakout Room No.Counter: " + breakoutRoomNumberCounter;
              //details += " \nBreakout Room Size: " + breakoutRoomSize;
              //details += " \nParticipants:" + Arrays.toString(participants);
              if (open == true)   
                  details += " " + "OPEN";
              else
                  details += " " + "CLOSED";
              details += " " + numberOfParticipants;
              return details;

    }
    
    public void closeBreakoutRoom(){
               open = false;
               System.out.println("The breakout Room is now closed");
               for(int i=0; i < numberOfParticipants; i++){
                   participants[i] = null;
               }
               numberOfParticipants =0;  
               breakoutRoomID = null;
               //breakoutRoomNumberCounter = 0;
    }
    
    public void openBreakoutRoom(){
               open = true;
               System.out.println("The breakout Room is now open");
    
     }
    
}
