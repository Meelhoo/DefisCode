package d�fis.solutions._3_4.validation;

public interface Validateur<T> {
	T convertir(String valeur) throws ValidationException;
}
