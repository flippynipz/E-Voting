/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author anjalinaik
 */
public class Ballot {

private int ID;
private int selection;

public Ballot(){
    
}
    
public void setID(int ID){
    this.ID = ID;
    
}
public void setSelection(int selection){
    this.selection = selection;
    
}
public int getSelection(){
    return this.selection;
    
}
public int getID(){
    return this.ID;
    
}

    
}
    
    