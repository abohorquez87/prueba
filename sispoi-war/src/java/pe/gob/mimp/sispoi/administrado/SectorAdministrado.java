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
import pe.gob.mimp.sispoi.fachada.SectorFacadeLocal;
import pe.gob.mimp.sispoi.modelo.Sector;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class SectorAdministrado extends AdministradorAbstracto implements Serializable{
    private Sector entidad;

    private Sector entidadSeleccionada;
	
    private List<Sector> entidades;

    @EJB
    private SectorFacadeLocal fachada;
    /**
     * Creates a new instance of SectorAdministrado
     */
    public SectorAdministrado() {
        setEntidad(new Sector());
        setEntidadSeleccionada(new Sector());
    }

    /**
     * @return the entidad
     */
    public Sector getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Sector entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Sector getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Sector entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Sector> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Sector> entidades) {
        this.entidades = entidades;
    }
    
    public Sector getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Sector entidad) throws UnknownHostException {
        Sector sector = new Sector();

        sector.setTxtSector(entidad.getTxtSector());

        sector.setTxtPc(Util.obtenerNombreCliente());
        sector.setTxtIp(Util.obtenerIPPublicaCliente());
        sector.setFecEdicion(new Date());
        
        sector.setFlgActivo(BigInteger.ONE);
        sector.setNidUsuario(BigInteger.ONE);

        this.fachada.create(sector);

        System.out.println("Entidad creada: " + sector.getTxtSector() + " estado: " + sector.getFlgActivo());
        adicionarMensaje("Creacion","Sector creado satisfactoriamente");
    }
    
    public void editar(Sector entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtSector() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Sector editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Sector entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtSector() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Sector anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
