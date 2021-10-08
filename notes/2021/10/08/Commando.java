public class Commando
{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%s] = %s\n", i, args[i]);
        }
    }
}