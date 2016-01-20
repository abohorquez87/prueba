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
@Table(name = "ACCION_ESTRATEGICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccionEstrategica.findAll", query = "SELECT a FROM AccionEstrategica a"),
    @NamedQuery(name = "AccionEstrategica.findByNidAccionEstrategica", query = "SELECT a FROM AccionEstrategica a WHERE a.nidAccionEstrategica = :nidAccionEstrategica"),
    @NamedQuery(name = "AccionEstrategica.findByTxtCodigoAccionEstrategica", query = "SELECT a FROM AccionEstrategica a WHERE a.txtCodigoAccionEstrategica = :txtCodigoAccionEstrategica"),
    @NamedQuery(name = "AccionEstrategica.findByTxtAccionEstrategica", query = "SELECT a FROM AccionEstrategica a WHERE a.txtAccionEstrategica = :txtAccionEstrategica"),
    @NamedQuery(name = "AccionEstrategica.findByFlgActivo", query = "SELECT a FROM AccionEstrategica a WHERE a.flgActivo = :flgActivo"),
    @NamedQuery(name = "AccionEstrategica.findByNidUsuario", query = "SELECT a FROM AccionEstrategica a WHERE a.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "AccionEstrategica.findByTxtPc", query = "SELECT a FROM AccionEstrategica a WHERE a.txtPc = :txtPc"),
    @NamedQuery(name = "AccionEstrategica.findByTxtIp", query = "SELECT a FROM AccionEstrategica a WHERE a.txtIp = :txtIp"),
    @NamedQuery(name = "AccionEstrategica.findByFecEdicion", query = "SELECT a FROM AccionEstrategica a WHERE a.fecEdicion = :fecEdicion")})
public class AccionEstrategica implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_ACCION_ESTRATEGICA", sequenceName = "SQ_ACCION_ESTRATEGICA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCION_ESTRATEGICA")
    @Column(name = "NID_ACCION_ESTRATEGICA")
    private BigDecimal nidAccionEstrategica;
    @Size(max = 10)
    @Column(name = "TXT_CODIGO_ACCION_ESTRATEGICA")
    private String txtCodigoAccionEstrategica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TXT_ACCION_ESTRATEGICA")
    private String txtAccionEstrategica;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accionEstrategica", fetch = FetchType.LAZY)
    private List<ActividadProgramada> actividadProgramadaList;
    @JoinColumn(name = "NID_PROGRAMACION_ITEM", referencedColumnName = "NID_PROGRAMACION_ITEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProgramacionItem programacionItem;

    public AccionEstrategica() {
    }

    public AccionEstrategica(BigDecimal nidAccionEstrategica) {
        this.nidAccionEstrategica = nidAccionEstrategica;
    }

    public AccionEstrategica(BigDecimal nidAccionEstrategica, String txtAccionEstrategica, BigInteger nidUsuario) {
        this.nidAccionEstrategica = nidAccionEstrategica;
        this.txtAccionEstrategica = txtAccionEstrategica;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidAccionEstrategica() {
        return nidAccionEstrategica;
    }

    public void setNidAccionEstrategica(BigDecimal nidAccionEstrategica) {
        this.nidAccionEstrategica = nidAccionEstrategica;
    }

    public String getTxtCodigoAccionEstrategica() {
        return txtCodigoAccionEstrategica;
    }

    public void setTxtCodigoAccionEstrategica(String txtCodigoAccionEstrategica) {
        this.txtCodigoAccionEstrategica = txtCodigoAccionEstrategica;
    }

    public String getTxtAccionEstrategica() {
        return txtAccionEstrategica;
    }

    public void setTxtAccionEstrategica(String txtAccionEstrategica) {
        this.txtAccionEstrategica = txtAccionEstrategica;
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
    public List<ActividadProgramada> getActividadProgramadaList() {
        return actividadProgramadaList;
    }

    public void setActividadProgramadaList(List<ActividadProgramada> actividadProgramadaList) {
        this.actividadProgramadaList = actividadProgramadaList;
    }

    public ProgramacionItem getProgramacionItem() {
        return programacionItem;
    }

    public void setProgramacionItem(ProgramacionItem programacionItem) {
        this.programacionItem = programacionItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidAccionEstrategica != null ? nidAccionEstrategica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionEstrategica)) {
            return false;
        }
        AccionEstrategica other = (AccionEstrategica) object;
        if ((this.nidAccionEstrategica == null && other.nidAccionEstrategica != null) || (this.nidAccionEstrategica != null && !this.nidAccionEstrategica.equals(other.nidAccionEstrategica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.AccionEstrategica[ nidAccionEstrategica=" + nidAccionEstrategica + " ]";
    }
    
}
