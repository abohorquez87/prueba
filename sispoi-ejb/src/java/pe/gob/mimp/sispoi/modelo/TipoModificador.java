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
@Table(name = "TIPO_MODIFICADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoModificador.findAll", query = "SELECT t FROM TipoModificador t"),
    @NamedQuery(name = "TipoModificador.findByNidTipoModificador", query = "SELECT t FROM TipoModificador t WHERE t.nidTipoModificador = :nidTipoModificador"),
    @NamedQuery(name = "TipoModificador.findByTxtTipoModificador", query = "SELECT t FROM TipoModificador t WHERE t.txtTipoModificador = :txtTipoModificador"),
    @NamedQuery(name = "TipoModificador.findByFlgActivo", query = "SELECT t FROM TipoModificador t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TipoModificador.findByNidUsuario", query = "SELECT t FROM TipoModificador t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TipoModificador.findByTxtPc", query = "SELECT t FROM TipoModificador t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TipoModificador.findByTxtIp", query = "SELECT t FROM TipoModificador t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TipoModificador.findByFecEdicion", query = "SELECT t FROM TipoModificador t WHERE t.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "TipoModificador.findByTxtCodigoModificador", query = "SELECT t FROM TipoModificador t WHERE t.txtCodigoModificador = :txtCodigoModificador")})
public class TipoModificador implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TIPO_MODIFICADOR", sequenceName = "SQ_TIPO_MODIFICADOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_MODIFICADOR")
    @Column(name = "NID_TIPO_MODIFICADOR")
    private BigDecimal nidTipoModificador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_TIPO_MODIFICADOR")
    private String txtTipoModificador;
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
    @Column(name = "TXT_CODIGO_MODIFICADOR")
    private String txtCodigoModificador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoModificador", fetch = FetchType.LAZY)
    private List<AsignacionActividad> asignacionActividadList;

    public TipoModificador() {
    }

    public TipoModificador(BigDecimal nidTipoModificador) {
        this.nidTipoModificador = nidTipoModificador;
    }

    public TipoModificador(BigDecimal nidTipoModificador, String txtTipoModificador, BigInteger nidUsuario) {
        this.nidTipoModificador = nidTipoModificador;
        this.txtTipoModificador = txtTipoModificador;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidTipoModificador() {
        return nidTipoModificador;
    }

    public void setNidTipoModificador(BigDecimal nidTipoModificador) {
        this.nidTipoModificador = nidTipoModificador;
    }

    public String getTxtTipoModificador() {
        return txtTipoModificador;
    }

    public void setTxtTipoModificador(String txtTipoModificador) {
        this.txtTipoModificador = txtTipoModificador;
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

    public String getTxtCodigoModificador() {
        return txtCodigoModificador;
    }

    public void setTxtCodigoModificador(String txtCodigoModificador) {
        this.txtCodigoModificador = txtCodigoModificador;
    }

    @XmlTransient
    public List<AsignacionActividad> getAsignacionActividadList() {
        return asignacionActividadList;
    }

    public void setAsignacionActividadList(List<AsignacionActividad> asignacionActividadList) {
        this.asignacionActividadList = asignacionActividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoModificador != null ? nidTipoModificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoModificador)) {
            return false;
        }
        TipoModificador other = (TipoModificador) object;
        if ((this.nidTipoModificador == null && other.nidTipoModificador != null) || (this.nidTipoModificador != null && !this.nidTipoModificador.equals(other.nidTipoModificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.TipoModificador[ nidTipoModificador=" + nidTipoModificador + " ]";
    }
    
}
