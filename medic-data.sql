USE medic;
INSERT INTO especialidad (cod_esp, nombre, image) VALUES 
( 'esp_1', 'Radiología', 'https://i.imgur.com/oHezj3o.png'),
( 'esp_2', 'Neurología', 'https://i.imgur.com/fpKaQc1.png'),
( 'esp_3', 'ORL', 'https://i.imgur.com/7FIMPJ7.png'),
( 'esp_4', 'Oftalmologia', 'https://i.imgur.com/60toiLC.png'),
( 'esp_5', 'Osteología', 'https://i.imgur.com/aAmKZin.png'),
( 'esp_6', 'Anestesiología', 'https://i.imgur.com/BQNUWJi.png'),
( 'esp_7', 'Ortopédico', 'https://i.imgur.com/nsSCBKn.png'),
( 'esp_8', 'Dermatología', 'https://i.imgur.com/kvBTtPz.png'),
( 'esp_9', 'Medicina Familiar', 'https://i.imgur.com/TVvHKhJ.png'),
( 'esp_10', 'Medicina Interna', 'https://i.imgur.com/mqe5VJe.png'),
( 'esp_11', 'Pediatría', 'https://i.imgur.com/3faG8ns.png'),
( 'esp_12', 'Fisióterapia', 'https://i.imgur.com/34kiOGO.png'),
( 'esp_13', 'Examen Hormonal', 'https://i.imgur.com/PdbOBqs.png'),
( 'esp_14', 'Patología Anatómica', 'https://i.imgur.com/JBV3Smx.png'),
( 'esp_15', 'Medicina de Emergencia', 'https://i.imgur.com/TSskSp3.png');

INSERT INTO medico VALUES
( 'med_1', 'José Luis', 'Rodríguez Tello', '1', '76771234', '1', '140101', '', 'M', 'https://i.imgur.com/pmA6xSV.png', '1996-07-03'),
( 'med_2', 'Daniel Tulio', 'Córdova Vásquez', '1', '56781041', '1', '140101', '', 'M', 'https://i.imgur.com/suAQ73m.png', '1996-07-03'),
( 'med_3', 'Karen Cesia', 'Zavaleta Huarcaya', '1', '34561041', '1', '140101', '', 'F', 'https://i.imgur.com/LxteMxS.png', '1996-07-03'),
( 'med_4', 'Abhishek', 'Agarwal', '3', 'XZ2223124', '1', '140101', '', 'M', 'https://i.imgur.com/hgc9WCF.png', '1996-07-03'),
( 'med_5', 'Julio Cesár', 'Zegarra Soto', '1', '3654821', '1', '140101', '', 'M', 'https://i.imgur.com/S1oQomJ.png', '1996-07-03'),
( 'med_6', 'Carolina Jimena', 'Chang Súarez', '1', '25486541', '1', '140101', '', 'F', 'https://i.imgur.com/frok9F4.png', '1996-07-03'),
( 'med_7', 'Alexandra Thalia', 'Barnechea García', '1', '78523645', '1', '140101', '', 'F', 'https://i.imgur.com/B9DckwT.png', '1996-07-03'),
( 'med_8', 'Manual Walter', 'Solis Flores', '1', '76774592', '1', '140101', '', 'M', 'https://i.imgur.com/7WdLpfQ.png', '1996-07-03');

INSERT INTO sala VALUES
( 'sal_1', '1', '1'),
( 'sal_2', '1', '2'),
( 'sal_3', '1', '3'),
( 'sal_4', '1', '4'),
( 'sal_5', '1', '5'),
( 'sal_6', '2', '1'),
( 'sal_7', '2', '2'),
( 'sal_8', '2', '3'),
( 'sal_9', '2', '4'),
( 'sal_10', '2', '5'),
( 'sal_11', '3', '1'),
( 'sal_12', '3', '2'),
( 'sal_13', '3', '3'),
( 'sal_14', '3', '4'),
( 'sal_15', '3', '5'),
( 'sal_16', '4', '1'),
( 'sal_17', '4', '2'),
( 'sal_18', '4', '3'),
( 'sal_19', '4', '4'),
( 'sal_20', '4', '5'),
( 'sal_21', '5', '1'),
( 'sal_22', '5', '2'),
( 'sal_23', '5', '3'),
( 'sal_24', '5', '4'),
( 'sal_25', '5', '5'),
( 'sal_26', '5', '6');

INSERT INTO especialidad_medico VALUES 
( 'mir_1', 'med_1', 'esp_3'),
( 'mir_2', 'med_2', 'esp_3'),
( 'mir_3', 'med_3', 'esp_3'),
( 'mir_4', 'med_4', 'esp_3'),
( 'mir_5', 'med_5', 'esp_4'),
( 'mir_6', 'med_6', 'esp_4'),
( 'mir_7', 'med_7', 'esp_4'),
( 'mir_8', 'med_8', 'esp_4'),
( 'mir_9', 'med_1', 'esp_8'),
( 'mir_10', 'med_2', 'esp_8'),
( 'mir_11', 'med_7', 'esp_8'),
( 'mir_12', 'med_8', 'esp_8');

INSERT INTO paciente VALUES
( 'pac_1', 'Ahron Genaro', 'Sotomayor Zegarra', '1', '76771058', '140101', 'Av. Canada 1324', 'M', '', '1996-07-03', 'ahronsz32@gmail.com', 'password');

INSERT INTO cita VALUES
("cit_1", "pac_1", "med_1", "sal_4", "esp_3", "0", "2020-12-04", "15:00"),
("cit_2", "pac_1", "med_1", "sal_4", "esp_8", "0", "2020-12-04", "18:00");
/* las citas son de 09:00 hasta las 18:00*/
 select c.* from cita c inner join especialidad_medico em on em.cod_med = c.cod_med where em.cod_esp = 'esp_3' and;



/*SELECT TIME_FORMAT(hora, "%h:%i %p") from sala;*/
/*SELECT * FROM medico where cod_med = med_1 inner join especialidad_medico on medico.cod_med = especialidad_medico.cod_med;*/
/* select medico.* from medico inner join especialidad_medico on especialidad_medico.cod_med = medico.cod_med where especialidad_medico.cod_esp = 'esp_3';*/
select m.* from medico m inner join especialidad_medico em on em.cod_med = m.cod_med where em.cod_esp = 'esp_3';
