import java.io.File;
import java.io.FileWriter;


public class Collision {
	static final int AUCUNE_COLLISION=0;
	static final int COLLISION_CRASH=1;
	static final int COLLISION_LIMITE=2;
	static final int COLLISION_EAU=4;
	static final int RALENTISSEMENT_HERBE=3;
	public static int SPACE=Jeu.PAS_QUADRILLAGE ;
	public static int hauteur=(int)Jeu.HEIGHT;
	public static int largeur=(int)Jeu.WIDTH;
	public static final char HERBE= '.';
	public static final char EAU='0';
	public static final char ROUTE='&';
	public static final char CRASH='#';
	
	//-----------------------------------------------------------
 	//-------------------verifCollision--------------------------
 	//-----------------------------------------------------------
   
    public static int verifCollision(Vehicule voiture,Terrain carte){ 
    	 int collision= AUCUNE_COLLISION;   			 
    	 
    	 //collision avec les limites du terrain
    	 if((((voiture.positionX-voiture.size) < 0)) || ((voiture.positionX+voiture.size) > largeur)){      
             collision=COLLISION_LIMITE ;
         }
         if((((voiture.positionY-voiture.size) < 0)) || ((voiture.positionY+voiture.size) > hauteur)){
             collision=COLLISION_LIMITE;
         }
       //collision avec un objet
        if(CRASH ==carte.terrain[(int)voiture.positionY][(int)voiture.positionX]){      
        	 collision=COLLISION_CRASH ;
        }
  
        if(EAU ==carte.terrain[(int)voiture.positionY][(int)voiture.positionX]){      
       	 collision=COLLISION_EAU ;
       }
         
         return collision;
    }
}
