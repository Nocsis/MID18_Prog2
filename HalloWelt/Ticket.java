public class Ticket
{
    private float preis = 1.0f;
    
    protected float getPreis() {
        return preis;
    }
    
    protected void setPreis(float preis) {
        if(preis > 0f){
            this.preis = preis;
        }
    }
}
