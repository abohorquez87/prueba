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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "UNIDAD_MEDIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByNidUnidadMedida", query = "SELECT u FROM UnidadMedida u WHERE u.nidUnidadMedida = :nidUnidadMedida"),
    @NamedQuery(name = "UnidadMedida.findByTxtUnidadMedida", query = "SELECT u FROM UnidadMedida u WHERE u.txtUnidadMedida = :txtUnidadMedida"),
    @NamedQuery(name = "UnidadMedida.findByFlgActivo", query = "SELECT u FROM UnidadMedida u WHERE u.flgActivo = :flgActivo"),
    @NamedQuery(name = "UnidadMedida.findByNidUsuario", query = "SELECT u FROM UnidadMedida u WHERE u.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "UnidadMedida.findByTxtPc", query = "SELECT u FROM UnidadMedida u WHERE u.txtPc = :txtPc"),
    @NamedQuery(name = "UnidadMedida.findByTxtIp", query = "SELECT u FROM UnidadMedida u WHERE u.txtIp = :txtIp"),
    @NamedQuery(name = "UnidadMedida.findByFecEdicion", query = "SELECT u FROM UnidadMedida u WHERE u.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "UnidadMedida.findByTxtCodigoUnidadMedida", query = "SELECT u FROM UnidadMedida u WHERE u.txtCodigoUnidadMedida = :txtCodigoUnidadMedida")})
public class UnidadMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_UNIDAD_MEDIDA", sequenceName = "SQ_UNIDAD_MEDIDA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDAD_MEDIDA")
    @Column(name = "NID_UNIDAD_MEDIDA")
    private BigDecimal nidUnidadMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_UNIDAD_MEDIDA")
    private String txtUnidadMedida;
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
    @Column(name = "TXT_CODIGO_UNIDAD_MEDIDA")
    private String txtCodigoUnidadMedida;
    @ManyToMany(mappedBy = "unidadMedidaList", fetch = FetchType.LAZY)
    private List<ActividadProgramada> actividadProgramadaList;

    public UnidadMedida() {
    }

    public UnidadMedida(BigDecimal nidUnidadMedida) {
        this.nidUnidadMedida = nidUnidadMedida;
    }

    public UnidadMedida(BigDecimal nidUnidadMedida, String txtUnidadMedida, BigInteger nidUsuario) {
        this.nidUnidadMedida = nidUnidadMedida;
        this.txtUnidadMedida = txtUnidadMedida;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidUnidadMedida() {
        return nidUnidadMedida;
    }

    public void setNidUnidadMedida(BigDecimal nidUnidadMedida) {
        this.nidUnidadMedida = nidUnidadMedida;
    }

    public String getTxtUnidadMedida() {
        return txtUnidadMedida;
    }

    public void setTxtUnidadMedida(String txtUnidadMedida) {
        this.txtUnidadMedida = txtUnidadMedida;
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

    public String getTxtCodigoUnidadMedida() {
        return txtCodigoUnidadMedida;
    }

    public void setTxtCodigoUnidadMedida(String txtCodigoUnidadMedida) {
        this.txtCodigoUnidadMedida = txtCodigoUnidadMedida;
    }

    @XmlTransient
    public List<ActividadProgramada> getActividadProgramadaList() {
        return actividadProgramadaList;
    }

    public void setActividadProgramadaList(List<ActividadProgramada> actividadProgramadaList) {
        this.actividadProgramadaList = actividadProgramadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidUnidadMedida != null ? nidUnidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.nidUnidadMedida == null && other.nidUnidadMedida != null) || (this.nidUnidadMedida != null && !this.nidUnidadMedida.equals(other.nidUnidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.UnidadMedida[ nidUnidadMedida=" + nidUnidadMedida + " ]";
    }
    
}
