/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.eao.ContactEao;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author celine.glissmann
 */
@Named
public class SearchController {

    @Inject
    ContactEao contactEao;
   
    @Inject
    ContactController contactController;
            
   private String inputSearch;
        
         
    
    public String getInputSearch(){
        return inputSearch;
    }
    
    public void setInputSearch(String inputSearch){
        this.inputSearch=inputSearch;
    }
    
    public void search(){
             contactEao.find(getInputSearch());
    }
}