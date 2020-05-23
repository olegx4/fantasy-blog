CREATE TABLE topic
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    name        VARCHAR                             NOT NULL,
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE post
(
    id            BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    title         VARCHAR                             NOT NULL,
    message       TEXT,
    attachment    VARCHAR,
    date_and_time TIMESTAMP,
    topic_id      BIGINT                              NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (topic_id) REFERENCES topic (id)
);