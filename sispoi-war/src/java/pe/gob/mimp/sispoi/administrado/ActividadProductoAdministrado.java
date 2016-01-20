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
import pe.gob.mimp.sispoi.fachada.ActividadProductoFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Producto;
import pe.gob.mimp.sispoi.modelo.ActividadProducto;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class ActividadProductoAdministrado extends AdministradorAbstracto implements Serializable{
    private ActividadProducto entidad;

    private ActividadProducto entidadSeleccionada;
	
    private List<ActividadProducto> entidades;

    @EJB
    private ActividadProductoFacadeLocal fachada;
    /**
     * Creates a new instance of ActividadProductoAdministrado
     */
    public ActividadProductoAdministrado() {
        setEntidad(new ActividadProducto());
        setEntidadSeleccionada(new ActividadProducto());
    }

    /**
     * @return the entidad
     */
    public ActividadProducto getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(ActividadProducto entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public ActividadProducto getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(ActividadProducto entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<ActividadProducto> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<ActividadProducto> entidades) {
        this.entidades = entidades;
    }
    
    public ActividadProducto getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(ActividadProducto entidadSeleccionada, Producto productoSeleccionada) throws UnknownHostException {
        ActividadProducto actividadProducto = new ActividadProducto();

        actividadProducto.setTxtActividadProducto(entidadSeleccionada.getTxtActividadProducto());
        actividadProducto.setProducto(productoSeleccionada);

        actividadProducto.setTxtPc(Util.obtenerNombreCliente());
        actividadProducto.setTxtIp(Util.obtenerIPPublicaCliente());
        actividadProducto.setFecEdicion(new Date());
        
        actividadProducto.setFlgActivo(BigInteger.ONE);
        actividadProducto.setNidUsuario(BigInteger.ONE);

        this.fachada.create(actividadProducto);

        System.out.println("Entidad creada: " + actividadProducto.getTxtActividadProducto() + " estado: " + actividadProducto.getFlgActivo());
        adicionarMensaje("Creacion","Actividad Producto creado satisfactoriamente");
    }
    
    public void editar(ActividadProducto entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtActividadProducto() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Actividad Producto editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(ActividadProducto entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtActividadProducto() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Actividad Producto anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
