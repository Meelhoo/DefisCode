package d�fis.solutions._3_4.vues;

import java.io.IOException;
import java.io.OutputStreamWriter;

import d�fis.solutions._3_4.Menu;

public class VueMenu implements Vue {
	private Menu menu;
	
	public VueMenu(Menu menu) {
		this.menu = menu;
	}
	
	@Override
	public void rendre(OutputStreamWriter sortie, OutputStreamWriter erreur) throws IOException {
		int indice = 1;
		
		for(Menu.�l�ment �l�ment : menu.get�l�ments()) {
			sortie.write(
				�l�ment.estActif()
					? String.format( "%2d) %s\n", indice+1, �l�ment) 
					: String.format( " -) %s\n" , �l�ment
				)
			);
		}
		sortie.write("\n");
	}

}
