package main.java.datas.responses;

/**
 * Created by david on 18/05/2016.
 */
public class Response {
    protected String status;
    protected String part;
    protected int time;
    protected String meth;

    public Response(String status){
        this.status = status;
    }
}
