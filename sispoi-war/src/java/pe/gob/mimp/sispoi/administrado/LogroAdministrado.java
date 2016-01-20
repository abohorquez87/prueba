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
    import pe.gob.mimp.sispoi.fachada.LogroFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.Logro;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class LogroAdministrado extends AdministradorAbstracto implements Serializable{
        private Logro entidad;

        private Logro entidadSeleccionada;

        private List<Logro> entidades;

        @EJB
        private LogroFacadeLocal fachada;
        /**
         * Creates a new instance of LogroAdministrado
         */
        public LogroAdministrado() {
            setEntidad(new Logro());
            setEntidadSeleccionada(new Logro());
        }

        /**
         * @return the entidad
         */
        public Logro getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(Logro entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public Logro getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(Logro entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<Logro> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<Logro> entidades) {
            this.entidades = entidades;
        }

        public Logro getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(Logro entidad) throws UnknownHostException {
            Logro logro = new Logro();

            logro.setTxtLogro(entidad.getTxtLogro());

            logro.setTxtPc(Util.obtenerNombreCliente());
            logro.setTxtIp(Util.obtenerIPPublicaCliente());
            logro.setFecEdicion(new Date());

            logro.setFlgActivo(BigInteger.ONE);
            logro.setNidUsuario(BigInteger.ONE);

            this.fachada.create(logro);

            System.out.println("Entidad creada: " + logro.getTxtLogro() + " estado: " + logro.getFlgActivo());
            adicionarMensaje("Creacion","Logro creado satisfactoriamente");
        }

        public void editar(Logro entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtLogro() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","Logro editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }

        public void anular(Logro entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtLogro() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","Logro anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
