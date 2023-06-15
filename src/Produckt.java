public class Produckt {
    String COD_ARTIC; //20 Char max
    String NAME_ARTIC; //200 Char max
    int Price ;

    public Produckt(String COD_ARTIC, String NAME_ARTIC, int price) {
        this.COD_ARTIC = COD_ARTIC;
        this.NAME_ARTIC = NAME_ARTIC;
        Price = price;
    }

    public String toString(){
        return COD_ARTIC+" "+NAME_ARTIC+" Price- "+Integer.toString(Price);
    }
}
