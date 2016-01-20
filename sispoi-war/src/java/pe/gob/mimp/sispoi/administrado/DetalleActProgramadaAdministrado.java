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
    import pe.gob.mimp.sispoi.fachada.DetalleActProgramadaFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.DetalleActProgramada;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class DetalleActProgramadaAdministrado extends AdministradorAbstracto implements Serializable{
        private DetalleActProgramada entidad;

        private DetalleActProgramada entidadSeleccionada;

        private List<DetalleActProgramada> entidades;

        @EJB
        private DetalleActProgramadaFacadeLocal fachada;
        /**
         * Creates a new instance of DetalleActProgramadaAdministrado
         */
        public DetalleActProgramadaAdministrado() {
            setEntidad(new DetalleActProgramada());
            setEntidadSeleccionada(new DetalleActProgramada());
        }

        /**
         * @return the entidad
         */
        public DetalleActProgramada getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(DetalleActProgramada entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public DetalleActProgramada getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(DetalleActProgramada entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<DetalleActProgramada> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<DetalleActProgramada> entidades) {
            this.entidades = entidades;
        }

        public DetalleActProgramada getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(DetalleActProgramada entidad) throws UnknownHostException {
            DetalleActProgramada detalleActProgramada = new DetalleActProgramada();

            detalleActProgramada.setTxtDetalleActProgramada(entidad.getTxtDetalleActProgramada());

            detalleActProgramada.setTxtPc(Util.obtenerNombreCliente());
            detalleActProgramada.setTxtIp(Util.obtenerIPPublicaCliente());
            detalleActProgramada.setFecEdicion(new Date());

            detalleActProgramada.setFlgActivo(BigInteger.ONE);
            detalleActProgramada.setNidUsuario(BigInteger.ONE);

            this.fachada.create(detalleActProgramada);

            System.out.println("Entidad creada: " + detalleActProgramada.getTxtDetalleActProgramada() + " estado: " + detalleActProgramada.getFlgActivo());
            adicionarMensaje("Creacion","Grupo Funcional creado satisfactoriamente");
        }

        public void editar(DetalleActProgramada entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtDetalleActProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","Grupo Funcional editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
        
        public void anular(DetalleActProgramada entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtDetalleActProgramada() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","Grupo Funcional anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
