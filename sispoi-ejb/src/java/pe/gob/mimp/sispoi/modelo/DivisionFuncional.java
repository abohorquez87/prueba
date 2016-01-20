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
@Table(name = "DIVISION_FUNCIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DivisionFuncional.findAll", query = "SELECT d FROM DivisionFuncional d"),
    @NamedQuery(name = "DivisionFuncional.findByNidDivisionFuncional", query = "SELECT d FROM DivisionFuncional d WHERE d.nidDivisionFuncional = :nidDivisionFuncional"),
    @NamedQuery(name = "DivisionFuncional.findByTxtCodigoDivisionFuncional", query = "SELECT d FROM DivisionFuncional d WHERE d.txtCodigoDivisionFuncional = :txtCodigoDivisionFuncional"),
    @NamedQuery(name = "DivisionFuncional.findByFlgActivo", query = "SELECT d FROM DivisionFuncional d WHERE d.flgActivo = :flgActivo"),
    @NamedQuery(name = "DivisionFuncional.findByNidUsuario", query = "SELECT d FROM DivisionFuncional d WHERE d.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "DivisionFuncional.findByTxtPc", query = "SELECT d FROM DivisionFuncional d WHERE d.txtPc = :txtPc"),
    @NamedQuery(name = "DivisionFuncional.findByTxtIp", query = "SELECT d FROM DivisionFuncional d WHERE d.txtIp = :txtIp"),
    @NamedQuery(name = "DivisionFuncional.findByFecEdicion", query = "SELECT d FROM DivisionFuncional d WHERE d.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "DivisionFuncional.findByTxtDivisionFuncional", query = "SELECT d FROM DivisionFuncional d WHERE d.txtDivisionFuncional = :txtDivisionFuncional")})
public class DivisionFuncional implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_DIVISION_FUNCIONAL", sequenceName = "SQ_DIVISION_FUNCIONAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIVISION_FUNCIONAL")
    @Column(name = "NID_DIVISION_FUNCIONAL")
    private BigDecimal nidDivisionFuncional;
    @Size(max = 512)
    @Column(name = "TXT_CODIGO_DIVISION_FUNCIONAL")
    private String txtCodigoDivisionFuncional;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_DIVISION_FUNCIONAL")
    private String txtDivisionFuncional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionFuncional", fetch = FetchType.LAZY)
    private List<GrupoFuncional> grupoFuncionalList;
    @JoinColumn(name = "NID_FUNCION", referencedColumnName = "NID_FUNCION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcion funcion;

    public DivisionFuncional() {
    }

    public DivisionFuncional(BigDecimal nidDivisionFuncional) {
        this.nidDivisionFuncional = nidDivisionFuncional;
    }

    public DivisionFuncional(BigDecimal nidDivisionFuncional, BigInteger nidUsuario, String txtDivisionFuncional) {
        this.nidDivisionFuncional = nidDivisionFuncional;
        this.nidUsuario = nidUsuario;
        this.txtDivisionFuncional = txtDivisionFuncional;
    }

    public BigDecimal getNidDivisionFuncional() {
        return nidDivisionFuncional;
    }

    public void setNidDivisionFuncional(BigDecimal nidDivisionFuncional) {
        this.nidDivisionFuncional = nidDivisionFuncional;
    }

    public String getTxtCodigoDivisionFuncional() {
        return txtCodigoDivisionFuncional;
    }

    public void setTxtCodigoDivisionFuncional(String txtCodigoDivisionFuncional) {
        this.txtCodigoDivisionFuncional = txtCodigoDivisionFuncional;
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

    public String getTxtDivisionFuncional() {
        return txtDivisionFuncional;
    }

    public void setTxtDivisionFuncional(String txtDivisionFuncional) {
        this.txtDivisionFuncional = txtDivisionFuncional;
    }

    @XmlTransient
    public List<GrupoFuncional> getGrupoFuncionalList() {
        return grupoFuncionalList;
    }

    public void setGrupoFuncionalList(List<GrupoFuncional> grupoFuncionalList) {
        this.grupoFuncionalList = grupoFuncionalList;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidDivisionFuncional != null ? nidDivisionFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DivisionFuncional)) {
            return false;
        }
        DivisionFuncional other = (DivisionFuncional) object;
        if ((this.nidDivisionFuncional == null && other.nidDivisionFuncional != null) || (this.nidDivisionFuncional != null && !this.nidDivisionFuncional.equals(other.nidDivisionFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.DivisionFuncional[ nidDivisionFuncional=" + nidDivisionFuncional + " ]";
    }
    
}
