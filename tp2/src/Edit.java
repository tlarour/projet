import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
//class pour creer des maps et le fichier text associé
public class Edit {
	public static final int PAS_QUADRILLAGE=25;
	public static final int WIDTH=1000;
	public static final int HEIGHT=1000;
	public static final int FRAMES_PER_SEC=1000;
	public static final char HERBE= '.';
	public static final char EAU='0';
	public static final char PONT='&';
	public static final char ROUTE='&';
	public static final char MAISON='#';
	public static final char FLEUR='#';
	public static final char CAMION='#';
	public static final char ARBRE='#';
	public static final char DEPART='d';
	public static final char ARRIVE='a';
	static int placer=0;
	static int choix=0;
	static int [][] panel= new int[WIDTH+1][HEIGHT+1];
	
	public Edit (String name, String name1 ){
		StdDraw.setXscale(0, WIDTH );            
		StdDraw.setYscale(0, HEIGHT);
		StdDraw.picture(WIDTH/2, HEIGHT/2,name1 );
		panel=convertTxtToTab(name1);
		erireTxt();
	}
	public Edit(String name){
		StdDraw.setXscale(0, WIDTH );            
		StdDraw.setYscale(0, HEIGHT);
		placerHerbe();
		placerContour(2*PAS_QUADRILLAGE);
		StdDraw.save(name);  
		StdDraw.picture(WIDTH/2, HEIGHT/2,name );
		while(StdDraw.isKeyPressed(KeyEvent.VK_ENTER)==false){
			buildTerrain(name);
		}
		erireTxt();
	}

	/*
	 * Convertir le fichier texte contenant de terrain en un tableau à 2 dimensions
	 *  
	 */
	public static int [][] convertTxtToTab(String name){
		int [][] tab= new int[WIDTH+2][HEIGHT+2];
		
		try {
			 File ff=new File(name);	
			 FileReader ffr=new FileReader(ff);
			 for (int i=0;i<=HEIGHT;i+=1){
	     			for (int j=0;j<=WIDTH;j+=1){	
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

	/*
	 * placer les éléments sur la carte
	 */
	public static void buildTerrain(String name){

			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)==true){
				while (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)==true){}
					choix++;
			}
			StdOut.println(choix);
			switch(choix){
			case 0:			
				placerRoute1(name);			
				break;
			case 1:		
				placerEau(name);
				break;
			case 2:
				placerMaison1(name);
				break;
			case 3:
				placerMaison2(name);
				break;
			case 4:
				placerUsine(name);
				break;
			case 5:
				placerFleur(name);
				break;
			case 6:
				placerCamion(name);
				break;
			case 7:
				placerDepart(name);
				break;
			case 8:
				placerPont(name);
				break;
			case 9:
				placerArbre(name);
				break;
			case 10:
				placerRoute2(name);
				break;
			case 11:
				placerRoute3(name);
				break;
			case 12:
				placerArrive1(name);
				break;
			case 13:
				placerArrive2(name);
				break;
			default:
				choix=0;
				break;
			}	
			System.out.println(panel[2][WIDTH-1]);
	}

	
	public static void placerHerbe(){
		for (int i=0;i<=HEIGHT;i+=3*PAS_QUADRILLAGE){
			for (int j=0;j<=WIDTH;j+=3*PAS_QUADRILLAGE){	
				StdDraw.picture(j,i,"herbe.png",3*PAS_QUADRILLAGE,3*PAS_QUADRILLAGE);
			}
		}	
		for (int i=0;i<=HEIGHT;i+=1){
			for (int j=0;j<=WIDTH;j+=1){	
				panel[i][j]=HERBE;
			}
		}	
	}
	public static void placerContour(int taille){
		for (int i=-taille/2;i<=HEIGHT+taille/2;i+=taille){
			StdDraw.picture(-taille/2,i,"contour.png",taille,taille);
			StdDraw.picture(WIDTH+(taille/2),i,"contour.png",taille,taille);
		}
		for (int j=-taille/2;j<=WIDTH+taille/2;j+=taille){
			StdDraw.picture(j,-taille/2,"contour.png",taille,taille);
			StdDraw.picture(j,HEIGHT+(taille/2),"contour.png",taille,taille);
		}
	}
	
	public static void placerRoute1(String name){
		placer(name,ROUTE,"route.png",4*PAS_QUADRILLAGE,4*PAS_QUADRILLAGE);
	}
	public static void placerRoute2(String name){
		placer(name,ROUTE,"route.png",20*PAS_QUADRILLAGE,4*PAS_QUADRILLAGE);
	}
	public static void placerRoute3(String name){
		placer(name,ROUTE,"route.png",4*PAS_QUADRILLAGE,10*PAS_QUADRILLAGE);
	}
	
	public static void placerPont(String name){
		placer(name,PONT,"pont.png",8*PAS_QUADRILLAGE,4*PAS_QUADRILLAGE);
	}
	
	public static void placerFleur(String name){
		placer(name,FLEUR,"fleur.png",10*PAS_QUADRILLAGE,5*PAS_QUADRILLAGE);
	}
	
	public static void placerMaison2(String name){
		placer(name,MAISON,"maison2.png",6*PAS_QUADRILLAGE,6*PAS_QUADRILLAGE);
	}
	
	public static void placerMaison1(String name){
		placer(name,MAISON,"maison1.png",6*PAS_QUADRILLAGE,6*PAS_QUADRILLAGE);
	}
	
	public static void placerUsine(String name){
		placer(name,MAISON,"usine.png",10*PAS_QUADRILLAGE,8*PAS_QUADRILLAGE);
	}
	
	public static void placerCamion(String name){
		placer(name,CAMION,"camion.png",3*PAS_QUADRILLAGE,3*PAS_QUADRILLAGE);
	}
	
	public static void placerArbre(String name){
		placer(name,ARBRE,"arbre.png",2*PAS_QUADRILLAGE,3*PAS_QUADRILLAGE);
	}
	
	public static void placerEau(String name){
		placer(name,EAU,"eau.png",4*PAS_QUADRILLAGE,4*PAS_QUADRILLAGE);
	}
	
	public static void placerDepart(String name){
		placer(name,DEPART,"depart.png",2*PAS_QUADRILLAGE,2*PAS_QUADRILLAGE);
	}
	public static void placerArrive1(String name){
		placer(name,ARRIVE,"arrive1.png",4*PAS_QUADRILLAGE,2*PAS_QUADRILLAGE);
	}
	public static void placerArrive2(String name){
		placer(name,ARRIVE,"arrive2.png",2*PAS_QUADRILLAGE,4*PAS_QUADRILLAGE);
	}
	
	public static void placer(String name,char car,String fichier,int tailleX,int tailleY){
		int positionX = (int)StdDraw.mouseX();
		int positionY= (int)StdDraw.mouseY();
		if (StdDraw.mousePressed()==true){
			while (StdDraw.mousePressed()==true){}
			placer++;
		}
		switch(placer){
			case 0:
				StdOut.println(fichier);
				break;
			case 1:
				int X=positionX,Y=positionY;
				X-=((int)(tailleX/2));
				Y-=((int)(tailleY/2));
				if (limite(X,Y,tailleX,tailleY)==false){
					for (int i=Y;i<=(Y+tailleY);i++){
						for (int j=X;j<=(X+tailleX);j++){	
							panel[i][j]=car;
						}
					}
					StdDraw.picture(positionX,positionY,fichier,tailleX,tailleY);
					StdDraw.save(name);
				}	
				placer=0;
				break;
		}
	}
	
	
	public static void erireTxt(){
		try{
		File ff=new File("C:\\Users\\thibault\\workspace2\\tp2\\level7.txt"); // définir l'arborescence
		ff.createNewFile();
		FileWriter ffw=new FileWriter(ff);
		for (int i=0;i<=HEIGHT;i+=1){
			for (int j=0;j<=WIDTH;j+=1){	
				ffw.write(panel[i][j]);  // écrire dans le fichier resultat.txt
			}
			ffw.write('\n');// forcer le passage à la ligne
		}
		 
		ffw.close(); // fermer le fichier à la fin des traitements
		} catch (Exception e) {
			System.out.println("Impossible de creer le fichier");
		}
	}
	public static boolean limite(int X, int Y,int tailleX,int tailleY){
		boolean limite =false;		
		if((X<0)||(Y<0)){
			limite =true;
		}
		X+=tailleX;
		Y+=tailleY;
		if((X>WIDTH)||(Y>HEIGHT)){
			limite =true;
		}
		return limite;
	}
	public static boolean superposition(){
		boolean superpose=false;
		
		return superpose;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edit map= new Edit("level7.png");

	}

}

