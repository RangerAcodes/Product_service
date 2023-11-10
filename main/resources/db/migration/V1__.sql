CREATE SEQUENCE categories_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE null_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE sc_user_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE something_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE tpc_instructor_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE tpc_mentor_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE tpc_ta_seq START WITH 1 INCREMENT BY 50
    GO

CREATE SEQUENCE tpc_user_seq START WITH 1 INCREMENT BY 50
    GO

CREATE TABLE categories
(
    id              bigint NOT NULL,
    created_at      datetime,
    last_updated_at datetime,
    is_deleted      bit    NOT NULL,
    name            varchar(255),
    description     varchar(255),
    CONSTRAINT pk_categories PRIMARY KEY (id)
)
    GO

CREATE TABLE product
(
    id              bigint    NOT NULL,
    created_at      datetime,
    last_updated_at datetime,
    is_deleted      bit       NOT NULL,
    title           varchar(255),
    price           float(53) NOT NULL,
    description     varchar(255),
    category_id     bigint,
    image_url       varchar(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
)
    GO

CREATE TABLE sc_user
(
    id        bigint    NOT NULL,
    user_type int,
    name      varchar(255),
    email     varchar(255),
    company   varchar(255),
    grad_year int       NOT NULL,
    rating    float(53) NOT NULL,
    CONSTRAINT pk_sc_user PRIMARY KEY (id)
)
    GO

CREATE TABLE something
(
    id              bigint NOT NULL,
    created_at      datetime,
    last_updated_at datetime,
    is_deleted      bit    NOT NULL,
    foo             int    NOT NULL,
    boo             int    NOT NULL,
    CONSTRAINT pk_something PRIMARY KEY (id)
)
    GO

CREATE TABLE tpc_instructor
(
    id      bigint NOT NULL,
    name    varchar(255),
    email   varchar(255),
    company varchar(255),
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
)
    GO

CREATE TABLE tpc_mentor
(
    id        bigint NOT NULL,
    name      varchar(255),
    email     varchar(255),
    grad_year int    NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
)
    GO

CREATE TABLE tpc_ta
(
    id     bigint    NOT NULL,
    name   varchar(255),
    email  varchar(255),
    rating float(53) NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
)
    GO

CREATE TABLE tpc_user
(
    id    bigint NOT NULL,
    name  varchar(255),
    email varchar(255),
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
)
    GO

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id)
    GO