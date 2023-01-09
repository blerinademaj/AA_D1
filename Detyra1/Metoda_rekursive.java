package Detyra1;

public class Metoda_rekursive{

    // JAVA recursive function

    public static void towerOfHanoi(int n, char from, char to, char aux){
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from tower " + from + " to tower " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }


    // Driver code
    public static void main(String[] args){
        int N = 3;

        // A, B and C jane shufrat
        towerOfHanoi(N, 'A', 'C', 'B');
    }
    public double time_second() {
        double time = System.currentTimeMillis();
        System.out.println("Koha e ekzekutimit në sekonda: " + ((time) / 1000));

        return ((time) / 1000);
    }

    public double time_millis() {

        System.out.println("Koha e ekzekutimit në milisekonda: ");
        System.out.println(System.currentTimeMillis());
        return System.currentTimeMillis();
    }

    public double time_microsecond() {

        double time = System.currentTimeMillis();
        System.out.println("Koha e ekzekutimit në mikrosekonda: " + ((time) * 1000));

        return ((time) * 1000);
    }

    public double time_nano() {
        System.out.println("Koha e ekzekutimit në nanosekonda: ");
        System.out.println(System.nanoTime());
        return System.nanoTime();
    }

    public double time_picosecond() {

        double time = System.nanoTime();
        System.out.println("Koha e ekzekutimit në pikosekonda: " + ((time) * 1000));

        return ((time) * 1000);
    }
}
