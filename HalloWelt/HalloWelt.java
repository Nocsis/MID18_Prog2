
/**
 * Beschreiben Sie hier die Klasse HalloWelt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class HalloWelt
{
   public static void main(int[] args) {
       String v1 = addiere(args[0], args[1]);
       System.out.println("Hallo Sebastian " + " " + v1);
    }
    
   public static String addiere(int a, int b) {
       return a + " + " + b + " = " + (a+b);
    }
}
