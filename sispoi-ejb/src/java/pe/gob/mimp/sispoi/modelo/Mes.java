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
@Table(name = "MES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mes.findAll", query = "SELECT m FROM Mes m"),
    @NamedQuery(name = "Mes.findByNidMes", query = "SELECT m FROM Mes m WHERE m.nidMes = :nidMes"),
    @NamedQuery(name = "Mes.findByTxtMes", query = "SELECT m FROM Mes m WHERE m.txtMes = :txtMes"),
    @NamedQuery(name = "Mes.findByFlgActivo", query = "SELECT m FROM Mes m WHERE m.flgActivo = :flgActivo"),
    @NamedQuery(name = "Mes.findByNidUsuario", query = "SELECT m FROM Mes m WHERE m.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Mes.findByTxtPc", query = "SELECT m FROM Mes m WHERE m.txtPc = :txtPc"),
    @NamedQuery(name = "Mes.findByTxtIp", query = "SELECT m FROM Mes m WHERE m.txtIp = :txtIp"),
    @NamedQuery(name = "Mes.findByFecEdicion", query = "SELECT m FROM Mes m WHERE m.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Mes.findByTxtCodigoMes", query = "SELECT m FROM Mes m WHERE m.txtCodigoMes = :txtCodigoMes")})
public class Mes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_MES", sequenceName = "SQ_MES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MES")
    @Column(name = "NID_MES")
    private BigDecimal nidMes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TXT_MES")
    private String txtMes;
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
    @Column(name = "TXT_CODIGO_MES")
    private String txtCodigoMes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mes", fetch = FetchType.LAZY)
    private List<DetalleActProgramada> detalleActProgramadaList;

    public Mes() {
    }

    public Mes(BigDecimal nidMes) {
        this.nidMes = nidMes;
    }

    public Mes(BigDecimal nidMes, String txtMes, BigInteger nidUsuario) {
        this.nidMes = nidMes;
        this.txtMes = txtMes;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidMes() {
        return nidMes;
    }

    public void setNidMes(BigDecimal nidMes) {
        this.nidMes = nidMes;
    }

    public String getTxtMes() {
        return txtMes;
    }

    public void setTxtMes(String txtMes) {
        this.txtMes = txtMes;
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

    public String getTxtCodigoMes() {
        return txtCodigoMes;
    }

    public void setTxtCodigoMes(String txtCodigoMes) {
        this.txtCodigoMes = txtCodigoMes;
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
        hash += (nidMes != null ? nidMes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mes)) {
            return false;
        }
        Mes other = (Mes) object;
        if ((this.nidMes == null && other.nidMes != null) || (this.nidMes != null && !this.nidMes.equals(other.nidMes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Mes[ nidMes=" + nidMes + " ]";
    }
    
}
