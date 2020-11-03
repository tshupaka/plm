-- Sensibilisation

select awa_date as date,
awa_name as nom,
awa_city as ville,
type_ddv.ddv_value as type,
count(*) as nb_jeunes,
sum(CASE WHEN UPPER(qpv_status_ddv.ddv_value) != 'NON' then 1 else 0 end) as nb_jeunes_qpv
 from awareness
 left outer join drop_down_value type_ddv on type_ddv.ddv_id = type_ddv_id
 left outer join young_awareness ya on ya.awa_id = awareness.awa_id
 left outer join young on young.you_id = ya.you_id
 left outer join drop_down_value qpv_status_ddv on young.qpv_status_ddv_id = qpv_status_ddv.ddv_id
 group by 1,2,3,4
 order by 1;



 