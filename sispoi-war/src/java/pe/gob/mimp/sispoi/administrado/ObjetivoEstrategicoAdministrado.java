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
    import pe.gob.mimp.sispoi.fachada.ObjetivoEstrategicoFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.ObjetivoEstrategico;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class ObjetivoEstrategicoAdministrado extends AdministradorAbstracto implements Serializable{
        private ObjetivoEstrategico entidad;

        private ObjetivoEstrategico entidadSeleccionada;

        private List<ObjetivoEstrategico> entidades;

        @EJB
        private ObjetivoEstrategicoFacadeLocal fachada;
        /**
         * Creates a new instance of ObjetivoEstrategicoAdministrado
         */
        public ObjetivoEstrategicoAdministrado() {
            setEntidad(new ObjetivoEstrategico());
            setEntidadSeleccionada(new ObjetivoEstrategico());
        }

        /**
         * @return the entidad
         */
        public ObjetivoEstrategico getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(ObjetivoEstrategico entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public ObjetivoEstrategico getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(ObjetivoEstrategico entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<ObjetivoEstrategico> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<ObjetivoEstrategico> entidades) {
            this.entidades = entidades;
        }

        public ObjetivoEstrategico getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(ObjetivoEstrategico entidad) throws UnknownHostException {
            ObjetivoEstrategico objetivoEstrategico = new ObjetivoEstrategico();

            objetivoEstrategico.setTxtObjetivoEstrategico(entidad.getTxtObjetivoEstrategico());

            objetivoEstrategico.setTxtPc(Util.obtenerNombreCliente());
            objetivoEstrategico.setTxtIp(Util.obtenerIPPublicaCliente());
            objetivoEstrategico.setFecEdicion(new Date());

            objetivoEstrategico.setFlgActivo(BigInteger.ONE);
            objetivoEstrategico.setNidUsuario(BigInteger.ONE);

            this.fachada.create(objetivoEstrategico);

            System.out.println("Entidad creada: " + objetivoEstrategico.getTxtObjetivoEstrategico() + " estado: " + objetivoEstrategico.getFlgActivo());
            adicionarMensaje("Creacion","ObjetivoEstrategico creado satisfactoriamente");
        }

        public void editar(ObjetivoEstrategico entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtObjetivoEstrategico() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","ObjetivoEstrategico editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }

        public void anular(ObjetivoEstrategico entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtObjetivoEstrategico() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","ObjetivoEstrategico anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
