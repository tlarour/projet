
public class Son {
	   
			static final int SON_ROUTE=0;
			static final int SON_CRASH=1;
		 	static final int SON_EAU=2;
	public static void choixSon(int choixSon){
		switch (choixSon){
		case 0:
			StdAudio.play("voiture.wav");
			break;
		case 1:
			StdAudio.play("explo1.wav");
			break;
		case 2 :
			StdAudio.play("eau.wav");
			break;
		}
		
	}
	
}
