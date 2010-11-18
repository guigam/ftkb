package converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeles.Clubs;

public class ClubConverter implements Converter {
	 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String name = value;
        Query query = em.createQuery("from Clubs");

        for (Clubs c : (List<Clubs>) query.getResultList()){
              if (c.getNomClub().equals(name))
            	  return c;
        }
        
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value !=null) {
		Clubs c = (Clubs) value;
		
		return c.getNomClub();
		}
		
		return null;
	}

}
