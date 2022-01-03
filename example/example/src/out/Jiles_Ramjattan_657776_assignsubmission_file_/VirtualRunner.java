package out.Jiles_Ramjattan_657776_assignsubmission_file_;
/**
 * Write a description of class Participants here.
 *
 * @author (Jiles Tony Ramjattan-816008647)
 * @version (V.1a)
 */
import java.io.PrintStream;
import java.util.Scanner;

public class VirtualRunner {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        PrintStream print= new PrintStream(System.out);
        VirtualMeetingSystem vms =new VirtualMeetingSystem();
        int input=0;
        String data="";
        int data3=0;

	String prompt="1. Load participant data from a data file\n" +
            "2. Create a new virtual room\n" +
            "3. Allocate participants to breakout rooms\n" +
            "4. Add a new participant to a breakout room\n" +
            "5. Display a list of all participants in a breakout room\n" +
            "6. Close a breakout room based on a room number\n" +
            "7. Open a breakout room based on a room number\n" +
            "8. Find a participant’s breakout room number\n" +
            "9. Display a list of all breakout rooms managed by the system\n" +
            "10. Display a list of all breakout rooms managed by the system and the participants in each room";

	System.out.println(prompt);
        input=scan.nextInt();
	while(true){



	    if(input==1){
	        vms.loadParticipantData("participant.dat");
	       print.println("Successful Load");

        }
	    else if(input==2){
	        vms=option2(vms);

	        print.println("Successful Room Creation");
        }
	    else if(input==3){
	        print.println("Please input an allocation method: ");
	        data=scan.next();
	        vms.allocateParticipants(data);
	        print.println("Successful Allocation");
        }

	    else if(input==4){
	        print.println("Please enter the desired Breakout room number: ");
	        data3=scan.nextInt();
	        print.println("Please enter the Participant ID: ");
	        data= scan.next();

	        if(!vms.addParticipant(data,data3)){
	            print.println("There was an error with the data provided please ensure that you input valid data");

            }
	    }
	        else if(input==5){
	            print.println("Please enter the desire Breakout room number");
	            data3= scan.nextInt();
	            if(vms.listParticipants(data3)!=null){
	                print.println(vms.listParticipants(data3));
                }
	            else print.println("Sorry that room does not exist/is empty");
	        }
	        else if(input==6){

	            print.println("Please enter the desire Breakout room number");
                data3= scan.nextInt();

                if(vms.closeBreakoutRoom(data3)){
                    print.println("Breakout room closed");

                }
                else print.println("Breakout room does not exist");
            }
	        else if(input ==7){
                print.println("Please enter the desire Breakout room number");
                data3= scan.nextInt();

                if(vms.openBreakoutRoom(data3)){
                    print.println(" Breakout room opened");
                }
                else print.println("Breakout room does not exist");
            }
	        else if (input==8){
                print.println("Please enter the Participant ID");
                data= scan.next();

                if(vms.findParticipantBreakoutRoom(data)!=null){
                    print.println(vms.findParticipantBreakoutRoom(data));
                }
                else print.println("Participant does not exist");
            }
	        else if(input==9){
	            if(vms.listAllBreakoutRoom()!=null){
	                print.println(vms.listAllBreakoutRoom());
                }

	        }
	        else if(input==10){
            
	            if(vms.listParticipantInAllBreakoutRooms()!=null){
                    
	                print.println(vms.listParticipantInAllBreakoutRooms());
                    
                }

            }
	        else if(input==0){
	            break;
        }

        print.println(prompt);
        input=scan.nextInt();
	}


    }

    public static VirtualMeetingSystem option2(VirtualMeetingSystem vms){
        Scanner in = new Scanner (System.in);

        System.out.println("Please enter a Virtual room name:");
        String name=in.next();

        vms.createVirtualRoom(name);

        return vms;
    }
}