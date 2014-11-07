-- PRODUCER
CREATE TABLE Producer (
  id bigint NOT NULL,
  name VARCHAR(500) NOT NULL,
  PRIMARY KEY (id)
);
CREATE SEQUENCE SEQ_PRODUCER;

INSERT INTO Producer VALUES(nextVal('SEQ_PRODUCER'), 'test');

-- CATEGORY
CREATE TABLE Category (
  id bigint NOT NULL,
  name VARCHAR (200) NOT NULL,
  category_id bigint,
  PRIMARY KEY (id)
);
CREATE SEQUENCE SEQ_CATEGORY;

INSERT INTO Category VALUES(nextVal('SEQ_CATEGORY'), 'test_category0', null);
INSERT INTO Category VALUES(nextVal('SEQ_CATEGORY'), 'test_category1', 1);

-- REGION
CREATE TABLE Region (
  id bigint NOT NULL,
  name VARCHAR (200),
  region_id bigint,
  PRIMARY KEY (id)
);
CREATE SEQUENCE SEQ_REGION;

INSERT INTO Region VALUES(nextVal('SEQ_REGION'), 'test_region1', NULL);
INSERT INTO Region VALUES(nextVal('SEQ_REGION'), 'test_region2', 1);

-- OFFER
CREATE TABLE Offer (
  id bigint NOT NULL,
  name VARCHAR (500) NOT NULL,
  price FLOAT ,
  address VARCHAR (500),
  producer_id bigint NOT NULL,
  category_id bigint NOT NULL,
  PRIMARY KEY (id)
);
CREATE SEQUENCE SEQ_OFFER;

INSERT INTO Offer VALUES (nextVal('SEQ_OFFER'), 'test_offer1', 123.32, 'test_address1', 1, 2);
INSERT INTO Offer VALUES (nextVal('SEQ_OFFER'), 'test_offer2', 234.43, 'test_address2', 1, 2);

-- CONSUMER
CREATE TABLE Consumer (
  id bigint NOT NULL,
  name VARCHAR (200),
  region_id bigint NOT NULL,
  PRIMARY KEY (id)
);
CREATE SEQUENCE SEQ_CONSUMER;
INSERT INTO Consumer VALUES(nextVal('SEQ_CONSUMER'), 'test_consumer', 1);

-- BOOKMARK
CREATE TABLE Bookmark (
  consumer_id bigint NOT NULL,
  offer_id bigint NOT NULL
);

INSERT INTO Bookmark VALUES(1, 1);

-- CONSUMER_CATEGORY
CREATE TABLE Consumer_Category (
  consumer_id bigint NOT NULL,
  category_id bigint NOT NULL
);

INSERT INTO Consumer_Category VALUES(1,1);

-- WISH
CREATE TABLE Wish (
  id bigint NOT NULL,
  name VARCHAR (200) NOT NULL,
  description VARCHAR(500),
  category_id bigint NOT NULL,
  consumer_id bigint NOT NULL,
  PRIMARY KEY (id)
);
CREATE SEQUENCE SEQ_WISH;

INSERT INTO Wish VALUES(nextVal('SEQ_WISH'), 'test_wish1', 'test_wish_description', 1, 1);

-- WISH_REGION
CREATE TABLE Wish_Region (
  wish_id bigint NOT NULL,
  region_id bigint NOT NULL
);

INSERT INTO Wish_Region VALUES(1,1);