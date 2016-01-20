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
import pe.gob.mimp.sispoi.fachada.FuncionFacadeLocal;
import pe.gob.mimp.sispoi.modelo.ActividadProducto;
import pe.gob.mimp.sispoi.modelo.Funcion;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class FuncionAdministrado extends AdministradorAbstracto implements Serializable{
    private Funcion entidad;

    private Funcion entidadSeleccionada;
	
    private List<Funcion> entidades;

    @EJB
    private FuncionFacadeLocal fachada;
    /**
     * Creates a new instance of FuncionAdministrado
     */
    public FuncionAdministrado() {
        setEntidad(new Funcion());
        setEntidadSeleccionada(new Funcion());
    }

    /**
     * @return the entidad
     */
    public Funcion getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Funcion entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Funcion getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Funcion entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Funcion> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Funcion> entidades) {
        this.entidades = entidades;
    }
    
    public Funcion getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Funcion entidadSeleccionada, ActividadProducto actividadProductoSeleccionada) throws UnknownHostException {
        Funcion funcion = new Funcion();

        funcion.setTxtFuncion(entidadSeleccionada.getTxtFuncion());
        funcion.setActividadProducto(actividadProductoSeleccionada);

        funcion.setTxtPc(Util.obtenerNombreCliente());
        funcion.setTxtIp(Util.obtenerIPPublicaCliente());
        funcion.setFecEdicion(new Date());
        
        funcion.setFlgActivo(BigInteger.ONE);
        funcion.setNidUsuario(BigInteger.ONE);

        this.fachada.create(funcion);

        System.out.println("Entidad creada: " + funcion.getTxtFuncion() + " estado: " + funcion.getFlgActivo());
        adicionarMensaje("Creacion","Funcion creado satisfactoriamente");
    }
    
    public void editar(Funcion entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtFuncion() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Funcion editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Funcion entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtFuncion() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Funcion anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
