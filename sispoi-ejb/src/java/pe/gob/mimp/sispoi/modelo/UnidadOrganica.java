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
@Table(name = "UNIDAD_ORGANICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadOrganica.findAll", query = "SELECT u FROM UnidadOrganica u"),
    @NamedQuery(name = "UnidadOrganica.findByNidUnidadOrganica", query = "SELECT u FROM UnidadOrganica u WHERE u.nidUnidadOrganica = :nidUnidadOrganica"),
    @NamedQuery(name = "UnidadOrganica.findByTxtUnidadOrganica", query = "SELECT u FROM UnidadOrganica u WHERE u.txtUnidadOrganica = :txtUnidadOrganica"),
    @NamedQuery(name = "UnidadOrganica.findByFlgActivo", query = "SELECT u FROM UnidadOrganica u WHERE u.flgActivo = :flgActivo"),
    @NamedQuery(name = "UnidadOrganica.findByNidUsuario", query = "SELECT u FROM UnidadOrganica u WHERE u.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "UnidadOrganica.findByTxtPc", query = "SELECT u FROM UnidadOrganica u WHERE u.txtPc = :txtPc"),
    @NamedQuery(name = "UnidadOrganica.findByTxtIp", query = "SELECT u FROM UnidadOrganica u WHERE u.txtIp = :txtIp"),
    @NamedQuery(name = "UnidadOrganica.findByFecEdicion", query = "SELECT u FROM UnidadOrganica u WHERE u.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "UnidadOrganica.findByTxtCodigoUnidadOrganica", query = "SELECT u FROM UnidadOrganica u WHERE u.txtCodigoUnidadOrganica = :txtCodigoUnidadOrganica")})
public class UnidadOrganica implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_UNIDAD_ORGANICA", sequenceName = "SQ_UNIDAD_ORGANICA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDAD_ORGANICA")
    @Column(name = "NID_UNIDAD_ORGANICA")
    private BigDecimal nidUnidadOrganica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_UNIDAD_ORGANICA")
    private String txtUnidadOrganica;
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
    @Column(name = "TXT_CODIGO_UNIDAD_ORGANICA")
    private String txtCodigoUnidadOrganica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadOrganica", fetch = FetchType.LAZY)
    private List<Direccion> direccionList;
    @JoinColumn(name = "NID_UNIDAD_EJECUTORA", referencedColumnName = "NID_UNIDAD_EJECUTORA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadEjecutora unidadEjecutora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadOrganica", fetch = FetchType.LAZY)
    private List<ProgramacionItem> programacionItemList;

    public UnidadOrganica() {
    }

    public UnidadOrganica(BigDecimal nidUnidadOrganica) {
        this.nidUnidadOrganica = nidUnidadOrganica;
    }

    public UnidadOrganica(BigDecimal nidUnidadOrganica, String txtUnidadOrganica, BigInteger nidUsuario) {
        this.nidUnidadOrganica = nidUnidadOrganica;
        this.txtUnidadOrganica = txtUnidadOrganica;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidUnidadOrganica() {
        return nidUnidadOrganica;
    }

    public void setNidUnidadOrganica(BigDecimal nidUnidadOrganica) {
        this.nidUnidadOrganica = nidUnidadOrganica;
    }

    public String getTxtUnidadOrganica() {
        return txtUnidadOrganica;
    }

    public void setTxtUnidadOrganica(String txtUnidadOrganica) {
        this.txtUnidadOrganica = txtUnidadOrganica;
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

    public String getTxtCodigoUnidadOrganica() {
        return txtCodigoUnidadOrganica;
    }

    public void setTxtCodigoUnidadOrganica(String txtCodigoUnidadOrganica) {
        this.txtCodigoUnidadOrganica = txtCodigoUnidadOrganica;
    }

    @XmlTransient
    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public UnidadEjecutora getUnidadEjecutora() {
        return unidadEjecutora;
    }

    public void setUnidadEjecutora(UnidadEjecutora unidadEjecutora) {
        this.unidadEjecutora = unidadEjecutora;
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
        hash += (nidUnidadOrganica != null ? nidUnidadOrganica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadOrganica)) {
            return false;
        }
        UnidadOrganica other = (UnidadOrganica) object;
        if ((this.nidUnidadOrganica == null && other.nidUnidadOrganica != null) || (this.nidUnidadOrganica != null && !this.nidUnidadOrganica.equals(other.nidUnidadOrganica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.UnidadOrganica[ nidUnidadOrganica=" + nidUnidadOrganica + " ]";
    }
    
}
