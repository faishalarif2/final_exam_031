/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.final_exam;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author NITRO
 */
@Entity
@Table(name = "surat")
@NamedQueries({
    @NamedQuery(name = "Surat.findAll", query = "SELECT s FROM Surat s"),
    @NamedQuery(name = "Surat.findById", query = "SELECT s FROM Surat s WHERE s.suratPK.id = :id"),
    @NamedQuery(name = "Surat.findByNoSurat", query = "SELECT s FROM Surat s WHERE s.suratPK.noSurat = :noSurat"),
    @NamedQuery(name = "Surat.findByJudul", query = "SELECT s FROM Surat s WHERE s.judul = :judul"),
    @NamedQuery(name = "Surat.findByTembusan", query = "SELECT s FROM Surat s WHERE s.tembusan = :tembusan"),
    @NamedQuery(name = "Surat.findByTimestamp", query = "SELECT s FROM Surat s WHERE s.timestamp = :timestamp")})
public class Surat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuratPK suratPK;
    @Column(name = "judul")
    private String judul;
    @Column(name = "tembusan")
    private String tembusan;
    @Lob
    @Column(name = "file")
    private byte[] file;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Surat() {
    }

    public Surat(SuratPK suratPK) {
        this.suratPK = suratPK;
    }

    public Surat(SuratPK suratPK, Date timestamp) {
        this.suratPK = suratPK;
        this.timestamp = timestamp;
    }

    public Surat(int id, int noSurat) {
        this.suratPK = new SuratPK(id, noSurat);
    }

    public SuratPK getSuratPK() {
        return suratPK;
    }

    public void setSuratPK(SuratPK suratPK) {
        this.suratPK = suratPK;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suratPK != null ? suratPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surat)) {
            return false;
        }
        Surat other = (Surat) object;
        if ((this.suratPK == null && other.suratPK != null) || (this.suratPK != null && !this.suratPK.equals(other.suratPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pws.a.final_exam.Surat[ suratPK=" + suratPK + " ]";
    }
    
}
