public class Monatskarte extends Ticket
{
    public Monatskarte() {
        setPreis(28.5f);
    }
    
    public void beschreibeDich() {
        System.out.println("Ich bin eine Monatskarte im Wert von: " + getPreis());
    }
}
