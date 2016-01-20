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
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desarrollador
 */
@Entity
@Table(name = "LOGRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logro.findAll", query = "SELECT l FROM Logro l"),
    @NamedQuery(name = "Logro.findByNidLogro", query = "SELECT l FROM Logro l WHERE l.nidLogro = :nidLogro"),
    @NamedQuery(name = "Logro.findByTxtLogro", query = "SELECT l FROM Logro l WHERE l.txtLogro = :txtLogro"),
    @NamedQuery(name = "Logro.findByFlgActivo", query = "SELECT l FROM Logro l WHERE l.flgActivo = :flgActivo"),
    @NamedQuery(name = "Logro.findByNidUsuario", query = "SELECT l FROM Logro l WHERE l.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Logro.findByTxtPc", query = "SELECT l FROM Logro l WHERE l.txtPc = :txtPc"),
    @NamedQuery(name = "Logro.findByTxtIp", query = "SELECT l FROM Logro l WHERE l.txtIp = :txtIp"),
    @NamedQuery(name = "Logro.findByFecEdicion", query = "SELECT l FROM Logro l WHERE l.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Logro.findByTxtCodigoLogro", query = "SELECT l FROM Logro l WHERE l.txtCodigoLogro = :txtCodigoLogro")})
public class Logro implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_LOGRO", sequenceName = "SQ_LOGRO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOGRO")
    @Column(name = "NID_LOGRO")
    private BigDecimal nidLogro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "TXT_LOGRO")
    private String txtLogro;
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
    @Column(name = "TXT_CODIGO_LOGRO")
    private String txtCodigoLogro;
    @JoinColumn(name = "NID_PROGRAMACION", referencedColumnName = "NID_PROGRAMACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programacion programacion;

    public Logro() {
    }

    public Logro(BigDecimal nidLogro) {
        this.nidLogro = nidLogro;
    }

    public Logro(BigDecimal nidLogro, String txtLogro, BigInteger nidUsuario) {
        this.nidLogro = nidLogro;
        this.txtLogro = txtLogro;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidLogro() {
        return nidLogro;
    }

    public void setNidLogro(BigDecimal nidLogro) {
        this.nidLogro = nidLogro;
    }

    public String getTxtLogro() {
        return txtLogro;
    }

    public void setTxtLogro(String txtLogro) {
        this.txtLogro = txtLogro;
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

    public String getTxtCodigoLogro() {
        return txtCodigoLogro;
    }

    public void setTxtCodigoLogro(String txtCodigoLogro) {
        this.txtCodigoLogro = txtCodigoLogro;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidLogro != null ? nidLogro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.nidLogro == null && other.nidLogro != null) || (this.nidLogro != null && !this.nidLogro.equals(other.nidLogro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Logro[ nidLogro=" + nidLogro + " ]";
    }
    
}
