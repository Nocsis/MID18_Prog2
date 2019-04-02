public class Einzelfahrt extends Ticket
{
    public Einzelfahrt() {
        setPreis(2.6f);
    }
    
    public void beschreibeDich() {
        System.out.println("Ich bin ein Einzelfahrtticket im Wert von: " + getPreis());
    }
}
