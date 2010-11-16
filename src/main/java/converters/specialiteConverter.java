/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;

import java.util.LinkedList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import modeles.specialite;

import services.GestionSpecialite;

/**
 *
 * @author guigam
 */
public class specialiteConverter implements Converter {
    List<specialite> lesSpec = new LinkedList<specialite>();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        GestionSpecialite cm = (GestionSpecialite)ctx.getExternalContext().getSessionMap().get("specialite");
        return cm.getspecFromID(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         return String.valueOf(((specialite)value).getId());
    }

}
