insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO, link_photo)
values ('1', 'Queen''s Gambit', 'd4 d5', 'c4', 'White', true, 'https://en.wikipedia.org/wiki/Queen%27s_Gambit','QueensGambit.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values ('2', 'Bishop''s opening', 'e4 e5', 'Bc4', 'White', false, 'https://en.wikipedia.org/wiki/Bishop%27s_Opening','BishopsOpening.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values ('3', 'Vienna Game', 'e4 e5', 'Nc3', 'White', false, 'https://en.wikipedia.org/wiki/Vienna_Game','ViennaGame.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values ('4', 'Philidor Defense', 'e4 e5', 'Nf3 d6', 'Black', false, 'https://en.wikipedia.org/wiki/Philidor_Defence','PhilidorDefense.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values ('5', 'Sicilian Defence', 'e4 d5','Black', false, 'https://en.wikipedia.org/wiki/Sicilian_Defence','SicilianDefence.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values ('6', 'King''s indian defence', 'd4 Nf6', 'c4 g6', 'Black', false, 'https://en.wikipedia.org/wiki/King%27s_Indian_Defence','KingsIndianDefence.png');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (1, 'Queen''s gambit Declined', 1, 'e6');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (2, 'Queen''s gambit Accepted', 1, 'dxc4');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (3, 'Slav Defense', 1, 'c6');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (4, 'Albin CounterGambit', 1, 'e5');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (5, 'Chigorin Defense', 1, 'nc6');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (6, 'Berlin defense', 2, 'Nf6');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (7, 'Classical Defense', 2, 'Bc5');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (8, 'Falkbeer Variation', 3, 'Nf6');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (9, 'Max Lange Defence', 3, 'Nc6');
insert into PLAYER(ID,NAME,RATING,DESCRIPTION)
values(1,'Hikaru Nakamura',2816,'Hikaru Nakamura (born December 9, 1987) is an American chess player, Twitch livestreamer, and content creator. A chess prodigy, he became the youngest American to earn the title of Grandmaster, aged 15 years and 79 days, which has since been broken by Samuel Sevian aged 13 years and 10 months. Nakamura is a five-time United States champion.[1] He won the 2011 edition of Tata Steel Chess Tournament Group A and represented the United States at five Chess Olympiads, winning a team gold medal and two team bronze medals.');
insert into PLAYER(id,name,rating,description)
values(2,'Ian Nepomniachtchi',2789,'an Alexandrovich Nepomniachtchi (Russian: Ян Алекса́ндрович Непо́мнящий, romanized: Yan Aleksandrovich Niepomniashchiy; born 14 July 1990) is a Russian chess grandmaster.');
insert into GAME(id,moves,player1_id,player2_id)
values (1,'e4,c5,Nf3,e6,d4,cxd4,Nxd4,Nc6,Nc3,a6,Nxc6,bxc6,Qf3,f5,exf5,exf5,Bg5,Be7,Bxe7,Qxe7+,Qe3,Qxe3,fxe3,Nf6,Na4,a5,Bd3,Rb8,a3,Ke7,Rb1,Kd6,b4,axb4,axb4,Re8,Kd2,Ng4,Rxh7,Rb7,Nb6',1,2);
insert into GAME(id,moves)
values (2,'1.d4 Nf6 2.c4 e6 3.Nc3 Bb4 4.f3 c5 5.d5 O-O 6.e4 d6 7.Bd2 Nd7 8.Ne2 Ne5 9.Ng3 exd5 10.cxd5 Bd7 11.a3Ba512.Be2b513.O-Oc414.Be3Bb615.Qd2Rb816.Nd1Bc817.Kh1Nfd718.f4Ng619.Bxb6Rxb620.Ne3Nc521.Bd1Nd322.f5Ngf423.a4a624.Ng4h525.Nf2Qf626.Nxd3Nxd327.Qe3Rb728.Nxh5Qh629.Qxh6gxh630.axb5axb531.Bc2Ne532.Ra6Rd833.Ng3Rb834.Ra7b435.Ne2Bd736.Rfa1Bb537.h3Rdc838.Kh2c339.Nd4cxb240.Rb1Rc441.Nxb5Rxc242.Nd4Rd243.Nc6Re844.Ra4Nd345.Nxb4Nf246.Ra2Nd147.Rxd1Rxd148.Rxb2Rxe449.Nc6Kg750.f6+Kxf651.Rf2+Kg652.Nd8Re8');