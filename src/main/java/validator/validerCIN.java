/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.*;

/**
 *
 * @author guiga
 */
public class validerCIN implements Validator {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Query query = em.createQuery("from Personnes p where p.cin =?1");
        query.setParameter(1, value);
        if(query.getResultList().size()>0){
            
            throw new ValidatorException(new FacesMessage("CIN existe déja"));
        }
    }

}
