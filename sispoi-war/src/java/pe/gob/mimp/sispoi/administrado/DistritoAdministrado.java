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
import pe.gob.mimp.sispoi.fachada.DistritoFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Distrito;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class DistritoAdministrado extends AdministradorAbstracto implements Serializable{
    private Distrito entidad;

    private Distrito entidadSeleccionada;
	
    private List<Distrito> entidades;

    @EJB
    private DistritoFacadeLocal fachada;
    /**
     * Creates a new instance of DistritoAdministrado
     */
    public DistritoAdministrado() {
        setEntidad(new Distrito());
        setEntidadSeleccionada(new Distrito());
    }

    /**
     * @return the entidad
     */
    public Distrito getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Distrito entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Distrito getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Distrito entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Distrito> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Distrito> entidades) {
        this.entidades = entidades;
    }
    
    public Distrito getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Distrito entidad) throws UnknownHostException {
        Distrito distrito = new Distrito();

        distrito.setTxtDistrito(entidad.getTxtDistrito());

        distrito.setTxtPc(Util.obtenerNombreCliente());
        distrito.setTxtIp(Util.obtenerIPPublicaCliente());
        distrito.setFecEdicion(new Date());
        
        distrito.setFlgActivo(BigInteger.ONE);
        distrito.setNidUsuario(BigInteger.ONE);

        this.fachada.create(distrito);

        System.out.println("Entidad creada: " + distrito.getTxtDistrito() + " estado: " + distrito.getFlgActivo());
        adicionarMensaje("Creacion","Distrito creado satisfactoriamente");
    }
    
    public void editar(Distrito entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtDistrito() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Distrito editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Distrito entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtDistrito() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Distrito anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
