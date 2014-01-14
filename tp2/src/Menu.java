import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JButton;


public class Menu {
	
	public static int SPACE=Jeu.PAS_QUADRILLAGE ;
	public static int hauteur=(int)Jeu.HEIGHT;
	public static int largeur=(int)Jeu.WIDTH;
	static  Color couleurBoutonNormal = StdDraw.BLUE;
	static  Color couleurBoutonClic= StdDraw.RED;
	static Color fondMenu =StdDraw.WHITE;
	
	 public static void pageAcceuil(){
		 
		StdDraw.setXscale(0, largeur );            
		StdDraw.setYscale(0, hauteur);
		StdDraw.setPenColor(couleurBoutonNormal);
		StdDraw.setPenRadius(0.01);
		int x=0;
		
		 //start + option + voir les scores
		//StdDraw.picture(largeur/2, hauteur/2,"titre.png",hauteur,largeur);
		
		while (true){
			double posX= StdDraw.mouseX();
			double posY= StdDraw.mouseY();
			
			if ((posX>largeur/2-largeur/3-100)&&(posX<largeur/2-largeur/3+100)&&(posY>hauteur/10-50)&&(posY<hauteur/10+50)){
				StdDraw.setPenColor(couleurBoutonClic);
				StdDraw.text(largeur/2-largeur/3,hauteur/10,"OPTION");
				StdDraw.rectangle(largeur/2-largeur/3,hauteur/10,100,50);
				if (StdDraw.mousePressed()==true){//clic
					while (StdDraw.mousePressed()==true){}//déclic
					option();
					StdDraw.clear(fondMenu);
				}
			}
			else if ((posX>largeur/2-100)&&(posX<largeur/2+100)&&(posY>hauteur/10-50)&&(posY<hauteur/10+50)){
				StdDraw.setPenColor(couleurBoutonClic);
				StdDraw.text(largeur/2,hauteur/10, "START");
				StdDraw.rectangle(largeur/2,hauteur/10,100,50);
				if (StdDraw.mousePressed()==true){//clic
					while (StdDraw.mousePressed()==true){}//déclic
					//lancer le menu de start
					StdDraw.clear(fondMenu);
					start();
					StdDraw.clear(fondMenu);
					
				}
			}
			else if ((posX>largeur/2+largeur/3-100)&&(posX<largeur/2+largeur/3+100)&&(posY>hauteur/10-50)&&(posY<hauteur/10+50)){
				StdDraw.setPenColor(couleurBoutonClic);
				StdDraw.text(largeur/2+largeur/3,hauteur/10, "EXIT");
				StdDraw.rectangle(largeur/2+largeur/3,hauteur/10,100,50);
				if (StdDraw.mousePressed()==true){//clic
					while (StdDraw.mousePressed()==true){}//déclic
					//arreter le jeu
					System.exit(0);
				}
			}
			else{
			StdDraw.setPenColor(couleurBoutonNormal);
			StdDraw.rectangle(largeur/2-largeur/3,hauteur/10,100,50);
			StdDraw.rectangle(largeur/2,hauteur/10,100,50);
			StdDraw.rectangle(largeur/2+largeur/3,hauteur/10,100,50);
			StdDraw.text(largeur/2-largeur/3,hauteur/10,"OPTION");
			StdDraw.text(largeur/2,hauteur/10, "START");
			StdDraw.text(largeur/2+largeur/3,hauteur/10, "EXIT");
			StdDraw.picture(largeur/2, hauteur/2, "menu_accueil.png",largeur,hauteur/1.5);
			StdDraw.picture(largeur/2, hauteur-50, "titre.png",largeur,200);
			}
		}
		 
		 
		 
	 }
	 
	 public static void gameOver(){ 
		 StdDraw.clear(fondMenu);
		 //afficher gameOver
		 //retour pge acceuil
		 while(true){
			 
		 }
	 }
	 public static void start(){
		 StdDraw.clear(fondMenu);
		 boolean exit=false;
		 //selection de la voiture
		 //demmarage du jeu 
		 //en cas de crash passer au menu gameover
		 //montrer le score
		 while(exit==false){
			 exit=boutonRetour();	
			 lancer();
		 }
	 }
	 public static void option(){
		 StdDraw.clear(fondMenu);
		 boolean exit=false;
		 //musique
		 //
		 //effacer donnée
		 while(exit==false){
			 exit=boutonRetour();	
		 }
		 
	 }
	 public static void lancer(){
		 double posX= StdDraw.mouseX();
		 double posY= StdDraw.mouseY();
		 StdDraw.picture(largeur/2, hauteur/2, "menu_start.png",largeur,hauteur/1.6);
		
		 if ((posX>largeur/2-100)&&(posX<largeur/2+100)&&(posY>hauteur/10-50)&&(posY<hauteur/10+50)){
			 StdDraw.setPenColor(couleurBoutonClic);
			 StdDraw.text(largeur/2,hauteur/10, "LANCER");
			 StdDraw.rectangle(largeur/2,hauteur/10,100,50);
			 if (StdDraw.mousePressed()==true){//clic
			 	 while (StdDraw.mousePressed()==true){}//déclic
			 	StdDraw.clear(fondMenu);
			 	String voiture=Vehicule.choixModele();
			 	StdDraw.clear(fondMenu);
			 	String map=Terrain.choixMap();
			 	StdDraw.clear(fondMenu);
			 	StdDraw.setPenRadius(0);
			 	int tour=0;
			 	switch (map){
			 	case "level1.png":
				 	Terrain level1=new Terrain();
				 	tour=Jeu.jouerSolo(level1,map, voiture);
				 	score(tour);
				 	break;
			 	case "level2.png":
				 	Terrain level2=new Terrain();
				 	tour=Jeu.jouerSolo(level2,map, voiture);
				 	score(tour);
				 	break;
			 	case "level3.png":
				 	Terrain level3=new Terrain();
				 	tour=Jeu.jouerSolo(level3,map, voiture);
				 	score(tour);
				 	break;
			 	case "level4.png":
				 	Terrain level4=new Terrain();
				 	tour=Jeu.jouerSolo(level4,map, voiture);
				 	score(tour);
				 	break;
			 	case "level5.png":
				 	Terrain level5=new Terrain();
				 	tour=Jeu.jouerSolo(level5,map, voiture);
				 	score(tour);
				 	break;
			 	case "level6.png":
				 	Terrain level6=new Terrain();
				 	tour=Jeu.jouerSolo(level6,map, voiture);
				 	score(tour);
				 	break;
			 	}
			 	System.out.println("arret");
			 }
		 }
		 else{
			 StdDraw.setPenColor(couleurBoutonNormal);
			 StdDraw.rectangle(largeur/2,hauteur/10,100,50);
			 StdDraw.text(largeur/2,hauteur/10,"LANCER");

		 }
	 }
	 
	 public static void score(int tour){
		 boolean exit=false;
		 StdDraw.clear(fondMenu);
		 StdDraw.setPenColor(couleurBoutonNormal);
		 if (tour==-1){
			 StdDraw.text(largeur/2,hauteur/2,"vous avez abandonné:");
		 }
		 else{
			 String nbTour=Integer.toString(tour);
			 StdDraw.text(largeur/2,hauteur/2,"vous avez fini en:");
			 StdDraw.text(largeur/2,hauteur/2-50,nbTour);
			 StdDraw.text(largeur/2,hauteur/2-100,"tours");	 
		 }
		 StdDraw.show();
		 StdDraw.setPenRadius(0.01);
		 while(exit==false){
			 exit=boutonRetour();	
		 }
		 
		 

	 }
	 
	 public static boolean boutonRetour(){
		 double posX= StdDraw.mouseX();
		 double posY= StdDraw.mouseY();
		 boolean exit=false;
		
		 if ((posX>largeur/2+largeur/3-100)&&(posX<largeur/2+largeur/3+100)&&(posY>hauteur-50-50)&&(posY<hauteur-50+50)){
			 StdDraw.setPenColor(couleurBoutonClic);
			 StdDraw.text(largeur/2+largeur/3,hauteur-50,"RETOUR");
			 StdDraw.rectangle(largeur/2+largeur/3,hauteur-50,100,50);
			 if (StdDraw.mousePressed()==true){//clic
			     while (StdDraw.mousePressed()==true){}//déclic
				 exit=true;
				 
			 }
		 }
		 else{
			 StdDraw.setPenColor(couleurBoutonNormal);
			 StdDraw.rectangle(largeur/2+largeur/3,hauteur-50,100,50);
			 StdDraw.text(largeur/2+largeur/3,hauteur-50,"RETOUR");
		 }

		 return exit;
	 }
	 
}
