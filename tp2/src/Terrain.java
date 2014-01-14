import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Terrain {
public static int SPACE=Jeu.PAS_QUADRILLAGE ;
public static int hauteur=(int)Jeu.HEIGHT;
public static int largeur=(int)Jeu.WIDTH;
public static String level1= "C:\\Users\\thibault\\workspace2\\tp2\\level1.txt";
public static String level2= "C:\\Users\\thibault\\workspace2\\tp2\\level2.txt";
public static String level3= "C:\\Users\\thibault\\workspace2\\tp2\\level3.txt";
public static String level4= "C:\\Users\\thibault\\workspace2\\tp2\\level4.txt";
public static String level5= "C:\\Users\\thibault\\workspace2\\tp2\\level5.txt";
public static String level6= "C:\\Users\\thibault\\workspace2\\tp2\\level6.txt";
String map="";
int [][] terrain= new int[largeur+2][hauteur+2];
	Terrain(){
		
	}

	Terrain(String name){
		StdDraw.setXscale(0, largeur );            
		StdDraw.setYscale(0, hauteur);
		this.map=name;
		if ("level1.png"==name)	this.terrain=convertTxtToTab(level1);
		if ("level2.png"==name)	this.terrain=convertTxtToTab(level2);
		if ("level3.png"==name)	this.terrain=convertTxtToTab(level3);
		if ("level4.png"==name)	this.terrain=convertTxtToTab(level4);
		if ("level5.png"==name)	this.terrain=convertTxtToTab(level5);
		if ("level6.png"==name)	this.terrain=convertTxtToTab(level6);
	}
	public static void afficher(Terrain niveau){
		StdDraw.picture(largeur/2, hauteur/2,niveau.map);
	}
	
	public static void selectMap(){
		
	}
	
	public static String choixMap(){
		String map="";
		boolean etat=false;
		StdDraw.picture(largeur/2-largeur/3, 2*hauteur/3, "level1.png",200,200);
		StdDraw.picture(largeur/2, 2*hauteur/3, "level2.png",200,200);
		StdDraw.picture(largeur/2+largeur/3, 2*hauteur/3, "level3.png",200,200);
		StdDraw.picture(largeur/2-largeur/3, hauteur/3, "level4.png",200,200);
		StdDraw.picture(largeur/2, hauteur/3, "level5.png",200,200);
		StdDraw.picture(largeur/2+largeur/3, hauteur/3, "level6.png",200,200);

		while(etat==false){
			if (boutonMap(largeur/2-largeur/3, 2*hauteur/3)==true){
				map="level1.png";
				etat=true;
			}
			if (boutonMap(largeur/2, 2*hauteur/3)==true){
				map="level2.png";
				etat=true;
			}
			if (boutonMap(largeur/2+largeur/3, 2*hauteur/3)==true){
				map="level3.png";
				etat=true;
			}
			if (boutonMap(largeur/2-largeur/3, hauteur/3)==true){
				map="level4.png";
				etat= true;
			}
			if (boutonMap(largeur/2, hauteur/3)==true){
				map="level5.png";
				etat=true;
			}
			if (boutonMap(largeur/2+largeur/3, hauteur/3)==true){
				map="level6.png";
				etat= true;
			}
		}
		return map;
	    
	}
	
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
	 
	public static int[] PlacerVoitureDepart(String niveau){
		int [] depart = new int [2];
		switch (niveau){
		case "level1.png":
			depart[0]=2; //x
			depart[1]=8;//y
			break;
		case "level2.png":
			depart[0]=2;
			depart[1]=6;
			break;
		case "level3.png":
			depart[0]=2;
			depart[1]=2;
			break;
		case "level4.png":
			depart[0]=2;
			depart[1]=4;
			break;
		case "level5.png":
			depart[0]=2;
			depart[1]=6;
			break;
		case "level6.png":
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
