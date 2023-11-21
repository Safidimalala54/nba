CREATE TABLE equipe (
    id_equipe SERIAL PRIMARY KEY,
    nom_equipe VARCHAR(50) NOT NULL,
    conference INT
);

CREATE TABLE joueur (
    id_joueur SERIAL PRIMARY KEY,
    nom_joueur VARCHAR(100) NOT NULL,
    prenom_joueur VARCHAR(100) NOT NULL,
    date_de_naissance DATE,
    position INT
);

CREATE TABLE joueur_equipe (
    date_transfert DATE,
    id_equipe INT REFERENCES equipe(id_equipe),
    id_joueur INT REFERENCES joueur(id_joueur)
);

CREATE TABLE action (
    id_action SERIAL PRIMARY KEY,
    nom_action VARCHAR(50)
);

CREATE TABLE match (
    id_match SERIAL PRIMARY KEY,
    date_match TIMESTAMP NOT NULL,
    id_equipe1 INT REFERENCES equipe(id_equipe) NOT NULL,
    id_equipe2 INT REFERENCES equipe(id_equipe) NOT NULL
);

CREATE TABLE statistique (
    id_statistique SERIAL PRIMARY KEY,
    id_match INT REFERENCES match(id_match) NOT NULL,
    id_joueur INT REFERENCES joueur(id_joueur) NOT NULL,
    id_action INT REFERENCES action(id_action) NOT NULL,
    marque INT NOT NULL
);


INSERT INTO joueur_equipe (date_transfert, id_equipe, id_joueur) VALUES
    ('2023-11-21', 2, 1), 
    ('2023-11-21', 2, 2), 
    ('2023-11-21', 2, 3),  
    ('2023-11-21', 2, 4), 
    ('2023-11-21', 2, 5), 
    ('2023-11-21', 3, 6),  
    ('2023-11-21', 3, 7), 
    ('2023-11-21', 3, 8), 
    ('2023-11-21', 3, 9), 
    ('2023-11-21', 3, 10); 

INSERT INTO statistique (id_match, id_joueur, id_action, marque)
VALUES
    (2, 1, 5, 1), -- Stephen Curry a réussi un tir à 2 points dans ce match
    (2, 2, 6, 1), -- Draymond Green a réussi un lancer franc dans ce match
    (2, 3, 4, 0), -- Klay Thompson n'a pas réussi un tir à 3 points dans ce match
    (2, 4, 2, 1), -- Kevon Looney a réussi un rebond dans ce match
    (2, 6, 5, 0), -- Shai Alexander n'a pas réussi un tir à 2 points dans ce match
    (2, 6, 3, 1), -- Shai Alexander a réussi un rebond dans ce match
    (2, 7, 4, 1), -- Luka Doncic a réussi un tir à 3 points dans ce match
    (2, 8, 5, 1); -- Chet Holmet a réussi un tir à 2 points dans ce match

CREATE VIEW v_statistique AS
SELECT
    j.nom_joueur AS Joueur,
    e.id_equipe as id_equipe,
    e.nom_equipe AS Equipe,
    COUNT(DISTINCT m.id_match) AS Match,
    COUNT(DISTINCT s.id_match) AS MatchJoueur,
    CASE
        WHEN COUNT(DISTINCT s.id_match) > 0 THEN
            COALESCE(SUM(CASE WHEN sa.nom_action = '3P' THEN 3
                              WHEN sa.nom_action = '2P' THEN 2
                              WHEN sa.nom_action = 'LF' THEN 1
                         ELSE 0 END) / COUNT(DISTINCT s.id_match), 0)
        ELSE 0
    END AS PPM,
    CASE
        WHEN COUNT(DISTINCT s.id_match) > 0 THEN
            COALESCE(SUM(CASE WHEN sa.nom_action = 'Rebond' THEN 1 ELSE 0 END) / COUNT(DISTINCT s.id_match), 0)
        ELSE 0
    END AS RBPM,
    CASE
        WHEN COUNT(DISTINCT s.id_match) > 0 THEN
            COALESCE(SUM(CASE WHEN sa.nom_action = 'Passe' THEN 1 ELSE 0 END) / COUNT(DISTINCT s.id_match), 0)
        ELSE 0
    END AS PDPM,
    CASE
        WHEN COUNT(DISTINCT s.id_match) > 0 THEN
            COALESCE((SUM(CASE WHEN sa.nom_action IN ('3P', '2P') THEN 1 ELSE 0 END) / COUNT(DISTINCT s.id_match)) * 100, 0)
        ELSE 0
    END AS Tir,
    CASE
        WHEN COUNT(DISTINCT s.id_match) > 0 THEN
            COALESCE((SUM(CASE WHEN sa.nom_action = '3P' THEN 1 ELSE 0 END) / COUNT(DISTINCT s.id_match)) * 100, 0)
        ELSE 0
    END AS Trois,
    CASE
        WHEN COUNT(DISTINCT s.id_match) > 0 THEN
            COALESCE((SUM(CASE WHEN sa.nom_action = 'LF' THEN 1 ELSE 0 END) / COUNT(DISTINCT s.id_match)) * 100, 0)
        ELSE 0
    END AS LF
FROM
    joueur j
JOIN
    joueur_equipe je ON j.id_joueur = je.id_joueur
JOIN
    equipe e ON je.id_equipe = e.id_equipe
LEFT JOIN
    statistique s ON j.id_joueur = s.id_joueur
LEFT JOIN
    match m ON s.id_match = m.id_match AND (m.id_equipe1 = e.id_equipe OR m.id_equipe2 = e.id_equipe)
LEFT JOIN
    action sa ON s.id_action = sa.id_action
GROUP BY
    j.nom_joueur, e.nom_equipe,e.id_equipe;
