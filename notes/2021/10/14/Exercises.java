public class Exercises
{
    public static void main(String[] args)
    {
        System.out.println("Between Tests");
        System.out.println(between("catamaran", 'a').equals("tamar"));
        System.out.println(between("catamaran", 'c').equals(""));
        System.out.println(between("catamaran", 'q').equals(""));
        System.out.println("LaxEquals Tests");
        System.out.println(laxEquals("    boot", "boot"));
        System.out.println(laxEquals("boot    ", "boot"));
        System.out.println(laxEquals("     boot    ", "boot"));
        System.out.println(laxEquals(" \t\n    boot \n\t   ", "boot"));
        System.out.println("Get Extension tests");
        System.out.println(getExtension("wd2.tex").equals("tex"));
        System.out.println(getExtension("hello.py").equals("py"));
        System.out.println(getExtension("Hello.java").equals("java"));
        System.out.println(getExtension("tossMeNow").equals(""));
        System.out.println(getExtension(".").equals(""));
        System.out.println("isUpperCaseOnly tests");
        System.out.println(isUpperCaseOnly("EAT NOW 123"));
        System.out.println(!isUpperCaseOnly("eat NOW 123"));
        System.out.println(isUpperCaseOnly(""));
    }
    /*
     * This returns an empty string if q is not present in
     * s or if it only appears once.  Otherwise, it returns the
     * substring between the first and last instances of q in s.
     */
    public static String between(String s, char q)
    {
        int charIndex = s.indexOf(Character.toString(q));
        if (charIndex == -1) {
            return "";
        }
        if (s.lastIndexOf(Character.toString(q)) != charIndex) {
            return s.substring(charIndex + 1, s.lastIndexOf(Character.toString(q)));
        }
        return s.substring(charIndex, s.lastIndexOf(Character.toString(q)));
    }
    /*
     * This returns true if the only difference between s1 and s2
     * is leading or trailing whitespace.  
     */
    public static boolean laxEquals(String s1, String s2)
    {
        return s1.strip().equals(s2.strip());
    }
    /*
     * this returns an empty string if the fileName is empty
     * or has no extension. Otherwise, it returns the extension
     * without the dot.
     */
    public static String getExtension(String fileName)
    {
        if (fileName.indexOf('.') == -1) {
            return "";
        }
        String[] split = fileName.split("\\.");
        if (split.length == 0) {
            return "";
        }
        return split[1];
    }
    /*
     * this returns true if the String contains only uppercase
     * or non-alpha characters.
     */
    public static boolean isUpperCaseOnly(String s)
    {
        return s.toUpperCase().equals(s);
    }
}
