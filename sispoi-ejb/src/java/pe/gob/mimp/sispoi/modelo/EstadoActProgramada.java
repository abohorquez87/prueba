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
@Table(name = "ESTADO_ACT_PROGRAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoActProgramada.findAll", query = "SELECT e FROM EstadoActProgramada e"),
    @NamedQuery(name = "EstadoActProgramada.findByNidEstadoActProgramada", query = "SELECT e FROM EstadoActProgramada e WHERE e.nidEstadoActProgramada = :nidEstadoActProgramada"),
    @NamedQuery(name = "EstadoActProgramada.findByTxtEstadoActProgramada", query = "SELECT e FROM EstadoActProgramada e WHERE e.txtEstadoActProgramada = :txtEstadoActProgramada"),
    @NamedQuery(name = "EstadoActProgramada.findByFlgActivo", query = "SELECT e FROM EstadoActProgramada e WHERE e.flgActivo = :flgActivo"),
    @NamedQuery(name = "EstadoActProgramada.findByNidUsuario", query = "SELECT e FROM EstadoActProgramada e WHERE e.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "EstadoActProgramada.findByTxtPc", query = "SELECT e FROM EstadoActProgramada e WHERE e.txtPc = :txtPc"),
    @NamedQuery(name = "EstadoActProgramada.findByTxtIp", query = "SELECT e FROM EstadoActProgramada e WHERE e.txtIp = :txtIp"),
    @NamedQuery(name = "EstadoActProgramada.findByFecEdicion", query = "SELECT e FROM EstadoActProgramada e WHERE e.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "EstadoActProgramada.findByTxtCodigoEstadoActPro", query = "SELECT e FROM EstadoActProgramada e WHERE e.txtCodigoEstadoActPro = :txtCodigoEstadoActPro")})
public class EstadoActProgramada implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ESTADO_ACT_PROGRAMADA", sequenceName = "SQ_ESTADO_ACT_PROGRAMADA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO_ACT_PROGRAMADA")
    @Column(name = "NID_ESTADO_ACT_PROGRAMADA")
    private BigDecimal nidEstadoActProgramada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_ESTADO_ACT_PROGRAMADA")
    private String txtEstadoActProgramada;
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
    @Column(name = "TXT_CODIGO_ESTADO_ACT_PRO")
    private String txtCodigoEstadoActPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoActProgramada", fetch = FetchType.LAZY)
    private List<DetalleActProgramada> detalleActProgramadaList;

    public EstadoActProgramada() {
    }

    public EstadoActProgramada(BigDecimal nidEstadoActProgramada) {
        this.nidEstadoActProgramada = nidEstadoActProgramada;
    }

    public EstadoActProgramada(BigDecimal nidEstadoActProgramada, String txtEstadoActProgramada, BigInteger nidUsuario) {
        this.nidEstadoActProgramada = nidEstadoActProgramada;
        this.txtEstadoActProgramada = txtEstadoActProgramada;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidEstadoActProgramada() {
        return nidEstadoActProgramada;
    }

    public void setNidEstadoActProgramada(BigDecimal nidEstadoActProgramada) {
        this.nidEstadoActProgramada = nidEstadoActProgramada;
    }

    public String getTxtEstadoActProgramada() {
        return txtEstadoActProgramada;
    }

    public void setTxtEstadoActProgramada(String txtEstadoActProgramada) {
        this.txtEstadoActProgramada = txtEstadoActProgramada;
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

    public String getTxtCodigoEstadoActPro() {
        return txtCodigoEstadoActPro;
    }

    public void setTxtCodigoEstadoActPro(String txtCodigoEstadoActPro) {
        this.txtCodigoEstadoActPro = txtCodigoEstadoActPro;
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
        hash += (nidEstadoActProgramada != null ? nidEstadoActProgramada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoActProgramada)) {
            return false;
        }
        EstadoActProgramada other = (EstadoActProgramada) object;
        if ((this.nidEstadoActProgramada == null && other.nidEstadoActProgramada != null) || (this.nidEstadoActProgramada != null && !this.nidEstadoActProgramada.equals(other.nidEstadoActProgramada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.EstadoActProgramada[ nidEstadoActProgramada=" + nidEstadoActProgramada + " ]";
    }
    
}
