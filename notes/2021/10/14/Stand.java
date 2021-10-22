public class Stand {
    public String fruit(char c) {
        String out = "";
        switch (c) {
            case 'a', 'A' -> { out = "Apple";  }
            case 'b', 'B' -> { out = "Banana"; }
            case 'c', 'C' -> { out = "Cherry"; }
            case 'g', 'G' -> { out = "Grape";  }
            default -> { out = "No fruit with that letter."; }
        }
        return out;
    }
    public static void main(String[] args) {
        Stand stand = new Stand();
        System.out.println(stand.fruit('g'));
    }
}
