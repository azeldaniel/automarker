package out.Shivam_Persad_657803_assignsubmission_file_;/** COMP2603 Assignment1
 *  Name: Shivam Persad
 *  ID: 816016854
 */

import java.util.Scanner;


public class VirtualRunner
{
    public static void printMenu(){
        System.out.println("VIRTUAL MEETING ROOM");
        System.out.println("=====================");
        System.out.println("[CONSOLE]:Select a valid option(1-10): ");
        System.out.println("[CONSOLE]: Remember that some options MUST be done sequentially!");
        System.out.println("1. Load participant data from a data file");
        System.out.println("2. Create a new virtual room");
        System.out.println("3. Allocate participants to breakout rooms");
        System.out.println("4. Add a new participant to a breakout room");
        System.out.println("5. Display a list of all participants in a breakout room");
        System.out.println("6. Close a breakout room based on a room number");
        System.out.println("7. Open a breakout room based on a room number");
        System.out.println("8. Find a participant’s breakout room number");
        System.out.println("9. Display a list of all breakout rooms managed by the system");
        System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");
        System.out.println("11. Manually QUIT program!");
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        VirtualMeetingSystem VRunner = new VirtualMeetingSystem();
        
        String option="";
        boolean x=false;
        String partID;
        int roomNumber;
        System.out.println("-=-=PROGRAM FUNCTIONS AS INTENDED AND ACCORDING TO INSTRUCTION PAPER!!!=-=-");
        while(x==false){
            printMenu();
            option=scan.nextLine();
            switch(option){
                case "1":
                System.out.println("[CONSOLE]: Loading participants data from file...");
                VRunner.loadParticipantData("participant.dat");
                break;
                
                case "2":
                System.out.println("[CONSOLE]: Creating virtual room...");
                String name="VirtualRoom";
                VRunner.createVirtualRoom(name);
                System.out.println("[CONSOLE]: Virtual Room created successfully!");
                break;
                
                case "3":
                System.out.println("[CONSOLE]: Input allocation type you'd like to use(C5 or RR): ");
                String code=scan.nextLine();
                if(code.equals("RR")||code.equals("C5")){
                    System.out.println("[CONSOLE]: Allocating participants..");
                    VRunner.allocateParticipants(code);
                    System.out.println("[CONSOLE]: Participants allocated using " + code);
                }
                else{ 
                    System.out.println("[CONSOLE]: Error!, Invalid code. \nReturn to menu...\n");
                }
                break;
                
                case "4":
                System.out.println("[CONSOLE]: ENTER A VALID PARTICIPANT ID(8-DIGITS): ");
                String ID=scan.nextLine();
                System.out.println("[CONSOLE]: ENTER A VALID ROOM#: ");
                roomNumber=scan.nextInt();
                VRunner.addParticipant(ID,roomNumber);
                break;
                
                case "5":
                System.out.println("[CONSOLE]: ENTER A VALID ROOM#(MUST BE INTEGER): ");
                roomNumber=scan.nextInt();
                System.out.println(VRunner.listParticipants(roomNumber));
                break;
                
                case "6":
                System.out.println("[CONSOLE]: ENTER A VALID ROOM#: ");
                roomNumber=scan.nextInt();
                VRunner.closeBreakoutRoom(roomNumber);
                break;
                
                case "7":
                System.out.println("[CONSOLE]: ENTER A VALID ROOM#: ");
                roomNumber=scan.nextInt();
                VRunner.openBreakoutRoom(roomNumber);
                break;
                
                case "8":
                System.out.println("[CONSOLE]: ENTER A VALID Participant ID: ");
                partID=scan.nextLine();
                System.out.println(VRunner.findParticipantBreakoutRoom(partID));
                break;
                
                case "9":
                VRunner.listAllBreakoutRooms();
                break;
                
                case "10":
                System.out.println(VRunner.listParticipantsInAllBreakoutRooms());
                break;
                
                case "11":
                System.out.println("[CONSOLE]: CLOSING PROGRAM!");
                x=true;
                break;
            }
        }
    }
}
