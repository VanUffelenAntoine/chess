insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO, link_photo)
values (1, 'Queen''s Gambit', 'd4 d5', 'c4', 'White', true, 'https://en.wikipedia.org/wiki/Queen%27s_Gambit','QueensGambit.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (2, 'Bishop''s opening', 'e4 e5', 'Bc4', 'White', false, 'https://en.wikipedia.org/wiki/Bishop%27s_Opening','BishopsOpening.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (3, 'Vienna Game', 'e4 e5', 'Nc3', 'White', false, 'https://en.wikipedia.org/wiki/Vienna_Game','ViennaGame.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (4, 'Philidor Defense', 'e4 e5', 'Nf3 d6', 'Black', false, 'https://en.wikipedia.org/wiki/Philidor_Defence','PhilidorDefense.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (5, 'Sicilian Defence', 'e4 c5','Black', false, 'https://en.wikipedia.org/wiki/Sicilian_Defence','SicilianDefence.png');
insert into OPENING(ID, OPENING_NAME, MOVE1, MOVE2, TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (6, 'King''s indian defence', 'd4 Nf6', 'c4 g6', 'Black', false, 'https://en.wikipedia.org/wiki/King%27s_Indian_Defence','KingsIndianDefence.png');
insert into OPENING(ID, OPENING_NAME, MOVE1,TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (7, 'English Opening', 'c4', 'White', false, 'https://en.wikipedia.org/wiki/English_Opening','EnglishOpening.png');
insert into OPENING(ID, OPENING_NAME, MOVE1,MOVE2,TYPE, GAMBIT, LINK_MORE_INFO,link_photo)
values (8, 'Ruy Lopez', 'e4 e5','Nf3 Nc6', 'White', false, 'https://en.wikipedia.org/wiki/Ruy_Lopez','RuyLopez.png');
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
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (10, 'Queen''s gambit Declined', 1, 'e6');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (11, 'Symmetrical Defence', 7, 'c5');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (12, 'Reversed Sicilian', 7, 'e5');
insert into VARIANT(ID, NAME, parent_opening_id, MOVE)
values (13, 'Open Sicilian', 5, 'Nf3');
insert into PLAYER(ID,NAME,RATING,DESCRIPTION)
values(nextval('player_seq'),'Hikaru Nakamura',2816,'Hikaru Nakamura (born December 9, 1987) is an American chess player, Twitch livestreamer, and content creator. A chess prodigy, he became the youngest American to earn the title of Grandmaster, aged 15 years and 79 days, which has since been broken by Samuel Sevian aged 13 years and 10 months. Nakamura is a five-time United States champion.[1] He won the 2011 edition of Tata Steel Chess Tournament Group A and represented the United States at five Chess Olympiads, winning a team gold medal and two team bronze medals.');
insert into PLAYER(id,name,rating,description)
values(nextval('player_seq'),'Ian Nepomniachtchi',2789,'an Alexandrovich Nepomniachtchi (Russian: Ян Алекса́ндрович Непо́мнящий, romanized: Yan Aleksandrovich Niepomniashchiy; born 14 July 1990) is a Russian chess grandmaster.');
insert into PLAYER(ID,NAME,RATING,DESCRIPTION)
values(nextval('player_seq'),'Magnus Carlsen',2872,'Sven Magnus Øen Carlsen (Norwegian: [svɛn ˈmɑ̀ŋnʉs øːn ˈkɑːlsn̩]; born 30 November 1990)[1][2] is a Norwegian chess grandmaster who is the current World Chess Champion, World Rapid Chess Champion, and World Blitz Chess Champion. Carlsen first reached the top of the FIDE world rankings in 2010, and trails only Garry Kasparov in time spent as the highest rated player in the world. His peak classical rating of 2882 is the highest in history. Carlsen also holds the record for the longest unbeaten run in classical chess.[3]');
insert into GAME(ID,PLAYER1_ID,PLAYER2_ID,OPENING_USED_ID,VARIANT_USED_ID,MOVES)
values(nextval('game_seq'),3,1,7,12,'1. c4 e5 2. Nc3 Nf6 3. Nf3 Nc6 4. g3 d5 5. cxd5 Nxd5 6. Bg2 Nb6 7. O-O Be7 8. d3 O-O 9. Be3 Be6 10. Rc1 Nd5 11. Nxd5 Bxd5 12. a3 Re8 13. Qc2 Bf6 14. Nd2 Nd4 15. Bxd4 Bxg2 16. Kxg2 exd4 17. Qxc7 Rxe2 18. Qxd8+ Rxd8 19. Nc4 Rde8 20. Kf3 Bg5 21. Rb1 R2e6 22. a4 h5 23. b4 g6 24. b5 Kg7 25. Rb2 Be7 26. Rc1 g5 27. Kg2 g4 28. Rcc2 Bg5 29. b6 axb6 30. Rb5 Kg6 31. f4 gxf3+ 32. Kxf3 Bd8 33. Rd5 Bf6 34. Rb2 Ra8 35. Rxb6 Rxa4 36. Rxe6 fxe6 37. Rb5 Ra1 38. Rxb7 Rf1+ 39. Ke2 Rh1 40. h4 Rg1 41. Kf2 Rd1 42. Rb3 Ra1 43. Nd6 Be5 44. Ne4 Ra5 45. Kf3 Kf5 46. Nd2 Bf6 47. Nc4 Ra1 48. Nd6+ Kg6 49. Ne4 Re1 50. Kf2 Re3 51. Nd2 Re5 52. Ne4 Rf5+ 53. Ke2 Ra5 54. Rb6 Kf5 55. Kf3 Be5 56. Rb3 Ra1 57. Rb5 Re1 58. Nd6+ Kg6 59. Nc4 Bf6 60. Rb6 Kf5 61. Kf2 Rd1 62. Nd6+ Kg4 63. Ne4 Be5 64. Rxe6 Kf5 65. Ke2 Rg1 66. Rh6 Bxg3 67. Rxh5+ Kf4 68. Rh8 Re1+ 69. Kd2 Re3 70. h5 Be1+ 71. Kc2 Rh3 72. h6 Kf5 73. h7 Kg6 74. Rg8+ Kxh7 75. Nf6+ Kh6 76. Rh8+ Kg6 77. Rxh3 Kxf6 78. Kb3 Ke5 79. Kc4 Bf2 80. Rf3 Be3 81. Rf8 Ke6 82. Kc5 Bg1 83. Kc6 Be3 84. Re8+ ');
insert into GAME(ID,PLAYER1_ID,PLAYER2_ID,OPENING_USED_ID,MOVES)
values(nextval('game_seq'),1,2,8,'1.e4 e5 2. Nf3 Nc6 3. Bb5 g6 4. c3 a6 5. Ba4 Bg7 6. d4 exd4 7. cxd4 b5 8. Bb3 Nge7 9. O-O d6 10. d5 Na5 11. Bc2 c5 12. Nc3 O-O 13. h3 h6 14. Re1 g5 15. e5 dxe5 16.Nxe5 b4 17. Na4 Qxd5 18. Qxd5 Nxd5 19. Be4 Be6 20. Nxc5 Bxe5 21. Bxd5 Bxd5 22. Rxe5 Rfd8 23. Re1 b3 24. Bd2 Nc4 25. Bc3 bxa2 26. Rxa2 Rac8 27. Rxa6 Rxc5 28. Rxh6 f6 29. Bxf6 Rd7 30. Rh8+ Kf7 31. Rh7+ Kxf6 32. Rxd7 Be6 33. Rb7 Ne5 34. Rb6 Kf5 35. b4 Rd5 36. Rb8 Nd7 37. Rd8 Rb5 38. Re8 Rb6 39. Re7 Ne5 40. Rb1 Nc6 41. Re8 Rxb4 42. Ra1 Nd4 43. Rf8+ Kg6 44. Re1 Kg7 45. Ra8 Kf6 46. Ra6 Kf5 47. Kh2 Rb2 48. Ra5+ Kf6 49. Re4 Nc6 50. Rc5 Rb6 51. h4 gxh4 52. Rxh4 Ne7 53. Rf4+ Kg7 54. Re4 Kf6 55. Re3 Nf5 56. Re2 Ne7 57. f3 Ng6 58. Rd2 Ne5 59. Kg3 Nf7 60. Ra5 Rc6 61. Rd4 Rb6 62. Kh4 Nh6 63. g4 Nf7 64. Rf4+ Kg7 65. Kg3 Rb1 66. Re4 Rb6 67. f4 Bb3 68. Re7 Kf8 69. Rc7 Bd1 70. Rf5 Bb3 71. g5 Kg7 72. Ra5 Rd6 73. f5 Rd3+ 74. Kf4 Rd4+ 75. Ke3 Rc4 76. Rb7 Rc3+ 77. Kd4 Rg3 78. g6 Rg4+ 79. Ke3 Rg1 80. Raa7 Bd5 81. Rxf7+ Bxf7 82. Rxf7+ Kg8 83. Kf4 Rf1+ 84. Kg5 Rg1+ 85. Kf6 a1 86. Rb7');