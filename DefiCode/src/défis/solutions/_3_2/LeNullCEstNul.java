package d�fis.solutions._3_2;

import java.util.Scanner;

public class LeNullCEstNul {
	public static void main(String [] args) {
		String [] menu = new String[] {
			"Inscrire un nouveau participant",
			"D�marrer la course",
			"Arriv�e d'un participant",
			"Classement",
			"Gagnant-e",
			"Quitter"
		};
		Scanner clavier = new Scanner(System.in);
		boolean fini = false;
		
		Cat�gorie cat�gorie = args.length > 0 
			? new Cat�gorie(args[0]) 
			: Cat�gorie.HORS_CATEGORIE;
		Course course = new Course(cat�gorie);
		
		while( !fini ) {
			int choix;
			
			do {
				for(int i=0; i<menu.length; i++) {
					System.out.printf("%d) %s\n", i+1, menu[i]);
				}
				System.out.printf("Votre choix (1-%d) : ", menu.length);
				try {
					choix = Integer.parseInt(clavier.next());						
				}
				catch(NumberFormatException e) {
					choix = 0;
				}				
			}
			while(choix < 1 || menu.length < choix);
			
			System.out.println();
			switch(choix) {
			case 1 : inscrire  (course, clavier	); break;
			case 2 : d�marrer  (course			); break;
			case 3 : arriv�e   (course, clavier	); break;
			case 4 : classement(course			); break;
			case 5 : vainqueur (course			); break;
			case 6 : fini = true; 
			}
		}
		System.out.println("Bye");
		clavier.close();
	}
	public static void inscrire(Course course, Scanner clavier) {
		System.out.print("Nom du participant : ");
		try {
			course.inscrire(new Participant(clavier.next()));
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public static void d�marrer(Course course) {
		try {
			course.d�marrer();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}	
	}
	public static void arriv�e(Course course, Scanner clavier) {
		System.out.print("Nom du participant : ");
		try {
			course.passerLaLigneDArriv�e(new Participant(clavier.next()));
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}		
	}
	public static void classement(Course course) {
		switch(course.get�tat()) {
		case Course.INSCRIPTION:
			System.err.println("Inscriptions en cours");
			break;
		case Course.EN_COURS:
			System.err.println("Course non termin�e");
			break;
		case Course.ARRIVEE:
			System.out.println("CLASSEMENT :");
			int position = 1;
			
			for(Participant participant : course.getClassement()) {
				System.out.printf("%4d) %s\n", position++, participant);				
			}
			System.out.println();
			break;
		}
	}
	public static void vainqueur(Course course) {
		if(course.get�tat() != Course.ARRIVEE) {
			System.err.println("Inscriptions ou course en cours");
		}
		else {
			System.out.println(course.getGagnant());
		}
	}
}
