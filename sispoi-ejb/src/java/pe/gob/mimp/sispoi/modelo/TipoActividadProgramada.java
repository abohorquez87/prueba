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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "TIPO_ACTIVIDAD_PROGRAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividadProgramada.findAll", query = "SELECT t FROM TipoActividadProgramada t"),
    @NamedQuery(name = "TipoActividadProgramada.findByNidTipoActividadProgramada", query = "SELECT t FROM TipoActividadProgramada t WHERE t.nidTipoActividadProgramada = :nidTipoActividadProgramada"),
    @NamedQuery(name = "TipoActividadProgramada.findByTxtTipoActividadProgramada", query = "SELECT t FROM TipoActividadProgramada t WHERE t.txtTipoActividadProgramada = :txtTipoActividadProgramada"),
    @NamedQuery(name = "TipoActividadProgramada.findByFlgActivo", query = "SELECT t FROM TipoActividadProgramada t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TipoActividadProgramada.findByNidUsuario", query = "SELECT t FROM TipoActividadProgramada t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TipoActividadProgramada.findByTxtPc", query = "SELECT t FROM TipoActividadProgramada t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TipoActividadProgramada.findByTxtIp", query = "SELECT t FROM TipoActividadProgramada t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TipoActividadProgramada.findByFecEdicion", query = "SELECT t FROM TipoActividadProgramada t WHERE t.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "TipoActividadProgramada.findByTxtCodigoTipoActProg", query = "SELECT t FROM TipoActividadProgramada t WHERE t.txtCodigoTipoActProg = :txtCodigoTipoActProg")})
public class TipoActividadProgramada implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TIPO_ACTIVIDAD_PROGRAMADA", sequenceName = "SQ_TIPO_ACTIVIDAD_PROGRAMADA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_ACTIVIDAD_PROGRAMADA")
    @Column(name = "NID_TIPO_ACTIVIDAD_PROGRAMADA")
    private BigDecimal nidTipoActividadProgramada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_TIPO_ACTIVIDAD_PROGRAMADA")
    private String txtTipoActividadProgramada;
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
    @Column(name = "TXT_CODIGO_TIPO_ACT_PROG")
    private String txtCodigoTipoActProg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoActividadProgramada", fetch = FetchType.LAZY)
    private List<DetalleActProgramada> detalleActProgramadaList;

    public TipoActividadProgramada() {
    }

    public TipoActividadProgramada(BigDecimal nidTipoActividadProgramada) {
        this.nidTipoActividadProgramada = nidTipoActividadProgramada;
    }

    public TipoActividadProgramada(BigDecimal nidTipoActividadProgramada, String txtTipoActividadProgramada, BigInteger nidUsuario) {
        this.nidTipoActividadProgramada = nidTipoActividadProgramada;
        this.txtTipoActividadProgramada = txtTipoActividadProgramada;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidTipoActividadProgramada() {
        return nidTipoActividadProgramada;
    }

    public void setNidTipoActividadProgramada(BigDecimal nidTipoActividadProgramada) {
        this.nidTipoActividadProgramada = nidTipoActividadProgramada;
    }

    public String getTxtTipoActividadProgramada() {
        return txtTipoActividadProgramada;
    }

    public void setTxtTipoActividadProgramada(String txtTipoActividadProgramada) {
        this.txtTipoActividadProgramada = txtTipoActividadProgramada;
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

    public String getTxtCodigoTipoActProg() {
        return txtCodigoTipoActProg;
    }

    public void setTxtCodigoTipoActProg(String txtCodigoTipoActProg) {
        this.txtCodigoTipoActProg = txtCodigoTipoActProg;
    }

    @XmlTransient
    public List<DetalleActProgramada> getDetalleActProgramadaList() {
        return detalleActProgramadaList;
    }

    public void setDetalleActProgramadaList(List<DetalleActProgramada> detalleActProgramadaList) {
        this.detalleActProgramadaList = detalleActProgramadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoActividadProgramada != null ? nidTipoActividadProgramada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividadProgramada)) {
            return false;
        }
        TipoActividadProgramada other = (TipoActividadProgramada) object;
        if ((this.nidTipoActividadProgramada == null && other.nidTipoActividadProgramada != null) || (this.nidTipoActividadProgramada != null && !this.nidTipoActividadProgramada.equals(other.nidTipoActividadProgramada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.TipoActividadProgramada[ nidTipoActividadProgramada=" + nidTipoActividadProgramada + " ]";
    }
    
}
