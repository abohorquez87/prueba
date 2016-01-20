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
import pe.gob.mimp.sispoi.fachada.UnidadOrganicaFacadeLocal;
import pe.gob.mimp.sispoi.modelo.UnidadEjecutora;
import pe.gob.mimp.sispoi.modelo.UnidadOrganica;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class UnidadOrganicaAdministrado extends AdministradorAbstracto implements Serializable{
    private UnidadOrganica entidad;

    private UnidadOrganica entidadSeleccionada;
	
    private List<UnidadOrganica> entidades;

    @EJB
    private UnidadOrganicaFacadeLocal fachada;
    /**
     * Creates a new instance of UnidadOrganicaAdministrado
     */
    public UnidadOrganicaAdministrado() {
        setEntidad(new UnidadOrganica());
        setEntidadSeleccionada(new UnidadOrganica());
    }

    /**
     * @return the entidad
     */
    public UnidadOrganica getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(UnidadOrganica entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public UnidadOrganica getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(UnidadOrganica entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<UnidadOrganica> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<UnidadOrganica> entidades) {
        this.entidades = entidades;
    }
    
    public UnidadOrganica getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(UnidadOrganica entidadSeleccionada, UnidadEjecutora unidadEjecutoraSeleccionada) throws UnknownHostException {
        UnidadOrganica unidadOrganica = new UnidadOrganica();

        unidadOrganica.setTxtUnidadOrganica(entidadSeleccionada.getTxtUnidadOrganica());
        unidadOrganica.setUnidadEjecutora(unidadEjecutoraSeleccionada);

        unidadOrganica.setTxtPc(Util.obtenerNombreCliente());
        unidadOrganica.setTxtIp(Util.obtenerIPPublicaCliente());
        unidadOrganica.setFecEdicion(new Date());
        
        unidadOrganica.setFlgActivo(BigInteger.ONE);
        unidadOrganica.setNidUsuario(BigInteger.ONE);

        this.fachada.create(unidadOrganica);

        System.out.println("Entidad creada: " + unidadOrganica.getTxtUnidadOrganica() + " estado: " + unidadOrganica.getFlgActivo());
        adicionarMensaje("Creacion","Unidad Organica creado satisfactoriamente");
    }
    
    public void editar(UnidadOrganica entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtUnidadOrganica() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Unidad Organica editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(UnidadOrganica entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtUnidadOrganica() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Unidad Organica anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
