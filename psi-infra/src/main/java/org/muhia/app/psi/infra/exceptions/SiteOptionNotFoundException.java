package org.muhia.app.psi.infra.exceptions;

public class SiteOptionNotFoundException extends Exception {


    private static final long serialVersionUID = -9166026439762847476L;
    private String msg;

    public SiteOptionNotFoundException() {
        super();
    }

    public SiteOptionNotFoundException(String msg) {
        this.msg = System.currentTimeMillis() + ": " + msg;
    }

    public String getMsg() {
        return msg;
    }


}


