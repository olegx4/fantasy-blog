ALTER TABLE post
    ADD COLUMN is_deleted BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE topic
    ADD COLUMN is_deleted BOOLEAN NOT NULL DEFAULT FALSE;
