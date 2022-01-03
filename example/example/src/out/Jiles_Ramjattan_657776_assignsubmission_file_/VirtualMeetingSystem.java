package out.Jiles_Ramjattan_657776_assignsubmission_file_;
/**
 * Write a description of class Participants here.
 *
 * @author (Jiles Tony Ramjattan-816008647)
 * @version (V.1a)
 */

import java.io.*;
import java.util.Scanner;

public class VirtualMeetingSystem {
    private String[] details=new String[100];
    private int count=0;
    private VirtualRoom virtualRoom;


    public VirtualMeetingSystem(){

    }
    public void loadParticipantData(String filename){
        File file= new File("C:\\Users\\Jiles\\Downloads\\participant.dat");

        try {
            Scanner scan= new Scanner(file);
            while(scan.hasNextLine()){
                details[count]=scan.nextLine();
                count++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void createVirtualRoom(String name){

        virtualRoom=new VirtualRoom(name);

        virtualRoom.createBreakoutRooms();



    }

    public void allocateParticipants(String code) {

        if (code.equals("C5")) {
            boolean pass2 = false;
            for (int i = 0; i < virtualRoom.getNumberOfBreakoutRooms(); i++) {
                for (int n = 0; n < 5; n++) {
                    if (!pass2) {
                        virtualRoom.getBreakoutRooms()[i].addParticipant(details[i * 5 + n]);
                    }

                    if (pass2) {
                        virtualRoom.getBreakoutRooms()[i].addParticipant(details[(i * 5 + n)]);
                    }
                    if (i == virtualRoom.getNumberOfBreakoutRooms() - 1 && !pass2 && n == 4) {
                        i = -1;
                        pass2 = true;
                    }
                }
            }
        }

        if (code.equals("RR")) {

            for (int i = 0; i < count; i++) {
                for (int n = 0; n < virtualRoom.getNumberOfBreakoutRooms(); n++) {
                    virtualRoom.getBreakoutRooms()[n].addParticipant(details[i]);
                }
            }
        }



}

    public boolean addParticipant(String participantID, int roomNumber){


            if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
                return virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);

            }

            return false;
    }

    public String listParticipants(int roomNumber){

            if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
                return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
            }

        return null;
    }

    public boolean openBreakoutRoom(int roomNumber){

            if(virtualRoom.findBreakoutRoom(roomNumber)!=null){

              return virtualRoom.openBreakoutRoom(roomNumber);
            }

        return false;
    }

    public boolean closeBreakoutRoom(int roomNumber){

            if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
                return virtualRoom.closeBreakoutRoom(roomNumber);
            }

        return false;
    }

    public String findParticipantBreakoutRoom(String participantID){

            if(virtualRoom.findParticipantBreakoutRoom(participantID)!=null){
                return virtualRoom.findParticipantBreakoutRoom(participantID);
            }

        return null;
    }

    public String listAllBreakoutRoom(){
        String aggregate="";

            aggregate+=virtualRoom.getName()+"\n";
            aggregate+=virtualRoom.listBreakoutRoom()+"\n\n";

        return aggregate;
    }

    public String listParticipantInAllBreakoutRooms(){
        String aggregate="";

            aggregate+=virtualRoom.getName()+"\n\n";
            for(int i=0; i<virtualRoom.getNumberOfBreakoutRooms(); i++){
                aggregate+= virtualRoom.getBreakoutRooms()[i].getBreakoutRoomID()+"\n\n";
                aggregate+=virtualRoom.getBreakoutRooms()[i].listParticipants();
                aggregate+="\n\n";
            }


        return aggregate;
    }


}
