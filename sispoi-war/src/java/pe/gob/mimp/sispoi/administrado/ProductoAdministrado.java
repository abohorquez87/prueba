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
import pe.gob.mimp.sispoi.fachada.ProductoFacadeLocal;
import pe.gob.mimp.sispoi.modelo.CategoriaPresupuestal;
import pe.gob.mimp.sispoi.modelo.Producto;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class ProductoAdministrado extends AdministradorAbstracto implements Serializable{
    private Producto entidad;

    private Producto entidadSeleccionada;
	
    private List<Producto> entidades;

    @EJB
    private ProductoFacadeLocal fachada;
    /**
     * Creates a new instance of ProductoAdministrado
     */
    public ProductoAdministrado() {
        setEntidad(new Producto());
        setEntidadSeleccionada(new Producto());
    }

    /**
     * @return the entidad
     */
    public Producto getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Producto entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Producto getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Producto entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Producto> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Producto> entidades) {
        this.entidades = entidades;
    }
    
    public Producto getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Producto entidadSeleccionada, CategoriaPresupuestal categoriaSeleccionada) throws UnknownHostException {
        Producto producto = new Producto();

        producto.setTxtProducto(entidadSeleccionada.getTxtProducto());
        producto.setCategoriaPresupuestal(categoriaSeleccionada);

        producto.setTxtPc(Util.obtenerNombreCliente());
        producto.setTxtIp(Util.obtenerIPPublicaCliente());
        producto.setFecEdicion(new Date());
        
        producto.setFlgActivo(BigInteger.ONE);
        producto.setNidUsuario(BigInteger.ONE);

        this.fachada.create(producto);

        System.out.println("Entidad creada: " + producto.getTxtProducto() + " estado: " + producto.getFlgActivo());
        adicionarMensaje("Creacion","Producto creado satisfactoriamente");
    }
    
    public void editar(Producto entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtProducto() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Producto editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Producto entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtProducto() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","Producto anulado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
}
