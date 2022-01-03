package out.Kyle_Ramkissoon_657751_assignsubmission_file_;//[816019715]
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.*;
import java.util.*;

public class VirtualMeetingSystem{

	private String[] participantData = new String[50];
    private VirtualRoom VR = null;
    private int dataSize = 0;

    public String[] getParticipantData(){
    	return participantData;
    	}

    public VirtualRoom getVirtualRoom(){
    	return this.VR;
    	}

    public int getDataSize(){
    	return this.dataSize;
    	}


    public void loadParticipantData(String fileName){

    	if (VR == null){
    		int i = 1;

        try{
            BufferedReader r = new BufferedReader(new FileReader(fileName));
            String s = r.readLine();
            this.participantData[i] = s;

            while (s != null){
            i++;

            s = r.readLine();
            this.participantData[i] = s;
         }

           r.close();

         }
         catch (Exception e){
           e.getMessage();
         }

          this.dataSize = i;

        }

        else{
         System.out.println("Data is already loaded...");
        }
}


    public void createVirtualRoom(String name){

        this.VR = new VirtualRoom(name);
        this.VR.createBreakoutRooms();
    }


    public void allocateParticipants(String code){

        int c = 1;
        int r = 1;

        if(code.equals("C5")){

        	while(c < this.dataSize){
                if(r == 6){
                    r = 1;
                }

            for (int i = 1; i <= 5 ; i++){

            	this.VR.addParticipantToBreakoutRoom(this.participantData[c], r);
            	c++;

                if(c == this.dataSize){
                	break;
               }
               }
               r++;
               }
               }

        if(code.equals("RR")){

            for(int i = 1; i <= this.dataSize; i++){
                this.VR.addParticipantToBreakoutRoom(this.participantData[i], r);
                r++;

                if(r == 6){
                    r = 1;
               }
               }
               }
}


    public boolean addParticipant(String participantID, int roomNumber){
    	return this.VR.addParticipantToBreakoutRoom(participantID, roomNumber);
    	}

    public String listParticipants(int roomNumber){
    	return this.VR.listParticipantsInBreakoutRoom(roomNumber);
    	}

   	public boolean openBreakoutRoom(int roomNumber){
    	return this.VR.openBreakoutRoom(roomNumber);
    	}

   	public boolean closeBreakoutRoom(int roomNumber){
    	return this.VR.closeBreakoutRoom(roomNumber);
    	}

    public String findParticipantBreakoutRoom(String participantID){
    	return this.VR.findParticipantBreakoutRoom(participantID);
    	}

    public String listAllBreakoutRooms(){
    	return this.VR.listBreakoutRooms();
    	}

    public String listParticipantsInAllBreakoutRooms(){
    	int i =1;
    	String details ="";
		details += "Listing all participants for each breakoutroom";
    	while (i<=5){

    		details += "\nBreakout Room Number: ";
    		details += i;
    		details += "\n";

    			if(this.VR.listParticipantsInBreakoutRoom(i) == null){
    				return null;
    			}
    		else{

    		details += this.VR.listParticipantsInBreakoutRoom(i);
    		details += "\n";
    		i++;
    		}
    			}

    	return details;
}










}
