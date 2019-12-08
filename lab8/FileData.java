import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileData {
	private String inputFileName;
	private String outputFileName;
	private Charset charset = Charset.forName("ISO-8859-2");
	private int[] array = null;


	public FileData(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	public void getData() throws Exception {
		try (BufferedReader reader = Files.newBufferedReader(new File(inputFileName).toPath(), charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				int added = Integer.parseInt(line);
				addToArray(added);
			}
		}
		catch (java.io.IOException e) {
			throw new InputFileIOException();
		}
		countAverageAndWriteToFile();
	}

	private void addToArray(int added) {
		if (array == null) {
			array = new int[1];
			array[0] = added;
			return;
		}
		int[] temp = array;
		array = new int[array.length+1];
		for (int i = 0; i < temp.length; i++)
			array[i] = temp[i];
		array[array.length-1] = added;
	}

	private void countAverageAndWriteToFile() {
		int sum = 0;
		int count = 0;
		try {
			for (int i = 0; i < array.length; i++, count++)
				sum = sum + array[i];
		}
		catch (NullPointerException e) {
			//ignored
		}
		if (count == 0)
			throw new DivisionByZeroException();
		double result = 1.0 * sum / count;
		String resultToFile = new String(""+result+"\n");
		try (BufferedWriter writer = Files.newBufferedWriter(new File(outputFileName).toPath(), charset)) {
			writer.write(resultToFile, 0, resultToFile.length());
		}
		catch (Exception x) {
			System.err.println("Zapis do pliku nie powiodl sie!");
		}
	}
}
