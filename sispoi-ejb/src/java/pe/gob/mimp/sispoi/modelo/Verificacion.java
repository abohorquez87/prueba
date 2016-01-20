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
@Table(name = "VERIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Verificacion.findAll", query = "SELECT v FROM Verificacion v"),
    @NamedQuery(name = "Verificacion.findByNidVerificacion", query = "SELECT v FROM Verificacion v WHERE v.nidVerificacion = :nidVerificacion"),
    @NamedQuery(name = "Verificacion.findByTxtVerificacion", query = "SELECT v FROM Verificacion v WHERE v.txtVerificacion = :txtVerificacion"),
    @NamedQuery(name = "Verificacion.findByFlgActivo", query = "SELECT v FROM Verificacion v WHERE v.flgActivo = :flgActivo"),
    @NamedQuery(name = "Verificacion.findByNidUsuario", query = "SELECT v FROM Verificacion v WHERE v.nidUsuario = :nidUsuario"),
    @NamedQuery(name = "Verificacion.findByTxtPc", query = "SELECT v FROM Verificacion v WHERE v.txtPc = :txtPc"),
    @NamedQuery(name = "Verificacion.findByTxtIp", query = "SELECT v FROM Verificacion v WHERE v.txtIp = :txtIp"),
    @NamedQuery(name = "Verificacion.findByFecEdicion", query = "SELECT v FROM Verificacion v WHERE v.fecEdicion = :fecEdicion"),
    @NamedQuery(name = "Verificacion.findByTxtCodigoVerificacion", query = "SELECT v FROM Verificacion v WHERE v.txtCodigoVerificacion = :txtCodigoVerificacion")})
public class Verificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "SQ_VERIFICACION", sequenceName = "SQ_VERIFICACION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VERIFICACION")
    @Column(name = "NID_VERIFICACION")
    private BigDecimal nidVerificacion;
    @Size(max = 512)
    @Column(name = "TXT_VERIFICACION")
    private String txtVerificacion;
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
    @Column(name = "TXT_CODIGO_VERIFICACION")
    private String txtCodigoVerificacion;
    @JoinColumn(name = "NID_ACTIVIDAD_PROGRAMADA", referencedColumnName = "NID_ACTIVIDAD_PROGRAMADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadProgramada actividadProgramada;
    @JoinColumn(name = "NID_MEDIO", referencedColumnName = "NID_MEDIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Medio medio;

    public Verificacion() {
    }

    public Verificacion(BigDecimal nidVerificacion) {
        this.nidVerificacion = nidVerificacion;
    }

    public Verificacion(BigDecimal nidVerificacion, BigInteger nidUsuario) {
        this.nidVerificacion = nidVerificacion;
        this.nidUsuario = nidUsuario;
    }

    public BigDecimal getNidVerificacion() {
        return nidVerificacion;
    }

    public void setNidVerificacion(BigDecimal nidVerificacion) {
        this.nidVerificacion = nidVerificacion;
    }

    public String getTxtVerificacion() {
        return txtVerificacion;
    }

    public void setTxtVerificacion(String txtVerificacion) {
        this.txtVerificacion = txtVerificacion;
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

    public String getTxtCodigoVerificacion() {
        return txtCodigoVerificacion;
    }

    public void setTxtCodigoVerificacion(String txtCodigoVerificacion) {
        this.txtCodigoVerificacion = txtCodigoVerificacion;
    }

    public ActividadProgramada getActividadProgramada() {
        return actividadProgramada;
    }

    public void setActividadProgramada(ActividadProgramada actividadProgramada) {
        this.actividadProgramada = actividadProgramada;
    }

    public Medio getMedio() {
        return medio;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nidVerificacion != null ? nidVerificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Verificacion)) {
            return false;
        }
        Verificacion other = (Verificacion) object;
        if ((this.nidVerificacion == null && other.nidVerificacion != null) || (this.nidVerificacion != null && !this.nidVerificacion.equals(other.nidVerificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.mimp.sispoi.modelo.Verificacion[ nidVerificacion=" + nidVerificacion + " ]";
    }
    
}
