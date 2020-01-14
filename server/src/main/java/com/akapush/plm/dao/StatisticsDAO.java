package com.akapush.plm.dao;

import com.akapush.plm.domain.model.Young;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Map;

public interface StatisticsDAO extends Repository<Young, Long> {

    @Query(value="SELECT \n" +
            "    young.you_id as id, \n" +
            "    ddv_gender.ddv_value as sexe, \n" +
            "    you_firstname as prenom, \n" +
            "    you_lastname as nom, \n" +
            "    you_birthday as dateDeNaissance, \n" +
            "    extract(year from age(CURRENT_DATE,you_birthday)) as age, \n" +
            "    you_member as adherent, \n" +
            "   \n" +
            "    you_email as email, \n" +
            "    you_phone as telephone, \n" +
            "    you_skype as skype, \n" +
            "    you_facebook as facebook, \n" +
            "   \n" +
            "    you_address1 as adresse1, \n" +
            "    you_address2 as adresse2, \n" +
            "    you_zipcode as codePostal, \n" +
            "    you_city as ville, \n" +
            "    ddv_geographic_focus.ddv_value as focusGeographique, \n" +
            "    ddv_qpv_status.ddv_value as qpv, \n" +
            "    ddv_qpv_quarter.ddv_value as quartierQPV, \n" +
            "   \n" +
            "    ddv_prescriber.ddv_value as prescripteur, \n" +
            "    you_prescriber_type_ as typeOrganismeReferent, \n" +
            "   \n" +
            "    you_prescriber_detail as detailOrganismeReferent, \n" +
            "    you_prescriber_name as nomReferent, \n" +
            "    you_prescriber_phone as telephoneReferent, \n" +
            "    you_prescriber_email as emailReferent, \n" +
            "   \n" +
            "    you_education_label as intituleFormation, \n" +
            "    ddv_education_level.ddv_value as niveauFormation, \n" +
            "    you_last_certificate as dernierDiplome, \n" +
            "    ddv_english_level.ddv_value as niveauAnglais, \n" +
            "    you_other_language as autreLangue, \n" +
            "   \n" +
            "    you_pole_emploi_inscription_date as inscriptionPoleEmploi, \n" +
            "    ddv_employement_status.ddv_value as statutEmploi, \n" +
            "    you_rsa_claimant as allocationRSA, \n" +
            "    you_young_guarantee as garantieJeune, \n" +
            "    accomp.date_depart,\n" +
            "    accomp.accompagnateur,\n" +
            "    accomp.nom_projet,\n" +
            "    accomp.nb_accompagnement, \n" +
            "    accomp.pays_mobilite, \n" +
            "    accomp.type_mobilite, \n" +
            "    accomp.type_financement,\n" +
            "    accomp.dernier_rdv_accompagnement,\n" +
            "    awar.nb_sensibilisation,\n" +
            "    awar.derniere_sensibilisation\n" +
            "    FROM young \n" +
            "    LEFT OUTER JOIN\n" +
            "\t\t(SELECT \n" +
            "\t\t\taccompanying.you_id,\n" +
            "\t\t\tcount(*) as nb_accompagnement,\n" +
            "\t\t\tmax(acc_departure_date) as date_depart,\n" +
            "\t\t\tstring_agg(CASE WHEN project.pro_id is not null then project.pro_name else '' END, ',') as nom_projet,\n" +
            "\t\t\tstring_agg(CASE WHEN user_.usr_id is not null THEN user_.usr_lastname ELSE '' END, ',') as accompagnateur, \n" +
            "\t\t\tstring_agg(CASE WHEN accompanying.acc_id is not null THEN accompanying.acc_country ELSE '' END, ',') as pays_mobilite, \n" +
            "\t\t\tstring_agg(CASE WHEN accompanying.acc_id is not null THEN ddv_mobility_type.ddv_value ELSE '' END, ',') as type_mobilite,\n" +
            "\t\t\tstring_agg(CASE WHEN accompanying.acc_id is not null then ddv_founding.ddv_value ELSE '' END, ',') as type_financement,\n" +
            "\t\t\tmax(meet.dernier_rdv_accompagnement) as dernier_rdv_accompagnement\n" +
            "\t\t\tFROM accompanying\n" +
            "\t\t\tLEFT OUTER JOIN \n" +
            "\t\t\t\t(SELECT acc_id,\n" +
            "\t\t\t\t\tmax(meeting.mee_date) as dernier_rdv_accompagnement\n" +
            "\t\t\t\tFROM meeting\n" +
            "\t\t\t\tGROUP BY acc_id) meet on meet.acc_id = accompanying.acc_id\n" +
            "\t\t\tLEFT OUTER JOIN drop_down_value ddv_mobility_type on ddv_mobility_type.ddv_id = accompanying.mobility_type_ddv_id \n" +
            "\t\t\tLEFT OUTER JOIN drop_down_value ddv_founding on ddv_founding.ddv_id = accompanying.founding_ddv_id\n" +
            "\t\t\tLEFT OUTER JOIN user_ on user_.usr_id = accompanying.usr_id_accompanying\n" +
            "\t\t\tLEFT OUTER JOIN project on project.pro_id = accompanying.pro_id\n" +
            "\t\t\tGROUP BY accompanying.you_id ) accomp ON accomp.you_id = young.you_id \n" +
            "    \n" +
            "    LEFT OUTER JOIN \n" +
            "\t( SELECT \n" +
            "\t\tya.you_id,\n" +
            "\t\tSUM(CASE WHEN ya.awa_id is not null then 1 else 0 END) as nb_sensibilisation,\n" +
            "\t\tmax(awa_date) as derniere_sensibilisation\n" +
            "\t\tFROM young_awareness ya \n" +
            "\t\tLEFT OUTER JOIN awareness on awareness.awa_id = ya.awa_id\n" +
            "\t\tGROUP BY ya.you_id) awar ON awar.you_id = young.you_id\n" +
            "    LEFT OUTER JOIN drop_down_value ddv_education_level on ddv_education_level.ddv_id = education_level_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_employement_status on ddv_employement_status.ddv_id = employement_status_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_english_level on ddv_english_level.ddv_id = english_level_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_gender on ddv_gender.ddv_id = gender_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_geographic_focus on ddv_geographic_focus.ddv_id = young.geographic_focus_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_prescriber on ddv_prescriber.ddv_id = prescriber_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_qpv_quarter on ddv_qpv_quarter.ddv_id = qpv_quarter_ddv_id \n" +
            "    LEFT OUTER JOIN drop_down_value ddv_qpv_status on ddv_qpv_status.ddv_id = qpv_status_ddv_id \n" +
            "   ",
            nativeQuery = true)
    List<Map<String, Object>> getStatistics();

}
