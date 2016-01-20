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
@Table(name = "PROGRAMACION_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramacionItem.findAll", query = "SELECT p FROM ProgramacionItem p"),
    @NamedQuery(name = "ProgramacionItem.findByNidProgramacionItem", query = "SELECT p FROM ProgramacionItem p WHERE p.nidProgramacionItem = :nidProgramacionItem"),
    @NamedQuery(name = "ProgramacionItem.findByFlgActivo", query = "SELECT p FROM ProgramacionItem p WHERE p.flgActivo = :flgActivo"),
    @NamedQuery(name = "ProgramacionItem.findByNidUsuario", query = "SELECT p FROM ProgramacionItem p WHERE p.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "ProgramacionItem.findByTxtPc", query = "SELECT p FROM ProgramacionItem p WHERE p.txtPc = :txtPc"),
    @NamedQuery(name = "ProgramacionItem.findByTxtIp", query = "SELECT p FROM ProgramacionItem p WHERE p.txtIp = :txtIp"),
    @NamedQuery(name = "ProgramacionItem.findByFecEdicion", query = "SELECT p FROM ProgramacionItem p WHERE p.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "ProgramacionItem.findByTxtCodigoProgramacionItem", query = "SELECT p FROM ProgramacionItem p WHERE p.txtCodigoProgramacionItem = :txtCodigoProgramacionItem"),
    @NamedQuery(name = "ProgramacionItem.findByTxtProgramacionItem", query = "SELECT p FROM ProgramacionItem p WHERE p.txtProgramacionItem = :txtProgramacionItem")})
public class ProgramacionItem implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_PROGRAMACION_ITEM", sequenceName = "SQ_PROGRAMACION_ITEM", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROGRAMACION_ITEM")
    @Column(name = "NID_PROGRAMACION_ITEM")
    private BigDecimal nidProgramacionItem;
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
    @Column(name = "TXT_CODIGO_PROGRAMACION_ITEM")
    private String txtCodigoProgramacionItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TXT_PROGRAMACION_ITEM")
    private String txtProgramacionItem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programacionItem", fetch = FetchType.LAZY)
    private List<AccionEstrategica> accionEstrategicaList;
    @JoinColumn(name = "NID_META_PRESUPUESTARIA", referencedColumnName = "NID_META_PRESUPUESTARIA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MetaPresupuestaria metaPresupuestaria;
    @JoinColumn(name = "NID_PROGRAMACION", referencedColumnName = "NID_PROGRAMACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programacion programacion;
    @JoinColumn(name = "NID_UNIDAD_ORGANICA", referencedColumnName = "NID_UNIDAD_ORGANICA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadOrganica unidadOrganica;

    public ProgramacionItem() {
    }

    public ProgramacionItem(BigDecimal nidProgramacionItem) {
        this.nidProgramacionItem = nidProgramacionItem;
    }

    public ProgramacionItem(BigDecimal nidProgramacionItem, BigInteger nidUsuario, String txtProgramacionItem) {
        this.nidProgramacionItem = nidProgramacionItem;
        this.nidUsuario = nidUsuario;
        this.txtProgramacionItem = txtProgramacionItem;
    }

    public BigDecimal getNidProgramacionItem() {
        return nidProgramacionItem;
    }

    public void setNidProgramacionItem(BigDecimal nidProgramacionItem) {
        this.nidProgramacionItem = nidProgramacionItem;
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

    public String getTxtCodigoProgramacionItem() {
        return txtCodigoProgramacionItem;
    }

    public void setTxtCodigoProgramacionItem(String txtCodigoProgramacionItem) {
        this.txtCodigoProgramacionItem = txtCodigoProgramacionItem;
    }

    public String getTxtProgramacionItem() {
        return txtProgramacionItem;
    }

    public void setTxtProgramacionItem(String txtProgramacionItem) {
        this.txtProgramacionItem = txtProgramacionItem;
    }

    @XmlTransient
    public List<AccionEstrategica> getAccionEstrategicaList() {
        return accionEstrategicaList;
    }

    public void setAccionEstrategicaList(List<AccionEstrategica> accionEstrategicaList) {
        this.accionEstrategicaList = accionEstrategicaList;
    }

    public MetaPresupuestaria getMetaPresupuestaria() {
        return metaPresupuestaria;
    }

    public void setMetaPresupuestaria(MetaPresupuestaria metaPresupuestaria) {
        this.metaPresupuestaria = metaPresupuestaria;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public UnidadOrganica getUnidadOrganica() {
        return unidadOrganica;
    }

    public void setUnidadOrganica(UnidadOrganica unidadOrganica) {
        this.unidadOrganica = unidadOrganica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidProgramacionItem != null ? nidProgramacionItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionItem)) {
            return false;
        }
        ProgramacionItem other = (ProgramacionItem) object;
        if ((this.nidProgramacionItem == null && other.nidProgramacionItem != null) || (this.nidProgramacionItem != null && !this.nidProgramacionItem.equals(other.nidProgramacionItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.ProgramacionItem[ nidProgramacionItem=" + nidProgramacionItem + " ]";
    }
    
}
