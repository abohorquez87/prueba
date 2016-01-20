package pe.gob.mimp.sispoi.administrado;

import bc.UsuarioFacadeLocal;
import be.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import util.Parametro;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class UsuarioAdministrado extends AdministradorAbstracto  implements Serializable{
	
    private Usuario entidad;

    private Usuario entidadSeleccionada;

    private List<Usuario> entidades;

    @EJB
    private UsuarioFacadeLocal fachada;
    
    private String modulo;

    public UsuarioAdministrado() {
        setEntidad(new Usuario());
        setEntidadSeleccionada(new Usuario());
        
        modulo = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("Modulo");
        
        System.out.println("Modulo del aplicativo: " + modulo);
    }

    public Usuario getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuario entidad) {
        this.entidad = entidad;
    }

    public Usuario getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    public void setEntidadSeleccionada(Usuario entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    public List<Usuario> getEntidades() {
        entidades = fachada.findAll();

        return entidades;
    }

    public void setEntidades(List<Usuario> entidades) {
        this.entidades = entidades;
    }

    public Usuario getEntidad(String id) {
        return fachada.find(new BigDecimal(id));
    }
    
    public boolean validar(String usuario, String password)
    {
        boolean resultado = false;
        
        Parametro parametro = new Parametro();
        
        parametro.adicionar("txtUsuario", usuario);
        parametro.adicionar("txtPassword", password);
        
        List<Usuario> usuarios = fachada.obtenerPorParametros(parametro);
        
        if(null != usuarios)
        {
            if(0 < usuarios.size())
            {
                resultado = true;
                entidadSeleccionada = usuarios.get(0);
            }
        }
        
        return resultado;
    } 
    
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        
        boolean loggedIn = false;
         
        if(true == validar(entidadSeleccionada.getTxtUsuario(), entidadSeleccionada.getTxtPassword())) {
            loggedIn = true;
            entidad = entidadSeleccionada;
            //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", entidad.getPersona().getTxtNombres());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Autenticacion", "Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
    }
}
