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
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByNidDepartamento", query = "SELECT d FROM Departamento d WHERE d.nidDepartamento = :nidDepartamento"),
    @NamedQuery(name = "Departamento.findByCidDepartamento", query = "SELECT d FROM Departamento d WHERE d.cidDepartamento = :cidDepartamento"),
    @NamedQuery(name = "Departamento.findByTxtDepartamento", query = "SELECT d FROM Departamento d WHERE d.txtDepartamento = :txtDepartamento"),
    @NamedQuery(name = "Departamento.findByFlgActivo", query = "SELECT d FROM Departamento d WHERE d.flgActivo = :flgActivo"),
    @NamedQuery(name = "Departamento.findByNidUsuario", query = "SELECT d FROM Departamento d WHERE d.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Departamento.findByTxtPc", query = "SELECT d FROM Departamento d WHERE d.txtPc = :txtPc"),
    @NamedQuery(name = "Departamento.findByTxtIp", query = "SELECT d FROM Departamento d WHERE d.txtIp = :txtIp"),
    @NamedQuery(name = "Departamento.findByFecEdicion", query = "SELECT d FROM Departamento d WHERE d.fecEdicion = :fecEdicion")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_DEPARTAMENTO", sequenceName = "SQ_DEPARTAMENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPARTAMENTO")
    @Column(name = "NID_DEPARTAMENTO")
    private BigDecimal nidDepartamento;
    @Size(max = 6)
    @Column(name = "CID_DEPARTAMENTO")
    private String cidDepartamento;
    @Size(max = 512)
    @Column(name = "TXT_DEPARTAMENTO")
    private String txtDepartamento;
    @Column(name = "FLG_ACTIVO")
    private BigInteger flgActivo;
    @Column(name = "NID_USUARIO")
    private BigInteger nidUsuario;
    @Size(max = 20)
    @Column(name = "TXT_PC")
    private String txtPc;
    @Size(max = 20)
    @Column(name = "TXT_IP")
    private String txtIp;
    @Column(name = "FEC_EDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEdicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Provincia> provinciaList;

    public Departamento() {
    }

    public Departamento(BigDecimal nidDepartamento) {
        this.nidDepartamento = nidDepartamento;
    }

    public BigDecimal getNidDepartamento() {
        return nidDepartamento;
    }

    public void setNidDepartamento(BigDecimal nidDepartamento) {
        this.nidDepartamento = nidDepartamento;
    }

    public String getCidDepartamento() {
        return cidDepartamento;
    }

    public void setCidDepartamento(String cidDepartamento) {
        this.cidDepartamento = cidDepartamento;
    }

    public String getTxtDepartamento() {
        return txtDepartamento;
    }

    public void setTxtDepartamento(String txtDepartamento) {
        this.txtDepartamento = txtDepartamento;
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
    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDepartamento != null ? nidDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.nidDepartamento == null && other.nidDepartamento != null) || (this.nidDepartamento != null && !this.nidDepartamento.equals(other.nidDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Departamento[ nidDepartamento=" + nidDepartamento + " ]";
    }
    
}
