package d�fis.solutions._3_4.validation;

import d�fis.essais._3_2.Participant;

public class ValidateurParticipant implements Validateur<Participant> {
	@Override
	public Participant convertir(String valeur) throws ValidationException {
		if(valeur.length()==0) {
			throw new ValidationException("Le nom de participant ne peut �tre vide");
		}
		return new Participant(valeur);
	}

}
