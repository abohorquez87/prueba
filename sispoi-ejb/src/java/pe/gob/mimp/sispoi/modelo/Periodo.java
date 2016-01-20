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
@Table(name = "PERIODO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByNidPeriodo", query = "SELECT p FROM Periodo p WHERE p.nidPeriodo = :nidPeriodo"),
    @NamedQuery(name = "Periodo.findByTxtPeriodo", query = "SELECT p FROM Periodo p WHERE p.txtPeriodo = :txtPeriodo"),
    @NamedQuery(name = "Periodo.findByFlgActivo", query = "SELECT p FROM Periodo p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "Periodo.findByNidUsuario", query = "SELECT p FROM Periodo p WHERE p.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Periodo.findByTxtPc", query = "SELECT p FROM Periodo p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "Periodo.findByTxtIp", query = "SELECT p FROM Periodo p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "Periodo.findByFecEdicion", query = "SELECT p FROM Periodo p WHERE p.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Periodo.findByTxtCodigoPeriodo", query = "SELECT p FROM Periodo p WHERE p.txtCodigoPeriodo = :txtCodigoPeriodo")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PERIODO", sequenceName = "SQ_PERIODO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERIODO")
    @Column(name = "NID_PERIODO")
    private BigDecimal nidPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_PERIODO")
    private String txtPeriodo;
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
    @Column(name = "TXT_CODIGO_PERIODO")
    private String txtCodigoPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo", fetch = FetchType.LAZY)
    private List<ObjetivoEstrategico> objetivoEstrategicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo", fetch = FetchType.LAZY)
    private List<Programacion> programacionList;

    public Periodo() {
    }

    public Periodo(BigDecimal nidPeriodo) {
        this.nidPeriodo = nidPeriodo;
    }

    public Periodo(BigDecimal nidPeriodo, String txtPeriodo, BigInteger nidUsuario) {
        this.nidPeriodo = nidPeriodo;
        this.txtPeriodo = txtPeriodo;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidPeriodo() {
        return nidPeriodo;
    }

    public void setNidPeriodo(BigDecimal nidPeriodo) {
        this.nidPeriodo = nidPeriodo;
    }

    public String getTxtPeriodo() {
        return txtPeriodo;
    }

    public void setTxtPeriodo(String txtPeriodo) {
        this.txtPeriodo = txtPeriodo;
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

    public String getTxtCodigoPeriodo() {
        return txtCodigoPeriodo;
    }

    public void setTxtCodigoPeriodo(String txtCodigoPeriodo) {
        this.txtCodigoPeriodo = txtCodigoPeriodo;
    }

    @XmlTransient
    public List<ObjetivoEstrategico> getObjetivoEstrategicoList() {
        return objetivoEstrategicoList;
    }

    public void setObjetivoEstrategicoList(List<ObjetivoEstrategico> objetivoEstrategicoList) {
        this.objetivoEstrategicoList = objetivoEstrategicoList;
    }

    @XmlTransient
    public List<Programacion> getProgramacionList() {
        return programacionList;
    }

    public void setProgramacionList(List<Programacion> programacionList) {
        this.programacionList = programacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidPeriodo != null ? nidPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.nidPeriodo == null && other.nidPeriodo != null) || (this.nidPeriodo != null && !this.nidPeriodo.equals(other.nidPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Periodo[ nidPeriodo=" + nidPeriodo + " ]";
    }
    
}
