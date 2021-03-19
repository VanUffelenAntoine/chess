insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO, link_photo)
values ('1', 'Queen''s Gambit', 'd4 d5', 'c4', 'White', true, 'https://en.wikipedia.org/wiki/Queen%27s_Gambit','QueensGambit.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values ('2', 'Bishop''s opening', 'e4 e5', 'Dc4', 'White', false, 'https://en.wikipedia.org/wiki/Bishop%27s_Opening','BishopsOpening.png');
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
insert into GAME(id,moves)
values (1,'e4,c5,Nf3,e6,d4,cxd4,Nxd4,Nc6,Nc3,a6,Nxc6,bxc6,Qf3,f5,exf5,exf5,Bg5,Be7,Bxe7,Qxe7+,Qe3,Qxe3,fxe3,Nf6,Na4,a5,Bd3,Rb8,a3,Ke7,Rb1,Kd6,b4,axb4,axb4,Re8,Kd2,Ng4,Rxh7,Rb7,Nb6');

