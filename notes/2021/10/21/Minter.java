public class Minter 
{
    private static int idWell;
    static {
        idWell = 1;
    }
    private int id;

    public Minter()
    {
        id = idWell;
        idWell++;
    }
    @Override
    public String toString() {
        return String.format("Minter (id=%d)", id);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Minter)) {
            return false;
        }
        Minter x = (Minter) obj;
        return x.id == id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Minter());
        }
    }
}
