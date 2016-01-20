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
import pe.gob.mimp.sispoi.fachada.UnidadEjecutoraFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Pliego;
import pe.gob.mimp.sispoi.modelo.UnidadEjecutora;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class UnidadEjecutoraAdministrado extends AdministradorAbstracto implements Serializable{
    private UnidadEjecutora entidad;

    private UnidadEjecutora entidadSeleccionada;
	
    private List<UnidadEjecutora> entidades;

    @EJB
    private UnidadEjecutoraFacadeLocal fachada;
    /**
     * Creates a new instance of UnidadEjecutoraAdministrado
     */
    public UnidadEjecutoraAdministrado() {
        setEntidad(new UnidadEjecutora());
        setEntidadSeleccionada(new UnidadEjecutora());
    }

    /**
     * @return the entidad
     */
    public UnidadEjecutora getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(UnidadEjecutora entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public UnidadEjecutora getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(UnidadEjecutora entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<UnidadEjecutora> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<UnidadEjecutora> entidades) {
        this.entidades = entidades;
    }
    
    public UnidadEjecutora getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(UnidadEjecutora entidadSeleccionada, Pliego pliegoSeleccionada) throws UnknownHostException {
        UnidadEjecutora unidadEjecutora = new UnidadEjecutora();

        unidadEjecutora.setTxtUnidadEjecutora(entidadSeleccionada.getTxtUnidadEjecutora());
        unidadEjecutora.setPliego(pliegoSeleccionada);

        unidadEjecutora.setTxtPc(Util.obtenerNombreCliente());
        unidadEjecutora.setTxtIp(Util.obtenerIPPublicaCliente());
        unidadEjecutora.setFecEdicion(new Date());
        
        unidadEjecutora.setFlgActivo(BigInteger.ONE);
        unidadEjecutora.setNidUsuario(BigInteger.ONE);

        this.fachada.create(unidadEjecutora);

        System.out.println("Entidad creada: " + unidadEjecutora.getTxtUnidadEjecutora() + " estado: " + unidadEjecutora.getFlgActivo());
        adicionarMensaje("Creacion","Unidad Ejecutora creado satisfactoriamente");
    }
    
    public void editar(UnidadEjecutora entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtUnidadEjecutora() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Unidad Ejecutora editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(UnidadEjecutora entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtUnidadEjecutora() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Unidad Ejecutora anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
