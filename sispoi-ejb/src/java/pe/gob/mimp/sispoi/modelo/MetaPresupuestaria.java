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
@Table(name = "META_PRESUPUESTARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetaPresupuestaria.findAll", query = "SELECT m FROM MetaPresupuestaria m"),
    @NamedQuery(name = "MetaPresupuestaria.findByNidMetaPresupuestaria", query = "SELECT m FROM MetaPresupuestaria m WHERE m.nidMetaPresupuestaria = :nidMetaPresupuestaria"),
    @NamedQuery(name = "MetaPresupuestaria.findByTxtCodigoMetaPresupuestaria", query = "SELECT m FROM MetaPresupuestaria m WHERE m.txtCodigoMetaPresupuestaria = :txtCodigoMetaPresupuestaria"),
    @NamedQuery(name = "MetaPresupuestaria.findByTxtMetaPresupuestaria", query = "SELECT m FROM MetaPresupuestaria m WHERE m.txtMetaPresupuestaria = :txtMetaPresupuestaria"),
    @NamedQuery(name = "MetaPresupuestaria.findByFlgActivo", query = "SELECT m FROM MetaPresupuestaria m WHERE m.flgActivo = :flgActivo"),
    @NamedQuery(name = "MetaPresupuestaria.findByNidUsuario", query = "SELECT m FROM MetaPresupuestaria m WHERE m.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "MetaPresupuestaria.findByTxtPc", query = "SELECT m FROM MetaPresupuestaria m WHERE m.txtPc = :txtPc"),
    @NamedQuery(name = "MetaPresupuestaria.findByTxtIp", query = "SELECT m FROM MetaPresupuestaria m WHERE m.txtIp = :txtIp"),
    @NamedQuery(name = "MetaPresupuestaria.findByFecEdicion", query = "SELECT m FROM MetaPresupuestaria m WHERE m.fecEdicion = :fecEdicion")})
public class MetaPresupuestaria implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_META_PRESUPUESTARIA", sequenceName = "SQ_META_PRESUPUESTARIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_META_PRESUPUESTARIA")
    @Column(name = "NID_META_PRESUPUESTARIA")
    private BigDecimal nidMetaPresupuestaria;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_META_PRESUPUESTARIA")
    private String txtCodigoMetaPresupuestaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TXT_META_PRESUPUESTARIA")
    private String txtMetaPresupuestaria;
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
    @JoinColumn(name = "NID_GRUPO_FUNCIONAL", referencedColumnName = "NID_GRUPO_FUNCIONAL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoFuncional grupoFuncional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metaPresupuestaria", fetch = FetchType.LAZY)
    private List<ProgramacionItem> programacionItemList;

    public MetaPresupuestaria() {
    }

    public MetaPresupuestaria(BigDecimal nidMetaPresupuestaria) {
        this.nidMetaPresupuestaria = nidMetaPresupuestaria;
    }

    public MetaPresupuestaria(BigDecimal nidMetaPresupuestaria, String txtMetaPresupuestaria, BigInteger nidUsuario) {
        this.nidMetaPresupuestaria = nidMetaPresupuestaria;
        this.txtMetaPresupuestaria = txtMetaPresupuestaria;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidMetaPresupuestaria() {
        return nidMetaPresupuestaria;
    }

    public void setNidMetaPresupuestaria(BigDecimal nidMetaPresupuestaria) {
        this.nidMetaPresupuestaria = nidMetaPresupuestaria;
    }

    public String getTxtCodigoMetaPresupuestaria() {
        return txtCodigoMetaPresupuestaria;
    }

    public void setTxtCodigoMetaPresupuestaria(String txtCodigoMetaPresupuestaria) {
        this.txtCodigoMetaPresupuestaria = txtCodigoMetaPresupuestaria;
    }

    public String getTxtMetaPresupuestaria() {
        return txtMetaPresupuestaria;
    }

    public void setTxtMetaPresupuestaria(String txtMetaPresupuestaria) {
        this.txtMetaPresupuestaria = txtMetaPresupuestaria;
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

    public GrupoFuncional getGrupoFuncional() {
        return grupoFuncional;
    }

    public void setGrupoFuncional(GrupoFuncional grupoFuncional) {
        this.grupoFuncional = grupoFuncional;
    }

    @XmlTransient
    public List<ProgramacionItem> getProgramacionItemList() {
        return programacionItemList;
    }

    public void setProgramacionItemList(List<ProgramacionItem> programacionItemList) {
        this.programacionItemList = programacionItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidMetaPresupuestaria != null ? nidMetaPresupuestaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetaPresupuestaria)) {
            return false;
        }
        MetaPresupuestaria other = (MetaPresupuestaria) object;
        if ((this.nidMetaPresupuestaria == null && other.nidMetaPresupuestaria != null) || (this.nidMetaPresupuestaria != null && !this.nidMetaPresupuestaria.equals(other.nidMetaPresupuestaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.MetaPresupuestaria[ nidMetaPresupuestaria=" + nidMetaPresupuestaria + " ]";
    }
    
}
