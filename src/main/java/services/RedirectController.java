/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import javax.faces.context.FacesContext;

/**
 *
 * @author guigamehdi
 */

public class RedirectController {

    /** Creates a new instance of RedirectController */
    public RedirectController() {
    }

    public String redirect(){
        String outcome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("outcome");
        System.out.println(outcome);
        return outcome;
    }
    

}
