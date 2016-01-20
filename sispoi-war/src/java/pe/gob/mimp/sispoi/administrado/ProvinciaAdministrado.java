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
    import pe.gob.mimp.sispoi.fachada.ProvinciaFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.Provincia;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class ProvinciaAdministrado extends AdministradorAbstracto implements Serializable{
        private Provincia entidad;

        private Provincia entidadSeleccionada;

        private List<Provincia> entidades;

        @EJB
        private ProvinciaFacadeLocal fachada;
        /**
         * Creates a new instance of ProvinciaAdministrado
         */
        public ProvinciaAdministrado() {
            setEntidad(new Provincia());
            setEntidadSeleccionada(new Provincia());
        }

        /**
         * @return the entidad
         */
        public Provincia getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(Provincia entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public Provincia getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(Provincia entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<Provincia> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<Provincia> entidades) {
            this.entidades = entidades;
        }

        public Provincia getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(Provincia entidad) throws UnknownHostException {
            Provincia provincia = new Provincia();

            provincia.setTxtProvincia(entidad.getTxtProvincia());

            provincia.setTxtPc(Util.obtenerNombreCliente());
            provincia.setTxtIp(Util.obtenerIPPublicaCliente());
            provincia.setFecEdicion(new Date());

            provincia.setFlgActivo(BigInteger.ONE);
            provincia.setNidUsuario(BigInteger.ONE);

            this.fachada.create(provincia);

            System.out.println("Entidad creada: " + provincia.getTxtProvincia() + " estado: " + provincia.getFlgActivo());
            adicionarMensaje("Creacion","Provincia creado satisfactoriamente");
        }

        public void editar(Provincia entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtProvincia() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","Provincia editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }

        public void anular(Provincia entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtProvincia() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","Provincia anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
