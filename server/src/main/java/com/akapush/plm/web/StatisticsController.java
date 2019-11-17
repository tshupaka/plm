package com.akapush.plm.web;

import com.akapush.plm.security.TokenAuthenticationService;
import com.akapush.plm.service.StatisticsService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;


    @GetMapping("/api/csv/export")
    public void exportCSV(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String token = request.getParameter("token");
        if (token == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        String user = TokenAuthenticationService.getUserInfo(token);
        if (user == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        response.setStatus(HttpStatus.OK.value());
        List<String> headers = new ArrayList<>();

        headers.add("id");
        headers.add("sexe");
        headers.add("prenom");
        headers.add("nom");
        headers.add("datedenaissance");
        headers.add("age");
        headers.add("adherent");
        headers.add("email");
        headers.add("telephone");
        headers.add("skype");
        headers.add("facebook");
        headers.add("adresse1");
        headers.add("adresse2");
        headers.add("codepostal");
        headers.add("ville");
        headers.add("focusgeographique");
        headers.add("qpv");
        headers.add("quartierqpv");
        headers.add("prescripteur");
        headers.add("typeorganismereferent");
        headers.add("detailorganismereferent");
        headers.add("nomreferent");
        headers.add("telephonereferent");
        headers.add("emailreferent");
        headers.add("intituleformation");
        headers.add("niveauformation");
        headers.add("dernierdiplome");
        headers.add("niveauanglais");
        headers.add("autrelangue");
        headers.add("inscriptionpoleemploi");
        headers.add("statutemploi");
        headers.add("allocationrsa");
        headers.add("garantiejeune");
        headers.add("date_depart");
        headers.add("accompagnateur");
        headers.add("nom_projet");
        headers.add("nb_accompagnement");
        headers.add("nb_sensibilisation");
        headers.add("pays_mobilite");
        headers.add("type_mobilite");

        response.setContentType("text/csv");

        String filename = "export.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");


        CSVWriter writer = new CSVWriter(response.getWriter());
        String[] headerTabs = new String[headers.size()];
        int index = 0;
        for (String header : headers) {
            headerTabs[index++] = header;
        }
        writer.writeNext(headerTabs);

        List<Map<String, Object>> result = statisticsService.getStatistics();

        for (Map<String, Object> line : result) {
            String[] csvLine = new String[headers.size()];
            index = 0;
            for (String header : headers) {
                Object value = line.get(header);
                csvLine[index] = getStringValue(value);

                index++;
            }
            writer.writeNext(csvLine);
        }

        writer.close();
    }

    private String getStringValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Date) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(value);
        } else if (value instanceof Boolean) {
            return (Boolean) value ? "Oui" : "Non";
        } else {
            return value.toString();
        }
    }
}
