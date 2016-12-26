/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author flippynipz
 */
public class Voter {
    String firstName;
    String lastName;
    String soc;
    int vID;
    public Ballot voterBallot = new Ballot();

    
    public Voter(String firstName, String lastName, String soc, int vID){   
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.soc = soc;
        this.vID = vID;
    
}

    public Voter() {
        this.voterBallot = new Ballot();
     
    }
    public String getFirst(){
        return this.firstName;
    }
     public String getLast(){
        return this.lastName;
    }
      public String getSoc(){
        return this.soc;
    }
       public int getvID(){
        return this.vID;
    }
    public void setFirst(String first){
        this.firstName = first;
    }
     public void setLast(String last){
        this.lastName = last;
    }  
     public void setSoc(String soc){
        this.soc = soc;
    }
     public void setID(int ID){
        this.vID = ID;
    }
       
}