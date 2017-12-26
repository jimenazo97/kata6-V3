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
 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.List;
 import model.Mail;
 
 public class MailListReader {
     public static List<Mail> read (String fileName) throws FileNotFoundException, IOException{
         List<Mail> mailList = new ArrayList<>();
         BufferedReader reader = new BufferedReader(new FileReader(new File(fileName))); 
         String mail;
         int id =0;
         while ((mail = reader.readLine()) != null){
             if (mail.contains("@")){
                 mailList.add(new Mail(mail,id)); 
             }
         }
         reader.close();
         return mailList;
    }
 
 }