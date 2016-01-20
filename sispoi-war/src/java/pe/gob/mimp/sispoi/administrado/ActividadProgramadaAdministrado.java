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
import pe.gob.mimp.sispoi.fachada.ActividadProgramadaFacadeLocal;
import pe.gob.mimp.sispoi.modelo.ActividadProgramada;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class ActividadProgramadaAdministrado extends AdministradorAbstracto implements Serializable{
    private ActividadProgramada entidad;

    private ActividadProgramada entidadSeleccionada;
	
    private List<ActividadProgramada> entidades;

    @EJB
    private ActividadProgramadaFacadeLocal fachada;
    /**
     * Creates a new instance of ActividadProgramadaAdministrado
     */
    public ActividadProgramadaAdministrado() {
        setEntidad(new ActividadProgramada());
        setEntidadSeleccionada(new ActividadProgramada());
    }

    /**
     * @return the entidad
     */
    public ActividadProgramada getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(ActividadProgramada entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public ActividadProgramada getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(ActividadProgramada entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<ActividadProgramada> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<ActividadProgramada> entidades) {
        this.entidades = entidades;
    }
    
    public ActividadProgramada getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(ActividadProgramada entidad) throws UnknownHostException {
        ActividadProgramada actividadProgramada = new ActividadProgramada();

        actividadProgramada.setTxtActividadProgramada(entidad.getTxtActividadProgramada());

        actividadProgramada.setTxtPc(Util.obtenerNombreCliente());
        actividadProgramada.setTxtIp(Util.obtenerIPPublicaCliente());
        actividadProgramada.setFecEdicion(new Date());
        
        actividadProgramada.setFlgActivo(BigInteger.ONE);
        actividadProgramada.setNidUsuario(BigInteger.ONE);

        this.fachada.create(actividadProgramada);

        System.out.println("Entidad creada: " + actividadProgramada.getTxtActividadProgramada() + " estado: " + actividadProgramada.getFlgActivo());
        adicionarMensaje("Creacion","Tipo Actividad Programada creado satisfactoriamente");
    }
    
    public void editar(ActividadProgramada entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtActividadProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Tipo Actividad Programada editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(ActividadProgramada entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtActividadProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Tipo Actividad Programada anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
