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
import pe.gob.mimp.sispoi.fachada.GrupoFuncionalFacadeLocal;
import pe.gob.mimp.sispoi.modelo.DivisionFuncional;
import pe.gob.mimp.sispoi.modelo.GrupoFuncional;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class GrupoFuncionalAdministrado extends AdministradorAbstracto implements Serializable{
    private GrupoFuncional entidad;

    private GrupoFuncional entidadSeleccionada;
	
    private List<GrupoFuncional> entidades;

    @EJB
    private GrupoFuncionalFacadeLocal fachada;
    /**
     * Creates a new instance of GrupoFuncionalAdministrado
     */
    public GrupoFuncionalAdministrado() {
        setEntidad(new GrupoFuncional());
        setEntidadSeleccionada(new GrupoFuncional());
    }

    /**
     * @return the entidad
     */
    public GrupoFuncional getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(GrupoFuncional entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public GrupoFuncional getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(GrupoFuncional entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<GrupoFuncional> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<GrupoFuncional> entidades) {
        this.entidades = entidades;
    }
    
    public GrupoFuncional getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(GrupoFuncional entidadSeleccionada, DivisionFuncional divisionFuncionalSeleccionada) throws UnknownHostException {
        GrupoFuncional grupoFuncional = new GrupoFuncional();

        grupoFuncional.setTxtGrupoFuncional(entidadSeleccionada.getTxtGrupoFuncional());
        grupoFuncional.setDivisionFuncional(divisionFuncionalSeleccionada);

        grupoFuncional.setTxtPc(Util.obtenerNombreCliente());
        grupoFuncional.setTxtIp(Util.obtenerIPPublicaCliente());
        grupoFuncional.setFecEdicion(new Date());
        
        grupoFuncional.setFlgActivo(BigInteger.ONE);
        grupoFuncional.setNidUsuario(BigInteger.ONE);

        this.fachada.create(grupoFuncional);

        System.out.println("Entidad creada: " + grupoFuncional.getTxtGrupoFuncional() + " estado: " + grupoFuncional.getFlgActivo());
        adicionarMensaje("Creacion","Unidad Ejecutora creado satisfactoriamente");
    }
    
    public void editar(GrupoFuncional entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtGrupoFuncional() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Unidad Ejecutora editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(GrupoFuncional entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtGrupoFuncional() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Unidad Ejecutora anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
