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
import pe.gob.mimp.sispoi.fachada.DepartamentoFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Departamento;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class DepartamentoAdministrado extends AdministradorAbstracto implements Serializable{
    private Departamento entidad;

    private Departamento entidadSeleccionada;
	
    private List<Departamento> entidades;

    @EJB
    private DepartamentoFacadeLocal fachada;
    /**
     * Creates a new instance of PeriodoAdministrado
     */
    public DepartamentoAdministrado() {
        setEntidad(new Departamento());
        setEntidadSeleccionada(new Departamento());
    }

    /**
     * @return the entidad
     */
    public Departamento getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Departamento entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Departamento getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Departamento entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Departamento> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Departamento> entidades) {
        this.entidades = entidades;
    }
    
    public Departamento getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Departamento entidad) throws UnknownHostException {
        Departamento departamento = new Departamento();

        departamento.setTxtDepartamento(entidad.getTxtDepartamento());

        departamento.setTxtPc(Util.obtenerNombreCliente());
        departamento.setTxtIp(Util.obtenerIPPublicaCliente());
        departamento.setFecEdicion(new Date());
        
        departamento.setFlgActivo(BigInteger.ONE);
        departamento.setNidUsuario(BigInteger.ONE);

        this.fachada.create(departamento);

        System.out.println("Entidad creada: " + departamento.getTxtDepartamento() + " estado: " + departamento.getFlgActivo());
        adicionarMensaje("Creacion","Departamento creado satisfactoriamente");
    }
    
    public void editar(Departamento entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtDepartamento() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Departamento editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Departamento entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtDepartamento() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Departamento anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
