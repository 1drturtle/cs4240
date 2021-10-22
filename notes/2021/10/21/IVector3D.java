public interface IVector3D
{
    /**
     * @param that another IVector3D
     * @return  the dot product of this vector and that.
     */
    public int dot(Vector3D that);
    /**
     * @param that another IVector3D
     * @return  the cross product of this vector and that.
     */
    public IVector3D cross(Vector3D that);
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return  the that*this
     */
    public IVector3D scalarMultiply(int scalar);
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return this + that
     */
    public IVector3D add(Vector3D that);
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return this - that
     */
    public IVector3D subtract(Vector3D that);
    /**
     * @return the length of this vector
     */
    public double magnitude();
    /**
     * @param that another vector
     * @return the angle between this and that in radians in [0,π]
     */
    public double angleBetween(Vector3D that);
}