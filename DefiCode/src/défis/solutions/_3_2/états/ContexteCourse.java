package d�fis.solutions._3_2.�tats;

import java.util.ArrayList;
import java.util.List;

import d�fis.solutions._3_2.Participant;

public class ContexteCourse {
	private final List<Participant> inscrits = new ArrayList<Participant>();
	private List<Participant> classement = new ArrayList<>();
	
	public List<Participant> getInscrits() {
		return inscrits;
	}	
	public List<Participant> getClassement() {
		return classement;
	}
}
