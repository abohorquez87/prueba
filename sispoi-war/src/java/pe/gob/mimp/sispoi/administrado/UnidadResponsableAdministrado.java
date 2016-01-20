/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.administrado;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.gob.mimp.sispoi.fachada.UnidadResponsableFacadeLocal;
import pe.gob.mimp.sispoi.modelo.UnidadResponsable;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class UnidadResponsableAdministrado extends AdministradorAbstracto implements Serializable{
    private UnidadResponsable entidad;

    private UnidadResponsable entidadSeleccionada;
	
    private List<UnidadResponsable> entidades;

    @EJB
    private UnidadResponsableFacadeLocal fachada;
    /**
     * Creates a new instance of UnidadResponsableAdministrado
     */
    public UnidadResponsableAdministrado() {
        setEntidad(new UnidadResponsable());
        setEntidadSeleccionada(new UnidadResponsable());
    }

    /**
     * @return the entidad
     */
    public UnidadResponsable getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(UnidadResponsable entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public UnidadResponsable getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(UnidadResponsable entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<UnidadResponsable> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<UnidadResponsable> entidades) {
        this.entidades = entidades;
    }
    
    public UnidadResponsable getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(UnidadResponsable entidad) throws UnknownHostException {
        UnidadResponsable unidadResponsable = new UnidadResponsable();

        unidadResponsable.setTxtUnidadResponsable(entidad.getTxtUnidadResponsable());

        unidadResponsable.setTxtPc(Util.obtenerNombreCliente());
        unidadResponsable.setTxtIp(Util.obtenerIPPublicaCliente());
        unidadResponsable.setFecEdicion(new Date());
        
        unidadResponsable.setFlgActivo(BigInteger.ONE);
        unidadResponsable.setNidUsuario(BigInteger.ONE);

        this.fachada.create(unidadResponsable);

        System.out.println("Entidad creada: " + unidadResponsable.getTxtUnidadResponsable() + " estado: " + unidadResponsable.getFlgActivo());
        adicionarMensaje("Creacion","Unidad Responsable creado satisfactoriamente");
    }
    
    public void editar(UnidadResponsable entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtUnidadResponsable() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Unidad Responsable editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(UnidadResponsable entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtUnidadResponsable() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Unidad Responsable anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
