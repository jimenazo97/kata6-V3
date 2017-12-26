/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6terceraversion;

/**
 *
 * @author Ithiel
 */
import java.io.IOException;
import java.util.List;
import model.Histogram;
import java.sql.SQLException;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import model.Person;
import view.DataBaseList;
import view.MailListReader;

 public class Kata6terceraversion {
     public static void main(String[] args) throws IOException, Exception {
         Kata6terceraversion histo = new Kata6terceraversion();
         histo.execute();
     }
     private static MailHistogramBuilder<Mail> builder;
     private Histogram <String> domains;
     private Histogram <Character> letters;
     private String filename;
     private List<Mail> mailList;
     private Histogram<String> histogram;
     private static HistogramDisplay histoDisplay;
     private Histogram<Character> gender;
     private  List<Person> people;
         
     private void execute() throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        filename = "/E://Kata6/emails.txt";
        mailList = MailListReader.read(filename);
        builder	=new MailHistogramBuilder<>(mailList);	
     }
     
    private void process() throws ClassNotFoundException, SQLException{
       domains = builder.build(new Attribute<Mail,String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
         });
         //new HistogramDisplay(domains, "Dominios").execute();
         letters = builder.build(new Attribute<Mail, Character>(){
             @Override
             public Character get(Mail item) {
                 return item.getMail().charAt(0);
             }
         });
         people = DataBaseList.read();
     MailHistogramBuilder<Person> builderPerson = new MailHistogramBuilder<>(people);
     gender = builderPerson.build(new Attribute<Person,Character>() {
         @Override
         public Character get(Person item) {
             return item.getGender();
          }
     });
         //new HistogramDisplay(letters,"Primer Caracter").execute();
    }
     
     private void output(){
         new HistogramDisplay(domains,"Dominios").execute();
         new HistogramDisplay(letters,"Primer Caracter").execute();
         new HistogramDisplay (gender,"Gender").execute();
         histoDisplay.execute();
     }
 }
