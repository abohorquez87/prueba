/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.convertidor;

import be.Usuario;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import pe.gob.mimp.sispoi.administrado.UsuarioAdministrado;

/**
 *
 * @author desarrollador
 */
@FacesConverter("usuarioConvertidor")
public class UsuarioConvertidor implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (context == null) {
            throw new NullPointerException("context");
        }

        if (component == null) {
            throw new NullPointerException("component");
        }

        FacesContext ctx = FacesContext.getCurrentInstance();

        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{usuarioAdministrado}", UsuarioAdministrado.class);

        UsuarioAdministrado administrado = (UsuarioAdministrado) vex.getValue(ctx.getELContext());

        Usuario entidad;
        
        try {
            entidad = administrado.getEntidad(value);
        } catch (NumberFormatException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "NumberFormatException");
            throw new ConverterException(message);
        }
        if (entidad == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Object NULL");
            throw new ConverterException(message);
        }

        return entidad;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (context == null) {
            throw new NullPointerException("context");
        }
        
        if (component == null) {
            throw new NullPointerException("component");
        }
        if (value == null || ((Usuario) value).getNidUsuario() == null) {
            return "";
        }

        return ((Usuario) value).getNidUsuario().toString();
    }

}
