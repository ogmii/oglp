CREATE TABLE "collection_value"
(
    "id" BIGSERIAL,
    "minimum" VARCHAR(255) NOT NULL,
    "median" VARCHAR(255) NOT NULL,
    "maximum" VARCHAR(255) NOT NULL,
    "created"        TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ("id")
);