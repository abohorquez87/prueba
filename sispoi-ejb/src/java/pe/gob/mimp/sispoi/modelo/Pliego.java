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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PLIEGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pliego.findAll", query = "SELECT p FROM Pliego p"),
    @NamedQuery(name = "Pliego.findByNidPliego", query = "SELECT p FROM Pliego p WHERE p.nidPliego = :nidPliego"),
    @NamedQuery(name = "Pliego.findByTxtCodigoPliego", query = "SELECT p FROM Pliego p WHERE p.txtCodigoPliego = :txtCodigoPliego"),
    @NamedQuery(name = "Pliego.findByTxtPliego", query = "SELECT p FROM Pliego p WHERE p.txtPliego = :txtPliego"),
    @NamedQuery(name = "Pliego.findByFlgActivo", query = "SELECT p FROM Pliego p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "Pliego.findByNidUsuario", query = "SELECT p FROM Pliego p WHERE p.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Pliego.findByTxtPc", query = "SELECT p FROM Pliego p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "Pliego.findByTxtIp", query = "SELECT p FROM Pliego p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "Pliego.findByFecEdicion", query = "SELECT p FROM Pliego p WHERE p.fecEdicion = :fecEdicion")})
public class Pliego implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PLIEGO", sequenceName = "SQ_PLIEGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PLIEGO")
    @Column(name = "NID_PLIEGO")
    private BigDecimal nidPliego;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_PLIEGO")
    private String txtCodigoPliego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_PLIEGO")
    private String txtPliego;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pliego", fetch = FetchType.LAZY)
    private List<UnidadEjecutora> unidadEjecutoraList;
    @JoinColumn(name = "NID_SECTOR", referencedColumnName = "NID_SECTOR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sector sector;

    public Pliego() {
    }

    public Pliego(BigDecimal nidPliego) {
        this.nidPliego = nidPliego;
    }

    public Pliego(BigDecimal nidPliego, String txtPliego, BigInteger nidUsuario) {
        this.nidPliego = nidPliego;
        this.txtPliego = txtPliego;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidPliego() {
        return nidPliego;
    }

    public void setNidPliego(BigDecimal nidPliego) {
        this.nidPliego = nidPliego;
    }

    public String getTxtCodigoPliego() {
        return txtCodigoPliego;
    }

    public void setTxtCodigoPliego(String txtCodigoPliego) {
        this.txtCodigoPliego = txtCodigoPliego;
    }

    public String getTxtPliego() {
        return txtPliego;
    }

    public void setTxtPliego(String txtPliego) {
        this.txtPliego = txtPliego;
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

    @XmlTransient
    public List<UnidadEjecutora> getUnidadEjecutoraList() {
        return unidadEjecutoraList;
    }

    public void setUnidadEjecutoraList(List<UnidadEjecutora> unidadEjecutoraList) {
        this.unidadEjecutoraList = unidadEjecutoraList;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidPliego != null ? nidPliego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pliego)) {
            return false;
        }
        Pliego other = (Pliego) object;
        if ((this.nidPliego == null && other.nidPliego != null) || (this.nidPliego != null && !this.nidPliego.equals(other.nidPliego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Pliego[ nidPliego=" + nidPliego + " ]";
    }
    
}
