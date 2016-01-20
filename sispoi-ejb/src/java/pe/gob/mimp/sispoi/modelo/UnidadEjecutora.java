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
@Table(name = "UNIDAD_EJECUTORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadEjecutora.findAll", query = "SELECT u FROM UnidadEjecutora u"),
    @NamedQuery(name = "UnidadEjecutora.findByNidUnidadEjecutora", query = "SELECT u FROM UnidadEjecutora u WHERE u.nidUnidadEjecutora = :nidUnidadEjecutora"),
    @NamedQuery(name = "UnidadEjecutora.findByTxtCodigoUnidadEjecutora", query = "SELECT u FROM UnidadEjecutora u WHERE u.txtCodigoUnidadEjecutora = :txtCodigoUnidadEjecutora"),
    @NamedQuery(name = "UnidadEjecutora.findByTxtUnidadEjecutora", query = "SELECT u FROM UnidadEjecutora u WHERE u.txtUnidadEjecutora = :txtUnidadEjecutora"),
    @NamedQuery(name = "UnidadEjecutora.findByFlgActivo", query = "SELECT u FROM UnidadEjecutora u WHERE u.flgActivo = :flgActivo"),
    @NamedQuery(name = "UnidadEjecutora.findByNidUsuario", query = "SELECT u FROM UnidadEjecutora u WHERE u.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "UnidadEjecutora.findByTxtPc", query = "SELECT u FROM UnidadEjecutora u WHERE u.txtPc = :txtPc"),
    @NamedQuery(name = "UnidadEjecutora.findByTxtIp", query = "SELECT u FROM UnidadEjecutora u WHERE u.txtIp = :txtIp"),
    @NamedQuery(name = "UnidadEjecutora.findByFecEdicion", query = "SELECT u FROM UnidadEjecutora u WHERE u.fecEdicion = :fecEdicion")})
public class UnidadEjecutora implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_UNIDAD_EJECUTORA", sequenceName = "SQ_UNIDAD_EJECUTORA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDAD_EJECUTORA")
    @Column(name = "NID_UNIDAD_EJECUTORA")
    private BigDecimal nidUnidadEjecutora;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_UNIDAD_EJECUTORA")
    private String txtCodigoUnidadEjecutora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_UNIDAD_EJECUTORA")
    private String txtUnidadEjecutora;
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
    @JoinColumn(name = "NID_PLIEGO", referencedColumnName = "NID_PLIEGO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pliego pliego;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadEjecutora", fetch = FetchType.LAZY)
    private List<UnidadOrganica> unidadOrganicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadEjecutora", fetch = FetchType.LAZY)
    private List<Programacion> programacionList;

    public UnidadEjecutora() {
    }

    public UnidadEjecutora(BigDecimal nidUnidadEjecutora) {
        this.nidUnidadEjecutora = nidUnidadEjecutora;
    }

    public UnidadEjecutora(BigDecimal nidUnidadEjecutora, String txtUnidadEjecutora, BigInteger nidUsuario) {
        this.nidUnidadEjecutora = nidUnidadEjecutora;
        this.txtUnidadEjecutora = txtUnidadEjecutora;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidUnidadEjecutora() {
        return nidUnidadEjecutora;
    }

    public void setNidUnidadEjecutora(BigDecimal nidUnidadEjecutora) {
        this.nidUnidadEjecutora = nidUnidadEjecutora;
    }

    public String getTxtCodigoUnidadEjecutora() {
        return txtCodigoUnidadEjecutora;
    }

    public void setTxtCodigoUnidadEjecutora(String txtCodigoUnidadEjecutora) {
        this.txtCodigoUnidadEjecutora = txtCodigoUnidadEjecutora;
    }

    public String getTxtUnidadEjecutora() {
        return txtUnidadEjecutora;
    }

    public void setTxtUnidadEjecutora(String txtUnidadEjecutora) {
        this.txtUnidadEjecutora = txtUnidadEjecutora;
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

    public Pliego getPliego() {
        return pliego;
    }

    public void setPliego(Pliego pliego) {
        this.pliego = pliego;
    }

    @XmlTransient
    public List<UnidadOrganica> getUnidadOrganicaList() {
        return unidadOrganicaList;
    }

    public void setUnidadOrganicaList(List<UnidadOrganica> unidadOrganicaList) {
        this.unidadOrganicaList = unidadOrganicaList;
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
        hash += (nidUnidadEjecutora != null ? nidUnidadEjecutora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadEjecutora)) {
            return false;
        }
        UnidadEjecutora other = (UnidadEjecutora) object;
        if ((this.nidUnidadEjecutora == null && other.nidUnidadEjecutora != null) || (this.nidUnidadEjecutora != null && !this.nidUnidadEjecutora.equals(other.nidUnidadEjecutora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.UnidadEjecutora[ nidUnidadEjecutora=" + nidUnidadEjecutora + " ]";
    }
    
}
