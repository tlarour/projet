import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Terrain {
public static int SPACE=Jeu.PAS_QUADRILLAGE ;
public static int hauteur=(int)Jeu.HEIGHT;
public static int largeur=(int)Jeu.WIDTH;
//cartes .txt
public final static String LEVEL1= "level1.txt";
public final static String LEVEL2= "level2.txt";
public final static String LEVEL3= "level3.txt";
public final static String LEVEL4= "level4.txt";
public final static String LEVEL5= "level5.txt";
public final static String LEVEL6= "level6.txt";
//cartes .png
public final static String MAP1= "level1.png";
public final static String MAP2= "level2.png";
public final static String MAP3= "level3.png";
public final static String MAP4= "level4.png";
public final static String MAP5= "level5.png";
public final static String MAP6= "level6.png";
//enregistrer la map choisie
String map="";
//tableau pour copier le fichier texte contenant la description de la carte
int [][] terrain= new int[largeur+2][hauteur+2];
	Terrain(){
		
	}

	Terrain(String name){
		StdDraw.setXscale(0, largeur );            
		StdDraw.setYscale(0, hauteur);
		this.map=name;
		if (MAP1==name)	this.terrain=convertTxtToTab(LEVEL1);
		if (MAP2==name)	this.terrain=convertTxtToTab(LEVEL2);
		if (MAP3==name)	this.terrain=convertTxtToTab(LEVEL3);
		if (MAP4==name)	this.terrain=convertTxtToTab(LEVEL4);
		if (MAP5==name)	this.terrain=convertTxtToTab(LEVEL5);
		if (MAP6==name)	this.terrain=convertTxtToTab(LEVEL6);
	}
	/*
	 * affichage de la carte
	 */
	public static void afficher(Terrain niveau){
		StdDraw.picture(largeur/2, hauteur/2,niveau.map);
	}
	/*
	 * selection de la map
	 */
	public static String choixMap(){
		String map="";
		boolean etat=false;
		StdDraw.picture(largeur/2-largeur/3, 2*hauteur/3,MAP1,200,200);
		StdDraw.picture(largeur/2, 2*hauteur/3, MAP2,200,200);
		StdDraw.picture(largeur/2+largeur/3, 2*hauteur/3,MAP3,200,200);
		StdDraw.picture(largeur/2-largeur/3, hauteur/3,MAP4,200,200);
		StdDraw.picture(largeur/2, hauteur/3,MAP5,200,200);
		StdDraw.picture(largeur/2+largeur/3, hauteur/3,MAP6,200,200);

		while(etat==false){
			if (boutonMap(largeur/2-largeur/3, 2*hauteur/3)==true){
				map=MAP1;
				etat=true;
			}
			if (boutonMap(largeur/2, 2*hauteur/3)==true){
				map=MAP2;
				etat=true;
			}
			if (boutonMap(largeur/2+largeur/3, 2*hauteur/3)==true){
				map=MAP3;
				etat=true;
			}
			if (boutonMap(largeur/2-largeur/3, hauteur/3)==true){
				map=MAP4;
				etat= true;
			}
			if (boutonMap(largeur/2, hauteur/3)==true){
				map=MAP5;
				etat=true;
			}
			if (boutonMap(largeur/2+largeur/3, hauteur/3)==true){
				map=MAP6;
				etat= true;
			}
		}
		return map;
	}
	/*
	 * bouton pour la selection de la carte
	 */
	 public static boolean boutonMap(int x,int y){
		 double posX= StdDraw.mouseX();
		 double posY= StdDraw.mouseY();
		 boolean exit=false;
		
		 if ((posX>x-100)&&(posX<x+100)&&(posY>y-100)&&(posY<y+100)){
			 StdDraw.setPenColor(StdDraw.RED);
			 
			 StdDraw.rectangle(x, y,150,150);
			 if (StdDraw.mousePressed()==true){//clic
			     while (StdDraw.mousePressed()==true){}//déclic
				 exit=true;
				 
			 }
		 }
		 else{
			 StdDraw.setPenColor(StdDraw.BLUE);
			 StdDraw.rectangle(x,y,150,150);
			 
		 }
		 return exit;
	 }
	 /* placement de la voiture au point de départ
	  * 
	  */
	public static int[] PlacerVoitureDepart(String niveau){
		int [] depart = new int [2];
		switch (niveau){
		case MAP1:
			depart[0]=2; //x
			depart[1]=8;//y
			break;
		case MAP2:
			depart[0]=2;
			depart[1]=6;
			break;
		case MAP3:
			depart[0]=2;
			depart[1]=2;
			break;
		case MAP4:
			depart[0]=2;
			depart[1]=4;
			break;
		case MAP5:
			depart[0]=2;
			depart[1]=6;
			break;
		case MAP6:
			depart[0]=2;
			depart[1]=2;
			break;
		}
		return depart;
		
	}
	/*
	 * Convertir le fichier texte contenant de terrain en un tableau à 2 dimensions
	 *  
	 */
	public static int [][] convertTxtToTab(String name){
		int [][] tab= new int[largeur+2][hauteur+2];
		try {
			 File ff=new File(name);	
			 FileReader ffr=new FileReader(ff);
			 for (int i=0;i<=hauteur;i+=1){
	     			for (int j=0;j<=largeur;j+=1){	
	     				tab[i][j] = ffr.read();
	     			}
	     			ffr.read();//on enleve le linefeed
		     }
    	} catch (IOException e) {
    		 // TODO Auto-generated catch block
    		 e.printStackTrace();
    	}	
		return tab;
	}

}
