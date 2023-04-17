
package ch.unil.doplab.gadswebsite.models;

import static ch.unil.doplab.gadsweb.Beans.FoodBean.generateRecipes;
import ch.unil.doplab.gadsweb.Beans.LoginBean;
import static ch.unil.doplab.gadsweb.Beans.UserBean.recipe;
import ch.unil.doplab.gadswebsite.database.MockDatabase;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



/**
 *
 * @author david
 */

public class Food {

private double proteines;
private double glucides;
private double lipides;
ArrayList<String> recipe;
private static final String Recipe_URL = "https://api.spoonacular.com/recipes/complexSearch?apiKey=7355daa524c442018a70544c07d33d57";
private static Client client;
public static String image;
private String description;
private String goal;

//double proteines, double lipides, double glucides,double foodweight
public Food(ArrayList<String> recipe) {   
        this.recipe = new ArrayList();
         this.recipe = recipe;
                 
           
}

//GETTERS methods
  
public double getProteines() {
      return proteines;
    }

public double getLipides() {
      return lipides;
    }

public double getGlucides() {
      return glucides;
    }

    public static ArrayList<Food> getRecipe() {
      return MockDatabase.getInstance().getRecipes();
    }

    public String getRecipe_URL() {
        return Recipe_URL;
    }

    public String getGoal() {
        return goal;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    
//SETTERS methods

public void setProteines(Double proteines) {
      this.proteines=proteines;
    }

public void setLipides(Double lipides) {
      this.lipides=lipides;
    }

public void setGlucides(Double glucides) {
      this.glucides=glucides;
    }

public void setRecipe(List recipe) {
      this.recipe= generateRecipes(goal);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
    
 public void setImage(String image) {
        this.image = image;
    }

// Fonctions

 public static double calculProteines(Double pweight) {
    return pweight * 0.4;
  }

  public static double calculLipides(Double lweight) {
    return lweight * 0.3;
  }

  public static double calculGlucides(Double gweight) {
    return gweight * 0.3;
  }
  public static int generateBetween(int number, int max) {
    Random random = new Random();
    int generated = random.nextInt(max - number);
    return generated;
}
  
// public static ArrayList<String> generateRecipes(String goal) {
//     List b= new ArrayList<String>();
//     List y =new ArrayList<String>();
//     String c= "";
//     b=getRecipe();
//     c= b.toString();
//     String[] d = c.split(";");
//     int i=-1;
//            while ( i < 3) {
//                i=i+1;
//            y.add(d[i]);
//            
//    
//        }   
//        
//        return (ArrayList<String>) y;
//  
//}
 @Override
    public boolean equals(Object obj) {
        if (obj instanceof Food) {
            Food f = (Food) obj;
            return f.toString().equals(this.toString());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "" + recipe;
    }
    
}
// public static List generateRecipes(Double foodWeight) {
//    Double a= calculProteines(foodWeight);
//    Double b= calculLipides(foodWeight);
//    Double c = calculGlucides(foodWeight);
//    int d = generateBetween(1,100);
//    String f = d + "";
//    try {
//      HttpRequest request = HttpRequest.newBuilder()
//          .uri(new URI(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=7355daa524c442018a70544c07d33d57&number=2&random=true&maxCarbs=%.0f&maxProtein=%.0f&maxFat=%.0f&offset="+f,c,a,b)))
//          .headers("Content-Type", "application/json")
//          .GET()
//          .build();
//      try {
//        try {
//          HttpResponse<String> response = HttpClient.newBuilder()
//              .build()
//              .send(request, BodyHandlers.ofString());
//
//          return response.body();
//
//        } catch (IOException e) {
//          e.printStackTrace();
//          return "";
//        }
//
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//        return "";
//      }
//      
//    } catch (URISyntaxException e) {
//      e.printStackTrace();
//      return "";
//    }
//
//  }
//} &number=2&random=true&maxCarbs=%.0f&maxProtein=%.0f&maxFat=%.0f&offset="

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
  
//public static String generateRecipes(double foodweight) {
//    double a= calculProteines(foodweight);
//    double b= calculLipides(foodweight);
//    double c = calculGlucides(foodweight);
//    int d = generateBetween(1,100);
//    String e = d + "";
//    Food.client = ClientBuilder.newClient();
//    String g= "Pas fonctionner";
//    
// String f = parseRecipe(client.target(Recipe_URL+(String.format("number=2&random=true&maxCarbs=%.0f&maxProtein=%.0f&maxFat=%.0f&offset="+e,c,a,b) )).request().get(String.class));
//        if (f != null) {
//            return f;
//       }
//    return g ;
//}
//private static String parseRecipe(String xml) {
//        return xml;
//        }
//}