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
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.gob.mimp.sispoi.fachada.EstadoProgramacionFacadeLocal;
import pe.gob.mimp.sispoi.fachada.ObjetivoEstrategicoFacadeLocal;
import pe.gob.mimp.sispoi.fachada.ProgramacionFacadeLocal;
import pe.gob.mimp.sispoi.fachada.UnidadEjecutoraFacadeLocal;
import pe.gob.mimp.sispoi.modelo.EstadoProgramacion;
import pe.gob.mimp.sispoi.modelo.Periodo;
import pe.gob.mimp.sispoi.modelo.Pliego;
import pe.gob.mimp.sispoi.modelo.Programacion;
import pe.gob.mimp.sispoi.modelo.UnidadEjecutora;
import pe.gob.mimp.sispoi.util.Util;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@SessionScoped
public class ProgramacionAdministrado extends AdministradorAbstracto implements Serializable{
    private Programacion entidad;

    private Programacion entidadSeleccionada;
	
    private List<Programacion> entidades;

    @EJB
    private ProgramacionFacadeLocal fachada;
    
    @EJB
    private UnidadEjecutoraFacadeLocal fachadaUnidadEjecutora;
    
    @EJB
    private ObjetivoEstrategicoFacadeLocal fachadaObjetivoEstrategico;
    
    @EJB
    private EstadoProgramacionFacadeLocal fachadaEstadoProgramacion;
    /**
     * Creates a new instance of ActividadProgramadaAdministrado
     */
    public ProgramacionAdministrado() {
        setEntidad(new Programacion());
        setEntidadSeleccionada(new Programacion());
    }

    /**
     * @return the entidad
     */
    public Programacion getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(Programacion entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the entidadSeleccionada
     */
    public Programacion getEntidadSeleccionada() {
        return entidadSeleccionada;
    }

    /**
     * @param entidadSeleccionada the entidadSeleccionada to set
     */
    public void setEntidadSeleccionada(Programacion entidadSeleccionada) {
        this.entidadSeleccionada = entidadSeleccionada;
    }

    /**
     * @return the entidades
     */
    public List<Programacion> getEntidades() {
        entidades = fachada.findAll();
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<Programacion> entidades) {
        this.entidades = entidades;
    }
    
    public Programacion getEntidad(String id) {
        return this.fachada.find(new BigDecimal(id));
    }
    
    public void crear(Programacion entidad) throws UnknownHostException {
        Programacion programacion = new Programacion();

        programacion.setTxtPc(Util.obtenerNombreCliente());
        programacion.setTxtIp(Util.obtenerIPPublicaCliente());
        programacion.setFecEdicion(new Date());
        
        programacion.setFlgActivo(BigInteger.ONE);
        programacion.setNidUsuario(BigInteger.ONE);

        this.fachada.create(programacion);

        System.out.println("Entidad creada: " + programacion.getNidProgramacion() + " estado: " + programacion.getFlgActivo());
        adicionarMensaje("Creacion","Tipo Actividad Programada creado satisfactoriamente");
    }
    
    public void editar(Programacion entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad actualizada: " + entidadSeleccionada.getNidProgramacion() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Edicion","Tipo Actividad Programada editado satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    public void anular(Programacion entidadSeleccionada) throws UnknownHostException {
        if(null != entidadSeleccionada)
        {
            entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
            entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
            entidadSeleccionada.setFecEdicion(new Date());
            
            entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

            this.fachada.edit(entidadSeleccionada);

            System.out.println("Entidad anulada: " + entidadSeleccionada.getNidProgramacion() + " estado: " + entidadSeleccionada.getFlgActivo());
            adicionarMensaje("Anulacion","programacion anulada satisfactoriamente");
        }

        this.entidadSeleccionada = entidadSeleccionada;
    }
    
    /**Este metodo debe generar una Programacion por cada unidad ejecutora que se tenga registrada, teniendo como dato obligatorio la fecha*/
    public void generar(Periodo periodo) throws UnknownHostException {
        if(null == periodo)
        {
            adicionarMensajeError("Generacion","No se ha seleccionado el año de ejecucion");
            System.out.println("No se ha seleccionado el año de ejecucion");
        }
        else
        {
            System.out.println("SI se ha seleccionado el año de ejecucion");
            
            List<UnidadEjecutora> unidadesEjecutoras = fachadaUnidadEjecutora.findAll();
            
            Iterator itue = unidadesEjecutoras.iterator();
            
            while(itue.hasNext())
            {
                UnidadEjecutora unidadEjecutora = (UnidadEjecutora)itue.next();
                
                System.out.println("Unidad Ejecutora: " + unidadEjecutora.getTxtUnidadEjecutora());
                
                Programacion programacion = new Programacion();

                programacion.setUnidadEjecutora(unidadEjecutora);
                programacion.setObjetivoEstrategico(fachadaObjetivoEstrategico.findAll().get(0));
                
                programacion.setTxtPc(Util.obtenerNombreCliente());
                programacion.setTxtIp(Util.obtenerIPPublicaCliente());
                programacion.setFecEdicion(new Date());

                programacion.setFlgActivo(BigInteger.ONE);
                programacion.setNidUsuario(BigInteger.ONE);

                this.fachada.create(programacion);
            }
            
            adicionarMensaje("Generaciòn","Se generaron propuestas vacias");
        }
    }
    
    public List<Programacion> getEntidadesRegistradas(Pliego pliego, UnidadEjecutora unidadEjecutora, Periodo periodo) {
        
        List<EstadoProgramacion> estadoProgramacion = fachadaEstadoProgramacion.findAllByField("txtEtdoProgramacion", "APROBADO");
        
        if((null != estadoProgramacion) && (0 < estadoProgramacion.size()))
        {
            entidades = fachada.getProgramacionSeguimiento(true, estadoProgramacion.get(0));
            Iterator<Programacion> it= entidades.iterator();
 
            while(it.hasNext()) 
            {
                Programacion programacion = it.next();

                System.out.println("programacion: " + programacion.getNidProgramacion());
            }
        }
        else
        {
            System.out.println("No se pudo encontrar el Estado Programacion con codigo: 1");
        }

        return entidades;
    }
}
