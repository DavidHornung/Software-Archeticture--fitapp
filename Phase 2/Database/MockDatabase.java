package ch.unil.doplab.gadswebsite.database;

import ch.unil.doplab.gadswebsite.models.Food;
import ch.unil.doplab.gadswebsite.models.PhysicalActivity;
import ch.unil.doplab.gadswebsite.models.User;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class MockDatabase {

    private static MockDatabase instance;

    private ArrayList<User> users;
    private ArrayList<PhysicalActivity> physicalActivities;
    private ArrayList<Food> Recipe;
    private ArrayList<PhysicalActivity> Exercices;
    
    

    private MockDatabase() {
        users = new ArrayList<User>();
       users.add(new User("Adrian", "Adrian", "Muino", "adrian@muino.com", "1234",27,"male",1.75,83.0,2,"url here or smth","",0.0,100.00,100.00,0,0,0,0));


        physicalActivities = new ArrayList<PhysicalActivity>();
        
        ArrayList<String> act1 = new ArrayList<String>();
        act1.add(";https://fontmeme.com/permalink/221124/9ad5a9ffcbb91f2567caf96108b0810e.png;"); // legs training pokemon
        act1.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221125/f75f0fb0d51027f47d4b3e13b66e3919.png;https://i.kym-cdn.com/photos/images/newsfeed/001/135/060/dcd.gif;"); // Exercices and Gain Pokemon GIF 1x
        act1.add(";https://i.pinimg.com/originals/6d/78/57/6d78572bfdda6c7378a394fa7db314e4.gif;https://thepadelmagazine.com/wp-content/uploads/2022/01/giphy-2022-01-21T223358.246.gif;https://i.kym-cdn.com/photos/images/original/002/190/432/5c6.gif;https://hips.hearstapps.com/hmg-prod/images/workouts/2017/10/legpress-1509458589.gif;"); // GIF exercices gain 4x GIF
        act1.add(";https://fontmeme.com/permalink/221124/9ad5a9ffcbb91f2567caf96108b0810e.png;"); // legs training pokemon
        act1.add(";https://fontmeme.com/permalink/221125/4588f9afa77a68ec8162e7527b070133.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://www.icegif.com/wp-content/uploads/2022/01/icegif-501.gif;");// Exercices and Lose Pokemon GIF 1x
        act1.add(";https://media1.giphy.com/media/fSvqyvXn1M3btN8sDh/giphy.gif;https://www.icegif.com/wp-content/uploads/angry-pokemon-icegif.gif;https://media.tenor.com/5tx4K4w-cocAAAAd/pikachu-dancing-pikachu.gif;https://pa1.narvii.com/6418/c28248f2c0ac7a2c5290969dcd074d1e075f9db2_hq.gif;");// GIF exercices gain 4x
        physicalActivities.add(new PhysicalActivity(act1));
        
        ArrayList<String> act2 = new ArrayList<String>();
        act2.add(";https://fontmeme.com/permalink/221125/e71cc24248c7e73b3778538988fcbee2.png;"); // arms training pokemon
        act2.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://media.tenor.com/wGI7b1yGg5IAAAAC/pokemon-workout.gif;"); // Exercices and Gain Pokemon GIF 1x
        act2.add(";https://media4.giphy.com/media/akAkj2L5pgA5a/giphy.gif?cid=ecf05e47l7evrdrsd886fj6ib21bx70s6g2ubzg6297t6hfg&rid=giphy.gif&ct=g;https://i.giphy.com/media/LEdeagTR1duUM/giphy.webp;https://media1.giphy.com/media/1334O1WETb3sIM/giphy.gif?cid=ecf05e47k30exl74ps8c099320akm5u027vfe4y1l47yicas&rid=giphy.gif&ct=g;https://media3.giphy.com/media/3o6gEb896PcLMSMRva/giphy.gif?cid=ecf05e47f8nhfu3gj425q6anmyk680xf2efv7zq438w3essk&rid=giphy.gif&ct=g;"); // GIF exercices gain 4x GIF
        act2.add(";https://fontmeme.com/permalink/221125/e71cc24248c7e73b3778538988fcbee2.png;"); // arms training pokemon
        act2.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://media3.giphy.com/media/npnevRsQRUc5a/giphy.gif?cid=ecf05e47120b7t56ht61z7o1f3ort97ewrxx1muu0rgkgnlr&rid=giphy.gif&ct=g;"); // Exercices and Lose Pokemon GIF 1x
        act2.add(";https://i.pinimg.com/originals/1f/40/45/1f4045eded9bfd9e041cd35166c06199.gif;https://i.makeagif.com/media/2-01-2014/ND3swh.gif;https://64.media.tumblr.com/6e6e88590445f144fc2fdb20654287bb/tumblr_inline_og6a7skGfp1r5ight_500.gifv;https://media.tenor.com/4uoK1Q18g6gAAAAC/pokemon-snorlax.gif;"); // GIF exercices gain 4x GIF
        physicalActivities.add(new PhysicalActivity(act2));

        
        ArrayList<String> act3 = new ArrayList<String>();
        act3.add(";https://fontmeme.com/permalink/221125/a6e4c2e000598996a8eb289502a217df.png;"); // abs training pokemon
        act3.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://media.tenor.com/86cAZdAe6PwAAAAC/work-hard-exercise.gif;"); // Exercices and Gain Pokemon GIF 1x
        act3.add(";https://media.tenor.com/gmrm2YizINIAAAAC/eijiro-kirishima-exercise.gif;https://media.tenor.com/Sx7F1vqrSvQAAAAC/dbz-goku.gif;https://i.pinimg.com/originals/b6/fe/8a/b6fe8ace415e3a6e376c018f220ac6c2.gif;https://i.pinimg.com/originals/56/7a/9d/567a9dbebf2bca69683c42bafb3405bc.gif;"); // GIF exercices gain 4x GIF
        act3.add(";https://fontmeme.com/permalink/221125/a6e4c2e000598996a8eb289502a217df.png;"); // abs training pokemon
        act3.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://media3.giphy.com/media/npnevRsQRUc5a/giphy.gif?cid=ecf05e47120b7t56ht61z7o1f3ort97ewrxx1muu0rgkgnlr&rid=giphy.gif&ct=g;"); // Exercices and Lose Pokemon GIF 1x
        act3.add(";https://i.pinimg.com/originals/60/c5/1c/60c51c5abf008d98e00082afad2788b7.gif;http://31.media.tumblr.com/12c35447577015076ce967026e8e2306/tumblr_nigto1FT3A1r5424io1_500.gif;https://64.media.tumblr.com/6e6e88590445f144fc2fdb20654287bb/tumblr_inline_og6a7skGfp1r5ight_500.gifv;https://media.tenor.com/4uoK1Q18g6gAAAAC/pokemon-snorlax.gif;"); // GIF exercices gain 4x GIF
        physicalActivities.add(new PhysicalActivity(act3));
        
        
        ArrayList<String> act4 = new ArrayList<String>();
        act4.add(";https://fontmeme.com/permalink/221125/e5dfa60fa025dde76884501fc33a23a5.png;"); // Cardio training pokemon
        act4.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://media.tenor.com/nJclFuwdP5wAAAAC/squirtle-pikachu.gif;"); // Exercices and Gain Pokemon GIF 1x
        act4.add(";https://cdn.vox-cdn.com/uploads/chorus_asset/file/654974/Basket-cartoon-charlieburp-cute-pikachu-Favim.com-238931.0.gif;https://media4.giphy.com/media/Ev2Ov4wBz9Ogg/200w.webp?cid=ecf05e47tcsh3qpguetmh58stzhnjgrc412prwsdxqry8a17&rid=200w.webp&ct=g;https://media0.giphy.com/media/vv8R20yaYZIKk/200.webp?cid=ecf05e47k58cwpo31g2qgh3wvhhqebghq0b7y2clw178midv&rid=200.webp&ct=g;https://media2.giphy.com/media/hEkBbwCnHwitCBTVli/giphy.gif?cid=ecf05e47tmkx30j61m5bicev9pww04cwr8z8vfi9uchylkrw&rid=giphy.gif&ct=g;"); // GIF exercices gain 4x GIF
        act4.add(";https://fontmeme.com/permalink/221125/e5dfa60fa025dde76884501fc33a23a5.png;"); // Cardio training pokemon
        act4.add(";https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png;https://fontmeme.com/permalink/221124/37fd9d358b5e5c3a6c42a4d8df278ecc.png;https://media4.giphy.com/media/hllwtNe9cnAeA/giphy.gif?cid=ecf05e47j6hby3v1unr00cdhgnrfsi7x2syg9titsccowmh3&rid=giphy.gif&ct=g;"); // Exercices and Lose Pokemon GIF 1x
        act4.add(";https://media2.giphy.com/media/CXaDzPow0SJqM/giphy.gif?cid=ecf05e47ummba17m9gpog4z7zhmt8fwta9opz29ueqgyh3xu&rid=giphy.gif&ct=g;https://media2.giphy.com/media/gtuQIOTlQdk9Mx3L5i/giphy.gif?cid=ecf05e47ct93lqfselctx4u5j1g68ky1x6hdewzungfgav18&rid=giphy.gif&ct=g;https://i.pinimg.com/originals/b0/b9/ec/b0b9ec56e32933545864dcde06070771.gif;https://pa1.narvii.com/6158/e2fbad295beee4ebca0e8b0e84ccc8cf6f60e6e1_hq.gif;"); // GIF exercices gain 4x GIF
        physicalActivities.add(new PhysicalActivity(act4));        
        //
        
        
        Recipe = new ArrayList<Food>();
        
        ArrayList<String> recette  = new ArrayList<String>();
        recette.add(";1;https://fontmeme.com/permalink/221125/35fe79adffba96bdd92ad803e96bb327.png;https://thevaultpublication.files.wordpress.com/2020/11/ghibli-food-1.jpg?w=1024;https://fontmeme.com/permalink/221125/340f020797ba913059cad825c9a50fe9.png;https://fontmeme.com/permalink/221125/f6e42f2ca615b4397fdcc8a2f497bd15.png;");
        recette.add(";2;https://fontmeme.com/permalink/221125/0c55963abf04cda236de676263c04174.png;https://cdn.shopify.com/s/files/1/0561/3553/files/11_0049a823-78df-4319-8030-0f13bb06f468.jpg?v=1659524392;https://fontmeme.com/permalink/221125/b4f7ccfc3194cdc9e18e82e185102d14.png;https://fontmeme.com/permalink/221125/fb8f47e46377cf049d347a866de743a7.png;");
        recette.add(";3;https://fontmeme.com/permalink/221125/549487029fd54455b3e540e946bc909c.png;https://cdn.shopify.com/s/files/1/0561/3553/files/16_c40212df-a56e-49bd-8c82-4bc02ef3a713.jpg?v=1659524645;https://fontmeme.com/permalink/221125/d938414bacb8b0c3a11166c237255729.png;https://fontmeme.com/permalink/221125/3abe61236b63ee7b11777f3179900e5f.png;");
        Recipe.add(new Food(recette));
    }

    public static MockDatabase getInstance() {
        if (instance == null) {
            instance = new MockDatabase();
        }
        return instance;
    }
    
    public void addAUser(User user) {
        users.add(user);
    }

    public void addPhysicalActivity(PhysicalActivity physicalActivity) {
        physicalActivities.add(physicalActivity);
    }
    public void addRecipe(Food recipe) {
        Recipe.add(recipe);
    }
    public void removeAUser(User user) {
        users.remove(user);
    }

    public static void removePhysicalActivity(PhysicalActivity phisicalActivity) {

    }

    public ArrayList<PhysicalActivity> getPhysicalActivities() {
        return physicalActivities;
    }
    
    public ArrayList<Food> getRecipes() {
        return Recipe;
    }
    public ArrayList<User> getUsers() {
        return users;
    }

}
