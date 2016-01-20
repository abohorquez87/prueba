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
import pe.gob.mimp.sispoi.fachada.PliegoFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Pliego;
import pe.gob.mimp.sispoi.modelo.Sector;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class PliegoAdministrado extends AdministradorAbstracto implements Serializable{
    private Pliego entidad;

    private Pliego entidadSeleccionada;
	
    private List<Pliego> entidades;

    @EJB
    private PliegoFacadeLocal fachada;
    /**
     * Creates a new instance of PliegoAdministrado
     */
    public PliegoAdministrado() {
        setEntidad(new Pliego());
        setEntidadSeleccionada(new Pliego());
    }

    /**
     * @return the entidad
     */
    public Pliego getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Pliego entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Pliego getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Pliego entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Pliego> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Pliego> entidades) {
        this.entidades = entidades;
    }
    
    public Pliego getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Pliego entidadSeleccionada, Sector sectorSeleccionada) throws UnknownHostException {
        Pliego pliego = new Pliego();

        pliego.setTxtPliego(entidadSeleccionada.getTxtPliego());
        pliego.setSector(sectorSeleccionada);

        pliego.setTxtPc(Util.obtenerNombreCliente());
        pliego.setTxtIp(Util.obtenerIPPublicaCliente());
        pliego.setFecEdicion(new Date());
        
        pliego.setFlgActivo(BigInteger.ONE);
        pliego.setNidUsuario(BigInteger.ONE);

        this.fachada.create(pliego);

        System.out.println("Entidad creada: " + pliego.getTxtPliego() + " estado: " + pliego.getFlgActivo());
        adicionarMensaje("Creacion","Pliego creado satisfactoriamente");
    }
    
    public void editar(Pliego entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtPliego() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Pliego editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Pliego entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtPliego() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Pliego anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
