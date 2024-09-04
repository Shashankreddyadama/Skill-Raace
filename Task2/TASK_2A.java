import java.util.*;

public class TASK_2A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long a = sc.nextLong();
        int odd = 0;
        int even = 0;

        while (a > 0) {
            long digit = a % 10;
            if (digit % 2 == 0) {
                even += digit;
            } else {
                odd += digit;
            }
            a /= 10;
        }

        System.out.println("Odd: " + odd + " Even: " + even);
        sc.close();
    }
}
