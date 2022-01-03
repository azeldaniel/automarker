package out.Chelsea_Joyeau_657671_assignsubmission_file_;import java.util.Scanner;
/**
 * Chelsea Joyeau ~ 816020515
 * Object Oriented Programming
 * Assignment 1.0 ~ Virtual Meeting
 */
public class VirtualRunner
{    
    public static void main (String[] args)
    {
        displayMenu ();
        System.out.println ("\n\nPlease enter an option (1-11)");
        Scanner keyboard = new Scanner (System.in);
        int menuSelection = keyboard.nextInt();
        
        VirtualMeetingSystem  newMeeting = new VirtualMeetingSystem();
        while (menuSelection != 11)
        {
            if (menuSelection == 1)
                newMeeting.loadParticipantData("participant.dat");
            
            else if (menuSelection == 2){
                System.out.println ("\nPlease Enter The Name Of The Virtual Room To Be Created");
                Scanner readInput = new Scanner (System.in);
                String name = readInput.nextLine();
                newMeeting.createVirtualRoom(name);
            }
            
            else if (menuSelection == 3){
                System.out.println ("\nPlease Enter The Code (C5 OR RR) As To How The Participants Will Be Allocated To The Breakout Rooms");
                Scanner readInput = new Scanner (System.in);
                String code = readInput.nextLine();
                
                if (code.equals("C5"))
                    newMeeting.allocateParticipants("C5");
                    
                else if (code.equals("RR"))
                    newMeeting.allocateParticipants("RR");
                    
                else 
                    System.out.println ("\nYou Entered An Invalid Code.");
            }
            
            else if (menuSelection == 4){ 
                System.out.println ("\nPlease Enter The ParticipantID (8 Digits) To Be Added.");
                Scanner readInput = new Scanner (System.in);
                String participantID = readInput.nextLine();
                System.out.println ("\nPlease Enter The Room Number (1 Digit) To Which The Participant Will Be Added To.");
                Scanner readInt = new Scanner (System.in);
                int roomNumber = readInt.nextInt();
                
                newMeeting.addParticipant (participantID,roomNumber);
            }
            
            else if (menuSelection == 5){ 
                System.out.println ("\nPlease Enter The Number Of The Breakout Room To View The Participant List");
                Scanner readInput = new Scanner (System.in);
                int roomNumber = readInput.nextInt();
                System.out.println (newMeeting.listParticipants(roomNumber));
            }
            
            else if (menuSelection == 6){ 
                System.out.println ("\nPlease Enter The Number Of The Breakout Room To Be Closed");
                Scanner read = new Scanner (System.in);
                int roomNum = read.nextInt();
                newMeeting.closeBreakoutRoom(roomNum);
            }
            
            else if (menuSelection == 7){ 
                System.out.println ("\nPlease Enter The Number Of The Breakout Room To Be Opened");
                Scanner read = new Scanner (System.in);
                int roomNum = read.nextInt();
                newMeeting.openBreakoutRoom(roomNum);
            }
            
            else if (menuSelection == 8){
                System.out.println ("\n\nPlease Enter The ParticipantID (8 Digits)");
                Scanner readInput = new Scanner (System.in);
                String participantID = readInput.nextLine();
                newMeeting.findParticipantBreakoutRoom(participantID);
            }
            
            else if (menuSelection == 9){ 
                System.out.println (newMeeting.listAllBreakoutRooms());          
            }
            
            else if (menuSelection == 10){
                System.out.println (newMeeting.listParticipantsInAllBreakoutRooms());
            }
            
            displayMenu ();
            System.out.println ("\n\nPlease Enter Another Option (1-11)");
            Scanner readInput = new Scanner (System.in);
            menuSelection = readInput.nextInt();
        }       
        System.out.println ("\nYou Chose To Exit The Application");
        System.out.println ("Thanks For Using The Beta Virtual Meeting Application!");
    }
    
    public static void displayMenu (){
        System.out.println ("\n   *****   VIRTUAL RUNNER MENU *****   ");
        System.out.println ("\n 1. Load participant data from a data file");
        System.out.println ("\n 2. Create a new virtual room");
        System.out.println ("\n 3. Allocate participants to breakout rooms ");
        System.out.println ("\n 4. Add a new participant to a breakout room");
        System.out.println ("\n 5. Display a list of all participants in a breakout room");
        System.out.println ("\n 6. Close a breakout room based on a room number");
        System.out.println ("\n 7. Open a breakout room based on a room number");
        System.out.println ("\n 8. Find a participant’s breakout room number");
        System.out.println ("\n 9. Display a list of all breakout rooms managed by the system");
        System.out.println ("\n 10. Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println ("\n 11. Exit Virtual Meeting System Application");  
    }
}
