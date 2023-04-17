
package ch.unil.doplab.gadswebsite.v1.models;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 *
 * @author david
 */

public class Food {

private double proteines;
private double glucides;
private double lipides;
List recipe = new ArrayList();


public Food(Double proteines, Double lipides, Double glucides,Double foodweight) {   

         this.proteines= proteines;
         this.lipides= lipides;
         this.glucides= glucides;
         this.recipe = new ArrayList<>();
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

public List getRecipe() {
      return recipe;
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
      this.recipe=recipe;
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
 public static String generateRecipes(Double foodWeight) {
    Double a= calculProteines(foodWeight);
    Double b= calculLipides(foodWeight);
    Double c = calculGlucides(foodWeight);
    int d = generateBetween(1,100);
    String f = d + "";
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=7355daa524c442018a70544c07d33d57&number=2&random=true&maxCarbs=%.0f&maxProtein=%.0f&maxFat=%.0f&offset="+f,c,a,b)))
          .headers("Content-Type", "application/json")
          .GET()
          .build();
      try {
        try {
          HttpResponse<String> response = HttpClient.newBuilder()
              .build()
              .send(request, BodyHandlers.ofString());

          return response.body();

        } catch (IOException e) {
          e.printStackTrace();
          return "";
        }

      } catch (InterruptedException e) {
        e.printStackTrace();
        return "";
      }
      
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return "";
    }

  }
 
}