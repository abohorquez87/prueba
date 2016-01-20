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
@Table(name = "PROGRAMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programacion.findAll", query = "SELECT p FROM Programacion p"),
    @NamedQuery(name = "Programacion.findByNidProgramacion", query = "SELECT p FROM Programacion p WHERE p.nidProgramacion = :nidProgramacion"),
    @NamedQuery(name = "Programacion.findByTxtSustento", query = "SELECT p FROM Programacion p WHERE p.txtSustento = :txtSustento"),
    @NamedQuery(name = "Programacion.findByFlgActivo", query = "SELECT p FROM Programacion p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "Programacion.findByNidUsuario", query = "SELECT p FROM Programacion p WHERE p.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Programacion.findByTxtPc", query = "SELECT p FROM Programacion p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "Programacion.findByTxtIp", query = "SELECT p FROM Programacion p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "Programacion.findByFecEdicion", query = "SELECT p FROM Programacion p WHERE p.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Programacion.findByTxtCodigoProgramacion", query = "SELECT p FROM Programacion p WHERE p.txtCodigoProgramacion = :txtCodigoProgramacion"),
    @NamedQuery(name = "Programacion.findByTxtProgramacion", query = "SELECT p FROM Programacion p WHERE p.txtProgramacion = :txtProgramacion")})
public class Programacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PROGRAMACION", sequenceName = "SQ_PROGRAMACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROGRAMACION")
    @Column(name = "NID_PROGRAMACION")
    private BigDecimal nidProgramacion;
    @Size(max = 4000)
    @Column(name = "TXT_SUSTENTO")
    private String txtSustento;
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
    @Column(name = "TXT_CODIGO_PROGRAMACION")
    private String txtCodigoProgramacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_PROGRAMACION")
    private String txtProgramacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacion", fetch = FetchType.LAZY)
    private List<AtencionProgramacion> atencionProgramacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacion", fetch = FetchType.LAZY)
    private List<Logro> logroList;
    @JoinColumn(name = "NID_OBJETIVO_ESTRATEGICO", referencedColumnName = "NID_OBJETIVO_ESTRATEGICO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ObjetivoEstrategico objetivoEstrategico;
    @JoinColumn(name = "NID_PERIODO", referencedColumnName = "NID_PERIODO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Periodo periodo;
    @JoinColumn(name = "NID_UNIDAD_EJECUTORA", referencedColumnName = "NID_UNIDAD_EJECUTORA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadEjecutora unidadEjecutora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacion", fetch = FetchType.LAZY)
    private List<ProgramacionItem> programacionItemList;

    public Programacion() {
    }

    public Programacion(BigDecimal nidProgramacion) {
        this.nidProgramacion = nidProgramacion;
    }

    public Programacion(BigDecimal nidProgramacion, BigInteger nidUsuario, String txtProgramacion) {
        this.nidProgramacion = nidProgramacion;
        this.nidUsuario = nidUsuario;
        this.txtProgramacion = txtProgramacion;
    }

    public BigDecimal getNidProgramacion() {
        return nidProgramacion;
    }

    public void setNidProgramacion(BigDecimal nidProgramacion) {
        this.nidProgramacion = nidProgramacion;
    }

    public String getTxtSustento() {
        return txtSustento;
    }

    public void setTxtSustento(String txtSustento) {
        this.txtSustento = txtSustento;
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

    public String getTxtCodigoProgramacion() {
        return txtCodigoProgramacion;
    }

    public void setTxtCodigoProgramacion(String txtCodigoProgramacion) {
        this.txtCodigoProgramacion = txtCodigoProgramacion;
    }

    public String getTxtProgramacion() {
        return txtProgramacion;
    }

    public void setTxtProgramacion(String txtProgramacion) {
        this.txtProgramacion = txtProgramacion;
    }

    @XmlTransient
    public List<AtencionProgramacion> getAtencionProgramacionList() {
        return atencionProgramacionList;
    }

    public void setAtencionProgramacionList(List<AtencionProgramacion> atencionProgramacionList) {
        this.atencionProgramacionList = atencionProgramacionList;
    }

    @XmlTransient
    public List<Logro> getLogroList() {
        return logroList;
    }

    public void setLogroList(List<Logro> logroList) {
        this.logroList = logroList;
    }

    public ObjetivoEstrategico getObjetivoEstrategico() {
        return objetivoEstrategico;
    }

    public void setObjetivoEstrategico(ObjetivoEstrategico objetivoEstrategico) {
        this.objetivoEstrategico = objetivoEstrategico;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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
        hash += (nidProgramacion != null ? nidProgramacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacion)) {
            return false;
        }
        Programacion other = (Programacion) object;
        if ((this.nidProgramacion == null && other.nidProgramacion != null) || (this.nidProgramacion != null && !this.nidProgramacion.equals(other.nidProgramacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Programacion[ nidProgramacion=" + nidProgramacion + " ]";
    }
    
}
