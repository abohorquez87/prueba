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
import pe.gob.mimp.sispoi.fachada.TipoModificadorFacadeLocal;
import pe.gob.mimp.sispoi.modelo.TipoModificador;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class TipoModificadorAdministrado extends AdministradorAbstracto implements Serializable{
    private TipoModificador entidad;

    private TipoModificador entidadSeleccionada;
	
    private List<TipoModificador> entidades;

    @EJB
    private TipoModificadorFacadeLocal fachada;
    /**
     * Creates a new instance of TipoModificadorAdministrado
     */
    public TipoModificadorAdministrado() {
        setEntidad(new TipoModificador());
        setEntidadSeleccionada(new TipoModificador());
    }

    /**
     * @return the entidad
     */
    public TipoModificador getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(TipoModificador entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public TipoModificador getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(TipoModificador entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<TipoModificador> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<TipoModificador> entidades) {
        this.entidades = entidades;
    }
    
    public TipoModificador getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(TipoModificador entidad) throws UnknownHostException {
        TipoModificador tipoModificador = new TipoModificador();

        tipoModificador.setTxtTipoModificador(entidad.getTxtTipoModificador());

        tipoModificador.setTxtPc(Util.obtenerNombreCliente());
        tipoModificador.setTxtIp(Util.obtenerIPPublicaCliente());
        tipoModificador.setFecEdicion(new Date());
        
        tipoModificador.setFlgActivo(BigInteger.ONE);
        tipoModificador.setNidUsuario(BigInteger.ONE);

        this.fachada.create(tipoModificador);

        System.out.println("Entidad creada: " + tipoModificador.getTxtTipoModificador() + " estado: " + tipoModificador.getFlgActivo());
        adicionarMensaje("Creacion","TipoModificador creado satisfactoriamente");
    }
    
    public void editar(TipoModificador entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtTipoModificador() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Tipo Modificador editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(TipoModificador entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtTipoModificador() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Tipo Modificador anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
