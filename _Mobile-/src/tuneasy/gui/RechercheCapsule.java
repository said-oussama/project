/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuneasy.gui;

/**
 *
 * @author oussama
 */

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import tuneasy.entities.Restaurant;
import tuneasy.services.RestaurantService;
import java.util.ArrayList;

/**
 *
 * @author 21658
 */
public class RechercheCapsule extends Form {
      Resources theme;
    public RechercheCapsule(Form previous, String recherche) {
       theme = UIManager.initFirstTheme("/theme");
      ArrayList<Restaurant> list =RestaurantService.getInstance().affichageResto();
        for(Restaurant cap : list) {
        setLayout(BoxLayout.y());
        if(cap.getNom().equals(recherche) )
        {
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.y());
        Container cnt3 = new Container(new FlowLayout(CENTER,CENTER));
      //  ImageViewer imgpers = new ImageViewer(theme.getImage(pers.getPhoto()));
      //  cnt3.add(imgpers);
        Label id = new Label("id : " + String.valueOf(cap.getId_resto()));
        Label nom = new Label ("nom capsule : " + cap.getNom());
        Label type = new Label ("type : " + cap.getAdresse());
        Label chemin = new Label ("chemin : " + cap.getPhoto());
        Label cible = new Label ("cible : " + cap.getVille());
        Label image = new Label ("type : " + cap.getDescription());
        Label duree = new Label ("type : " + cap.getType());
       
         //Label photo = new Label ("photo : " + pers.getPhoto()); 
       cnt2.addAll(id,nom,type,chemin,cible,image,duree);
     //  Button modifier = new Button ("modifier");
     //  Button supprimer = new Button ("supprimer");
       cnt1.addAll(cnt2,cnt3);
        add(cnt1);
      /* supprimer.addActionListener(e->{
       Dialog dig = new Dialog("supression");
       if (dig.show("suppression","veuillez supprimer une personnel","annuler","oui"))
            dig.dispose();
       else {
       dig.dispose();
//       if (RestaurantService.getInstance().supprimercapsule(cap.getId_resto())){
//           System.out.println(cap.getId_resto());
//           new FormResto(previous).show();}
       }
       }); 
       */
//       modifier.addActionListener(m-> {
//       new ModifierCapsule(previous, cap).show();
//       });
            
    } }
            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

}
}

