package itExerciciDominiVideos;

public class NoDataException extends Exception {

	@Override
	public void printStackTrace() {
		System.out.println("No hi ha dades");
	}
	
}
