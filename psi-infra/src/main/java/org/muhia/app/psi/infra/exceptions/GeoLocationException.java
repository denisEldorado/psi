package org.muhia.app.psi.infra.exceptions;

public class GeoLocationException extends Exception {

    private static final long serialVersionUID = 3336735270794235096L;
    private String msg;

    /**
     *
     */
    public GeoLocationException() {
        super();
    }

    /**
     * @param msg
     */
    public GeoLocationException(String msg) {
        this.msg = System.currentTimeMillis() + ": " + msg;
    }

    public String getMsg() {
        return msg;
    }


}


