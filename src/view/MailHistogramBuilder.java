/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Ithiel
 */
import kata6terceraversion.Attribute;
import model.Histogram;
import model.Mail;
import java.util.List;

    public class MailHistogramBuilder <T> {
        private final List <T> items;
        public MailHistogramBuilder (List <T> items){
        this.items = items;
     }
    public <A> Histogram <A> build (Attribute <T,A> attribute){
         Histogram<A> histo = new Histogram<>();
         for (T item : items) {
             	A value	= attribute.get(item);
                 histo.increment(value);}
         return histo;
     }	
 }