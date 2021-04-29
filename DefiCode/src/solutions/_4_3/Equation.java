package d�fis.solutions._4_3;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Equation {
	private static HashMap<Character, Op�ration> op�rations;
	
	static {
		op�rations = new HashMap<Character, Equation.Op�ration>();
		
		op�rations.put('*', new Op�ration(3, (a, b) -> a * b));
		op�rations.put('/', new Op�ration(3, (a, b) -> a / b));
		
		op�rations.put('+', new Op�ration(2, (a, b) -> a + b));
		op�rations.put('-', new Op�ration(2, (a, b) -> a - b));
		
		op�rations.put(')'                   , new Op�ration(1));
		op�rations.put(CharacterIterator.DONE, new Op�ration(0));
	}
	public static double calculer(String equation) {
		return expression(new StringCharacterIterator(equation), 0);
	}
	private static double expression(CharacterIterator it, int priorit�) {
		double total = operande(it);
		Op�ration op;
		
		while((op = op�rationPrioritaire(it, priorit�)) != null) {
			total = op.calculer(total, it);
		}
		return total;
	}
	private static Op�ration op�rationPrioritaire(CharacterIterator it, int priorit�) {
		Op�ration op = op�rations.get(it.current());
		
		return op.getPriorit�() > priorit� ? op : null;
	}
	private static double operande(CharacterIterator it) {
		char caract�re = it.current();
		
		it.next();
		return caract�re=='(' ? expression(it, 0) : (double)(caract�re-'0');
	}	
	private static class Op�ration
	{
		private int priorit�;
		private BinaryOperator<Double> op�rateur;
		
		public Op�ration(int priorit�) {
			this(priorit�, null);
		}
		public Op�ration(int priorit�, BinaryOperator<Double> op�rateur) {
			this.priorit� = priorit�;
			this.op�rateur = op�rateur;
		}
		public double calculer(double total, CharacterIterator it) {
			it.next();
			return op�rateur==null 
				? total 
				: op�rateur.apply(total, expression(it, getPriorit�()));
		}
		public int getPriorit�() {
			return priorit�;
		}		
	}
}
