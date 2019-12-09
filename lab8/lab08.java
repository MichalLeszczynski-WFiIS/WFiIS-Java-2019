import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class lab08 {


	public static void main(String[] args) throws Exception {
		try {
			if (args.length != 2)
				throw new WrongInputArgsAmountException();
			String inputFile = args[0];
			String outputFile = args[1];
			ArrayList<Double> numbers = new ArrayList<Double>();

			try (BufferedReader reader = Files.newBufferedReader(new File(inputFile).toPath())) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					double number = Double.parseDouble(line);
					numbers.add(number);
				}
			}
			catch (IOException e) {
				throw new InputFileIOException();
			}

			double sum = 0;
			double count = numbers.size();

			if(count == 0){
				throw new DivisionByZeroException();
			}

			for (Double num : numbers) {
				sum += num;
			}
			Double avg = sum / count;

			try {

				FileOutputStream fos = new FileOutputStream(outputFile);
				DataOutputStream dos = new DataOutputStream(fos);
				System.out.println(avg);
				dos.writeUTF(avg.toString());
				dos.close();
			}
			catch (IOException e) {
				throw new OutputFileIOException();
			}
		}
		catch (WrongInputArgsAmountException e) {
			System.err.println("Zla ilosc argumentow wejsciowych");
			System.err.println(e);
		}
		catch (NumberFormatException e) {
			System.err.println("Niepoprawnie wprowadzona liczba!");
			System.err.println(e);
		}
		catch (InputFileIOException e) {
			System.err.println("Blad odczytu!");
			System.err.println(e);
		}
		catch (OutputFileIOException e) {
			System.err.println("Blad zapisu!");
			System.err.println(e);
		}
		catch (DivisionByZeroException e) {
			System.err.println("Dzielenie przez zero!");
			System.err.println(e);
		}
	}
}
