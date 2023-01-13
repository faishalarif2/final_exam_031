/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.final_exam;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author NITRO
 */
@Embeddable
public class SuratPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "no_surat")
    private int noSurat;

    public SuratPK() {
    }

    public SuratPK(int id, int noSurat) {
        this.id = id;
        this.noSurat = noSurat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(int noSurat) {
        this.noSurat = noSurat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) noSurat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuratPK)) {
            return false;
        }
        SuratPK other = (SuratPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.noSurat != other.noSurat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pws.a.final_exam.SuratPK[ id=" + id + ", noSurat=" + noSurat + " ]";
    }
    
}
