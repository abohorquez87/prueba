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
import pe.gob.mimp.sispoi.fachada.TipoObjetivoEstrategicoFacadeLocal;
import pe.gob.mimp.sispoi.modelo.TipoObjetivoEstrategico;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class TipoObjetivoEstrategicoAdministrado extends AdministradorAbstracto implements Serializable{
    private TipoObjetivoEstrategico entidad;

    private TipoObjetivoEstrategico entidadSeleccionada;
	
    private List<TipoObjetivoEstrategico> entidades;

    @EJB
    private TipoObjetivoEstrategicoFacadeLocal fachada;
    /**
     * Creates a new instance of TipoObjetivoEstrategicoAdministrado
     */
    public TipoObjetivoEstrategicoAdministrado() {
        setEntidad(new TipoObjetivoEstrategico());
        setEntidadSeleccionada(new TipoObjetivoEstrategico());
    }

    /**
     * @return the entidad
     */
    public TipoObjetivoEstrategico getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(TipoObjetivoEstrategico entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public TipoObjetivoEstrategico getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(TipoObjetivoEstrategico entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<TipoObjetivoEstrategico> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<TipoObjetivoEstrategico> entidades) {
        this.entidades = entidades;
    }
    
    public TipoObjetivoEstrategico getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(TipoObjetivoEstrategico entidad) throws UnknownHostException {
        TipoObjetivoEstrategico tipoObjetivoEstrategico = new TipoObjetivoEstrategico();

        tipoObjetivoEstrategico.setTxtTipoObjetivoEstrategico(entidad.getTxtTipoObjetivoEstrategico());

        tipoObjetivoEstrategico.setTxtPc(Util.obtenerNombreCliente());
        tipoObjetivoEstrategico.setTxtIp(Util.obtenerIPPublicaCliente());
        tipoObjetivoEstrategico.setFecEdicion(new Date());
        
        tipoObjetivoEstrategico.setFlgActivo(BigInteger.ONE);
        tipoObjetivoEstrategico.setNidUsuario(BigInteger.ONE);

        this.fachada.create(tipoObjetivoEstrategico);

        System.out.println("Entidad creada: " + tipoObjetivoEstrategico.getTxtTipoObjetivoEstrategico() + " estado: " + tipoObjetivoEstrategico.getFlgActivo());
        adicionarMensaje("Creacion","Tipo Objetivo Estrategico creado satisfactoriamente");
    }
    
    public void editar(TipoObjetivoEstrategico entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtTipoObjetivoEstrategico() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Tipo Objetivo Estrategico editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(TipoObjetivoEstrategico entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtTipoObjetivoEstrategico() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Tipo Objetivo Estrategico anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
