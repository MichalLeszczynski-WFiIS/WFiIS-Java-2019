import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class lab9 {
    public static void main(String[] args) throws Exception {
        String[] firstLine = new String[3];
        ArrayList<Point> points = new ArrayList<>();
        int numberOfPoints = 0;
        double epsilon = 1.0;

        BufferedReader f = new BufferedReader(new FileReader(args[0]));
        firstLine = f.readLine().split(" ");
        numberOfPoints = Integer.parseInt(f.readLine());

        for (int i = 0; i < numberOfPoints; i++) {
            String[] point = new String[2];
            point = f.readLine().split(",");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);

            points.add(new Point(x, y));
        }

        int height = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        String outputName = firstLine[2];


        FileWriter writer = null;
        writer = new FileWriter(new File(outputName));
        writer.write("P3\n");
        writer.write("#Michal Leszczynski\n");
        writer.write(new String(height + " " + width + "\n"));
        writer.write("255\n");

        for (int currY = 0; currY < height; currY++) {
            for (int currX = 0; currX < width; currX++) {
                ArrayList<Double> distances = new ArrayList<>();

                Point currentPoint = new Point(currX, currY);

                for (int i = 0; i < numberOfPoints; i++) {
                    Point checkedPoint = points.get(i);
                    distances.add(currentPoint.calculateDistanceTo(checkedPoint));
                    if(checkedPoint.equals(currentPoint)) {
                        writer.write("100 100 100 ");
                    }
                }
                distances.sort(Double::compareTo);

                if (Math.abs(distances.get(0) - distances.get(1)) < epsilon) {
                    writer.write("0 0 0 ");
                } else {
                    writer.write("255 255 255 ");
                }
            }
            writer.write("\n");
        }
        writer.close();
    }
}