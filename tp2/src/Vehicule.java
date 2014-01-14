public class Vehicule {
    float size= 10;
    public static int SPACE=Jeu.PAS_QUADRILLAGE ;
    public static int hauteur=(int)Jeu.HEIGHT;
    public static int largeur=(int)Jeu.WIDTH;
    //historique de la position
    double[] x=new double [100];
    double[] y=new double [100];
    //position en cours
    double positionX=0; 
    double positionY=0;
    static double angleModele=0;
    //vitesse en cours
    int vitesseX= 0;
    int vitesseY= 0;
    //nb de tour
    int tour=0;
    //modèle du véhicule
    String modele="";
    
    //accélération
    int accelerationX=0;
    int accelerationY=0;
  
    Vehicule(){
        this.size= 10;
        this.x[0]=0;
        this.y[0]= 0;
        this.vitesseX= 0;
        this.vitesseY= 0;
        this.tour= 0;
        int accelerationX=0;
        int accelerationY=0;
        
    }
   
    
    Vehicule (float size,int x,int y,int vitesseX,int vitesseY,String modele){
        this.size= size;
        this.x[0]=x*Jeu.PAS_QUADRILLAGE;
        this.y[0]=y*Jeu.PAS_QUADRILLAGE;
        this.positionX=x*Jeu.PAS_QUADRILLAGE;
        this.positionY=y*Jeu.PAS_QUADRILLAGE;
        this.vitesseX= vitesseX;
        this.vitesseY= vitesseY;
        this.tour= 0;
        this.modele=modele;
        int accelerationX=0;
        int accelerationY=0;
    }
    /*Choix du modele 
     * 
     */
    public static String choixModele(){
    	int etat=0;
    	StdDraw.picture(largeur/2, hauteur-100, "choix_voiture.png",largeur,200);
    	StdDraw.picture(largeur/2, hauteur/2, "cercle.png",400,300);
	    	while(true){
	    		
	    	switch (etat){
	    	//si on clique sur suivant etat ++
	    	//si on clique sur précedent etat--
	    	//si on clique sur selectionner etat =100 et on retourne la voiture selectionnée
	    	case -1:
	    		etat=8;
	    		break;
	    	case 0:
	    		afficherModele("voiture1.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture1.png";
	    		}
	    		break;
	    	case 1:
	    		afficherModele("voiture2.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture2.png";
	    		}
	    		break;
	    	case 2:
	    		afficherModele("voiture3.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture3.png";
	    		}
	    		break;
	    	case 3:
	    		afficherModele("voiture4.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture4.png";
	    		}
	    		break;
	    	case 4:
	    		afficherModele("voiture5.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture5.png";
	    		}
	    		break;
	    	case 5:
	    		afficherModele("voiture6.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture6.png";
	    		}
	    		break;
	    	case 6:
	    		afficherModele("voiture7.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "voiture7.png";
	    		}
	    		break;
	    	case 7:
	    		afficherModele("tank1.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "tank1.png";
	    		}
	    		break;
	    	case 8:
	    		afficherModele("tank2.png");
	    		etat+=boutonChoixVoiture();
	    		if (etat >=100){
	    			return "tank2.png";
	    		}
	    		break;
	    	case 9:	    	
	    		etat=0;
	    		break;
	    	default:
	    		etat=0;
	    		break;
	    	}
	    }	
    }
    /*Bouton pour le choix de la voiture
     *  bouton suivant et précedent
     *  bouton selectionner
     *  cercle au centre
     */
    public static int boutonChoixVoiture(){
    	int suivant=1;
    	int precedent=-1;
    	double posX= StdDraw.mouseX();
		double posY= StdDraw.mouseY();
		StdDraw.setPenRadius(0.01);
		
		
		if ((posX>largeur/2-largeur/3-50)&&(posX<largeur/2-largeur/3+50)&&(posY>hauteur/2-50)&&(posY<hauteur/2+50)){
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(largeur/2-largeur/3,hauteur/2,"<<<");
			StdDraw.rectangle(largeur/2-largeur/3,hauteur/2,50,50);
			if (StdDraw.mousePressed()==true){//clic
			    while (StdDraw.mousePressed()==true){}//déclic
			    StdDraw.setPenColor(StdDraw.WHITE);
			    StdDraw.picture(largeur/2, hauteur/2, "cercle.png",400,300);
		    	//StdDraw.filledSquare(largeur/2,hauteur/2,150);
				return precedent; 
			}
		}
		else if ((posX>largeur/2+largeur/3-50)&&(posX<largeur/2+largeur/3+50)&&(posY>hauteur/2-50)&&(posY<hauteur/2+50)){
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(largeur/2+largeur/3,hauteur/2,">>>");
			StdDraw.rectangle(largeur/2+largeur/3,hauteur/2,50,50);
			if (StdDraw.mousePressed()==true){//clic
			    while (StdDraw.mousePressed()==true){}//déclic
			    StdDraw.setPenColor(StdDraw.WHITE);
			    StdDraw.picture(largeur/2, hauteur/2, "cercle.png",400,300);
		    	//StdDraw.filledSquare(largeur/2,hauteur/2,150);
				return suivant;
				 
			}
		}
		else if ((posX>largeur/2-150)&&(posX<largeur/2+150)&&(posY>hauteur/5-50)&&(posY<hauteur/5+50)){
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(largeur/2,hauteur/5,"SELECTIONNER");
			StdDraw.rectangle(largeur/2,hauteur/5,150,50);
			if (StdDraw.mousePressed()==true){//clic
			    while (StdDraw.mousePressed()==true){}//déclic
				return 100;		 
			}
		}
		else{
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.rectangle(largeur/2-largeur/3,hauteur/2,50,50);
			StdDraw.rectangle(largeur/2+largeur/3,hauteur/2,50,50);
			StdDraw.rectangle(largeur/2,hauteur/5,150,50);
			StdDraw.text(largeur/2-largeur/3,hauteur/2,"<<<");
			StdDraw.text(largeur/2+largeur/3,hauteur/2,">>>");
			StdDraw.text(largeur/2,hauteur/5,"SELECTIONNER");	
		}
    	return 0;
    }
    /*afficher le véhicule pendant la phase de choixModele
     * 
     */
    public static void afficherModele(String nomVoiture){
    	//StdDraw.setPenColor(StdDraw.WHITE);
    	//StdDraw.filledSquare(largeur/2,hauteur/2,100);
		StdDraw.picture(largeur/2, hauteur/2,nomVoiture,Jeu.PAS_QUADRILLAGE*6, Jeu.PAS_QUADRILLAGE*9);
		
    }
    /*
     * afficher le véhicule pendant l'animation
     */
    public static void afficherVehicule(Vehicule voiture){
    	double angle=0; 
    		if ((voiture.y[voiture.tour+1]==voiture.y[voiture.tour])&&(voiture.x[voiture.tour+1]==voiture.x[voiture.tour])){
    			angle=-90;
    		}
    		else{
	    		angle=Math.atan((voiture.y[voiture.tour+1]-voiture.y[voiture.tour])/ (voiture.x[voiture.tour+1]-voiture.x[voiture.tour])) ;
	    		angle=(angle*180/Math.PI)-90;
    		}	
    		StdDraw.picture(voiture.positionX, voiture.positionY,voiture.modele,Jeu.PAS_QUADRILLAGE*2, Jeu.PAS_QUADRILLAGE*3,angle);
    	
    }

}