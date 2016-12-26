/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;
import UI.Start;
/**
 *
 * @author flippynipz
 */
public class Main {
    
    public static void main(String args[]) {
        /* Create and display entry point */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
        
    
    
    }
    
    
    
    
    
}
