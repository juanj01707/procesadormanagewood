package com.uco.managewood.procesadormanagewood.domain.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String correo;
    private String password;

    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }

    public JwtRequest(String username, String password) {
        this.setCorreo(correo);
        this.setPassword(password);
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}