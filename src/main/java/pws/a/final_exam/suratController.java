/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.final_exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NITRO (Faishal Arif Nugroho_20200140031)
 */
@RestController
@CrossOrigin
@RequestMapping("/mysurat")
public class suratController {

    Surat data = new Surat();
    SuratJpaController ctrl = new SuratJpaController();

    @GetMapping
    public List<Surat> getAll() {
        List<Surat> surat = new ArrayList<>();
        try{
            surat = ctrl.findSuratEntities();
        }catch (Exception e){
            surat = List.of();
        }
        return surat;

    }
    
    @GetMapping("/{id}")
    public List<Surat> getNameById(@PathVariable("id") int id) {
        List<Surat> surat = new ArrayList<>(); // Declare new LIST
        try {
            data = ctrl.findSurat(id); // get data from db
            surat.add(data); // fill data from db to list
        } catch (Exception e) {
            surat = List.of(); // data not found
        }
        return surat;
    }
    
    @PostMapping()
    public String createData(HttpEntity<String> paket) {
        String message = "";

        try {
            String json_receive = paket.getBody();

            ObjectMapper map = new ObjectMapper();
        
            data = map.readValue(json_receive, Surat.class);

            ctrl.create(data);
            message = data.getSuratPK()+ " Data Saved";

        } catch (Exception e) {
            message = "Failed";
        }

        return message;
    }
    
    @PutMapping()
    public String editData(HttpEntity<String> paket) {
        String message = "";

        try {
            String json_receive = paket.getBody();

            ObjectMapper map = new ObjectMapper();
        
            data = map.readValue(json_receive, Surat.class);

            ctrl.edit(data);
            message = data.getJudul()+ " Data Update";

        } catch (Exception e) {
            message = "Failed";
        }

        return message;
    }
    
    @DeleteMapping()
    public String deleteData(HttpEntity<String> paket) {
        String message = "";

        try {
            String json_receive = paket.getBody();

            ObjectMapper map = new ObjectMapper();
        
            data = map.readValue(json_receive, Surat.class);

            ctrl.destroy(data.getSuratPK());
            message = "SURAT = " +data.getJudul().toString() + " Data Delete";

        } catch (Exception e) {
            message = "Failed";
        }

        return message;
    }

}
