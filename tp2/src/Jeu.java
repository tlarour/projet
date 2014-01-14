import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;


public class Jeu {
	//import java.awt.Cursor;  //class pour changer le curseur
	
	    static final float WIDTH= 1000;
	    static final float HEIGHT= 1000;
	    static final int FRAMES_PER_SEC= 50;
	    static final int PAS_QUADRILLAGE=25;
	    private static int selection=0;


	 
//-----------------------------------------------------------
//--------------------------quadrillage----------------------
//-----------------------------------------------------------
	 	public static void quadrillage(){
	 		StdDraw.setPenColor(StdDraw.WHITE);
	 		for (int i=0;i<=HEIGHT;i=i+PAS_QUADRILLAGE)
	 		StdDraw.line(0,i,WIDTH,i);
	 		for (int i=0;i<=HEIGHT;i=i+PAS_QUADRILLAGE)
		 		StdDraw.line(i,0,i,HEIGHT);
	 	}
		
//-----------------------------------------------------------
//--------------------------MOVE-----------------------------
//-----------------------------------------------------------
	    public static void move(Vehicule voiture){
	       
	        voiture.x[voiture.tour+1]=0;
	        voiture.y[voiture.tour+1]=0;
	    	//lancer le son de la voiture sur la route, dans l'herbe ou sur l'eau
	        voiture.vitesseX+=voiture.accelerationX;
	        voiture.vitesseY+=voiture.accelerationY;
	        //modification des positions
	        voiture.x[voiture.tour+1]+= voiture.x[voiture.tour]+ voiture.vitesseX*PAS_QUADRILLAGE;   // on ajoute la vitesse en X à la position x
	        voiture.y[voiture.tour+1]+= voiture.y[voiture.tour]+ voiture.vitesseY*PAS_QUADRILLAGE;   // on ajoute la vitesse en Y à la position y
	   
	   
	   
	    }
	    
	  
//-----------------------------------------------------------
//--------------------------DRAW-----------------------------
//-----------------------------------------------------------
	    public static void draw(Vehicule voiture){ 
	        StdDraw.filledCircle(voiture.x[voiture.tour], voiture.y[voiture.tour], voiture.size);
	    }
//-----------------------------------------------------------
//-------------------------CLEAR-----------------------------
//----------------------------------------------------------- 
	    public static void clear(){ 
	    	StdDraw.clear(StdDraw.BLUE);   
	    }
	    
	  
//-----------------------------------------------------------
//-------------------------RONDS-----------------------------
//-----------------------------------------------------------
	    //rond devant la voiture, non cliquable
	    public static void tracerRonds(Vehicule voiture){
	    	StdDraw.setPenColor(StdDraw.BLACK);
	    	if ((voiture.vitesseX==0)&&(voiture.vitesseY==0)){
	    		StdDraw.circle(voiture.x[voiture.tour]-PAS_QUADRILLAGE, voiture.y[voiture.tour]+PAS_QUADRILLAGE,PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour], voiture.y[voiture.tour]+PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour]+PAS_QUADRILLAGE, voiture.y[voiture.tour]+PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour]+PAS_QUADRILLAGE, voiture.y[voiture.tour],PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour]+PAS_QUADRILLAGE, voiture.y[voiture.tour]-PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour], voiture.y[voiture.tour]-PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour]-PAS_QUADRILLAGE, voiture.y[voiture.tour]-PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(voiture.x[voiture.tour]-PAS_QUADRILLAGE, voiture.y[voiture.tour], PAS_QUADRILLAGE/3); 		
	    	}
	    	else{
	    		double nextPositionX=voiture.x[voiture.tour]+PAS_QUADRILLAGE*voiture.vitesseX;
	    		double nextPositionY=voiture.y[voiture.tour]+PAS_QUADRILLAGE*voiture.vitesseY;
	    		
	    		StdDraw.circle(nextPositionX-PAS_QUADRILLAGE, nextPositionY+PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX, nextPositionY+PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX+PAS_QUADRILLAGE, nextPositionY+PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX+PAS_QUADRILLAGE, nextPositionY, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX+PAS_QUADRILLAGE, nextPositionY-PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX, nextPositionY-PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX-PAS_QUADRILLAGE, nextPositionY-PAS_QUADRILLAGE, PAS_QUADRILLAGE/3);
	    		StdDraw.circle(nextPositionX-PAS_QUADRILLAGE, nextPositionY, PAS_QUADRILLAGE/3); 
	    		StdDraw.circle(nextPositionX, nextPositionY, PAS_QUADRILLAGE/3); 
	    		
	    		
	    		
	    	}
	    	StdDraw.show(1000/FRAMES_PER_SEC); 	
	    }
//-----------------------------------------------------------
//-------------------------RONDS-----------------------------
//-----------------------------------------------------------	    
//9 rond cliquable
	    
	    public static boolean boutonAcceleration(Vehicule voiture){

	    	boolean choixAcceleration=false;
	    	if (boutonRond(800,200)==true){

	    		voiture.accelerationX+=-1;
				voiture.accelerationY+=1;
	    		choixAcceleration=true;
	    	}
		    if (boutonRond(875,200)==true){
		    	voiture.accelerationX+=0;
				voiture.accelerationY+=1;
		    	choixAcceleration=true;
		    }
		    if (boutonRond(950,200)==true){
		    	voiture.accelerationX+=1;
				voiture.accelerationY+=1;
		    	choixAcceleration=true;
		    }
		    if (boutonRond(800,125)==true){
		    	voiture.accelerationX+=-1;
				voiture.accelerationY+=0;
		    	choixAcceleration=true;
		    }
		    if (boutonRond(875,125)==true){
		    	if ((voiture.vitesseX==0)&&(voiture.vitesseY==0)){
		    		choixAcceleration=false;
		    	}
		    	else{
		    	voiture.accelerationX+=0;
				voiture.accelerationY+=0;
		    	choixAcceleration=true;
		    	}
		    }
		    if (boutonRond(950,125)==true){
		    	voiture.accelerationX+=1;
				voiture.accelerationY+=0;
		    	choixAcceleration=true;
		    }
		    if (boutonRond(800,50)==true){
		    	voiture.accelerationX+=-1;
				voiture.accelerationY+=-1;
		    	choixAcceleration=true;
		    }
		    if (boutonRond(875,50)==true){
		    	voiture.accelerationX+=0;
				voiture.accelerationY+=-1;
		    	choixAcceleration=true;
		    }
		    if (boutonRond(950,50)==true){
		    	voiture.accelerationX+=1;
				voiture.accelerationY+=-1;
		    	choixAcceleration=true;
		    }
		    return choixAcceleration;
	    }
//-----------------------------------------------------------
//-------------------------RONDS-----------------------------
//-----------------------------------------------------------	    
//1 rond cliquable
		    public static boolean boutonRond(double boutonX,double boutonY){
		    	double posX=StdDraw.mouseX();
		    	double posY=StdDraw.mouseY();
		    	boolean clic=false;
				if ((((posX-boutonX)*(posX-boutonX))+((posY-boutonY)*(posY-boutonY)))<=PAS_QUADRILLAGE*PAS_QUADRILLAGE){
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.circle(boutonX,boutonY,PAS_QUADRILLAGE);
					if (StdDraw.mousePressed()==true){//clic
					    while (StdDraw.mousePressed()==true){}//déclic
							clic=true; 
					}
				}
				else{
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.circle(boutonX,boutonY,PAS_QUADRILLAGE);
				}
				 return clic;
			}
//-----------------------------------------------------------
//-----------------------ANIMATION-CRASH---------------------
//-----------------------------------------------------------
		    public static void animationCrash(double x,double y){
		    	for (int i=0;i<5;i++){
		    		switch (i){
		    		case 0:
		    			StdDraw.picture(x, y, "explosion1.png");
		    			break;
		    		case 1:
		    			StdDraw.picture(x, y, "explosion2.png");
		    			break;
		    		case 2:
		    			StdDraw.picture(x, y, "explosion3.png");
		    			break;
		    		case 3:
		    			StdDraw.picture(x, y, "explosion4.png");
		    			break;
		    		case 4:
		    			StdDraw.picture(x, y, "explosion5.png");
		    			break;
		    			
		    		}
		    		StdDraw.show(100);
		    	}
		    }
//-----------------------------------------------------------
//-----------------------ANIMATION-CRASH---------------------
//-----------------------------------------------------------
  		    public static void animationEau(double x,double y){
  		    	for (int i=0;i<5;i++){
  		    		switch (i){
  		    		case 0:
  		    			StdDraw.picture(x, y, "eau1.png");
  		    			break;
  		    		case 1:
  		    			StdDraw.picture(x, y, "eau2.png");
  		    			break;
  		    		case 2:
  		    			StdDraw.picture(x, y, "eau3.png");
  		    			break;
  		    		case 3:
  		    			StdDraw.picture(x, y, "eau4.png");
  		    			break;
  		    			
  		    		}
  		    		StdDraw.show(100);
  		    	}
  		    }		
		    
//-----------------------------------------------------------
//-----------------------ANIMATION---------------------------
//-----------------------------------------------------------
	     public static int animation(Vehicule voiture,Terrain map){
	    	 int stop=0;
	    	 int fin =2;
	    	 voiture.positionX+=(double)(PAS_QUADRILLAGE*voiture.vitesseX)/FRAMES_PER_SEC;
	    	 voiture.positionY+=(double)(PAS_QUADRILLAGE*voiture.vitesseY)/FRAMES_PER_SEC;
	    	 //collision avec un élément
	    	 if (map.terrain[(int)voiture.positionY][(int)voiture.positionX]=='a'){ 
	    		 return fin; 
	    	 }
	    	 
	    	 if (Collision.verifCollision(voiture,map)==Collision.COLLISION_CRASH){ 
	    		 //animation crash
	    		// StdDraw.picture( voiture.positionX, voiture.positionY,"explo.gif");
	    		 StdAudio.close();
	    		 Son.choixSon(Son.SON_CRASH);
	    		 animationCrash(voiture.positionX,voiture.positionY);
	    		 voiture.accelerationX=0;
	    		 voiture.accelerationY=0;

	    		 voiture.vitesseX=0;
	    		 voiture.vitesseY=0;
	    		 voiture.positionX=voiture.x[voiture.tour];
	    		 voiture.positionY=voiture.y[voiture.tour];
	    		 voiture.x[voiture.tour+1]=voiture.x[voiture.tour];
	    		 voiture.y[voiture.tour+1]=voiture.y[voiture.tour];
	    		 stop=1; 
	    	 } 
	    	 //collision avec un bord
	    	 if (Collision.verifCollision(voiture,map)==Collision.COLLISION_LIMITE){ 
	    		 	//animation quand la voiture tombe dans l'eau
	    		 Son.choixSon(Son.SON_CRASH);
	    		 	 animationCrash(voiture.positionX,voiture.positionY);
		    		 voiture.accelerationX=0;
		    		 voiture.accelerationY=0;
		    		 voiture.vitesseX=0;
		    		 voiture.vitesseY=0;
		    		 voiture.positionX=voiture.x[voiture.tour];
		    		 voiture.positionY=voiture.y[voiture.tour];
		    		 voiture.x[voiture.tour+1]=voiture.x[voiture.tour];
		    		 voiture.y[voiture.tour+1]=voiture.y[voiture.tour]; 		
		    		 stop=1; 
		    	 } 
	    	 if (Collision.verifCollision(voiture,map)==Collision.COLLISION_EAU){ 
	    		 	//animation quand la voiture tombe dans l'eau
	    		 	Son.choixSon(Son.SON_EAU);
	    		 	 animationEau(voiture.positionX,voiture.positionY);
		    		 voiture.accelerationX=0;
		    		 voiture.accelerationY=0;
		    		 voiture.vitesseX=0;
		    		 voiture.vitesseY=0;
		    		 voiture.positionX=voiture.x[voiture.tour];
		    		 voiture.positionY=voiture.y[voiture.tour];
		    		 voiture.x[voiture.tour+1]=voiture.x[voiture.tour];
		    		 voiture.y[voiture.tour+1]=voiture.y[voiture.tour]; 		
		    		 stop=1; 
		    	 } 
	    	 //arret de la voiture
	    	 if ((voiture.positionX==voiture.x[voiture.tour+1] )&&(voiture.positionY==voiture.y[voiture.tour+1])){
	    		 stop=1;
	    		 voiture.accelerationX=0;
	    		 voiture.accelerationY=0;
	    	 }
	    	 map.afficher(map);
	    	 Vehicule.afficherVehicule(voiture);
	    	 return stop;
	     	}
	   
//-----------------------------------------------------------
//---------------------------BASE----------------------------
//-----------------------------------------------------------
 
 /* affichage de la fenetre  
  * 
  * 
  */
		public static void base(Vehicule voiture,Terrain map){
			// TODO : factor previous code ! 
			map.afficher(map);
         	//draw(voiture);
			Vehicule.afficherVehicule(voiture);
		}
//-----------------------------------------------------------
//---------------------------TRAJECTOIRE----------------------------
//-----------------------------------------------------------
//modele qui trace la trajectoire de la voiture et fait des ronds à chaque tour

		public static void trajectoire (Vehicule voiture,int i) {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line (voiture.x[i],voiture.y[i],voiture.x[i+1],voiture.y[i+1]);
			StdDraw.filledCircle (voiture.x[i],voiture.y[i],PAS_QUADRILLAGE/4);
			StdDraw.filledCircle (voiture.x[i+1],voiture.y[i+1],PAS_QUADRILLAGE/4);
		}
//-----------------------------------------------------------
//---------------------------TOUR----------------------------
//-----------------------------------------------------------
		public static int run (Vehicule voiture,Terrain map){
			int stop=0;
			
			StdDraw.setPenColor(StdDraw.RED);
			switch (selection){
			case 0:
				
				while(Jeu.boutonAcceleration(voiture)==false){
					tracerRonds(voiture);
					if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)==true){
						while (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)==true){}
							 return selection=4;
					}
				}
				Vehicule.afficherVehicule(voiture);
				move(voiture);
				Son.choixSon(Son.SON_ROUTE);
				
				selection=1;
				break;
			case 1:	
				Terrain.afficher(map);	    				
	    		stop=animation(voiture,map);
	    		StdDraw.show(1000/FRAMES_PER_SEC);
	    		if (stop==1) selection++; 
	    		if(stop==2) selection=3;
	    		break;
    		case 2:
    			voiture.tour++;
    			for (int i=0;i<voiture.tour;i+=1){
					trajectoire(voiture,i);
				}
    			selection=0;
    			break;		
    		case 3:
    			voiture.tour++;
    			break;
			}
			return selection;
		}
		
//-----------------------------------------------------------
//-------------------------JOUERSOLO-------------------------
//-----------------------------------------------------------

/*
 *lancement du mode solo sans IA 
 * 
 * 
 */
		
		public static int jouerSolo(Terrain lvl, String map,String modele){
			StdDraw.setXscale(0, WIDTH );            
			StdDraw.setYscale(0, HEIGHT);
			StdDraw.setPenColor(StdDraw.BLUE);
	    	StdDraw.text(WIDTH/2, HEIGHT/2, "Chargement de la carte");
	    	lvl =new Terrain(map);
	    	int [] depart=Terrain.PlacerVoitureDepart(map);
	    	Vehicule voiture =new Vehicule(20,depart[0],depart[1],0,0,modele);
    		base(voiture,lvl);
    		int arret=0;	
    		while(arret==0||arret==1||arret==2){
    		arret=run(voiture,lvl);
    		}
    		selection=0;
    		int retour=voiture.tour;
    		if (arret==4)retour=-1;
    		return retour;
		}
	  
}
