import java.util.Comparator;

public class PerimComparator implements Comparator {
    public PerimComparator() {
    }

    public int compare(Object origin, Object target) {

        Shape shapeOrigin = (Shape)origin;
        Shape shapeTarget = (Shape)target;

        if (shapeOrigin.perimeter() < shapeTarget.perimeter()) {
            return -1;
        } else if (shapeOrigin.perimeter() == shapeTarget.perimeter()) {
            return 0;
        } else {
            return 1;
        }
    }
}
