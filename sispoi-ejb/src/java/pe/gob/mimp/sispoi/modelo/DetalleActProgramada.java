/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.sispoi.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "DETALLE_ACT_PROGRAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleActProgramada.findAll", query = "SELECT d FROM DetalleActProgramada d"),
    @NamedQuery(name = "DetalleActProgramada.findByNidDetalleActProgramada", query = "SELECT d FROM DetalleActProgramada d WHERE d.nidDetalleActProgramada = :nidDetalleActProgramada"),
    @NamedQuery(name = "DetalleActProgramada.findByTxtDetalleActProgramada", query = "SELECT d FROM DetalleActProgramada d WHERE d.txtDetalleActProgramada = :txtDetalleActProgramada"),
    @NamedQuery(name = "DetalleActProgramada.findByFlgActivo", query = "SELECT d FROM DetalleActProgramada d WHERE d.flgActivo = :flgActivo"),
    @NamedQuery(name = "DetalleActProgramada.findByNidUsuario", query = "SELECT d FROM DetalleActProgramada d WHERE d.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "DetalleActProgramada.findByTxtPc", query = "SELECT d FROM DetalleActProgramada d WHERE d.txtPc = :txtPc"),
    @NamedQuery(name = "DetalleActProgramada.findByTxtIp", query = "SELECT d FROM DetalleActProgramada d WHERE d.txtIp = :txtIp"),
    @NamedQuery(name = "DetalleActProgramada.findByFecEdicion", query = "SELECT d FROM DetalleActProgramada d WHERE d.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "DetalleActProgramada.findByTxtCodigoDetalleActProg", query = "SELECT d FROM DetalleActProgramada d WHERE d.txtCodigoDetalleActProg = :txtCodigoDetalleActProg")})
public class DetalleActProgramada implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_DETALLE_ACT_PROGRAMADA", sequenceName = "SQ_DETALLE_ACT_PROGRAMADA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DETALLE_ACT_PROGRAMADA")
    @Column(name = "NID_DETALLE_ACT_PROGRAMADA")
    private BigDecimal nidDetalleActProgramada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_DETALLE_ACT_PROGRAMADA")
    private String txtDetalleActProgramada;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_DETALLE_ACT_PROG")
    private String txtCodigoDetalleActProg;
    @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadProgramada actividadProgramada;
    @JoinColumn(name = "NID_ESTADO_ACT_PROGRAMADA", referencedColumnName = "NID_ESTADO_ACT_PROGRAMADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoActProgramada estadoActProgramada;
    @JoinColumn(name = "NID_MES", referencedColumnName = "NID_MES")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mes mes;
    @JoinColumn(name = "NID_TIPO_ACT_PROGRAMADA", referencedColumnName = "NID_TIPO_ACTIVIDAD_PROGRAMADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoActividadProgramada tipoActividadProgramada;

    public DetalleActProgramada() {
    }

    public DetalleActProgramada(BigDecimal nidDetalleActProgramada) {
        this.nidDetalleActProgramada = nidDetalleActProgramada;
    }

    public DetalleActProgramada(BigDecimal nidDetalleActProgramada, String txtDetalleActProgramada, BigInteger nidUsuario) {
        this.nidDetalleActProgramada = nidDetalleActProgramada;
        this.txtDetalleActProgramada = txtDetalleActProgramada;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidDetalleActProgramada() {
        return nidDetalleActProgramada;
    }

    public void setNidDetalleActProgramada(BigDecimal nidDetalleActProgramada) {
        this.nidDetalleActProgramada = nidDetalleActProgramada;
    }

    public String getTxtDetalleActProgramada() {
        return txtDetalleActProgramada;
    }

    public void setTxtDetalleActProgramada(String txtDetalleActProgramada) {
        this.txtDetalleActProgramada = txtDetalleActProgramada;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public String getTxtPc() {
        return txtPc;
    }

    public void setTxtPc(String txtPc) {
        this.txtPc = txtPc;
    }

    public String getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(String txtIp) {
        this.txtIp = txtIp;
    }

    public Date getFecEdicion() {
        return fecEdicion;
    }

    public void setFecEdicion(Date fecEdicion) {
        this.fecEdicion = fecEdicion;
    }

    public String getTxtCodigoDetalleActProg() {
        return txtCodigoDetalleActProg;
    }

    public void setTxtCodigoDetalleActProg(String txtCodigoDetalleActProg) {
        this.txtCodigoDetalleActProg = txtCodigoDetalleActProg;
    }

    public ActividadProgramada getActividadProgramada() {
        return actividadProgramada;
    }

    public void setActividadProgramada(ActividadProgramada actividadProgramada) {
        this.actividadProgramada = actividadProgramada;
    }

    public EstadoActProgramada getEstadoActProgramada() {
        return estadoActProgramada;
    }

    public void setEstadoActProgramada(EstadoActProgramada estadoActProgramada) {
        this.estadoActProgramada = estadoActProgramada;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public TipoActividadProgramada getTipoActividadProgramada() {
        return tipoActividadProgramada;
    }

    public void setTipoActividadProgramada(TipoActividadProgramada tipoActividadProgramada) {
        this.tipoActividadProgramada = tipoActividadProgramada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDetalleActProgramada != null ? nidDetalleActProgramada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleActProgramada)) {
            return false;
        }
        DetalleActProgramada other = (DetalleActProgramada) object;
        if ((this.nidDetalleActProgramada == null && other.nidDetalleActProgramada != null) || (this.nidDetalleActProgramada != null && !this.nidDetalleActProgramada.equals(other.nidDetalleActProgramada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.DetalleActProgramada[ nidDetalleActProgramada=" + nidDetalleActProgramada + " ]";
    }
    
}
