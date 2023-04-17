/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */

@XmlRootElement
public class Achievement {

    private Integer idachievement;
    private String achievementpokemon;
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
    
    public static List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
}
