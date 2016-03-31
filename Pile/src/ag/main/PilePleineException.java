package ag.main;

/**
 * Created by allan on 31/03/2016.
 */
public class PilePleineException extends PileException {

    public PilePleineException(){

    }
    public String toString(){
        return "Pile Pleine";
    }
    @Override
    public String getMessage(){
        return "Pile pleine";
    }
}
