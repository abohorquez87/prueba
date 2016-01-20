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
import pe.gob.mimp.sispoi.fachada.MesFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Mes;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class MesAdministrado extends AdministradorAbstracto implements Serializable{
    private Mes entidad;

    private Mes entidadSeleccionada;
	
    private List<Mes> entidades;

    @EJB
    private MesFacadeLocal fachada;
    /**
     * Creates a new instance of MesAdministrado
     */
    public MesAdministrado() {
        setEntidad(new Mes());
        setEntidadSeleccionada(new Mes());
    }

    /**
     * @return the entidad
     */
    public Mes getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Mes entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Mes getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Mes entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Mes> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Mes> entidades) {
        this.entidades = entidades;
    }
    
    public Mes getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Mes entidad) throws UnknownHostException {
        Mes mes = new Mes();

        mes.setTxtMes(entidad.getTxtMes());

        mes.setTxtPc(Util.obtenerNombreCliente());
        mes.setTxtIp(Util.obtenerIPPublicaCliente());
        mes.setFecEdicion(new Date());
        
        mes.setFlgActivo(BigInteger.ONE);
        mes.setNidUsuario(BigInteger.ONE);

        this.fachada.create(mes);

        System.out.println("Entidad creada: " + mes.getTxtMes() + " estado: " + mes.getFlgActivo());
        adicionarMensaje("Creacion","Mes creado satisfactoriamente");
    }
    
    public void editar(Mes entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtMes() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Mes editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Mes entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtMes() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Mes anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
