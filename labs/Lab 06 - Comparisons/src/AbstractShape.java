/**
 * Created by ashesh on 1/26/2017.
 * Modified by Triet Ngo on 2/23/2023.
 */
public abstract class AbstractShape implements Shape {
    protected Point2D reference;
    public AbstractShape(Point2D reference) {
        this.reference = reference;
    }
    @Override
    public double distanceFromOrigin() {
        return reference.distToOrigin();
    }
    @Override
    public int compareTo(Shape s) {
        double areaThis = this.area();
        double areaOther = s.area();
        if (areaThis < areaOther) {
            return -1;
        } else if (areaOther < areaThis) {
            return 1;
        } else {
            return 0;
        }
    }
}

/* Question 3 Answer:
* If the ordering of shapes is based on perimeter,
* lines 15, 16, 17, and 19 in AbstractShape.java
* would have to be modified.
*
* If it were not for sharing code, 3 files would have
* needed modification, each file indicative of a
* concrete Shape class.
*/
