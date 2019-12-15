import java.util.ArrayList;

public class Data {
    private ArrayList<Point> points;

    Data() {
        this.points = new ArrayList<>();
    }

    void addPoint(Point point) {
        points.add(point);
    }

    Point get(int i) {
        return points.get(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.toString());
        }
        return new String(sb);
    }
}