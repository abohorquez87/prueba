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
    import pe.gob.mimp.sispoi.fachada.EstadoProgramacionFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.EstadoProgramacion;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class EstadoProgramacionAdministrado extends AdministradorAbstracto implements Serializable{
        private EstadoProgramacion entidad;

        private EstadoProgramacion entidadSeleccionada;

        private List<EstadoProgramacion> entidades;

        @EJB
        private EstadoProgramacionFacadeLocal fachada;
        /**
         * Creates a new instance of EstadoProgramacionAdministrado
         */
        public EstadoProgramacionAdministrado() {
            setEntidad(new EstadoProgramacion());
            setEntidadSeleccionada(new EstadoProgramacion());
        }

        /**
         * @return the entidad
         */
        public EstadoProgramacion getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(EstadoProgramacion entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public EstadoProgramacion getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(EstadoProgramacion entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<EstadoProgramacion> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<EstadoProgramacion> entidades) {
            this.entidades = entidades;
        }

        public EstadoProgramacion getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(EstadoProgramacion entidad) throws UnknownHostException {
            EstadoProgramacion estadoProgramacion = new EstadoProgramacion();

            estadoProgramacion.setTxtEtdoProgramacion(entidad.getTxtEtdoProgramacion());
            estadoProgramacion.setTxtPc(Util.obtenerNombreCliente());
            estadoProgramacion.setTxtIp(Util.obtenerIPPublicaCliente());
            estadoProgramacion.setFecEdicion(new Date());

            estadoProgramacion.setFlgActivo(BigInteger.ONE);
            estadoProgramacion.setNidUsuario(BigInteger.ONE);

            this.fachada.create(estadoProgramacion);

            System.out.println("Entidad creada: " + estadoProgramacion.getTxtEtdoProgramacion() + " estado: " + estadoProgramacion.getFlgActivo());
            adicionarMensaje("Creacion","Estado Programacion creado satisfactoriamente");
        }

        public void editar(EstadoProgramacion entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtEtdoProgramacion() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","Estado Programacion editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }

        public void anular(EstadoProgramacion entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtEtdoProgramacion() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","Estado Programacion anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
