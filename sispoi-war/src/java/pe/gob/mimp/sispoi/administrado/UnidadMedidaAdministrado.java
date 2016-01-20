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
import pe.gob.mimp.sispoi.fachada.UnidadMedidaFacadeLocal;
import pe.gob.mimp.sispoi.modelo.UnidadMedida;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class UnidadMedidaAdministrado extends AdministradorAbstracto implements Serializable{
    private UnidadMedida entidad;

    private UnidadMedida entidadSeleccionada;
	
    private List<UnidadMedida> entidades;

    @EJB
    private UnidadMedidaFacadeLocal fachada;
    /**
     * Creates a new instance of UnidadMedidaAdministrado
     */
    public UnidadMedidaAdministrado() {
        setEntidad(new UnidadMedida());
        setEntidadSeleccionada(new UnidadMedida());
    }

    /**
     * @return the entidad
     */
    public UnidadMedida getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(UnidadMedida entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public UnidadMedida getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(UnidadMedida entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<UnidadMedida> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<UnidadMedida> entidades) {
        this.entidades = entidades;
    }
    
    public UnidadMedida getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(UnidadMedida entidad) throws UnknownHostException {
        UnidadMedida unidadMedida = new UnidadMedida();

        unidadMedida.setTxtUnidadMedida(entidad.getTxtUnidadMedida());

        unidadMedida.setTxtPc(Util.obtenerNombreCliente());
        unidadMedida.setTxtIp(Util.obtenerIPPublicaCliente());
        unidadMedida.setFecEdicion(new Date());
        
        unidadMedida.setFlgActivo(BigInteger.ONE);
        unidadMedida.setNidUsuario(BigInteger.ONE);

        this.fachada.create(unidadMedida);

        System.out.println("Entidad creada: " + unidadMedida.getTxtUnidadMedida() + " estado: " + unidadMedida.getFlgActivo());
        adicionarMensaje("Creacion","Unidad Medida creado satisfactoriamente");
    }
    
    public void editar(UnidadMedida entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtUnidadMedida() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Unidad Medida editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(UnidadMedida entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtUnidadMedida() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Unidad Medida anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
