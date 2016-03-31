package ag.main;

/**
 * Created by allan on 31/03/2016.
 */
public class PileVideException extends PileException{
    public PileVideException(){

    }
    public String toString(){
        return "Pile Vide";
    }
    @Override
    public String getMessage(){
        return "Pile vide";
    }
}
