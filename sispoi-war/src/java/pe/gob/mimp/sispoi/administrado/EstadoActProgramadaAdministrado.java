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
import pe.gob.mimp.sispoi.fachada.EstadoActProgramadaFacadeLocal;
import pe.gob.mimp.sispoi.modelo.EstadoActProgramada;


import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class EstadoActProgramadaAdministrado extends AdministradorAbstracto implements Serializable{
    private EstadoActProgramada entidad;

    private EstadoActProgramada entidadSeleccionada;
	
    private List<EstadoActProgramada> entidades;

    @EJB
    private EstadoActProgramadaFacadeLocal fachada;
    /**
     * Creates a new instance of PeriodoAdministrado
     */
    public EstadoActProgramadaAdministrado() {
        setEntidad(new EstadoActProgramada());
        setEntidadSeleccionada(new EstadoActProgramada());
    }

    /**
     * @return the entidad
     */
    public EstadoActProgramada getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(EstadoActProgramada entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public EstadoActProgramada getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(EstadoActProgramada entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<EstadoActProgramada> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<EstadoActProgramada> entidades) {
        this.entidades = entidades;
    }
    
    public EstadoActProgramada getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(EstadoActProgramada entidad) throws UnknownHostException {
        EstadoActProgramada estadoActProgramada = new EstadoActProgramada();

        estadoActProgramada.setTxtEstadoActProgramada(entidad.getTxtEstadoActProgramada());

        estadoActProgramada.setTxtPc(Util.obtenerNombreCliente());
        estadoActProgramada.setTxtIp(Util.obtenerIPPublicaCliente());
        estadoActProgramada.setFecEdicion(new Date());
        
        estadoActProgramada.setFlgActivo(BigInteger.ONE);
        estadoActProgramada.setNidUsuario(BigInteger.ONE);

        this.fachada.create(estadoActProgramada);

        System.out.println("Entidad creada: " + estadoActProgramada.getTxtEstadoActProgramada() + " estado: " + estadoActProgramada.getFlgActivo());
        adicionarMensaje("Creacion","Estado Actividad Programada creado satisfactoriamente");
    }
    
    public void editar(EstadoActProgramada entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtEstadoActProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Estado Actividad Programada editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(EstadoActProgramada entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtEstadoActProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Estado Actividad Programada anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
