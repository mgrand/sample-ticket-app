package com.hcl.example.ticketHeatMap.server.api;

class ApiException extends Exception{
    private int code;
    ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }

    @SuppressWarnings("unused")
    public int getCode() {
        return code;
    }
}
