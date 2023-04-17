/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "achievement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Achievement.findAll", query = "SELECT a FROM Achievement a"),
    @NamedQuery(name = "Achievement.findByIdachievement", query = "SELECT a FROM Achievement a WHERE a.idachievement = :idachievement"),
    @NamedQuery(name = "Achievement.findByAchievementpokemon", query = "SELECT a FROM Achievement a WHERE a.achievementpokemon = :achievementpokemon")})

public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACHIEVEMENT")
    private Integer idachievement;
    @Size(min = 1, max = 150)
    @Column(name = "ACHIEVEMENTPOKEMON")
    private String achievementpokemon;
    @ManyToMany(mappedBy = "achievementList")
    private static List<User> userList;

    public Achievement() {
    }

    public Achievement(Integer idachievement) {
        this.idachievement = idachievement;
    }

    public Integer getIdachievement() {
        return idachievement;
    }

    public void setIdachievement(Integer idachievement) {
        this.idachievement = idachievement;
    }

    public String getAchievementpokemon() {
        return achievementpokemon;
    }

    public void setAchievementpokemon(String achievementpokemon) {
        this.achievementpokemon = achievementpokemon;
    }
    
    @XmlTransient
    public static List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idachievement != null ? idachievement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Achievement)) {
            return false;
        }
        Achievement other = (Achievement) object;
        if ((this.idachievement == null && other.idachievement != null) || (this.idachievement != null && !this.idachievement.equals(other.idachievement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.unil.doplab.gadswebsite.models.Achievement[ idachievement=" + idachievement + " ]";
    }
    
}
