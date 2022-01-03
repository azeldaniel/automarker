package out.Antonio_Vialva_657675_assignsubmission_file_;/*
 816004121
 */
import java.util.Scanner;
/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    public static void main(String[] args){
        
        VirtualMeetingSystem vmsystem = new VirtualMeetingSystem();
        
        vmsystem.loadParticipantData();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an ID");
        String text= keyboard.nextLine();

        vmsystem.createVirtualRoom(text);
        
    }
}
