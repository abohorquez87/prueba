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
@Table(name = "SECTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findByNidSector", query = "SELECT s FROM Sector s WHERE s.nidSector = :nidSector"),
    @NamedQuery(name = "Sector.findByTxtCodigoSector", query = "SELECT s FROM Sector s WHERE s.txtCodigoSector = :txtCodigoSector"),
    @NamedQuery(name = "Sector.findByTxtSector", query = "SELECT s FROM Sector s WHERE s.txtSector = :txtSector"),
    @NamedQuery(name = "Sector.findByFlgActivo", query = "SELECT s FROM Sector s WHERE s.flgActivo = :flgActivo"),
    @NamedQuery(name = "Sector.findByNidUsuario", query = "SELECT s FROM Sector s WHERE s.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Sector.findByTxtPc", query = "SELECT s FROM Sector s WHERE s.txtPc = :txtPc"),
    @NamedQuery(name = "Sector.findByTxtIp", query = "SELECT s FROM Sector s WHERE s.txtIp = :txtIp"),
    @NamedQuery(name = "Sector.findByFecEdicion", query = "SELECT s FROM Sector s WHERE s.fecEdicion = :fecEdicion")})
public class Sector implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_SECTOR", sequenceName = "SQ_SECTOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SECTOR")
    @Column(name = "NID_SECTOR")
    private BigDecimal nidSector;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_SECTOR")
    private String txtCodigoSector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_SECTOR")
    private String txtSector;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sector", fetch = FetchType.LAZY)
    private List<Pliego> pliegoList;

    public Sector() {
    }

    public Sector(BigDecimal nidSector) {
        this.nidSector = nidSector;
    }

    public Sector(BigDecimal nidSector, String txtSector, BigInteger nidUsuario) {
        this.nidSector = nidSector;
        this.txtSector = txtSector;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidSector() {
        return nidSector;
    }

    public void setNidSector(BigDecimal nidSector) {
        this.nidSector = nidSector;
    }

    public String getTxtCodigoSector() {
        return txtCodigoSector;
    }

    public void setTxtCodigoSector(String txtCodigoSector) {
        this.txtCodigoSector = txtCodigoSector;
    }

    public String getTxtSector() {
        return txtSector;
    }

    public void setTxtSector(String txtSector) {
        this.txtSector = txtSector;
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
    public List<Pliego> getPliegoList() {
        return pliegoList;
    }

    public void setPliegoList(List<Pliego> pliegoList) {
        this.pliegoList = pliegoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidSector != null ? nidSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.nidSector == null && other.nidSector != null) || (this.nidSector != null && !this.nidSector.equals(other.nidSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Sector[ nidSector=" + nidSector + " ]";
    }
    
}
