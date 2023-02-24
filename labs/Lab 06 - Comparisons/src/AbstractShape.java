// Created by ashesh on 1/26/2017.
// Modified by Triet Ngo on 2/23/2023.

/**
 * This abstract class represents any shape. It offers all
 * the attributes that can be inherited by a specific Shape class.
 */
public abstract class AbstractShape implements Shape {
    protected Point2D reference;
    public AbstractShape(Point2D reference) {
        this.reference = reference;
    }

    /**
     * Returns the distance of this shape from the origin. The distance is
     * measured from whatever reference position a shape is (e.g. a center for
     * a circle)
     * @return the distance from the origin
     */
    @Override
    public double distanceFromOrigin() {
        return reference.distToOrigin();
    }

    /**
     * Compares this shape with the one passed to it based on their areas.
     * if (this<s) return a negative number
     * if (this==s) return 0
     * if (this>s) return a positive number
     * @param s the other shape to be compared to
     * @return the result of the comparison
     */
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
* lines 35, 36, 37, and 39 in AbstractShape.java
* would have to be modified.
*
* If it were not for sharing code, 3 files would have
* needed modification, each file indicative of a
* concrete Shape class.
*/
