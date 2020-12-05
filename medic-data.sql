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
( 'med_1', 'José Luis', 'Rodríguez Tello', '1', '76771234', '1', '140101', '', 'M', 'https://i.imgur.com/pmA6xSV.png', '1965-11-13'),
( 'med_2', 'Daniel Tulio', 'Córdova Vásquez', '1', '56781041', '1', '140101', '', 'M', 'https://i.imgur.com/suAQ73m.png', '1980-01-12'),
( 'med_3', 'Karen Cesia', 'Zavaleta Huarcaya', '1', '34561041', '1', '140101', '', 'F', 'https://i.imgur.com/LxteMxS.png', '1990-05-25'),
( 'med_4', 'Abhishek', 'Agarwal', '3', 'XZ2223124', '1', '140101', '', 'M', 'https://i.imgur.com/hgc9WCF.png', '1989-07-28'),
( 'med_5', 'Julio Cesár', 'Zegarra Soto', '1', '3654821', '1', '140101', '', 'M', 'https://i.imgur.com/S1oQomJ.png', '1973-12-10'),
( 'med_6', 'Carolina Jimena', 'Chang Súarez', '1', '25486541', '1', '140101', '', 'F', 'https://i.imgur.com/frok9F4.png', '1988-02-13'),
( 'med_7', 'Alexandra Thalia', 'Barnechea García', '1', '78523645', '1', '140101', '', 'F', 'https://i.imgur.com/B9DckwT.png', '1990-01-22'),
( 'med_8', 'Manuel Walter', 'Solis Flores', '1', '76774592', '1', '140101', '', 'M', 'https://i.imgur.com/7WdLpfQ.png', '1985-08-03');

INSERT INTO sala VALUES
( 'sal_1', '1', '1', '2'),
( 'sal_2', '1', '2', '2'),
( 'sal_3', '1', '3', '2'),
( 'sal_4', '1', '4', '2'),
( 'sal_5', '1', '5', '2'),
( 'sal_6', '1', '6', '2'),
( 'sal_7', '1', '7', '0'),
( 'sal_8', '1', '8', '0'),
( 'sal_9', '1', '9', '0'),

( 'sal_10', '2', '1', '0'),
( 'sal_11', '2', '2', '0'),
( 'sal_12', '2', '3', '0'),
( 'sal_13', '2', '4', '0'),
( 'sal_14', '2', '5', '0'),
( 'sal_15', '2', '6', '0'),
( 'sal_16', '2', '7', '0'),
( 'sal_17', '2', '8', '0'),
( 'sal_18', '2', '9', '0'),

( 'sal_19', '3', '1', '0'),
( 'sal_20', '3', '2', '0'),
( 'sal_21', '3', '3', '0'),
( 'sal_22', '3', '4', '0'),
( 'sal_23', '3', '5', '0'),
( 'sal_24', '3', '6', '0'),
( 'sal_25', '3', '7', '0'),
( 'sal_26', '3', '8', '0'),
( 'sal_27', '3', '9', '0'),

( 'sal_28', '4', '1', '0'),
( 'sal_29', '4', '2', '0'),
( 'sal_30', '4', '3', '0'),
( 'sal_31', '4', '4', '0'),
( 'sal_32', '4', '5', '0'),
( 'sal_33', '4', '6', '0'),
( 'sal_34', '4', '7', '0'),
( 'sal_35', '4', '8', '0'),
( 'sal_36', '4', '9', '0'),

( 'sal_37', '5', '1', '0'),
( 'sal_38', '5', '2', '0'),
( 'sal_39', '5', '3', '0'),
( 'sal_40', '5', '4', '0'),
( 'sal_41', '5', '5', '0'),
( 'sal_42', '5', '6', '0'),
( 'sal_43', '5', '7', '0'),
( 'sal_44', '5', '8', '0'),
( 'sal_45', '5', '9', '0'),

( 'sal_46', '6', '1', '0'),
( 'sal_47', '6', '2', '0'),
( 'sal_48', '6', '3', '0'),
( 'sal_49', '6', '4', '0'),
( 'sal_50', '6', '5', '0'),
( 'sal_51', '6', '6', '0'),
( 'sal_52', '6', '7', '0'),
( 'sal_53', '6', '8', '0'),
( 'sal_54', '6', '9', '0'),

( 'sal_55', '7', '1', '0'),
( 'sal_56', '7', '2', '0'),
( 'sal_57', '7', '3', '0'),
( 'sal_58', '7', '4', '0'),
( 'sal_59', '7', '5', '0'),
( 'sal_60', '7', '6', '0'),
( 'sal_61', '7', '7', '0'),
( 'sal_62', '7', '8', '0'),
( 'sal_63', '7', '9', '0');

INSERT INTO hora VALUES
('hor_1', '09:00', '12:00'),
('hor_2', '15:00', '18:00');


INSERT INTO especialidad_medico VALUES 
( 'mir_1', 'med_1', 'esp_2', 'hor_1', '0'),
( 'mir_2', 'med_2', 'esp_2', 'hor_2', '0'),
( 'mir_3', 'med_3', 'esp_2', 'hor_1', '0'),
( 'mir_4', 'med_4', 'esp_2', 'hor_2', '0'),
( 'mir_5', 'med_5', 'esp_8', 'hor_1', '0'),
( 'mir_6', 'med_6', 'esp_8', 'hor_2', '0'),
( 'mir_7', 'med_7', 'esp_8', 'hor_1', '0'),
( 'mir_8', 'med_8', 'esp_8', 'hor_2', '0'),
( 'mir_9', 'med_1', 'esp_9', 'hor_2', '0'),
( 'mir_10', 'med_2', 'esp_9', 'hor_1', '0'),
( 'mir_11', 'med_7', 'esp_9', 'hor_2', '0'),
( 'mir_12', 'med_8', 'esp_9', 'hor_1', '0');

INSERT INTO paciente VALUES
( 'pac_1', 'Ahron Genaro', 'Sotomayor Zegarra', '1', '76771058', '140101', 'Av. Canada 1324', 'M', '', '1996-07-03', 'ahronsz32@gmail.com', 'password');

INSERT INTO cita VALUES
("cit_1", "pac_1", "mir_1", "sal_4","0", "2020-12-04", "10:00"),
("cit_2", "pac_1", "mir_5", "sal_6", "0", "2020-12-04", "09:00"),
("cit_3", "pac_1", "mir_9", "sal_5", "0", "2020-12-04", "15:00"),
("cit_4", "pac_1", "mir_2", "sal_1","0", "2020-12-05", "15:00"),
("cit_5", "pac_1", "mir_6", "sal_2", "0", "2020-12-06", "18:00"),
("cit_6", "pac_1", "mir_10", "sal_3", "0", "2020-12-07", "10:00"),
("cit_7", "pac_1", "mir_3", "sal_4","0", "2020-12-05", "09:00");
