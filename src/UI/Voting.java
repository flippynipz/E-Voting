/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author flippynipz
 */
@Entity
@Table(name = "voting", catalog = "data", schema = "")
@NamedQueries({
    @NamedQuery(name = "Voting.findAll", query = "SELECT v FROM Voting v")
    , @NamedQuery(name = "Voting.findByVID", query = "SELECT v FROM Voting v WHERE v.vID = :vID")
    , @NamedQuery(name = "Voting.findByLastName", query = "SELECT v FROM Voting v WHERE v.lastName = :lastName")
    , @NamedQuery(name = "Voting.findByFirstName", query = "SELECT v FROM Voting v WHERE v.firstName = :firstName")
    , @NamedQuery(name = "Voting.findByChoice", query = "SELECT v FROM Voting v WHERE v.choice = :choice")})
public class Voting implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vID")
    private Integer vID;
    @Basic(optional = false)
    @Lob
    @Column(name = "Social")
    private byte[] social;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "Choice")
    private Integer choice;

    public Voting() {
    }

    public Voting(Integer vID) {
        this.vID = vID;
    }

    public Voting(Integer vID, byte[] social, String lastName, String firstName) {
        this.vID = vID;
        this.social = social;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getVID() {
        return vID;
    }

    public void setVID(Integer vID) {
        Integer oldVID = this.vID;
        this.vID = vID;
        changeSupport.firePropertyChange("VID", oldVID, vID);
    }

    public byte[] getSocial() {
        return social;
    }

    public void setSocial(byte[] social) {
        byte[] oldSocial = this.social;
        this.social = social;
        changeSupport.firePropertyChange("social", oldSocial, social);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        Integer oldChoice = this.choice;
        this.choice = choice;
        changeSupport.firePropertyChange("choice", oldChoice, choice);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vID != null ? vID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voting)) {
            return false;
        }
        Voting other = (Voting) object;
        if ((this.vID == null && other.vID != null) || (this.vID != null && !this.vID.equals(other.vID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UI.Voting[ vID=" + vID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
