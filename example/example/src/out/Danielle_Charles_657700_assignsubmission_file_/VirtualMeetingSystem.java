package out.Danielle_Charles_657700_assignsubmission_file_;
/**
 * @author Danielle Charles 816017229
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    private VirtualRoom vr;
    private String participants[] = new String[50];
    
    public VirtualMeetingSystem()
    {
    }
    
    public void loadParticipantData(String filename)
    {
        int i =0;
        //System.out.println(filename);
        try
        {
            File pFile = new File(filename);
            Scanner myScanner = new Scanner(pFile);
            
            while(myScanner.hasNextLine())
            {
                participants[i] = myScanner.nextLine();
                //System.out.println(participants[i]);
                i++;
            }
            myScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println("data loaded");
        
    }
    
    public void createVirtualRoom(String name)
    {
       vr = new VirtualRoom(name);
       vr.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code)
    {
        if(code.equals("C5"))
        {
            int roomNum = 1;
            for(int i = 1; i<=participants.length ; i++)
            {
                if((i%5)==0)
                {
                    vr.addParticipantToBreakoutRoom(participants[i-1], roomNum);
                    roomNum++;
                }
                else
                {
                    vr.addParticipantToBreakoutRoom(participants[i-1], roomNum);
                }
                if(roomNum > 5)
                {
                    roomNum = 1;
                }
            }
        }
        
        if(code == "RR")
        {
            int roomNum = 1;
            for(int j = 1; j<=participants.length; j++)
            {
                if((j%5)==0)
                {
                    vr.addParticipantToBreakoutRoom(participants[j-1], roomNum);
                    roomNum = 1;
                }
                else
                {
                    vr.addParticipantToBreakoutRoom(participants[j-1], roomNum);
                    roomNum++;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID,int roomNumber)
    {
        if(vr.addParticipantToBreakoutRoom(participantID,roomNumber))
        {
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber)
    {
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(vr.openBreakoutRoom(roomNumber))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(vr.closeBreakoutRoom(roomNumber)== true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String bRoomID = vr.findParticipantBreakoutRoom(participantID);
        if(bRoomID !=null)
        {
            return bRoomID;
        }
        return null;
    }
    
    public String listAllBreakoutRooms()
    {
        return vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        String listOfAllParticipants = "";
        
        for(int i = 1; i<=5; i++)
        {
            listOfAllParticipants += vr.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return listOfAllParticipants;
    }
    
    /*public static void main(String[] args)
    {
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("TRY");
        vms.openBreakoutRoom(1);
        vms.openBreakoutRoom(2);
        vms.openBreakoutRoom(3);
        vms.openBreakoutRoom(4);
        vms.openBreakoutRoom(5);
        vms.allocateParticipants("RR");
        //System.out.println(vms.addParticipant("12345689", 5));
        //System.out.println(vms.listParticipants(3));
        //System.out.println(vms.findParticipantBreakoutRoom("67773814"));
        //System.out.println(vms.findParticipantBreakoutRoom("00000000"));
        //System.out.println(vms.listAllBreakoutRooms());
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
        //System.out.println(vms.closeBreakoutRoom(3));
    }*/
}
