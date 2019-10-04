/*
DROP TABLE DROP_DOWN_VALUE;
DROP TABLE DROP_DOWN_KEY;
DROP SEQUENCE seq_plm_drop_down_key_ddk_id;
DROP SEQUENCE seq_plm_drop_down_value_ddv_id;
*/




CREATE TABLE DROP_DOWN_KEY (
  DDK_ID BIGINT NOT NULL,
  DDK_KEY VARCHAR(255) NOT NULL,
  DDK_LABEL VARCHAR(255) NOT NULL,
  PRIMARY KEY (DDK_ID));
  
CREATE TABLE DROP_DOWN_VALUE (
	DDV_ID BIGINT NOT NULL,
	DDV_VALUE VARCHAR(512) NOT NULL,
	DDV_ORDER INT NOT NULL,
	DDK_ID BIGINT NOT NULL,
	PRIMARY KEY (DDV_ID),
	FOREIGN KEY (DDK_ID) REFERENCES DROP_DOWN_KEY(DDK_ID)
);

CREATE SEQUENCE seq_plm_drop_down_key_ddk_id START 1;
CREATE SEQUENCE seq_plm_drop_down_value_ddv_id START 1;

INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'gender', 'Sexe');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'public', 'Public');

INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'geographicFocus', 'Focus Géographique');

INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'awarenessType', 'Type de sensibilisation');

INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'qpvQuarter', 'Nom Quartier Politique de la ville');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'prescriber', 'Prescripteur');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'educationlevel', 'Niveau de formation');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'englishLevel', 'Niveau d''anglais');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'employmentStatus', 'Statut d''emploi');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'qpvStatus', 'Est quartier QPV');


INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'position','Situation (accompagnement)');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'endFollowReason','Raison fin accompagnement');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'mobilityDuration','Durée de la mobilité');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'geographicZone','Zone géographique (mobilité)');
INSERT INTO DROP_DOWN_KEY (DDK_ID, DDK_KEY, DDK_LABEL) VALUES (nextval('seq_plm_drop_down_key_ddk_id'), 'mobilityType','Type de mobilité');



INSERT INTO DROP_DOWN_VALUE(DDV_ID, DDV_VALUE,DDV_ORDER, DDK_ID) VALUES (nextval('seq_plm_drop_down_value_ddv_id'), 'Femme', 1, 1);
INSERT INTO DROP_DOWN_VALUE(DDV_ID, DDV_VALUE,DDV_ORDER, DDK_ID) VALUES (nextval('seq_plm_drop_down_value_ddv_id'), 'Homme', 2, 1);
INSERT INTO DROP_DOWN_VALUE(DDV_ID, DDV_VALUE,DDV_ORDER, DDK_ID) VALUES (nextval('seq_plm_drop_down_value_ddv_id'), 'Autre', 3, 1);

'Raison fin accompagnement'
'Durée de la mobilité'
'Zone géographique (mobilité)'
'Type de mobilité'

CREATE SEQUENCE seq_plm_young_you_id START 1;

