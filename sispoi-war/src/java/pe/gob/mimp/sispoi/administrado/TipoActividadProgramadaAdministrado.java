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
import pe.gob.mimp.sispoi.fachada.TipoActividadProgramadaFacadeLocal;
import pe.gob.mimp.sispoi.modelo.TipoActividadProgramada;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class TipoActividadProgramadaAdministrado extends AdministradorAbstracto implements Serializable{
    private TipoActividadProgramada entidad;

    private TipoActividadProgramada entidadSeleccionada;
	
    private List<TipoActividadProgramada> entidades;

    @EJB
    private TipoActividadProgramadaFacadeLocal fachada;
    /**
     * Creates a new instance of TipoActividadProgramadaAdministrado
     */
    public TipoActividadProgramadaAdministrado() {
        setEntidad(new TipoActividadProgramada());
        setEntidadSeleccionada(new TipoActividadProgramada());
    }

    /**
     * @return the entidad
     */
    public TipoActividadProgramada getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(TipoActividadProgramada entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public TipoActividadProgramada getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(TipoActividadProgramada entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<TipoActividadProgramada> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<TipoActividadProgramada> entidades) {
        this.entidades = entidades;
    }
    
    public TipoActividadProgramada getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(TipoActividadProgramada entidad) throws UnknownHostException {
        TipoActividadProgramada tipoActividadProgramada = new TipoActividadProgramada();

        tipoActividadProgramada.setTxtTipoActividadProgramada(entidad.getTxtTipoActividadProgramada());

        tipoActividadProgramada.setTxtPc(Util.obtenerNombreCliente());
        tipoActividadProgramada.setTxtIp(Util.obtenerIPPublicaCliente());
        tipoActividadProgramada.setFecEdicion(new Date());
        
        tipoActividadProgramada.setFlgActivo(BigInteger.ONE);
        tipoActividadProgramada.setNidUsuario(BigInteger.ONE);

        this.fachada.create(tipoActividadProgramada);

        System.out.println("Entidad creada: " + tipoActividadProgramada.getTxtTipoActividadProgramada() + " estado: " + tipoActividadProgramada.getFlgActivo());
        adicionarMensaje("Creacion","Tipo Actividad Programada creado satisfactoriamente");
    }
    
    public void editar(TipoActividadProgramada entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtTipoActividadProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Tipo Actividad Programada editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(TipoActividadProgramada entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtTipoActividadProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Tipo Actividad Programada anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
