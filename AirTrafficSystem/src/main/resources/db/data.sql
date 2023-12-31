INSERT INTO AEROPORTO(ID,NAME) VALUES (1,'POA');
INSERT INTO AEROPORTO(ID,NAME) VALUES (2,'FLO');
INSERT INTO AEROPORTO(ID,NAME) VALUES (3,'SP');
INSERT INTO AEROPORTO(ID,NAME) VALUES (4,'CWB');

INSERT INTO ROTAS(ID,NAME) VALUES (1,'POAFLO_R1');
INSERT INTO ROTAS(ID,NAME) VALUES (2,'POAGRU_R2');
INSERT INTO ROTAS(ID,NAME) VALUES (3,'GRUPOA_R3');
INSERT INTO ROTAS(ID,NAME) VALUES (4,'FLOCWB_R4');
INSERT INTO ROTAS(ID,NAME) VALUES (5,'CWBFLO_R5');
INSERT INTO ROTAS(ID,NAME) VALUES (6,'CWBGRU_R6');
INSERT INTO ROTAS(ID,NAME) VALUES (7,'GRUCWB_R7');
INSERT INTO ROTAS(ID,NAME) VALUES (8,'FLOPOA_R8');

INSERT INTO LINHAS_AEREAS(ID,NAME) VALUES (1,'Linha1');
INSERT INTO LINHAS_AEREAS(ID,NAME) VALUES (2,'Linha2');
INSERT INTO LINHAS_AEREAS(ID,NAME) VALUES (3,'Linha3');

INSERT INTO AVIOES(ID,AUTONOMY,CRUISING_SPEED,PREFIX ) VALUES (1,1000,850.0,'PPCST');
INSERT INTO AVIOES(ID,AUTONOMY,CRUISING_SPEED,PREFIX ) VALUES (2,2000,550.0,'PRBST');
INSERT INTO AVIOES(ID,AUTONOMY,CRUISING_SPEED,PREFIX ) VALUES (3,3000,650.0,'PSCST');
INSERT INTO AVIOES(ID,AUTONOMY,CRUISING_SPEED,PREFIX ) VALUES (4,4000,550,'PTDST');

INSERT INTO PLANO_VOO(FLIGHT_NUMBER, ALTITUDE, CRUISING_SPEED, DATE, DISPATCHED, ROTA, AVIAO) VALUES (111, 27000, 550, '2020-02-12', 0, 7, 4);
INSERT INTO PLANO_VOO VALUES (222, 25000, 550, '2020-02-11', 0, 6, 2);
INSERT INTO PLANO_VOO VALUES (333, 26000, 650, '2020-02-03', 0, 2, 3);
INSERT INTO PLANO_VOO VALUES (444, 32000, 850, '2020-02-26', 0, 1, 1);
--ID = FLIGHT_NUMBER