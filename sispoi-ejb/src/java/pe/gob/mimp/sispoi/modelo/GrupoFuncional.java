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
@Table(name = "GRUPO_FUNCIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoFuncional.findAll", query = "SELECT g FROM GrupoFuncional g"),
    @NamedQuery(name = "GrupoFuncional.findByNidGrupoFuncional", query = "SELECT g FROM GrupoFuncional g WHERE g.nidGrupoFuncional = :nidGrupoFuncional"),
    @NamedQuery(name = "GrupoFuncional.findByFlgActivo", query = "SELECT g FROM GrupoFuncional g WHERE g.flgActivo = :flgActivo"),
    @NamedQuery(name = "GrupoFuncional.findByNidUsuario", query = "SELECT g FROM GrupoFuncional g WHERE g.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "GrupoFuncional.findByTxtPc", query = "SELECT g FROM GrupoFuncional g WHERE g.txtPc = :txtPc"),
    @NamedQuery(name = "GrupoFuncional.findByTxtIp", query = "SELECT g FROM GrupoFuncional g WHERE g.txtIp = :txtIp"),
    @NamedQuery(name = "GrupoFuncional.findByFecEdicion", query = "SELECT g FROM GrupoFuncional g WHERE g.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "GrupoFuncional.findByTxtGrupoFuncional", query = "SELECT g FROM GrupoFuncional g WHERE g.txtGrupoFuncional = :txtGrupoFuncional"),
    @NamedQuery(name = "GrupoFuncional.findByTxtCodigoGrupoFuncional", query = "SELECT g FROM GrupoFuncional g WHERE g.txtCodigoGrupoFuncional = :txtCodigoGrupoFuncional")})
public class GrupoFuncional implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_GRUPO_FUNCIONAL", sequenceName = "SQ_GRUPO_FUNCIONAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GRUPO_FUNCIONAL")
    @Column(name = "NID_GRUPO_FUNCIONAL")
    private BigDecimal nidGrupoFuncional;
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
    @Size(max = 512)
    @Column(name = "TXT_GRUPO_FUNCIONAL")
    private String txtGrupoFuncional;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_GRUPO_FUNCIONAL")
    private String txtCodigoGrupoFuncional;
    @JoinColumn(name = "NID_DIVISION_FUNCIONAL", referencedColumnName = "NID_DIVISION_FUNCIONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DivisionFuncional divisionFuncional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoFuncional", fetch = FetchType.LAZY)
    private List<MetaPresupuestaria> metaPresupuestariaList;

    public GrupoFuncional() {
    }

    public GrupoFuncional(BigDecimal nidGrupoFuncional) {
        this.nidGrupoFuncional = nidGrupoFuncional;
    }

    public GrupoFuncional(BigDecimal nidGrupoFuncional, BigInteger nidUsuario) {
        this.nidGrupoFuncional = nidGrupoFuncional;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidGrupoFuncional() {
        return nidGrupoFuncional;
    }

    public void setNidGrupoFuncional(BigDecimal nidGrupoFuncional) {
        this.nidGrupoFuncional = nidGrupoFuncional;
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

    public String getTxtGrupoFuncional() {
        return txtGrupoFuncional;
    }

    public void setTxtGrupoFuncional(String txtGrupoFuncional) {
        this.txtGrupoFuncional = txtGrupoFuncional;
    }

    public String getTxtCodigoGrupoFuncional() {
        return txtCodigoGrupoFuncional;
    }

    public void setTxtCodigoGrupoFuncional(String txtCodigoGrupoFuncional) {
        this.txtCodigoGrupoFuncional = txtCodigoGrupoFuncional;
    }

    public DivisionFuncional getDivisionFuncional() {
        return divisionFuncional;
    }

    public void setDivisionFuncional(DivisionFuncional divisionFuncional) {
        this.divisionFuncional = divisionFuncional;
    }

    @XmlTransient
    public List<MetaPresupuestaria> getMetaPresupuestariaList() {
        return metaPresupuestariaList;
    }

    public void setMetaPresupuestariaList(List<MetaPresupuestaria> metaPresupuestariaList) {
        this.metaPresupuestariaList = metaPresupuestariaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidGrupoFuncional != null ? nidGrupoFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoFuncional)) {
            return false;
        }
        GrupoFuncional other = (GrupoFuncional) object;
        if ((this.nidGrupoFuncional == null && other.nidGrupoFuncional != null) || (this.nidGrupoFuncional != null && !this.nidGrupoFuncional.equals(other.nidGrupoFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.GrupoFuncional[ nidGrupoFuncional=" + nidGrupoFuncional + " ]";
    }
    
}
