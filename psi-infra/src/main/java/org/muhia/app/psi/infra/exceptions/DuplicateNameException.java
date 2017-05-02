package org.muhia.app.psi.infra.exceptions;

public class DuplicateNameException extends Exception {

    private static final long serialVersionUID = -4658463190108406055L;
    private String msg;

    public DuplicateNameException() {
        super();
    }

    public DuplicateNameException(String msg) {
        this.msg = System.currentTimeMillis() + ": " + msg;
    }

    public String getMsg() {
        return msg;
    }


}


