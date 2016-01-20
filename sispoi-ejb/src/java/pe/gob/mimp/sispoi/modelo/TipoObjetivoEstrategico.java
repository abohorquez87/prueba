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
@Table(name = "TIPO_OBJETIVO_ESTRATEGICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoObjetivoEstrategico.findAll", query = "SELECT t FROM TipoObjetivoEstrategico t"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByNidTipoObjetivoEstrategico", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.nidTipoObjetivoEstrategico = :nidTipoObjetivoEstrategico"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByTxtTipoObjetivoEstrategico", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.txtTipoObjetivoEstrategico = :txtTipoObjetivoEstrategico"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByFlgActivo", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.flgActivo = :flgActivo"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByNidUsuario", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByTxtPc", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.txtPc = :txtPc"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByTxtIp", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.txtIp = :txtIp"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByFecEdicion", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "TipoObjetivoEstrategico.findByTxtCodigoTipObjEstrategico", query = "SELECT t FROM TipoObjetivoEstrategico t WHERE t.txtCodigoTipObjEstrategico = :txtCodigoTipObjEstrategico")})
public class TipoObjetivoEstrategico implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_TIPO_OBJETIVO_ESTRATEGICO", sequenceName = "SQ_TIPO_OBJETIVO_ESTRATEGICO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_OBJETIVO_ESTRATEGICO")
    @Column(name = "NID_TIPO_OBJETIVO_ESTRATEGICO")
    private BigDecimal nidTipoObjetivoEstrategico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_TIPO_OBJETIVO_ESTRATEGICO")
    private String txtTipoObjetivoEstrategico;
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
    @Column(name = "TXT_CODIGO_TIP_OBJ_ESTRATEGICO")
    private String txtCodigoTipObjEstrategico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoObjetivoEstrategico", fetch = FetchType.LAZY)
    private List<ObjetivoEstrategico> objetivoEstrategicoList;

    public TipoObjetivoEstrategico() {
    }

    public TipoObjetivoEstrategico(BigDecimal nidTipoObjetivoEstrategico) {
        this.nidTipoObjetivoEstrategico = nidTipoObjetivoEstrategico;
    }

    public TipoObjetivoEstrategico(BigDecimal nidTipoObjetivoEstrategico, String txtTipoObjetivoEstrategico, BigInteger nidUsuario) {
        this.nidTipoObjetivoEstrategico = nidTipoObjetivoEstrategico;
        this.txtTipoObjetivoEstrategico = txtTipoObjetivoEstrategico;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidTipoObjetivoEstrategico() {
        return nidTipoObjetivoEstrategico;
    }

    public void setNidTipoObjetivoEstrategico(BigDecimal nidTipoObjetivoEstrategico) {
        this.nidTipoObjetivoEstrategico = nidTipoObjetivoEstrategico;
    }

    public String getTxtTipoObjetivoEstrategico() {
        return txtTipoObjetivoEstrategico;
    }

    public void setTxtTipoObjetivoEstrategico(String txtTipoObjetivoEstrategico) {
        this.txtTipoObjetivoEstrategico = txtTipoObjetivoEstrategico;
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

    public String getTxtCodigoTipObjEstrategico() {
        return txtCodigoTipObjEstrategico;
    }

    public void setTxtCodigoTipObjEstrategico(String txtCodigoTipObjEstrategico) {
        this.txtCodigoTipObjEstrategico = txtCodigoTipObjEstrategico;
    }

    @XmlTransient
    public List<ObjetivoEstrategico> getObjetivoEstrategicoList() {
        return objetivoEstrategicoList;
    }

    public void setObjetivoEstrategicoList(List<ObjetivoEstrategico> objetivoEstrategicoList) {
        this.objetivoEstrategicoList = objetivoEstrategicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidTipoObjetivoEstrategico != null ? nidTipoObjetivoEstrategico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoObjetivoEstrategico)) {
            return false;
        }
        TipoObjetivoEstrategico other = (TipoObjetivoEstrategico) object;
        if ((this.nidTipoObjetivoEstrategico == null && other.nidTipoObjetivoEstrategico != null) || (this.nidTipoObjetivoEstrategico != null && !this.nidTipoObjetivoEstrategico.equals(other.nidTipoObjetivoEstrategico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.TipoObjetivoEstrategico[ nidTipoObjetivoEstrategico=" + nidTipoObjetivoEstrategico + " ]";
    }
    
}
