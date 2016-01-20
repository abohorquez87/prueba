package pe.gob.mimp.sispoi.administrado;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/////
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.gob.mimp.sispoi.fachada.CategoriaPresupuestalFacadeLocal;
import pe.gob.mimp.sispoi.modelo.CategoriaPresupuestal;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class CategoriaPresupuestalAdministrado extends AdministradorAbstracto implements Serializable{
    private CategoriaPresupuestal entidad;

    private CategoriaPresupuestal entidadSeleccionada;
	
    private List<CategoriaPresupuestal> entidades;

    @EJB
    private CategoriaPresupuestalFacadeLocal fachada;
    /**
     * Creates a new instance of PeriodoAdministrado
     */
    public CategoriaPresupuestalAdministrado() {
        setEntidad(new CategoriaPresupuestal());
        setEntidadSeleccionada(new CategoriaPresupuestal());
    }

    /**
     * @return the entidad
     */
    public CategoriaPresupuestal getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(CategoriaPresupuestal entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public CategoriaPresupuestal getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(CategoriaPresupuestal entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<CategoriaPresupuestal> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<CategoriaPresupuestal> entidades) {
        this.entidades = entidades;
    }
    
    public CategoriaPresupuestal getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(CategoriaPresupuestal entidad) throws UnknownHostException {
        CategoriaPresupuestal categoriaPresupuestal = new CategoriaPresupuestal();

        categoriaPresupuestal.setTxtCategoriaPresupuestal(entidad.getTxtCategoriaPresupuestal());

        categoriaPresupuestal.setTxtPc(Util.obtenerNombreCliente());
        categoriaPresupuestal.setTxtIp(Util.obtenerIPPublicaCliente());
        categoriaPresupuestal.setFecEdicion(new Date());
        
        categoriaPresupuestal.setFlgActivo(BigInteger.ONE);
        categoriaPresupuestal.setNidUsuario(BigInteger.ONE);

        this.fachada.create(categoriaPresupuestal);

        System.out.println("Entidad creada: " + categoriaPresupuestal.getTxtCategoriaPresupuestal()+ " estado: " + categoriaPresupuestal.getFlgActivo());
        adicionarMensaje("Creacion","Categoria Presupuestal creado satisfactoriamente");
    }
    
    public void editar(CategoriaPresupuestal entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtCategoriaPresupuestal()+ " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Categoria Presupuestal editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(CategoriaPresupuestal entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtCategoriaPresupuestal()+ " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Categoria Presupuestal anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
