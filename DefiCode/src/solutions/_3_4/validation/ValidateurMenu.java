package d�fis.solutions._3_4.validation;

import d�fis.solutions._3_4.Menu;

public class ValidateurMenu implements Validateur<Integer> {
	private Menu menu;
	
	public ValidateurMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public Integer convertir(String valeur) throws ValidationException {
		try {
			int n = Integer.parseInt(valeur);
			Menu.�l�ment �l�ment = menu.get�l�ment(n);
			
			if(!�l�ment.estActif()) {
				throw new ValidationException("�l�ment de menu inactif.");
			}
			return n; 
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new ValidationException("�l�ment de menu inexistant.");
		}
		catch(NumberFormatException e) {
			throw new ValidationException("Nombre non valide", e);
		}
		
	}

}
