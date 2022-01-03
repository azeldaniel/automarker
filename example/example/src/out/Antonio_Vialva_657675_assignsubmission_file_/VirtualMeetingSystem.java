package out.Antonio_Vialva_657675_assignsubmission_file_;/*
 816004121
 */

import java.io.*;
import java.util.*;

/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    public void loadParticipantData()
    {
        String ParticipantIDs [] ={ };
        int i =0;
       try{
           File myObj = new File ("participant.dat");
           Scanner read = new Scanner(myObj);
           while (read.hasNextLine()) {
             ParticipantIDs[i] = read.nextLine();
             System.out.println(ParticipantIDs[i]);
             i++;
            }
           read.close();
       }
       catch(Exception e){
           System.out.println("An error occurred.");
        }
    }
    
    public void createVirtualRoom(String name){
        VirtualRoom rooms = new VirtualRoom(name);
        rooms.createBreakoutRooms();
    }

}
