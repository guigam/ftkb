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
import modeles.specialite;

public class SpecialiteConverter implements Converter {
	 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String name = value;
        Query query = em.createQuery("from specialite");

        for (specialite s : (List<specialite>) query.getResultList()){
              if (s.getNomSpecialite().equals(name))
            	  return s;
        }
        
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value !=null) {
			specialite s = (specialite) value;
		
		return s.getNomSpecialite();
		}
		
		return null;
	}

}
