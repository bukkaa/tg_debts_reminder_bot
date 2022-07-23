CREATE SEQUENCE seq_users START 1 INCREMENT 1;
CREATE SEQUENCE seq_reminders START 1 INCREMENT 1;
CREATE SEQUENCE seq_debts START 1 INCREMENT 1;

create table users
(
    id         BIGINT                      NOT NULL PRIMARY KEY DEFAULT nextval('seq_users'),
    name       VARCHAR                     NOT NULL,
    tg_tag     VARCHAR,
    tg_phone   VARCHAR,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL             DEFAULT now()
) WITH (FILLFACTOR = 90);

create table reminders
(
    id          BIGINT                      NOT NULL PRIMARY KEY DEFAULT nextval('seq_reminders'),
    cron        VARCHAR                     NOT NULL,
    message     VARCHAR(1000),
    enabled     BOOLEAN                                          DEFAULT TRUE,
    modified_at TIMESTAMP WITHOUT TIME ZONE,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL             DEFAULT now()
) WITH (FILLFACTOR = 90);

create table debts
(
    id          BIGINT                      NOT NULL PRIMARY KEY DEFAULT nextval('seq_debts'),
    owner_id    BIGINT                      NOT NULL REFERENCES users (id),
    giver_id    BIGINT                      NOT NULL REFERENCES users (id),
    taker_id    BIGINT                      NOT NULL REFERENCES users (id),
    reminder_id BIGINT REFERENCES reminders (id),
    amount      INT                         NOT NULL             DEFAULT 1,
    of          VARCHAR,
    comment     VARCHAR(1000),
    active      BOOLEAN                     NOT NULL             DEFAULT TRUE,
    modified_at TIMESTAMP WITHOUT TIME ZONE,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL             DEFAULT now()
) WITH (FILLFACTOR = 90);
