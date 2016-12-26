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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author flippynipz
 */
@Entity
@Table(name = "numVotes", catalog = "data", schema = "")
@NamedQueries({
    @NamedQuery(name = "NumVotes.findAll", query = "SELECT n FROM NumVotes n")
    , @NamedQuery(name = "NumVotes.findByCandidateNumber", query = "SELECT n FROM NumVotes n WHERE n.candidateNumber = :candidateNumber")
    , @NamedQuery(name = "NumVotes.findByVotes", query = "SELECT n FROM NumVotes n WHERE n.votes = :votes")})
public class NumVotes implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "candidateNumber")
    private Integer candidateNumber;
    @Basic(optional = false)
    @Column(name = "votes")
    private long votes;

    public NumVotes() {
    }

    public NumVotes(Integer candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public NumVotes(Integer candidateNumber, long votes) {
        this.candidateNumber = candidateNumber;
        this.votes = votes;
    }

    public Integer getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(Integer candidateNumber) {
        Integer oldCandidateNumber = this.candidateNumber;
        this.candidateNumber = candidateNumber;
        changeSupport.firePropertyChange("candidateNumber", oldCandidateNumber, candidateNumber);
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        long oldVotes = this.votes;
        this.votes = votes;
        changeSupport.firePropertyChange("votes", oldVotes, votes);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateNumber != null ? candidateNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumVotes)) {
            return false;
        }
        NumVotes other = (NumVotes) object;
        if ((this.candidateNumber == null && other.candidateNumber != null) || (this.candidateNumber != null && !this.candidateNumber.equals(other.candidateNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UI.NumVotes[ candidateNumber=" + candidateNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
