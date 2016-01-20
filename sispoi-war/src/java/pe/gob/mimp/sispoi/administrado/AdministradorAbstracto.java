package pe.gob.mimp.sispoi.administrado;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AdministradorAbstracto {

	public AdministradorAbstracto() {
		
	}

	public void adicionarMensaje(String resumen, String detalle) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        public void adicionarMensajeError(String resumen, String detalle) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
}
