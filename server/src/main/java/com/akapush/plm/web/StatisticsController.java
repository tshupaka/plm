package com.akapush.plm.web;

import com.akapush.plm.domain.bean.AccompanyingStatistics;
import com.akapush.plm.domain.dto.AccompanyingStatisticsDTO;
import com.akapush.plm.security.TokenAuthenticationService;
import com.akapush.plm.service.StatisticsService;
import com.akapush.plm.util.StatisticsHelper;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private StatisticsHelper statisticsHelper;

    @GetMapping("/api/export/csv/young/accompanying")
    public void exportYoungAccompanyingCSV(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // L'URL est whitelisté par Spring Security, il faut donc traiter la sécurité ici
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
        headers.add("pays_mobilite");
        headers.add("type_mobilite");
        headers.add("type_financement");
        headers.add("dernier_rdv_accompagnement");
        response.setContentType("text/csv");

        String filename = "export_accompagnement.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");


        CSVWriter writer = new CSVWriter(response.getWriter());
        String[] headerTabs = new String[headers.size()];
        int index = 0;
        for (String header : headers) {
            headerTabs[index++] = header;
        }
        writer.writeNext(headerTabs);

        List<Map<String, Object>> result = statisticsService.getYoungAccompanyingStatistics();

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


    @GetMapping("/api/export/csv/young/awareness")
    public void exportYoungAwarenessCSV(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
        headers.add("date_sensibilisation");
        headers.add("nom_sensibilisation");
        headers.add("ville_sensibilisation");
        headers.add("type_sensibilisation");
        response.setContentType("text/csv");

        String filename = "export_jeunes_sensibilisations.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");


        CSVWriter writer = new CSVWriter(response.getWriter());
        String[] headerTabs = new String[headers.size()];
        int index = 0;
        for (String header : headers) {
            headerTabs[index++] = header;
        }
        writer.writeNext(headerTabs);

        List<Map<String, Object>> result = statisticsService.getYoungAwarenessStatistics();

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


    @GetMapping("/api/export/csv/awareness")
    public void exportAwarenessCSV(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        headers.add("date");
        headers.add("nom");
        headers.add("ville");
        headers.add("type");
        headers.add("nb_jeunes");
        headers.add("nb_jeunes_qpv");

        response.setContentType("text/csv");

        String filename = "export_sensibilisations.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");


        CSVWriter writer = new CSVWriter(response.getWriter());
        String[] headerTabs = new String[headers.size()];
        int index = 0;
        for (String header : headers) {
            headerTabs[index++] = header;
        }
        writer.writeNext(headerTabs);

        List<Map<String, Object>> result = statisticsService.getAwarenessStatistics();

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


    @RequestMapping(value = "/api/statistics", method = RequestMethod.GET)
    public ResponseEntity<AccompanyingStatisticsDTO> getAccompanyingStatistics() {
        AccompanyingStatistics accompanyingStatistics = statisticsService.getAccompanyingStatistics();
        AccompanyingStatisticsDTO accompanyingStatisticsDTO = statisticsHelper.getAccompanyingStatisticsDTO(accompanyingStatistics);
        return new ResponseEntity<>(accompanyingStatisticsDTO, HttpStatus.OK);
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
