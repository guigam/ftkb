/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validator;


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
