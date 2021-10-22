public interface IVector3D
{
    /**
     * Returns the dot product of this and that.
     * @param that The {@link IVector3D} to multiply with.
     * @return {@link IVector3D} with the dot product of this and that.
     */
    public int dot(Vector3D that);
    /**
     * The cross-product of the two {@link Vector3D}.
     * @param that The {@link Vector3D} to use.
     * @return the {@link Vector3D} containing the cross product of this and that.
     */
    public IVector3D cross(Vector3D that);
    /**
     * @param scalar a integer we are scalar multiplying this vector by
     * @return The Vector3D containing this multiplied by scalar.
     */
    public IVector3D scalarMultiply(int scalar);
    /**
     * @param that The {@link Vector3D} to add.
     * @return this + that
     */
    public IVector3D add(Vector3D that);
    /**
     * @param that The {@link Vector3D} to subtract.
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