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
public class Candidate {
    String name;
    int numVotes;

    
    public Candidate(String candidateName){   
    
        this.name = candidateName;
        this.numVotes = 0;
}
    public void incrementVote(){
        
        this.numVotes++;
        
    }
    public int getNumVotes(){
        
        return this.numVotes;
     }
    
}