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
@Table(name = "OBJETIVO_ESTRATEGICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjetivoEstrategico.findAll", query = "SELECT o FROM ObjetivoEstrategico o"),
    @NamedQuery(name = "ObjetivoEstrategico.findByNidObjetivoEstrategico", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.nidObjetivoEstrategico = :nidObjetivoEstrategico"),
    @NamedQuery(name = "ObjetivoEstrategico.findByNidObjetivoEstrategicoPadre", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.nidObjetivoEstrategicoPadre = :nidObjetivoEstrategicoPadre"),
    @NamedQuery(name = "ObjetivoEstrategico.findByTxtObjetivoEstrategico", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.txtObjetivoEstrategico = :txtObjetivoEstrategico"),
    @NamedQuery(name = "ObjetivoEstrategico.findByTxtContenido", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.txtContenido = :txtContenido"),
    @NamedQuery(name = "ObjetivoEstrategico.findByFlgActivo", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.flgActivo = :flgActivo"),
    @NamedQuery(name = "ObjetivoEstrategico.findByNidUsuario", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "ObjetivoEstrategico.findByTxtPc", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.txtPc = :txtPc"),
    @NamedQuery(name = "ObjetivoEstrategico.findByTxtIp", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.txtIp = :txtIp"),
    @NamedQuery(name = "ObjetivoEstrategico.findByFecEdicion", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "ObjetivoEstrategico.findByTxtCodigoObjEstrategico", query = "SELECT o FROM ObjetivoEstrategico o WHERE o.txtCodigoObjEstrategico = :txtCodigoObjEstrategico")})
public class ObjetivoEstrategico implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_OBJETIVO_ESTRATEGICO", sequenceName = "SQ_OBJETIVO_ESTRATEGICO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OBJETIVO_ESTRATEGICO")
    @Column(name = "NID_OBJETIVO_ESTRATEGICO")
    private BigDecimal nidObjetivoEstrategico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NID_OBJETIVO_ESTRATEGICO_PADRE")
    private BigInteger nidObjetivoEstrategicoPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2025)
    @Column(name = "TXT_OBJETIVO_ESTRATEGICO")
    private String txtObjetivoEstrategico;
    @Size(max = 2014)
    @Column(name = "TXT_CONTENIDO")
    private String txtContenido;
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
    @Column(name = "TXT_CODIGO_OBJ_ESTRATEGICO")
    private String txtCodigoObjEstrategico;
    @JoinColumn(name = "NID_PERIODO", referencedColumnName = "NID_PERIODO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Periodo periodo;
    @JoinColumn(name = "NID_TIPO_OBJETIVO_ESTRATEGICO", referencedColumnName = "NID_TIPO_OBJETIVO_ESTRATEGICO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoObjetivoEstrategico tipoObjetivoEstrategico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objetivoEstrategico", fetch = FetchType.LAZY)
    private List<Programacion> programacionList;

    public ObjetivoEstrategico() {
    }

    public ObjetivoEstrategico(BigDecimal nidObjetivoEstrategico) {
        this.nidObjetivoEstrategico = nidObjetivoEstrategico;
    }

    public ObjetivoEstrategico(BigDecimal nidObjetivoEstrategico, BigInteger nidObjetivoEstrategicoPadre, String txtObjetivoEstrategico, BigInteger nidUsuario) {
        this.nidObjetivoEstrategico = nidObjetivoEstrategico;
        this.nidObjetivoEstrategicoPadre = nidObjetivoEstrategicoPadre;
        this.txtObjetivoEstrategico = txtObjetivoEstrategico;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidObjetivoEstrategico() {
        return nidObjetivoEstrategico;
    }

    public void setNidObjetivoEstrategico(BigDecimal nidObjetivoEstrategico) {
        this.nidObjetivoEstrategico = nidObjetivoEstrategico;
    }

    public BigInteger getNidObjetivoEstrategicoPadre() {
        return nidObjetivoEstrategicoPadre;
    }

    public void setNidObjetivoEstrategicoPadre(BigInteger nidObjetivoEstrategicoPadre) {
        this.nidObjetivoEstrategicoPadre = nidObjetivoEstrategicoPadre;
    }

    public String getTxtObjetivoEstrategico() {
        return txtObjetivoEstrategico;
    }

    public void setTxtObjetivoEstrategico(String txtObjetivoEstrategico) {
        this.txtObjetivoEstrategico = txtObjetivoEstrategico;
    }

    public String getTxtContenido() {
        return txtContenido;
    }

    public void setTxtContenido(String txtContenido) {
        this.txtContenido = txtContenido;
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

    public String getTxtCodigoObjEstrategico() {
        return txtCodigoObjEstrategico;
    }

    public void setTxtCodigoObjEstrategico(String txtCodigoObjEstrategico) {
        this.txtCodigoObjEstrategico = txtCodigoObjEstrategico;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public TipoObjetivoEstrategico getTipoObjetivoEstrategico() {
        return tipoObjetivoEstrategico;
    }

    public void setTipoObjetivoEstrategico(TipoObjetivoEstrategico tipoObjetivoEstrategico) {
        this.tipoObjetivoEstrategico = tipoObjetivoEstrategico;
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
        hash += (nidObjetivoEstrategico != null ? nidObjetivoEstrategico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoEstrategico)) {
            return false;
        }
        ObjetivoEstrategico other = (ObjetivoEstrategico) object;
        if ((this.nidObjetivoEstrategico == null && other.nidObjetivoEstrategico != null) || (this.nidObjetivoEstrategico != null && !this.nidObjetivoEstrategico.equals(other.nidObjetivoEstrategico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.ObjetivoEstrategico[ nidObjetivoEstrategico=" + nidObjetivoEstrategico + " ]";
    }
    
}
