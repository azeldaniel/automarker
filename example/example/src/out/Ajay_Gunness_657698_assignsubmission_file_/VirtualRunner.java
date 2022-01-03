package out.Ajay_Gunness_657698_assignsubmission_file_;// Code is well underdone, I underestimated the assignment and overestimated my abilities and my understanding of the language
// so whereas I will do poorly in this assignment, I will not make the same mistakes again.
//  Ajay Gunness 
//  816021061

import java.util.Scanner;

public class VirtualRunner
{
    VirtualMeetingSystem Runner = new VirtualMeetingSystem();

    
    public VirtualRunner()
    {
        
    }
    
    public static void main(String[] args)
    {
        menu();
    }
    
    public static void menu()
    {
        System.out.println("1. Load participant data from file");
        System.out.println("2. Create new Virtual Room");
        System.out.println("3. Allocate Participants to breakout rooms ");
        System.out.println("4. Add new Participant to a breakout room");
        System.out.println("5. Display a list of all Participants in a breakout room");
        System.out.println("6. Close a breakout room based on a room number");
        System.out.println("7. Open a breakout room based on a room number");
        System.out.println("8. Find a participant’s breakout room number");
        System.out.println("9. Display a list of all breakout rooms managed by the system");
        System.out.println("10. Display a list of all breakout rooms managed by the system and the participants in each room");    
        System.out.println("Enter choice:");
        Scanner c = new Scanner(System.in);
        String choice = c.nextLine();
        switch(choice)
        {
            case "1":
            
            case "2":
            
            case "3":
            
            case "4":
            
            case "5":
            
            case "6":
            
            case "7":
            
            case "8":
            
            case "9":
            
            case "10":
            
            
            default:
                break;
        }
    }
}
