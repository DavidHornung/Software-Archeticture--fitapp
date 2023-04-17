package ch.unil.doplab.gadsweb.Client;

import ch.unil.doplab.gadswebsite.exceptions.AlreadyExistsException;
import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Achievement;
import ch.unil.doplab.gadswebsite.models.Recipe;
import ch.unil.doplab.gadswebsite.models.Trainingprogram;
import ch.unil.doplab.gadswebsite.models.User;
import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class PersistenceClient {
    
    private static final String USER_URL = "http://localhost:8080/GADSRestfulService/resources/ch.unil.doplab.gadsrestfulservice.user";
    private static final String RECIPE_URL = "http://localhost:8080/GADSRestfulService/resources/ch.unil.doplab.gadsrestfulservice.recipe";
    private static final String ACHIEVEMENT_URL = "http://localhost:8080/GADSRestfulService/resources/ch.unil.doplab.gadsrestfulservice.achievement";
    private static final String TRAININGPROGRAM_URL = "http://localhost:8080/GADSRestfulService/resources/ch.unil.doplab.gadsrestfulservice.trainingprogram";
    private static Client client;
    private static WebTarget target;
    private static PersistenceClient instance;

    private PersistenceClient() {
        PersistenceClient.client = ClientBuilder.newClient();
    }

    public static PersistenceClient getInstance() {
        if (instance == null) {
            instance = new PersistenceClient();
        }
        return instance;
    }

    public User checkPassword(String username, int password) throws DoesNotExistException {
        User u = getUserByName(username);
        if (u.getUsername().equals(username) & u.getPassword() == password) {
            return u;
        }
        throw new DoesNotExistException("Users " + username + " does not exist.");
    }
    
    public void addToRecipe(int uId, int fId) {
        client.target(USER_URL + "/addToRecipe/" + uId + "/" + fId).request().get();
    }
    
    public void removeFromRecipe(int uId, int fId) {
        client.target(USER_URL + "/removeFromRecipe/" + uId + "/" + fId).request().get();
    }
    
    public boolean emailExists(String email) throws AlreadyExistsException {
        return client.target(USER_URL + "/emailExists/" + email).request().get().readEntity(Boolean.class);
    }

    public void createUser(User user) {
        client.target(USER_URL + "/create").request().post(Entity.entity(user, "application/xml"));
    }

    public void updateUser(User user) {
        client.target(USER_URL + "/edit/" + user.getIdUser()).request().put(Entity.entity(user, "application/xml"));
    }

    public void removeUser(int id) {
        client.target(USER_URL + "/remove/" + id).request().get().readEntity(String.class);
    }

    public User getUserById(int id) {
        return parseUser(client.target(USER_URL + "/find/" + id).request().get().readEntity(String.class));
    }

    public User getUserByName(String username) {
        User u = parseUser(client.target(USER_URL + "/findByName/" + username).request().get(String.class));
        return u;
    }

    public List<User> getAllUsers() {
        return parseUserList(client.target(USER_URL).request().get(String.class));
    }

    private List<User> parseUserList(String xml) {
        List<User> userList = new ArrayList<>();
        NodeList list = parseDocument(xml).getElementsByTagName("user");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            User user = new User();
            user.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
            user.setFirstname(e.getElementsByTagName("firstname").item(0).getTextContent());
            user.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
            user.setPassword(Integer.valueOf(e.getElementsByTagName("password").item(0).getTextContent()));
            user.setIdUser(Integer.valueOf(e.getElementsByTagName("idUser").item(0).getTextContent()));
            user.setUsername(e.getElementsByTagName("username").item(0).getTextContent());
            user.setAge(Integer.valueOf(e.getElementsByTagName("age").item(0).getTextContent()));
            user.setGender(e.getElementsByTagName("gender").item(0).getTextContent());
            user.setGoal(e.getElementsByTagName("goal").item(0).getTextContent());
            user.setHeight(Double.valueOf(e.getElementsByTagName("height").item(0).getTextContent()));
            user.setWeight(Double.valueOf(e.getElementsByTagName("weight").item(0).getTextContent()));

            userList.add(user);
        }
        return userList;
    }

    private User parseUser(String xml) {
        if (xml.length() == 0) {
            return null;
        }
        Element e = (Element) parseDocument(xml).getElementsByTagName("user").item(0);

        User user = new User();
            user.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
            user.setFirstname(e.getElementsByTagName("firstname").item(0).getTextContent());
            user.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
            user.setPassword(Integer.valueOf(e.getElementsByTagName("password").item(0).getTextContent()));
            user.setIdUser(Integer.valueOf(e.getElementsByTagName("idUser").item(0).getTextContent()));
            user.setUsername(e.getElementsByTagName("username").item(0).getTextContent());
            user.setAge(Integer.valueOf(e.getElementsByTagName("age").item(0).getTextContent()));
            user.setGender(e.getElementsByTagName("gender").item(0).getTextContent());

        return user;
    }
    
    private Document parseDocument(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // RECIPE
    
    private List<Recipe> parseRecipeList(String xml) {
        List<Recipe> recipeList = new ArrayList<>();
        NodeList list = parseDocument(xml).getElementsByTagName("recipe");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            Recipe recipe = new Recipe();
            recipe.setIdrecipe(Integer.valueOf(e.getElementsByTagName("idrecipe").item(0).getTextContent()));
            recipe.setRecipetitel(e.getElementsByTagName("recipetitel").item(0).getTextContent());
            recipe.setRecipedescription(e.getElementsByTagName("recipedescription").item(0).getTextContent());
            recipe.setRecipeingredient(e.getElementsByTagName("recipeingredient").item(0).getTextContent());
            recipe.setRecipeimage(e.getElementsByTagName("recipeimage").item(0).getTextContent());
            
            recipeList.add(recipe);
        }
        return recipeList;
    }
    private Recipe parseRecipe(String xml) {
        if (xml.length() == 0) {
            return null;
        }
        Element e = (Element) parseDocument(xml).getElementsByTagName("recipe").item(0);

        Recipe recipe = new Recipe();
        recipe.setIdrecipe(Integer.valueOf(e.getElementsByTagName("idrecipe").item(0).getTextContent()));
        recipe.setRecipetitel(e.getElementsByTagName("recipetitel").item(0).getTextContent());
        recipe.setRecipedescription(e.getElementsByTagName("recipedescription").item(0).getTextContent());
        recipe.setRecipeingredient(e.getElementsByTagName("recipeingredient").item(0).getTextContent());
        recipe.setRecipeimage(e.getElementsByTagName("recipeimage").item(0).getTextContent());
        
        return recipe;
    }
    
    
public Recipe getRecipeById(int id) {
        return parseRecipe(client.target(RECIPE_URL + "/find/" + id).request().get().readEntity(String.class));
    }

public Recipe getRecipeByName(String foodName) throws DoesNotExistException {
        Recipe f = parseRecipe(client.target(RECIPE_URL + "/findByName/" + foodName).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Food " + foodName + " does not exist.");
    }

public List<Recipe> getAllRecipe(int id) {
        return parseRecipeList(client.target(USER_URL + "/getRecipe/" + id).request().get(String.class));
    }

public void createRecipe(Recipe recipe) {
        client.target(RECIPE_URL + "/create").request().post(Entity.entity(recipe, "application/xml"));
    }

    public void updateRecipe(Recipe recipe) {
        client.target(RECIPE_URL + "/edit/" + recipe.getIdrecipe()).request().put(Entity.entity(recipe, "application/xml"));
    }

    public void removeRecipe(int id) {
        client.target(RECIPE_URL + "/remove/" + id).request().get().readEntity(String.class);
    }

    // Achievement
    
    private List<Achievement> parseAchievementList(String xml) {
        List<Achievement> achievementList = new ArrayList<>();
        NodeList list = parseDocument(xml).getElementsByTagName("achievement");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            Achievement Pokemon = new Achievement();
            Pokemon.setIdachievement(Integer.valueOf(e.getElementsByTagName("idachievement").item(0).getTextContent()));
            Pokemon.setAchievementpokemon(e.getElementsByTagName("achievementpokemon").item(0).getTextContent());
        
            
            achievementList.add(Pokemon);
        }
        return achievementList;
    }
    
private Achievement parseAchievement(String xml) {
        if (xml.length() == 0) {
            return null;
        }
        Element e = (Element) parseDocument(xml).getElementsByTagName("achievement").item(0);

        Achievement Pokemon = new Achievement();
            Pokemon.setIdachievement(Integer.valueOf(e.getElementsByTagName("idachievement").item(0).getTextContent()));
            Pokemon.setAchievementpokemon(e.getElementsByTagName("achievementpokemon").item(0).getTextContent());
        
        
        return Pokemon;
    }

    public Achievement getAchievementById(int id) {
        return parseAchievement(client.target(ACHIEVEMENT_URL + "/find/" + id).request().get().readEntity(String.class));
    }

    public Achievement getAchievementByName(String pokemon) throws DoesNotExistException {
        Achievement f = parseAchievement(client.target(ACHIEVEMENT_URL + "/findByName/" + pokemon).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Pokemon " + pokemon+ " does not exist.");
    }

    public List<Achievement> getAllAchievement(int id) {
        return parseAchievementList(client.target(USER_URL + "/getAchievement/" + id).request().get(String.class));
    }
    
    public void createAchievement(Achievement achievement) {
        client.target(ACHIEVEMENT_URL + "/create").request().post(Entity.entity(achievement, "application/xml"));
    }

    public void updateAchievement(Achievement achievement) {
        client.target(ACHIEVEMENT_URL + "/edit/" + achievement.getIdachievement()).request().put(Entity.entity(achievement, "application/xml"));
    }

    public void removeAchievement(int id) {
        client.target(ACHIEVEMENT_URL + "/remove/" + id).request().get().readEntity(String.class);
    }
    
    public void removeFromAchievement(int uId, int fId) {
        client.target(USER_URL + "/removeFromAchievement/" + uId + "/" + fId).request().get();
    }
    
    public void addToAchievement(int uId, int fId) {
        client.target(USER_URL + "/addToAchievement/" + uId + "/" + fId).request().get();
    }
    
        // TrainingProgram
    
    private List<Trainingprogram> parseTrainingprogramList(String xml) {
        List<Trainingprogram> TrainingprogramList = new ArrayList<>();
        NodeList list = parseDocument(xml).getElementsByTagName("trainingprogram");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            Trainingprogram exercices = new Trainingprogram();
            exercices.setIdTrainingProgram(Integer.valueOf(e.getElementsByTagName("idTrainingProgram").item(0).getTextContent()));
            exercices.setAbs(e.getElementsByTagName("abs").item(0).getTextContent());
            exercices.setCardio(e.getElementsByTagName("cardio").item(0).getTextContent());
            exercices.setArms(e.getElementsByTagName("arms").item(0).getTextContent());
            exercices.setLegs(e.getElementsByTagName("legs").item(0).getTextContent());
            exercices.setTrainingProgramTitel(e.getElementsByTagName("trainingProgramTitel").item(0).getTextContent());
            exercices.setTrainingProgramGoal(e.getElementsByTagName("trainingProgramGoal").item(0).getTextContent());
            exercices.setTrainingProgramExercicesImage(e.getElementsByTagName("trainingProgramExercicesImage").item(0).getTextContent());
            exercices.setTrainingProgramGIF1(e.getElementsByTagName("trainingProgramGIF1").item(0).getTextContent());
            exercices.setTrainingProgramGIF2(e.getElementsByTagName("trainingProgramGIF2").item(0).getTextContent());
            exercices.setTrainingProgramGIF3(e.getElementsByTagName("trainingProgramGIF3").item(0).getTextContent());
            exercices.setTrainingProgramGIF4(e.getElementsByTagName("trainingProgramGIF4").item(0).getTextContent());
            exercices.setTrainingProgramGIF5(e.getElementsByTagName("trainingProgramGIF5").item(0).getTextContent());
        
        
            
            TrainingprogramList.add(exercices);
        }
        return TrainingprogramList;
    }
    
private Trainingprogram parseTrainingprogram(String xml) {
        if (xml.length() == 0) {
            return null;
        }
        Element e = (Element) parseDocument(xml).getElementsByTagName("trainingprogram").item(0);
        
        Trainingprogram exercicese = new Trainingprogram();
            exercicese.setIdTrainingProgram(Integer.valueOf(e.getElementsByTagName("idTrainingProgram").item(0).getTextContent()));
            exercicese.setAbs(e.getElementsByTagName("abs").item(0).getTextContent());
            exercicese.setCardio(e.getElementsByTagName("cardio").item(0).getTextContent());
            exercicese.setArms(e.getElementsByTagName("arms").item(0).getTextContent());
            exercicese.setLegs(e.getElementsByTagName("legs").item(0).getTextContent());
            exercicese.setTrainingProgramTitel(e.getElementsByTagName("trainingProgramTitel").item(0).getTextContent());
            exercicese.setTrainingProgramGoal(e.getElementsByTagName("trainingProgramGoal").item(0).getTextContent());
            exercicese.setTrainingProgramExercicesImage(e.getElementsByTagName("trainingProgramExercicesImage").item(0).getTextContent());
            exercicese.setTrainingProgramGIF1(e.getElementsByTagName("trainingProgramGIF1").item(0).getTextContent());
            exercicese.setTrainingProgramGIF2(e.getElementsByTagName("trainingProgramGIF2").item(0).getTextContent());
            exercicese.setTrainingProgramGIF3(e.getElementsByTagName("trainingProgramGIF3").item(0).getTextContent());
            exercicese.setTrainingProgramGIF4(e.getElementsByTagName("trainingProgramGIF4").item(0).getTextContent());
            exercicese.setTrainingProgramGIF5(e.getElementsByTagName("trainingProgramGIF5").item(0).getTextContent());
        
        return exercicese;
    }

    public Trainingprogram getTrainingprogramById(int id) {
        return parseTrainingprogram(client.target(TRAININGPROGRAM_URL + "/find/" + id).request().get().readEntity(String.class));
    }

public Trainingprogram getTrainingprogramByName(String exercice) throws DoesNotExistException {
        Trainingprogram f = parseTrainingprogram(client.target(TRAININGPROGRAM_URL + "/findByName/" + exercice).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Food " + exercice + " does not exist.");
    }

    public List<Trainingprogram> getAllTrainingprogram(int id) {
        return parseTrainingprogramList(client.target(USER_URL + "/getTrainingprogram/" + id).request().get(String.class));
    }
    

    public void createTrainingprogram(Trainingprogram achievement) {
        client.target(TRAININGPROGRAM_URL + "/create").request().post(Entity.entity(achievement, "application/xml"));
    }

    public void updateTrainingprogram(Trainingprogram exercice) {
        client.target(TRAININGPROGRAM_URL + "/edit/" + exercice.getIdTrainingProgram()).request().put(Entity.entity(exercice, "application/xml"));
    }

    public void removeTrainingprogram(int id) {
        client.target(TRAININGPROGRAM_URL + "/remove/" + id).request().get().readEntity(String.class);
    }
    
    public void removeFromTrainingprogram(int uId, int fId) {
        client.target(USER_URL + "/removeFromTrainingprogram/" + uId + "/" + fId).request().get();
    }
    
    public void addToTrainingprogram(int uId, int fId) {
        client.target(USER_URL + "/addToTrainingprogram/" + uId + "/" + fId).request().get();
    }
    
    public Trainingprogram getTrainingprogramByLegs(String exercice, String goal) throws DoesNotExistException {
        Trainingprogram f = parseTrainingprogram(client.target(TRAININGPROGRAM_URL + "/findByLegs/" + exercice +"/"+ goal).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Exercice " + exercice + " does not exist.");
    }
    
    public Trainingprogram getTrainingprogramByArms(String exercice, String goal) throws DoesNotExistException {
        Trainingprogram f = parseTrainingprogram(client.target(TRAININGPROGRAM_URL + "/findByArms/" + exercice +"/"+goal).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Exercice " + exercice + " does not exist.");
    }
    
    public Trainingprogram getTrainingprogramByAbs(String exercice, String goal) throws DoesNotExistException {
        Trainingprogram f = parseTrainingprogram(client.target(TRAININGPROGRAM_URL + "/findByAbs/" + exercice +"/"+goal).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Exercice " + exercice + " does not exist.");
    }
    
    public Trainingprogram getTrainingprogramByCardio(String exercice, String goal) throws DoesNotExistException {
        Trainingprogram f = parseTrainingprogram(client.target(TRAININGPROGRAM_URL + "/findByCardio/" + exercice +"/"+goal).request().get(String.class));
        if (f != null) {
            return f;
        }
        throw new DoesNotExistException("Exercice " + exercice + " does not exist.");
    }
}
