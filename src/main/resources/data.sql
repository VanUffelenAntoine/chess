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
insert into PLAYER(ID,NAME,RATING,DESCRIPTION)
values(3,'Magnus Carlsen',2872,'Sven Magnus Øen Carlsen (Norwegian: [svɛn ˈmɑ̀ŋnʉs øːn ˈkɑːlsn̩]; born 30 November 1990)[1][2] is a Norwegian chess grandmaster who is the current World Chess Champion, World Rapid Chess Champion, and World Blitz Chess Champion. Carlsen first reached the top of the FIDE world rankings in 2010, and trails only Garry Kasparov in time spent as the highest rated player in the world. His peak classical rating of 2882 is the highest in history. Carlsen also holds the record for the longest unbeaten run in classical chess.[3]');
insert into GAME(ID,PLAYER1_ID,PLAYER2_ID,MOVES)
values(1,3,1,'1. c4 e5 2. Nc3 Nf6 3. Nf3 Nc6 4. g3 d5 5. cxd5 Nxd5 6. Bg2 Nb6 7. O-O Be7 8. d3 O-O 9. Be3 Be6 10. Rc1 Nd5 11. Nxd5 Bxd5 12. a3 Re8 13. Qc2 Bf6 14. Nd2 Nd4 15. Bxd4 Bxg2 16. Kxg2 exd4 17. Qxc7 Rxe2 18. Qxd8+ Rxd8 19. Nc4 Rde8 20. Kf3 Bg5 21. Rb1 R2e6 22. a4 h5 23. b4 g6 24. b5 Kg7 25. Rb2 Be7 26. Rc1 g5 27. Kg2 g4 28. Rcc2 Bg5 29. b6 axb6 30. Rb5 Kg6 31. f4 gxf3+ 32. Kxf3 Bd8 33. Rd5 Bf6 34. Rb2 Ra8 35. Rxb6 Rxa4 36. Rxe6 fxe6 37. Rb5 Ra1 38. Rxb7 Rf1+ 39. Ke2 Rh1 40. h4 Rg1 41. Kf2 Rd1 42. Rb3 Ra1 43. Nd6 Be5 44. Ne4 Ra5 45. Kf3 Kf5 46. Nd2 Bf6 47. Nc4 Ra1 48. Nd6+ Kg6 49. Ne4 Re1 50. Kf2 Re3 51. Nd2 Re5 52. Ne4 Rf5+ 53. Ke2 Ra5 54. Rb6 Kf5 55. Kf3 Be5 56. Rb3 Ra1 57. Rb5 Re1 58. Nd6+ Kg6 59. Nc4 Bf6 60. Rb6 Kf5 61. Kf2 Rd1 62. Nd6+ Kg4 63. Ne4 Be5 64. Rxe6 Kf5 65. Ke2 Rg1 66. Rh6 Bxg3 67. Rxh5+ Kf4 68. Rh8 Re1+ 69. Kd2 Re3 70. h5 Be1+ 71. Kc2 Rh3 72. h6 Kf5 73. h7 Kg6 74. Rg8+ Kxh7 75. Nf6+ Kh6 76. Rh8+ Kg6 77. Rxh3 Kxf6 78. Kb3 Ke5 79. Kc4 Bf2 80. Rf3 Be3 81. Rf8 Ke6 82. Kc5 Bg1 83. Kc6 Be3 84. Re8+ ');