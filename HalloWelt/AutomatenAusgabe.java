public class AutomatenAusgabe
{
    private float rueckgeld;
    private Ticket ticket;
    
    public AutomatenAusgabe(float rueckgeld, Ticket ticket) {
        this.rueckgeld = rueckgeld;
        this.ticket = ticket;
    }
    
    public String toString() {
        return "Ticket: " + ticket + " -- Rückgeld: " + rueckgeld;
    }
}
