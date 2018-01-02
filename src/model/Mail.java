/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Andrés
 */
public class Mail {
    private final String mail;
    private final Integer id;

    public Mail(String mail, Integer id) {
        this.mail = mail;
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public Integer getId() {
        return id;
    }   
}
