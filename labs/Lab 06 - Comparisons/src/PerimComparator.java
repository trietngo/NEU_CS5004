/**
 * Import Java Comparator Utility
 */
import java.util.Comparator;

/**
 * This class implements the Java Comparator Utility to enable the
 * comparison between two objects.
 */
public class PerimComparator implements Comparator {

    /**
     * Constructing a PerimComparator instance
     */
    public PerimComparator() {
    }

    /**
     * Compare two shapes based on their perimeters
     * @param origin the current Shape Object
     * @param target the target Shape Object
     * if (origin<target) return -1
     * if (origin<target) return 0
     * if (origin<target) return 1
     * @return comparison result.
     */
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
