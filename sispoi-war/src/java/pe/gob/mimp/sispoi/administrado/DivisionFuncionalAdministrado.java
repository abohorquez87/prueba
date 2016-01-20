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
import pe.gob.mimp.sispoi.fachada.DivisionFuncionalFacadeLocal;
import pe.gob.mimp.sispoi.modelo.DivisionFuncional;
import pe.gob.mimp.sispoi.modelo.Funcion;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class DivisionFuncionalAdministrado extends AdministradorAbstracto implements Serializable{
    private DivisionFuncional entidad;

    private DivisionFuncional entidadSeleccionada;
	
    private List<DivisionFuncional> entidades;

    @EJB
    private DivisionFuncionalFacadeLocal fachada;
    /**
     * Creates a new instance of DivisionFuncionalAdministrado
     */
    public DivisionFuncionalAdministrado() {
        setEntidad(new DivisionFuncional());
        setEntidadSeleccionada(new DivisionFuncional());
    }

    /**
     * @return the entidad
     */
    public DivisionFuncional getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(DivisionFuncional entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public DivisionFuncional getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(DivisionFuncional entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<DivisionFuncional> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<DivisionFuncional> entidades) {
        this.entidades = entidades;
    }
    
    public DivisionFuncional getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(DivisionFuncional entidadSeleccionada, Funcion funcionProductoSeleccionada) throws UnknownHostException {
        DivisionFuncional divisionFuncional = new DivisionFuncional();

        divisionFuncional.setTxtDivisionFuncional(entidadSeleccionada.getTxtDivisionFuncional());
        divisionFuncional.setFuncion(funcionProductoSeleccionada);

        divisionFuncional.setTxtPc(Util.obtenerNombreCliente());
        divisionFuncional.setTxtIp(Util.obtenerIPPublicaCliente());
        divisionFuncional.setFecEdicion(new Date());
        
        divisionFuncional.setFlgActivo(BigInteger.ONE);
        divisionFuncional.setNidUsuario(BigInteger.ONE);

        this.fachada.create(divisionFuncional);

        System.out.println("Entidad creada: " + divisionFuncional.getTxtDivisionFuncional() + " estado: " + divisionFuncional.getFlgActivo());
        adicionarMensaje("Creacion","Division Funcional creado satisfactoriamente");
    }
    
    public void editar(DivisionFuncional entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtDivisionFuncional() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Division Funcional editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(DivisionFuncional entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtDivisionFuncional() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Division Funcional anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
