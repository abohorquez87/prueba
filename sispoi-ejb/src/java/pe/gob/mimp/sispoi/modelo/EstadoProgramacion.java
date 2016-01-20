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
@Table(name = "ESTADO_PROGRAMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProgramacion.findAll", query = "SELECT e FROM EstadoProgramacion e"),
    @NamedQuery(name = "EstadoProgramacion.findByNidEtdoProgramacion", query = "SELECT e FROM EstadoProgramacion e WHERE e.nidEtdoProgramacion = :nidEtdoProgramacion"),
    @NamedQuery(name = "EstadoProgramacion.findByTxtEtdoProgramacion", query = "SELECT e FROM EstadoProgramacion e WHERE e.txtEtdoProgramacion = :txtEtdoProgramacion"),
    @NamedQuery(name = "EstadoProgramacion.findByNidUsuario", query = "SELECT e FROM EstadoProgramacion e WHERE e.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "EstadoProgramacion.findByFlgActivo", query = "SELECT e FROM EstadoProgramacion e WHERE e.flgActivo = :flgActivo"),
    @NamedQuery(name = "EstadoProgramacion.findByTxtPc", query = "SELECT e FROM EstadoProgramacion e WHERE e.txtPc = :txtPc"),
    @NamedQuery(name = "EstadoProgramacion.findByTxtIp", query = "SELECT e FROM EstadoProgramacion e WHERE e.txtIp = :txtIp"),
    @NamedQuery(name = "EstadoProgramacion.findByFecEdicion", query = "SELECT e FROM EstadoProgramacion e WHERE e.fecEdicion = :fecEdicion")})
public class EstadoProgramacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ETDO_PROGRAMACION", sequenceName = "SQ_ETDO_PROGRAMACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ETDO_PROGRAMACION")
    @Column(name = "NID_ETDO_PROGRAMACION")
    private BigDecimal nidEtdoProgramacion;
    @Size(max = 50)
    @Column(name = "TXT_ETDO_PROGRAMACION")
    private String txtEtdoProgramacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Size(max = 50)
    @Column(name = "TXT_PC")
    private String txtPc;
    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProgramacion", fetch = FetchType.LAZY)
    private List<AtencionProgramacion> atencionProgramacionList;

    public EstadoProgramacion() {
    }

    public EstadoProgramacion(BigDecimal nidEtdoProgramacion) {
        this.nidEtdoProgramacion = nidEtdoProgramacion;
    }

    public EstadoProgramacion(BigDecimal nidEtdoProgramacion, BigInteger nidUsuario) {
        this.nidEtdoProgramacion = nidEtdoProgramacion;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidEtdoProgramacion() {
        return nidEtdoProgramacion;
    }

    public void setNidEtdoProgramacion(BigDecimal nidEtdoProgramacion) {
        this.nidEtdoProgramacion = nidEtdoProgramacion;
    }

    public String getTxtEtdoProgramacion() {
        return txtEtdoProgramacion;
    }

    public void setTxtEtdoProgramacion(String txtEtdoProgramacion) {
        this.txtEtdoProgramacion = txtEtdoProgramacion;
    }

    public BigInteger getNidUsuario() {
        return nidUsuario;
    }

    public void setNidUsuario(BigInteger nidUsuario) {
        this.nidUsuario = nidUsuario;
    }

    public BigInteger getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(BigInteger flgActivo) {
        this.flgActivo = flgActivo;
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
    public List<AtencionProgramacion> getAtencionProgramacionList() {
        return atencionProgramacionList;
    }

    public void setAtencionProgramacionList(List<AtencionProgramacion> atencionProgramacionList) {
        this.atencionProgramacionList = atencionProgramacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidEtdoProgramacion != null ? nidEtdoProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProgramacion)) {
            return false;
        }
        EstadoProgramacion other = (EstadoProgramacion) object;
        if ((this.nidEtdoProgramacion == null && other.nidEtdoProgramacion != null) || (this.nidEtdoProgramacion != null && !this.nidEtdoProgramacion.equals(other.nidEtdoProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.EstadoProgramacion[ nidEtdoProgramacion=" + nidEtdoProgramacion + " ]";
    }
    
}
