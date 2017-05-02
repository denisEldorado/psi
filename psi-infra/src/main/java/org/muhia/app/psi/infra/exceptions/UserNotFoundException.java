package org.muhia.app.psi.infra.exceptions;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = -8060531120470573530L;

    private String msg;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String msg) {
        this.msg = System.currentTimeMillis() + ": " + msg;
    }

    public String getMsg() {
        return msg;
    }


}


