package coop.tecso.examen.model.exception;

public class ExcepcionAplicativo extends RuntimeException{
    private String msg;

    public ExcepcionAplicativo(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
