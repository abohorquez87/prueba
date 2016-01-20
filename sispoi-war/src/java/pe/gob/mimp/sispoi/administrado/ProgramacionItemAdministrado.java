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
    import pe.gob.mimp.sispoi.fachada.ProgramacionItemFacadeLocal;
    import pe.gob.mimp.sispoi.modelo.ProgramacionItem;
    import pe.gob.mimp.sispoi.util.Util;

    /**
     *
     * @author desarrollador
     */
    @ManagedBean
    @SessionScoped
    public class ProgramacionItemAdministrado extends AdministradorAbstracto implements Serializable{
        private ProgramacionItem entidad;

        private ProgramacionItem entidadSeleccionada;

        private List<ProgramacionItem> entidades;

        @EJB
        private ProgramacionItemFacadeLocal fachada;
        /**
         * Creates a new instance of ProgramacionItemAdministrado
         */
        public ProgramacionItemAdministrado() {
            setEntidad(new ProgramacionItem());
            setEntidadSeleccionada(new ProgramacionItem());
        }

        /**
         * @return the entidad
         */
        public ProgramacionItem getEntidad() {
            return entidad;
        }

        /**
         * @param entidad the entidad to set
         */
        public void setEntidad(ProgramacionItem entidad) {
            this.entidad = entidad;
        }

        /**
         * @return the entidadSeleccionada
         */
        public ProgramacionItem getEntidadSeleccionada() {
            return entidadSeleccionada;
        }

        /**
         * @param entidadSeleccionada the entidadSeleccionada to set
         */
        public void setEntidadSeleccionada(ProgramacionItem entidadSeleccionada) {
            this.entidadSeleccionada = entidadSeleccionada;
        }

        /**
         * @return the entidades
         */
        public List<ProgramacionItem> getEntidades() {
            entidades = fachada.findAll();
            return entidades;
        }

        /**
         * @param entidades the entidades to set
         */
        public void setEntidades(List<ProgramacionItem> entidades) {
            this.entidades = entidades;
        }

        public ProgramacionItem getEntidad(String id) {
            return this.fachada.find(new BigDecimal(id));
        }

        public void crear(ProgramacionItem entidad) throws UnknownHostException {
            ProgramacionItem programacionItem = new ProgramacionItem();

            programacionItem.setTxtProgramacionItem(entidad.getTxtProgramacionItem());

            programacionItem.setTxtPc(Util.obtenerNombreCliente());
            programacionItem.setTxtIp(Util.obtenerIPPublicaCliente());
            programacionItem.setFecEdicion(new Date());

            programacionItem.setFlgActivo(BigInteger.ONE);
            programacionItem.setNidUsuario(BigInteger.ONE);

            this.fachada.create(programacionItem);

            System.out.println("Entidad creada: " + programacionItem.getTxtProgramacionItem() + " estado: " + programacionItem.getFlgActivo());
            adicionarMensaje("Creacion","ProgramacionItem creado satisfactoriamente");
        }

        public void editar(ProgramacionItem entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad actualizada: " + entidadSeleccionada.getTxtProgramacionItem() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Edicion","ProgramacionItem editado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }

        public void anular(ProgramacionItem entidadSeleccionada) throws UnknownHostException {
            if(null != entidadSeleccionada)
            {
                entidadSeleccionada.setTxtPc(Util.obtenerNombreCliente());
                entidadSeleccionada.setTxtIp(Util.obtenerIPPublicaCliente());
                entidadSeleccionada.setFecEdicion(new Date());

                entidadSeleccionada.setFlgActivo(BigInteger.ZERO);

                this.fachada.edit(entidadSeleccionada);

                System.out.println("Entidad anulada: " + entidadSeleccionada.getTxtProgramacionItem() + " estado: " + entidadSeleccionada.getFlgActivo());
                adicionarMensaje("Anulacion","ProgramacionItem anulado satisfactoriamente");
            }

            this.entidadSeleccionada = entidadSeleccionada;
        }
    }
