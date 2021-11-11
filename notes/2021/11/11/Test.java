public class Test
{
    String name;
    int tests;
    int pass;
    int fail;

    public Test(String name)
    {
        this.name = name;
        this.tests = 0;
        this.pass = 0;
        this.fail = 0;
        System.out.println("- Test -> " + name);
    }
    public void run(Object input, Object output, Object expected)
    {
        Boolean matches = output.equals(expected);
        tests += 1;
        if (!matches)
        {
            System.out.printf("[FAIL] f(%s) -> %s, expected: %s\n", input, output, expected);
            fail += 1;
        } else
        {
            pass += 1;   
        }
    }
    public void finish()
    {
        System.out.printf("[%s] Tests complete. %s pass, %s failed (total %s).\n", name, pass, fail, tests);
    }
    public static void main(String[] args)
    {
        Test x = new Test("abcd");
        x.run(3, 4, 4);
        x.finish();    
    }
}
