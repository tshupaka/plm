package com.akapush.plm.dao;

import com.akapush.plm.domain.model.Young;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Map;

public interface StatisticsDAO extends Repository<Young, Long> {

    @Query(value = "SELECT   \n" +
            "                young.you_id as id,   \n" +
            "                ddv_gender.ddv_value as sexe,   \n" +
            "                you_firstname as prenom,   \n" +
            "                you_lastname as nom,   \n" +
            "                you_birthday as dateDeNaissance,   \n" +
            "                extract(year from age(CURRENT_DATE,you_birthday)) as age,   \n" +
            "                you_member as adherent,   \n" +
            "                 \n" +
            "                you_email as email,   \n" +
            "                you_phone as telephone,   \n" +
            "                you_skype as skype,   \n" +
            "                you_facebook as facebook,   \n" +
            "                 \n" +
            "                you_address1 as adresse1,   \n" +
            "                you_address2 as adresse2,   \n" +
            "                you_zipcode as codePostal,   \n" +
            "                you_city as ville,   \n" +
            "                ddv_geographic_focus.ddv_value as focusGeographique,   \n" +
            "                ddv_qpv_status.ddv_value as qpv,   \n" +
            "                ddv_qpv_quarter.ddv_value as quartierQPV,   \n" +
            "                 \n" +
            "                ddv_prescriber.ddv_value as prescripteur,   \n" +
            "                you_prescriber_type_ as typeOrganismeReferent,   \n" +
            "                 \n" +
            "                you_prescriber_detail as detailOrganismeReferent,   \n" +
            "                you_prescriber_name as nomReferent,   \n" +
            "                you_prescriber_phone as telephoneReferent,   \n" +
            "                you_prescriber_email as emailReferent,   \n" +
            "                 \n" +
            "                you_education_label as intituleFormation,   \n" +
            "                ddv_education_level.ddv_value as niveauFormation,   \n" +
            "                you_last_certificate as dernierDiplome,   \n" +
            "                ddv_english_level.ddv_value as niveauAnglais,   \n" +
            "                you_other_language as autreLangue,   \n" +
            "                 \n" +
            "                you_pole_emploi_inscription_date as inscriptionPoleEmploi,   \n" +
            "                ddv_employement_status.ddv_value as statutEmploi,   \n" +
            "                you_rsa_claimant as allocationRSA,   \n" +
            "                you_young_guarantee as garantieJeune,   \n" +
            "                acc_departure_date as date_depart,  \n" +
            "               CASE WHEN project.pro_id is not null then project.pro_name else '' END as nom_projet,  \n" +
            "               CASE WHEN user_.usr_id is not null THEN user_.usr_lastname ELSE '' END as accompagnateur,   \n" +
            "               CASE WHEN accompanying.acc_id is not null THEN accompanying.acc_country ELSE '' END as pays_mobilite,   \n" +
            "               CASE WHEN accompanying.acc_id is not null THEN ddv_mobility_type.ddv_value ELSE '' END as type_mobilite,  \n" +
            "               CASE WHEN accompanying.acc_id is not null then ddv_founding.ddv_value ELSE '' END as type_financement,  \n" +
            "               max(meet.mee_date) as dernier_rdv_accompagnement \n" +
            "                FROM young   \n" +
            "                LEFT OUTER JOIN  accompanying  on young.you_id = accompanying.you_id\n" +
            "               LEFT OUTER JOIN meeting  meet on meet.acc_id = accompanying.acc_id  \n" +
            "               LEFT OUTER JOIN drop_down_value ddv_mobility_type on ddv_mobility_type.ddv_id = accompanying.mobility_type_ddv_id   \n" +
            "               LEFT OUTER JOIN drop_down_value ddv_founding on ddv_founding.ddv_id = accompanying.founding_ddv_id  \n" +
            "               LEFT OUTER JOIN user_ on user_.usr_id = accompanying.usr_id_accompanying  \n" +
            "               LEFT OUTER JOIN project on project.pro_id = accompanying.pro_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_education_level on ddv_education_level.ddv_id = education_level_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_employement_status on ddv_employement_status.ddv_id = employement_status_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_english_level on ddv_english_level.ddv_id = english_level_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_gender on ddv_gender.ddv_id = gender_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_geographic_focus on ddv_geographic_focus.ddv_id = young.geographic_focus_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_prescriber on ddv_prescriber.ddv_id = prescriber_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_qpv_quarter on ddv_qpv_quarter.ddv_id = qpv_quarter_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_qpv_status on ddv_qpv_status.ddv_id = qpv_status_ddv_id\n" +
            "                GROUP BY 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39\n" +
            "                order by you_lastname, you_firstname\n" +
            "                 ",
            nativeQuery = true)
    List<Map<String, Object>> getYoungAccompanyingStatistics();

    @Query(value = "SELECT   \n" +
            "                young.you_id as id,   \n" +
            "                ddv_gender.ddv_value as sexe,   \n" +
            "                you_firstname as prenom,   \n" +
            "                you_lastname as nom,   \n" +
            "                you_birthday as dateDeNaissance,   \n" +
            "                extract(year from age(CURRENT_DATE,you_birthday)) as age,   \n" +
            "                you_member as adherent,   \n" +
            "                 \n" +
            "                you_email as email,   \n" +
            "                you_phone as telephone,   \n" +
            "                you_skype as skype,   \n" +
            "                you_facebook as facebook,   \n" +
            "                 \n" +
            "                you_address1 as adresse1,   \n" +
            "                you_address2 as adresse2,   \n" +
            "                you_zipcode as codePostal,   \n" +
            "                you_city as ville,   \n" +
            "                ddv_geographic_focus.ddv_value as focusGeographique,   \n" +
            "                ddv_qpv_status.ddv_value as qpv,   \n" +
            "                ddv_qpv_quarter.ddv_value as quartierQPV,   \n" +
            "                 \n" +
            "                ddv_prescriber.ddv_value as prescripteur,   \n" +
            "                you_prescriber_type_ as typeOrganismeReferent,   \n" +
            "                 \n" +
            "                you_prescriber_detail as detailOrganismeReferent,   \n" +
            "                you_prescriber_name as nomReferent,   \n" +
            "                you_prescriber_phone as telephoneReferent,   \n" +
            "                you_prescriber_email as emailReferent,   \n" +
            "                 \n" +
            "                you_education_label as intituleFormation,   \n" +
            "                ddv_education_level.ddv_value as niveauFormation,   \n" +
            "                you_last_certificate as dernierDiplome,   \n" +
            "                ddv_english_level.ddv_value as niveauAnglais,   \n" +
            "                you_other_language as autreLangue,   \n" +
            "                 \n" +
            "                you_pole_emploi_inscription_date as inscriptionPoleEmploi,   \n" +
            "                ddv_employement_status.ddv_value as statutEmploi,   \n" +
            "                you_rsa_claimant as allocationRSA,   \n" +
            "                you_young_guarantee as garantieJeune,   \n" +
            "                awa_date as date_sensibilisation,\n" +
            "\t\tawa_name as nom_sensibilisation,\n" +
            "\t\tawa_city as ville_sensibilisation,\n" +
            "\t\ttype_ddv.ddv_value as type_sensibilisation\n" +
            "\t\t\n" +
            "                FROM young   \n" +
            "                left outer join young_awareness ya on ya.you_id = young.you_id\n" +
            "                LEFT OUTER JOIN awareness on ya.awa_id = awareness.awa_id\n" +
            "                LEFT OUTER JOIN drop_down_value type_ddv on type_ddv.ddv_id = type_ddv_id\n" +
            "                LEFT OUTER JOIN drop_down_value ddv_education_level on ddv_education_level.ddv_id = education_level_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_employement_status on ddv_employement_status.ddv_id = employement_status_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_english_level on ddv_english_level.ddv_id = english_level_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_gender on ddv_gender.ddv_id = gender_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_geographic_focus on ddv_geographic_focus.ddv_id = young.geographic_focus_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_prescriber on ddv_prescriber.ddv_id = prescriber_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_qpv_quarter on ddv_qpv_quarter.ddv_id = qpv_quarter_ddv_id   \n" +
            "                LEFT OUTER JOIN drop_down_value ddv_qpv_status on ddv_qpv_status.ddv_id = qpv_status_ddv_id\n" +
            "                order by you_lastname, you_firstname\n" +
            "               ",
            nativeQuery = true)
    List<Map<String, Object>> getYoungAwarenessStatistics();

    @Query(value = "\n" +
            "    select awa_date as date,\n" +
            "    awa_name as nom,\n" +
            "    awa_city as ville,\n" +
            "    type_ddv.ddv_value as type,\n" +
            "    sum(CASE WHEN young.you_id is not null then 1 else 0 end) as nb_jeunes,\n" +
            "    sum(CASE WHEN UPPER(qpv_status_ddv.ddv_value) != 'NON' then 1 else 0 end) as nb_jeunes_qpv\n" +
            "    from awareness\n" +
            "    left outer join drop_down_value type_ddv on type_ddv.ddv_id = type_ddv_id\n" +
            "    left outer join young_awareness ya on ya.awa_id = awareness.awa_id\n" +
            "    left outer join young on young.you_id = ya.you_id\n" +
            "    left outer join drop_down_value qpv_status_ddv on young.qpv_status_ddv_id = qpv_status_ddv.ddv_id\n" +
            "    group by 1,2,3,4\n" +
            "    order by 1\n" +
            "           ",
    nativeQuery = true)
    List<Map<String, Object>> exportAwarnessStatistics();
}
