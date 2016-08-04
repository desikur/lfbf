/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selensatu;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.DefaultSelenium;

/**
 *
 * @author Sony Vaio
 */
public class Selensatu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //inisiasi rc, start selenium
        Selenium sel = new DefaultSelenium("localhost", 4444, "firefox", "http://calculator.net");
        sel.start();
        sel.open("/");
        Thread.sleep(2500); 
        sel.windowMaximize();
        
        //klik link math calculator
        sel.click("xpath=.//*[@id='menu']/div[3]/a");
        Thread.sleep(2500); 
        
        //klik link percentage calculator
        sel.click("xpath=.//*[@id='menu']/div[4]/div[3]/a");
        Thread.sleep(4000);
        
        //fokusin ke textbox pertama,kenapa harus difokusin ya?
        sel.focus("name=cpar1");
        //input angka pertama
        sel.type("css=input[name=\"cpar1\"]", "5");
        
        //fokusin ketextbox kedua
        sel.focus("name=cpar2");
        //input angka kedua
        sel.type("css=input[name=\"cpar2\"]","500");
        
        //click tombol calculate
        sel.click("xpath=.//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]");
        Thread.sleep(1500);
        //verify the result
        String hasil=sel.getText("xpath=.//*[@id='content']/p[2]");
        System.out.println(hasil);
        if (hasil!="25"){
            System.out.println("fail");
        }else{
            System.out.println("pass");
        }
    }
    
}
