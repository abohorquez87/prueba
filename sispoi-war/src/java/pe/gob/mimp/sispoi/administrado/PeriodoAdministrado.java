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
    import pe.gob.mimp.sispoi.fachada.PeriodoFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.Periodo;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class PeriodoAdministrado extends AdministradorAbstracto implements Serializable{
        private Periodo entidad;

        private Periodo entidadSeleccionada;

        private List<Periodo> entidades;

        @EJB
        private PeriodoFacadeLocal fachada;
        /**
         * Creates a new instance of PeriodoAdministrado
         */
        public PeriodoAdministrado() {
            setEntidad(new Periodo());
            setEntidadSeleccionada(new Periodo());
        }

        /**
         * @return the entidad
         */
        public Periodo getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(Periodo entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public Periodo getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(Periodo entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<Periodo> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<Periodo> entidades) {
            this.entidades = entidades;
        }

        public Periodo getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(Periodo entidad) throws UnknownHostException {
            Periodo periodo = new Periodo();

            periodo.setTxtPeriodo(entidad.getTxtPeriodo());

            periodo.setTxtPc(Util.obtenerNombreCliente());
            periodo.setTxtIp(Util.obtenerIPPublicaCliente());
            periodo.setFecEdicion(new Date());

            periodo.setFlgActivo(BigInteger.ONE);
            periodo.setNidUsuario(BigInteger.ONE);

            this.fachada.create(periodo);

            System.out.println("Entidad creada: " + periodo.getTxtPeriodo() + " estado: " + periodo.getFlgActivo());
            adicionarMensaje("Creacion","Periodo creado satisfactoriamente");
        }

        public void editar(Periodo entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtPeriodo() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","Periodo editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }

        public void anular(Periodo entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtPeriodo() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","Periodo anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
