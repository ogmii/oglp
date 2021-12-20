CREATE TABLE "artist"
(
    "id" BIGSERIAL,
    "name" VARCHAR(255) NOT NULL,
    "sort" VARCHAR(1)   NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "label"
(
    "id" BIGSERIAL,
    "name" VARCHAR(255) NOT NULL,
    "sort" VARCHAR(1)   NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE "record"
(
    "id" BIGSERIAL,
    "title"          VARCHAR(255) NOT NULL,
    "artist_id"      BIGINT       NOT NULL,
    "label_id"       BIGINT       NOT NULL,
    "release_year"   BIGINT       NOT NULL,
    "catalog_number" VARCHAR(255)  DEFAULT NULL,
    "format"         VARCHAR(255)  DEFAULT NULL,
    "variant"        VARCHAR(255)  DEFAULT NULL,
    "comment"        VARCHAR(255)  DEFAULT NULL,
    "cover_front"    VARCHAR(1000) DEFAULT NULL,
    "cover_back"     VARCHAR(1000) DEFAULT NULL,
    "discogs_id"     VARCHAR(255)  DEFAULT NULL,
    "sort"           VARCHAR(1)   NOT NULL,
    "owned"          BOOLEAN       DEFAULT TRUE,
    "created"        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ("id"),
    CONSTRAINT "f98d74cc27744c719a6f_fk" FOREIGN KEY ("label_id") REFERENCES "label" ("id"),
    CONSTRAINT "c60c15d7e4024700bfee_fk" FOREIGN KEY ("artist_id") REFERENCES "artist" ("id")
);