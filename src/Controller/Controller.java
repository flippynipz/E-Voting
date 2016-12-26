package Controller;


import Entities.Ballot;
import Entities.Candidate;
import Entities.Voter;
import UI.Tally;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author flippynipz
 */
public class Controller { 
     public static Voter newVoter = new Voter();    
     public static Candidate clinton = new Candidate("Clinton");
     public static Candidate trump = new Candidate("Trump");
     public static Candidate johnson = new Candidate("Johnson");
     public static Connection conn;
      public static int count = 0;
          
     public Controller() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","derp123");
    }
    
    /**
     * Method that establishes a connection to a database and adds the voter to it
     * using prepared statements for security
     * @param voter to be instantiated and added to the voter database 
     */
    public void addVoterToDB(Voter voter){
          
        try{ 
           
            String insertVoter = "INSERT IGNORE INTO data.voting(vID,Social,LastName,FirstName) VALUES (?, AES_ENCRYPT(?,'text'), ?, ?)";
            PreparedStatement st = conn.prepareStatement(insertVoter);         
            st.setInt(1,newVoter.getvID());
            st.setString(2,newVoter.getSoc());
            st.setString(3,newVoter.getLast());
            st.setString(4,newVoter.getFirst());
            st.executeUpdate(); 
            conn.close(); 
        
         } catch (SQLException e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
    }
    
    public static void checkAdmin(int ID, String pw) throws SQLException{
        
        String query =  "SELECT * FROM admin WHERE ID = ? AND pw = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,ID);
        stmt.setString(2,pw);
        ResultSet rs = stmt.executeQuery();
      if(Controller.count<3){
        
        if(rs.next()){
            Tally tally = new Tally();
            tally.setVisible(true);
        }
        
        else{
         Controller.count++;
           
            JOptionPane.showMessageDialog(null, "User not found in database");
            
        }
      }
      else{ 
      System.exit(0);
      
      }
    }
    
    
    public static void verify(){
        try{ 
           
            String verify = "SELECT Choice,vID FROM data.voting INTO OUTFILE '/tmp/verify.out'";
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/data","root","derp123"); 
            PreparedStatement st = conn.prepareStatement(verify);
            st.execute(); 
            conn.close(); 
        
         } catch (SQLException e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
    }
    
    public void createVoter(String fName, String lName, String vSoc, int vID) throws IOException{
        
        String voterFirstName= fName;
        String voterLastName = lName;
        String voterSoc = vSoc;
        int voterID = vID;
        Controller.newVoter = new Voter(voterFirstName,voterLastName,voterSoc,voterID);
        addVoterToDB(Controller.newVoter);   
        
    }
    public static void addBallot(Ballot ballot){
        try{ 
           
            String insertBallot = "UPDATE data.voting SET Choice = ? WHERE vID = ?";
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/data","root","derp123"); 
            PreparedStatement st = conn.prepareStatement(insertBallot);
            
            st.setInt(1,newVoter.voterBallot.getSelection());
            st.setInt(2,newVoter.voterBallot.getID());
            st.executeUpdate(); 
            conn.close(); 
        
         } catch (SQLException e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
        
    }
 
    /**
     * 
     * @param ballot created and then assigned to the voter who cast it 
     */
    
    public static void createBallot(int selection){  
        if(selection == 1){
            Controller.clinton.incrementVote();
        }
        if(selection == 2){
            Controller.trump.incrementVote();
            
        }
        if(selection == 3){
            Controller.johnson.incrementVote();
        }
        Controller.newVoter.voterBallot.setID(newVoter.getvID());
        Controller.newVoter.voterBallot.setSelection(selection);
        Controller.addBallot(newVoter.voterBallot);
        

        
    }
    
}