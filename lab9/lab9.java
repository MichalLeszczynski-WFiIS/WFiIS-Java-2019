import java.io.*;
import java.util.Arrays;
import java.util.Collections;


public class lab9 {
    public static void main(String[] args) {
        String[] firstLine = new String[3];
        int numberOfPoints = 0;
        Data data = new Data();

        try {
            BufferedReader f = new BufferedReader(new FileReader("in.txt"));
            firstLine = f.readLine().split(" ");
            numberOfPoints = Integer.parseInt(f.readLine());

            for (int i = 0; i < numberOfPoints; i++) {
                String[] lineWithPoint = new String[2];
                lineWithPoint = f.readLine().split(",");
                int x = Integer.parseInt(lineWithPoint[0]);
                int y = Integer.parseInt(lineWithPoint[1]);

                data.addPoint(new Point(x, y));
            }

        } catch (Exception e ) {
            System.out.println(e);
        }

        int height = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        String outputName = firstLine[2];


        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(outputName));
            writer.write("P3\n");
            writer.write("#Michal Leszczynski\n");
            writer.write(new String(height + " " + width + "\n"));
            writer.write("255\n");

            for (int currY = 0; currY < height; currY++) {
                for (int currX = 0; currX < width; currX++) {
                    Double[] distances = new Double[numberOfPoints];

                    Point currentPoint = new Point(currX, currY);

                    for (int i = 0; i < numberOfPoints; i++) {
                        distances[i] = currentPoint.calculateDistanceTo(data.get(i));
                    }

                    Arrays.sort( distances, Collections.reverseOrder() );

                    if (Math.abs(distances[0] - distances[1]) < 1.5) {
                        writer.write("0 0 0 ");
                    } else {
                        writer.write("255 255 255 ");
                    }
                }
                writer.write("\n");
            }

        } catch (IOException e) {
            System.out.println( "Wystapil blad podczas wpisywania danych do pliku wyjsciowego " + outputName + "." );
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println( "Wystapil blad podczas zamykania pliku wyjsciowego " + outputName + "." );
            }
        }
    }
}