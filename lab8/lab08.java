import java.nio.file.NoSuchFileException;
import java.io.IOException;


public class lab08 {


	public static void main(String[] args) throws Exception {
		try {
			if (args.length != 2)
				throw new WrongInputArgsAmountException();
			
			FileData fileParser = new FileData(args[0], args[1]);
			fileParser.getData();
		}
		catch (WrongInputArgsAmountException e) {
			System.err.println("Niepoprawna ilosc argumentow wejsciowych");
		}
		catch (NoSuchFileException e) {
			System.err.println("Brak pliku wejsciowego!");
		}
		catch (NumberFormatException e) {
			System.err.println("Niepoprawna liczba!");
		}
		catch (InputFileIOException e) {
			System.err.println("Blad odczytu plik wejsciowego!");
		}
		catch (OutputFileIOException e) {
			System.err.println("Blad zapisu do pliku wynikowego!");
		}
		catch (DivisionByZeroException e) {
			System.err.println("Dzielenie przez zero!");
		}

	}
}
