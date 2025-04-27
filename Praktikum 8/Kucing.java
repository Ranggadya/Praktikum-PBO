public class Kucing extends Anabul{
    public Kucing(String nama){
        super(nama);
    }

    @Override
    public void bersuara(){
        System.out.println(getNama() + "bersuara : Meong!");
    }

    @Override
    public void bergerak(){
        System.out.println(getNama() + "bergerak : bergerak dengan melata");
    }
    
}
