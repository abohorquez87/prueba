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
import pe.gob.mimp.sispoi.fachada.MetaPresupuestariaFacadeLocal;
import pe.gob.mimp.sispoi.modelo.GrupoFuncional;
import pe.gob.mimp.sispoi.modelo.MetaPresupuestaria;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class MetaPresupuestariaAdministrado extends AdministradorAbstracto implements Serializable{
    private MetaPresupuestaria entidad;

    private MetaPresupuestaria entidadSeleccionada;
	
    private List<MetaPresupuestaria> entidades;

    @EJB
    private MetaPresupuestariaFacadeLocal fachada;
    /**
     * Creates a new instance of MetaPresupuestariaAdministrado
     */
    public MetaPresupuestariaAdministrado() {
        setEntidad(new MetaPresupuestaria());
        setEntidadSeleccionada(new MetaPresupuestaria());
    }

    /**
     * @return the entidad
     */
    public MetaPresupuestaria getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(MetaPresupuestaria entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public MetaPresupuestaria getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(MetaPresupuestaria entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<MetaPresupuestaria> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<MetaPresupuestaria> entidades) {
        this.entidades = entidades;
    }
    
    public MetaPresupuestaria getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(MetaPresupuestaria entidadSeleccionada, GrupoFuncional grupoFuncionalSeleccionada) throws UnknownHostException {
        MetaPresupuestaria metaPresupuestaria = new MetaPresupuestaria();

        metaPresupuestaria.setTxtMetaPresupuestaria(entidadSeleccionada.getTxtMetaPresupuestaria());
        metaPresupuestaria.setGrupoFuncional(grupoFuncionalSeleccionada);

        metaPresupuestaria.setTxtPc(Util.obtenerNombreCliente());
        metaPresupuestaria.setTxtIp(Util.obtenerIPPublicaCliente());
        metaPresupuestaria.setFecEdicion(new Date());
        
        metaPresupuestaria.setFlgActivo(BigInteger.ONE);
        metaPresupuestaria.setNidUsuario(BigInteger.ONE);

        this.fachada.create(metaPresupuestaria);

        System.out.println("Entidad creada: " + metaPresupuestaria.getTxtMetaPresupuestaria() + " estado: " + metaPresupuestaria.getFlgActivo());
        adicionarMensaje("Creacion","Meta Presupuestaria creado satisfactoriamente");
    }
    
    public void editar(MetaPresupuestaria entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtMetaPresupuestaria() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Meta Presupuestaria editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(MetaPresupuestaria entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtMetaPresupuestaria() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Meta Presupuestaria anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
