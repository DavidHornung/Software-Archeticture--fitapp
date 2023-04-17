package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    @PersistenceContext(unitName = "gads_PU")
    private EntityManager em;
    
    private static User currentUser;
    private String username = "";
    private String password = "";

    public String userLogsIn() {
        try {
            User user = findByUsername();
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
                return "/UserPage/UserMainPage.xhtml?faces-redirect=true";
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/LoginPage.xhtml?faces-redirect=true";
    }
    
    protected User findByUsername() throws DoesNotExistException {
        Query query = em.createNamedQuery("User.findByUsername", User.class);
        List<User> user = query.setParameter("username", username).getResultList();
        if (user.size() > 0) {
            return user.get(0);
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    public String userLogsout() {
        currentUser = null;
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public static User getUserLoggedIn() {
        return currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

}
