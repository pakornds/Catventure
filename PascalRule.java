import java.util.Scanner;

public class PascalRule {
    public static void main(String[] args) {
        PascalRuleMethods meth = new PascalRuleMethods();
        Scanner sc = new Scanner(System.in);
        meth.input(sc.nextInt());
        sc.close();
    }
}