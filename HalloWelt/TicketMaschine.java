public class TicketMaschine
{
    private float geldEingeworfen = 0.0f;
    private int ticketsVerkauft = 0;
    private float barBestand = 100.0f;
    private String ticket = "Einzelfahrt";
    
    public void waehleTicket(String art) {
        switch(art) {
            case "Einzelfahrt": ticket = art; break;
            case "Monatskarte": ticket = art; break;
            default: System.out.println("Wähle Einzelfahrt oder Monatskarte");
        }
    }
    public AutomatenAusgabe kaufeTicket() {
        float rueckgeld = 0.0f;
        float preis = 0.0f;
        Ticket t = null;
        
        if (ticket.equals("Einzelfahrt")) {
            t = new Einzelfahrt();
            preis = t.getPreis();
        }
        else if(ticket.equals("Monatskarte")) {
            t = new Monatskarte();
            preis = t.getPreis();
        }
        if(geldEingeworfen >= preis){
            ticketsVerkauft++;
            barBestand += preis;
            rueckgeld = geldEingeworfen - preis;
            geldEingeworfen = 0.0f;
        }
        else {
            System.out.println("Fehler: Nicht genügend Geld eingeworfen!");
        }
        AutomatenAusgabe ausgabe = new AutomatenAusgabe(rueckgeld, t);
        return ausgabe;
    }
    public int verkaufteTickets() {
        return ticketsVerkauft;
    }
    public float geldEinwerfen(float betrag){
        double zufall = Math.random();
        if(zufall > 0.7) {
            System.out.println("Geld nicht erkannt.");
            return betrag;
        }
        
        if(betrag == 0.01f || betrag == 0.02f || betrag == 0.05f || betrag == 0.10f 
          || betrag == 0.20f || betrag == 0.50f || betrag == 1.0f || betrag == 2.0f 
          || betrag == 5.0f || betrag == 10.0f) {
            geldEingeworfen += betrag;
        }
        else {
            System.out.println("Keine gültige Währung.");
        }
        
        return 0.0f;
    }
}
