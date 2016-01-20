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
import pe.gob.mimp.sispoi.fachada.MedioFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Medio;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class MedioAdministrado extends AdministradorAbstracto implements Serializable{
    private Medio entidad;

    private Medio entidadSeleccionada;
	
    private List<Medio> entidades;

    @EJB
    private MedioFacadeLocal fachada;
    /**
     * Creates a new instance of MedioAdministrado
     */
    public MedioAdministrado() {
        setEntidad(new Medio());
        setEntidadSeleccionada(new Medio());
    }

    /**
     * @return the entidad
     */
    public Medio getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Medio entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Medio getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Medio entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Medio> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Medio> entidades) {
        this.entidades = entidades;
    }
    
    public Medio getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Medio entidad) throws UnknownHostException {
        Medio medio = new Medio();

        medio.setTxtMedio(entidad.getTxtMedio());

        medio.setTxtPc(Util.obtenerNombreCliente());
        medio.setTxtIp(Util.obtenerIPPublicaCliente());
        medio.setFecEdicion(new Date());
        
        medio.setFlgActivo(BigInteger.ONE);
        medio.setNidUsuario(BigInteger.ONE);

        this.fachada.create(medio);

        System.out.println("Entidad creada: " + medio.getTxtMedio() + " estado: " + medio.getFlgActivo());
        adicionarMensaje("Creacion","Medio creado satisfactoriamente");
    }
    
    public void editar(Medio entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtMedio() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Medio editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Medio entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtMedio() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Medio anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
